package com.sysoiev.notebook.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

@Override
public Object postProcessAfterInitialization(Object object, String name) throws BeansException {
    System.err.println(object + " - postProcessAfterInitialization()");
    return object;
}

    @Override
    public Object postProcessBeforeInitialization(Object object, String name) throws BeansException {
        return object;
    }
}