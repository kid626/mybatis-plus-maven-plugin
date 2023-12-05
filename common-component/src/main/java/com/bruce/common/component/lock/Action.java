package com.bruce.common.component.lock;

/**
 * @Copyright Copyright © 2021 fanzh . All rights reserved.
 * @Desc
 * @ProjectName redis
 * @Date 2021/2/4 21:34
 * @Author Bruce
 */
@FunctionalInterface
public interface Action<T> {

    T run();

}
