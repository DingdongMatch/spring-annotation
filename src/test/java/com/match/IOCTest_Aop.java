package com.match;

import com.match.aop.MathCalculator;
import com.match.config.MainConfigOfAOP;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Aop {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        // 不要自己创建
//        MathCalculator calculator = new MathCalculator();
//        calculator.div(1,1);

        MathCalculator mathCalculator = applicationContext.getBean(MathCalculator.class);
        mathCalculator.div(1,0);

        applicationContext.close();
    }
}
