package com.dmsd.framework.activity.example.controller;

import com.dmsd.framework.activity.core.activity.ActivityResult;
import com.dmsd.framework.activity.core.activity.IActivityCallBack;
import com.dmsd.framework.activity.core.activity.imp.AbsActivity;
import com.dmsd.framework.activity.core.component.IActivityComponent;
import com.dmsd.framework.activity.core.component.IStartActivityComponent;
import com.dmsd.framework.activity.core.component.impl.AbsActivityComponent;
import com.dmsd.framework.activity.example.config.ApplicationContextHolder;
import com.dmsd.framework.activity.example.domain.ActivityComponentConfig;
import com.dmsd.framework.activity.example.domain.ActivityConfig;
import com.dmsd.framework.activity.example.domain.ActivityRelationConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Description: 
 * @author cao xueliang
 * @date 2020/9/29 14:47
*/
@Controller
@RequestMapping("/activity")
@Slf4j
public class ActivityController {
    @PostMapping("/save")
    @ResponseBody
    public ActivityResult save(@RequestBody ActivityConfig activityConfig){
        log.info("开始执行{}活动",activityConfig.getName());
        if(CollectionUtils.isEmpty(activityConfig.getNodeList())){
            return ActivityResult.OK();
        }
        AbsActivity activity=ApplicationContextHolder.applicationContext.getBean(AbsActivity.class);

        Map<String,ActivityComponentConfig> nodeMap=  activityConfig.getNodeList().stream().collect(Collectors.toMap(ActivityComponentConfig::getId,Function.identity()));
        Map<String,AbsActivityComponent> activityComponentMap=new HashMap<>();
        Iterator<Map.Entry<String, ActivityComponentConfig>> iterator = nodeMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,ActivityComponentConfig> entry=iterator.next();
            String nodeId=entry.getKey();
            String beanName=entry.getValue().getBeanName();
            AbsActivityComponent component= ApplicationContextHolder.applicationContext.getBean(beanName,AbsActivityComponent.class);
            component.setActivityContext(activity.getActivityContextReader());
            activityComponentMap.put(nodeId,component);
        }
        List<ActivityRelationConfig> activityRelationConfigs= activityConfig.getLineList();
        if(CollectionUtils.isEmpty(activityRelationConfigs)){
            return ActivityResult.OK();
        }
        for (ActivityRelationConfig activityRelationConfig : activityRelationConfigs) {
            String fromId=activityRelationConfig.getFrom();
            String toId=activityRelationConfig.getTo();
            AbsActivityComponent fromComponent= activityComponentMap.get(fromId);
            AbsActivityComponent toComponent= activityComponentMap.get(toId);
            List<IActivityComponent> childComponents= fromComponent.getChildComponents();
            if(CollectionUtils.isEmpty(childComponents)){
                childComponents=new ArrayList<>();
                fromComponent.setChildComponents(childComponents);
            }
            childComponents.add(toComponent);
            if(IStartActivityComponent.class.isAssignableFrom(fromComponent.getClass())){
                activity.setStartComponent((IStartActivityComponent) fromComponent);
            }
        }
        activity.start(new IActivityCallBack() {
            @Override
            public void finish(ActivityResult activityResult) {
                System.out.println("finish!");
            }
        });
        return ActivityResult.OK();
    }
}
