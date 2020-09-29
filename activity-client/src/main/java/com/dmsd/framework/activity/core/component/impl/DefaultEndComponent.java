package com.dmsd.framework.activity.core.component.impl;

import com.dmsd.framework.activity.core.activity.IActivityContext;
import com.dmsd.framework.activity.core.activity.imp.ActivityEnvironment;
import com.dmsd.framework.activity.core.activity.imp.ActivityStatus;
import com.dmsd.framework.activity.core.component.IEndActivityComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 默认的结束节点
 * @author cao xueliang
 * @date 2020/9/28 14:27
*/
@Slf4j
@Component
@Scope("prototype")
public class DefaultEndComponent extends AbsActivityComponent implements IEndActivityComponent {
    public DefaultEndComponent(){

    }

    public DefaultEndComponent(IActivityContext activityContext){
        this.activityContext =activityContext;
    }

    @Override
    protected void execute() {
        this.activityContext.set(ActivityEnvironment.STATUS, ActivityStatus.ended);
        log.info("活动{}执行完毕",this.activityContext.get(ActivityEnvironment.ID,String.class));
    }
}
