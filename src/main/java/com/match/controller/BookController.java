package com.match.controller;

import com.match.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author matchfu
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
}
