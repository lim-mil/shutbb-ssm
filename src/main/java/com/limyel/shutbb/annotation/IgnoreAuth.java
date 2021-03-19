package com.limyel.shutbb.annotation;

import java.lang.annotation.*;

/**
 * 跳过用户验证
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
