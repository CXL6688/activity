package com.dmsd.framework.activity.core.component.impl;


import com.dmsd.framework.activity.core.activity.IActivityContextReader;
import com.dmsd.framework.activity.core.activity.IActivityContextWriter;
import com.dmsd.framework.activity.core.activity.imp.ActivityEnvironment;
import com.dmsd.framework.activity.core.activity.imp.ActivityStatus;
import com.dmsd.framework.activity.core.component.IActivityComponent;
import com.dmsd.framework.activity.core.component.IEndActivityComponent;
import com.dmsd.framework.activity.core.strategy.IStrategy;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 抽象活动组件
 *
 * 提供活动组件代码复用的基础类
 * @author cao xueliang
 * @date 2020/9/28 10:44
*/
@Slf4j
public abstract class AbsActivityComponent implements IActivityComponent {
    /**
     * 活动组件的id
     */
    protected String id= UUID.randomUUID().toString();
    /**
     * 活动上下文的读取器
     */
    @Setter
    protected IActivityContextReader activityContextReader;

    @Setter
    protected IActivityContextWriter activityContextWriter;
    /**
     * 有序的下一层活动组件
     */
    @Setter
    private List<IActivityComponent> childComponents;
    /**
     * 策略
     */
    private IStrategy strategy;

    @Override
    public void proccess() {
        if(ActivityStatus.ended.equals(this.activityContextReader.get(ActivityEnvironment.STATUS,ActivityStatus.class))){
            return;
        }
        log.debug("开始执行活动组件{}",id);
        if(strategy==null){
            strategy=this.activityContextReader.get(ActivityEnvironment.DEFAULT_STRATEGY,IStrategy.class);
        }
        if(!strategy.isMatch()){
            return;
        }
        this.execute();
        if(CollectionUtils.isEmpty(childComponents)){
            this.childComponents= new ArrayList<>();
            if(!IEndActivityComponent.class.isAssignableFrom(this.getClass())){
                this.childComponents.add(this.activityContextReader.get(ActivityEnvironment.DEFAULT_END_ACTIVITY_COMPNENT,IEndActivityComponent.class));
            }
        }
        log.debug("活动组件{}执行完毕。",id);
        for (IActivityComponent childComponent : childComponents) {
            childComponent.proccess();
        }
    }

    protected abstract void execute();
}
