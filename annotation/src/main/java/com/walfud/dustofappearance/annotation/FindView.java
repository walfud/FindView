package com.walfud.dustofappearance.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by walfud on 2017/3/17.
 */

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface FindView {

}
