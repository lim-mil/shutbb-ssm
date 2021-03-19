package com.limyel.shutbb.annotation;

import java.lang.annotation.*;

/**
 * 当前登录用户
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

}
