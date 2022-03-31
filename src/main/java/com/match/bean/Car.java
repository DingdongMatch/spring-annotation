package com.match.bean;

import org.springframework.stereotype.Component;

/**
 * @author matchfu
 */
@Component
public class Car {

    public Car() {
        System.out.println("Car constructor...");
    }

    public void init() {
        System.out.println("Car ... init...");
    }

    public void destroy() {
        System.out.println("car ... destroy");
    }
}
