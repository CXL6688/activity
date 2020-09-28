package com.dmsd.framework.activity.example;


import com.dmsd.framework.activity.core.activity.ActivityResult;
import com.dmsd.framework.activity.core.activity.IActivity;
import com.dmsd.framework.activity.core.activity.IActivityCallBack;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IActivityTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void testStart(){
        ClassPathXmlApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:application2.xml");
        IActivity activity= applicationContext.getBean(IActivity.class);
        activity.start(new IActivityCallBack() {
            @Override
            public void finish(ActivityResult activityResult) {
                System.out.println(activityResult);
            }
        });
    }
}