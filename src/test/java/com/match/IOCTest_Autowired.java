package com.match;

import com.match.bean.Boss;
import com.match.bean.Car;
import com.match.bean.Color;
import com.match.config.MainConfigOfAutowired;
import com.match.dao.BookDao;
import com.match.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Autowired {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);
        BookService bookService = applicationContext.getBean(BookService.class);
        System.out.println(bookService);
        BookDao bookDao = applicationContext.getBean(BookDao.class);
        System.out.println(bookDao);
        Boss boss = applicationContext.getBean(Boss.class);
        System.out.println(boss);
        System.out.println(applicationContext.getBean(Car.class));
        System.out.println(applicationContext.getBean(Color.class));
        applicationContext.close();
    }
}
