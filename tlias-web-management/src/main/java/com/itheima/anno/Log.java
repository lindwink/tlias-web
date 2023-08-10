package com.itheima.anno;

import java.lang.annotation.*;

/**
 * @author:deconglin
 * @date:2023-08-09-16:21
 * @description:
 */

//标识的作用
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Log {
}
