package com.match;

import com.match.bean.Person;
import com.match.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author matchfu
 */
public class MainTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);

        AnnotationConfigApplicationContext applicationContext1 = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person1 = applicationContext1.getBean(Person.class);
        System.out.println(person1);
        String[] names = applicationContext1.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}
