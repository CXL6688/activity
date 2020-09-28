package com.dmsd.framework.activity.core.activity;
/**  
 * 活动
 * @author cao xueliang
 * @date 2020/9/26 16:23
*/
public interface IActivity {
    /**
     * 开始活动
     * @param activityCallBack 结果回调接口
     */
    void start(IActivityCallBack activityCallBack);
}
