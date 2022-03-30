package com.match;

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
        applicationContext.close();
    }
}
