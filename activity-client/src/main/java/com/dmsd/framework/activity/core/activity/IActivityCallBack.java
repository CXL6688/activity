package com.dmsd.framework.activity.core.activity;
/**  
 * 活动执行完毕之后回调函数接口
 * @author cao xueliang
 * @date 2020/9/26 16:26
*/
public interface IActivityCallBack<T> {
    /**
     * 回调函数
     * @param activityResult 活动结束后的结果
     */
    void finish(ActivityResult<T> activityResult);
}
