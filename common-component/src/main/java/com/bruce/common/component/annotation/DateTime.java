package com.bruce.common.component.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2020 <br/>
 * @Desc: 日期注解 <br/>
 * @ProjectName: park-api <br/>
 * @Date: 2020/1/6 13:44 <br/>
 * @Author: wdz
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateTimeValidator.class)
public @interface DateTime {

	String message() default "格式错误";

	String format() default "yyyyMM";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
