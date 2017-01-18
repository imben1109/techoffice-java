package com.ittechoffice.spring.mockito;

import org.mockito.Mockito;
import org.springframework.beans.factory.FactoryBean;

public class MockitoFactoryBean<T> implements FactoryBean<T> {

    private Class<T> classToBeMocked;

    public MockitoFactoryBean(Class<T> classToBeMocked) {
        this.classToBeMocked = classToBeMocked;
    }

    public T getObject() throws Exception {
        return Mockito.mock(classToBeMocked);
    }

    public Class<?> getObjectType() {
        return classToBeMocked;
    }

    public boolean isSingleton() {
        return true;
    }

}
