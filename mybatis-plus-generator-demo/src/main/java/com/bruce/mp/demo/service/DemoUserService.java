package com.bruce.mp.demo.service;

import com.bruce.mp.demo.model.po.DemoUser;
import com.bruce.mp.demo.model.form.DemoUserForm;
import com.bruce.mp.demo.model.vo.DemoUserVO;
import com.bruce.mp.demo.model.query.DemoUserQuery;
import com.bruce.common.component.model.common.PageData;

/**
 * @Copyright Copyright © 2023 Bruce . All rights reserved.
 * @Desc service 层
 * @ProjectName mp-demo
 * @Date 2023-11-30
 * @Author Bruce
 */
public interface DemoUserService {

    /**
     * 新增
     *
     * @param form DemoUserForm
     * @return 主键
     */
    Long save(DemoUserForm form);


    /**
     * 更新
     *
     * @param form DemoUserForm
     */
    void update(DemoUserForm form);

    /**
     * 删除
     *
     * @param id 主键
     */
    void remove(Long id);

    /**
     * 按主键查询
     */
    DemoUser queryById(Long id);

    /**
     * 分页查询
     *
     * @param query DemoUserQuery
     * @return 分页信息
     */
    PageData<DemoUserVO> queryByPage(DemoUserQuery query);

}
