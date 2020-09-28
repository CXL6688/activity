package com.dmsd.framework.activity.core.activity;
/**  
 * 活动上下文写入器
 * @author cao xueliang
 * @date 2020/9/28 15:23
*/
public interface IActivityContextWriter {
    boolean set(String key,Object value);
}
