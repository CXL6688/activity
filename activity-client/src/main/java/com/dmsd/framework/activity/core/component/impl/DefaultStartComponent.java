package com.dmsd.framework.activity.core.component.impl;

import com.dmsd.framework.activity.core.activity.imp.ActivityEnvironment;
import com.dmsd.framework.activity.core.component.IStartActivityComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 默认的开始节点
 * @author cao xueliang
 * @date 2020/9/28 10:45
*/
@Slf4j
@Component
@Scope("prototype")
public class DefaultStartComponent extends AbsActivityComponent implements IStartActivityComponent {

    @Override
    protected void execute() {
        log.info("开始执行活动{}",this.activityContext.get(ActivityEnvironment.ID,String.class));
    }
}
