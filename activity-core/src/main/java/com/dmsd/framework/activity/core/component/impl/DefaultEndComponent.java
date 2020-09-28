package com.dmsd.framework.activity.core.component.impl;

import com.dmsd.framework.activity.core.activity.IActivityContextReader;
import com.dmsd.framework.activity.core.activity.IActivityContextWriter;
import com.dmsd.framework.activity.core.activity.imp.ActivityEnvironment;
import com.dmsd.framework.activity.core.activity.imp.ActivityStatus;
import com.dmsd.framework.activity.core.component.IEndActivityComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认的结束节点
 * @author cao xueliang
 * @date 2020/9/28 14:27
*/
@Slf4j
public class DefaultEndComponent extends AbsActivityComponent implements IEndActivityComponent {
    public DefaultEndComponent(){

    }

    public DefaultEndComponent(IActivityContextReader activityContextReader, IActivityContextWriter activityContextWriter){
        this.activityContextReader=activityContextReader;
        this.activityContextWriter=activityContextWriter;
    }

    @Override
    protected void execute() {
        this.activityContextWriter.set(ActivityEnvironment.STATUS, ActivityStatus.ended);
        log.info("活动{}执行完毕",this.activityContextReader.get(ActivityEnvironment.ID,String.class));
    }
}
