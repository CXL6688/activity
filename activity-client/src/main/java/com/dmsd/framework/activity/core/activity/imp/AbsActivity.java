package com.dmsd.framework.activity.core.activity.imp;

import com.dmsd.framework.activity.core.activity.*;
import com.dmsd.framework.activity.core.component.IStartActivityComponent;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 抽象活动类
 * @author cao xueliang
 * @date 2020/9/28 10:29
*/
@Data
public class AbsActivity implements IActivity {
    @Autowired
    protected IActivityContext activityContextReader;

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
