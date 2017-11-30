package com.framework.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by Administrator on 2017/11/28.
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    private SpringContext springContext;
    private static final Object instanceLocker = new Object();

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        synchronized (instanceLocker) {
            if (springContext == null) {
                springContext = applicationContext.getBean(SpringContext.class);
                springContext.applicationContext = applicationContext;
            } else if (applicationContext != springContext.applicationContext) {
                throw new RuntimeException("ObjectContext 初始化错误：在当前运行环境中检测到多个不同的 Spring 上下文。");
            }

        }
    }

    public static <T> T getBean(Class<T> clazz) {

        return applicationContext.getBean(clazz);
    }
}
