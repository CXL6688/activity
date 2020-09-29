package com.dmsd.framework.activity.core.strategy.impl;
/**  
 * 默认直接匹配的策略器
 * @author cao xueliang
 * @date 2020/9/28 15:27
*/
public class DefaultIgnoreStrategy extends AbsStrategy{
    @Override
    public boolean isMatch() {
        return true;
    }
}
