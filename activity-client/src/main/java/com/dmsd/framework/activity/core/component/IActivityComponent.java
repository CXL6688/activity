package com.dmsd.framework.activity.core.component;

/**
 * 活动组件
 *
 * 注意：活动组件只能顺序执行，不能并行执行
 * @author cao xueliang
 * @date 2020/9/26 16:24
*/
public interface IActivityComponent {
    /**
     * 执行组件
     */
    void proccess();
}
