package com.dmsd.framework.activity.core.activity.imp;

import com.dmsd.framework.activity.core.component.impl.DefaultEndComponent;
import com.dmsd.framework.activity.core.strategy.impl.DefaultIgnoreStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 默认的活动上下文
 * @author cao xueliang
 * @date 2020/9/28 14:59
*/
@Slf4j
@Component
@Scope("prototype")
public class DefaultActivityContext extends AbsActivityContext {
    public DefaultActivityContext(){
        innerMap.put(ActivityEnvironment.ID,this.id);
        innerMap.put(ActivityEnvironment.DEFAULT_END_ACTIVITY_COMPNENT,new DefaultEndComponent(this));
        innerMap.put(ActivityEnvironment.DEFAULT_STRATEGY,new DefaultIgnoreStrategy());
        outerMap.put(ActivityEnvironment.STATUS,ActivityStatus.created);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        if(innerMap.containsKey(key)){
            return (T)innerMap.get(key);
        }
        return (T)outerMap.get(key);
    }
}
