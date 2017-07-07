package com.android.yt.ehouse.app.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by feng on 2017/7/7.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    int index() default -1;
    String description() default "";
    String formAlias() default "";
}
