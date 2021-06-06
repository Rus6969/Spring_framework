package com.cybertek.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
// we choose method level bc we want to add it to our controller,
@Target(ElementType.METHOD)
 //Annotation needs to use while runtime controller
@Retention(RetentionPolicy.RUNTIME )
public @interface DefaultExceptionMessage {


    String defaultMessage() default "";

}
