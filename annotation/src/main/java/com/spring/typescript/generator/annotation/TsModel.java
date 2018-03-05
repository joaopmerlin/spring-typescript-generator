package com.spring.typescript.generator.annotation;

import java.lang.annotation.*;

/**
 * Created by joao on 17/08/17.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TsModel {

    String value() default "";

    boolean encapsulate() default true;
}
