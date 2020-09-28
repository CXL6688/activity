package com.dmsd.framework.activity.core.activity.imp;

import com.dmsd.framework.activity.core.activity.ActivityResult;
import com.dmsd.framework.activity.core.activity.IActivity;
import com.dmsd.framework.activity.core.activity.IActivityCallBack;
import com.dmsd.framework.activity.core.activity.IActivityContextReader;
import com.dmsd.framework.activity.core.component.IStartActivityComponent;
import lombok.Setter;

/**
 * 抽象活动类
 * @author cao xueliang
 * @date 2020/9/28 10:29
*/
public class AbsActivity implements IActivity {
    @Setter
    protected IActivityContextReader activityContextReader;

    /**
     * 起始节点
     */
    @Setter
    private IStartActivityComponent startComponent;

    @Override
    public void start(IActivityCallBack activityCallBack) {
        try {
            startComponent.proccess();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(activityCallBack!=null){
                activityCallBack.finish(this.activityContextReader.get(ActivityEnvironment.RESULT, ActivityResult.class));
            }
        }
    }
}
