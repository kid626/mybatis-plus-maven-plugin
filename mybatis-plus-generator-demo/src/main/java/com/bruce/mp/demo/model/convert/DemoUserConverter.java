package com.bruce.mp.demo.model.convert;

import com.bruce.mp.demo.model.po.DemoUser;
import com.bruce.mp.demo.model.form.DemoUserForm;
import com.bruce.mp.demo.model.vo.DemoUserVO;
import org.springframework.beans.BeanUtils;

/**
 * @Copyright Copyright © 2023 Bruce . All rights reserved.
 * @Desc 转换层
 * @ProjectName mp-demo
 * @Date 2023-11-30
 * @Author Bruce
 */
public class DemoUserConverter {

    public static DemoUser convert2Po(DemoUserForm form) {
        DemoUser po = new DemoUser();
        BeanUtils.copyProperties(form, po);
        return po;
    }

    public static DemoUserVO convert2Vo(DemoUser po) {
        DemoUserVO vo = new DemoUserVO();
        BeanUtils.copyProperties(po, vo);
        return vo;
    }



}

