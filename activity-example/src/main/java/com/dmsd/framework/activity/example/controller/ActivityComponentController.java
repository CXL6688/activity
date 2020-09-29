package com.dmsd.framework.activity.example.controller;

import com.dmsd.framework.activity.core.component.IActivityComponent;
import com.dmsd.framework.activity.core.component.IEndActivityComponent;
import com.dmsd.framework.activity.core.component.IStartActivityComponent;
import com.dmsd.framework.activity.example.config.ApplicationContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * 管理活动组件的controller
 * @author cao xueliang
 * @date 2020/9/29 9:49
*/
@Controller
@RequestMapping("/components")
public class ActivityComponentController {

    @GetMapping("/all")
    @ResponseBody
    public List all(){
        List result=new ArrayList();
        Map startGroup=new HashMap();
        startGroup.put("id",UUID.randomUUID().toString());
        startGroup.put("type","group");
        startGroup.put("name","开始节点");
        startGroup.put("ico","el-icon-video-play");
        startGroup.put("open","true");
        startGroup.put("children",new ArrayList<>());
        result.add(startGroup);

        Map endGroup=new HashMap();
        endGroup.put("id",UUID.randomUUID().toString());
        endGroup.put("type","group");
        endGroup.put("name","结束节点");
        endGroup.put("ico","el-icon-video-play");
        endGroup.put("open","true");
        endGroup.put("children",new ArrayList<>());
        result.add(endGroup);

        Map simpleGroup=new HashMap();
        simpleGroup.put("id",UUID.randomUUID().toString());
        simpleGroup.put("type","group");
        simpleGroup.put("name","业务节点");
        simpleGroup.put("ico","el-icon-video-play");
        simpleGroup.put("open","true");
        simpleGroup.put("children",new ArrayList<>());
        result.add(simpleGroup);

        Map<String, IActivityComponent> map= ApplicationContextHolder.applicationContext.getBeansOfType(IActivityComponent.class);
        Iterator<Map.Entry<String,IActivityComponent>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,IActivityComponent> entry= iterator.next();
            String beanName=entry.getKey();
            IActivityComponent activityComponent=entry.getValue();
            Map<String,String> componentInfo=new HashMap<>();
            componentInfo.put("id",UUID.randomUUID().toString());
            componentInfo.put("type",beanName);
            componentInfo.put("name",beanName);
            componentInfo.put("beanName",beanName);
            componentInfo.put("ico","el-icon-odometer");
            if(IStartActivityComponent.class.isAssignableFrom(activityComponent.getClass())){
                ((List)startGroup.get("children")).add(componentInfo);
            }else if(IEndActivityComponent.class.isAssignableFrom(activityComponent.getClass())){
                ((List)endGroup.get("children")).add(componentInfo);
            }else{
                ((List)simpleGroup.get("children")).add(componentInfo);
            }
        }
        return result;
    }
}
