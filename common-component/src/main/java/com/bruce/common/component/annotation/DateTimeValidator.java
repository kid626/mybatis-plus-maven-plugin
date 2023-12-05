package com.bruce.common.component.annotation;


import cn.hutool.core.util.StrUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * @Copyright: Zhejiang Drore Technology Co., Ltd  2020 <br/>
 * @Desc: <br/>
 * @ProjectName: park-api <br/>
 * @Date: 2020/1/6 13:45 <br/>
 * @Author: wdz
 */
public class DateTimeValidator implements ConstraintValidator<DateTime, String> {

    private DateTime dateTime;

    @Override
    public void initialize(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 如果 value 为空则不进行格式验证，为空验证可以使用 @NotBlank @NotNull @NotEmpty 等注解来进行控制，职责分离
        if (StrUtil.isEmpty(value)) {
            return true;
        }
        String format = dateTime.format();

        if (value.length() != format.length()) {
            return false;
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

        try {
            simpleDateFormat.parse(value);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
