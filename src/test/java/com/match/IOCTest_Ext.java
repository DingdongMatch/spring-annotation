package com.match;

import com.match.ext.ExtConfig;
import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ExtConfig.class);

        applicationContext.publishEvent(new ApplicationEvent("我发布的事件") {});

        applicationContext.close();
    }
}
