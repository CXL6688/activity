package com.dmsd.framework.activity.core.activity.imp;

import com.dmsd.framework.activity.core.activity.IActivityContextReader;
import com.dmsd.framework.activity.core.activity.IActivityContextWriter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 活动上下文抽象类
 * @author cao xueliang
 * @date 2020/9/28 14:56
*/
@Slf4j
public abstract class AbsActivityContext implements IActivityContextReader, IActivityContextWriter {
    protected final String id= UUID.randomUUID().toString();
    protected Map<String,Object> innerMap=new HashMap<>();
    protected Map<String,Object> outerMap=new HashMap<>();

    @Override
    public boolean set(String key, Object value) {
        if(innerMap.containsKey(key)){
            log.error("线程上下文{}中，{}是受保护的键，不能被设置，请修改您的键。",id,key);
            return false;
        }
        outerMap.put(key,value);
        return true;
    }
}
