package com.match;

import com.match.bean.Yellow;
import com.match.config.MainConfigOfProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_Profile {

    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码方式激活某种环境
    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 1、创建一个applicationContext
        // 2、设置需要激活的环境
        applicationContext.getEnvironment().setActiveProfiles("test");
        // 3、注册配置类
        applicationContext.register(MainConfigOfProfile.class);
        // 4、启动刷新容器
        applicationContext.refresh();

        String[] namesForType = applicationContext.getBeanNamesForType(DataSource.class);
        for (String s : namesForType) {
            System.out.println(s);
        }

        System.out.println(applicationContext.getBean(Yellow.class));
        applicationContext.close();
    }
}
