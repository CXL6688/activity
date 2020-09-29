package com.dmsd.framework.activity.example;

import com.dmsd.framework.activity.core.component.impl.AbsActivityComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @author cao xueliang
 * @date 2020/9/28 17:37
*/
@Slf4j
@Component
@Scope("prototype")
public class ActivityComponent3 extends AbsActivityComponent {
    @Override
    protected void execute() {
        log.info("execute ActivityComponent3");
    }
}
