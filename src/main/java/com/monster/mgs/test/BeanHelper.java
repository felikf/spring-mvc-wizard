package com.monster.mgs.test;

/**
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Helper class to get beans from Spring Context without autowiring them.
 */
public class BeanHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T getBean(Class<T> clazz) {
        T bean = applicationContext.getBean(clazz);

        if (bean == null) {
            throw new RuntimeException("No bean has been found in context for: " + clazz);
        }

        return bean;
    }
}

