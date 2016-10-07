package com.epam;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;

public class DataStore implements BeanNameAware, DisposableBean {

    public DataStore() {
        System.out.println("DataStore()");
    }

    public void init() {
        System.out.println("init()");
    }
    
    @Override
    public void destroy() throws Exception {
        System.out.println("DataStore.destroy()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("DataStore bean name: " + name);
    }

}
