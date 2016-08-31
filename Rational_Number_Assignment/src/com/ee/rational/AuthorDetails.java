package com.ee.rational;

import java.lang.annotation.*;

/**
 * Created by Vishal on 31-08-2016.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
public @interface AuthorDetails {
    String name() default "Vishal";
    String date();
    int version() default 1;
}
