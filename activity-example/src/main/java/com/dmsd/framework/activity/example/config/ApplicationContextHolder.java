package com.dmsd.framework.activity.example.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Description: 
 * @author cao xueliang
 * @date 2020/9/29 9:56
*/
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    public static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.applicationContext=applicationContext;
    }
}
