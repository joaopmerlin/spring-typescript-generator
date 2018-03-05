package com.spring.typescript.generator.annotation;

import java.lang.annotation.*;

/**
 * Created by joao on 17/08/17.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface TsIgnore {

}
