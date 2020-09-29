package com.dmsd.framework.activity.core.activity;
/**  
 * 活动上下文读取器
 *
 * 作用：为活动组件提供共享数据的平台
 * @author cao xueliang
 * @date 2020/9/28 10:26
*/
public interface IActivityContext {
    <T> T get(String key,Class<T> clazz);

    boolean set(String key,Object value);

}
