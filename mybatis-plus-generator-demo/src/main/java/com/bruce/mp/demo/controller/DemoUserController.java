package com.bruce.mp.demo.controller;


import com.bruce.common.component.model.common.PageData;
import com.bruce.common.component.model.common.Result;
import com.bruce.mp.demo.model.form.DemoUserForm;
import com.bruce.mp.demo.model.po.DemoUser;
import com.bruce.mp.demo.model.query.DemoUserQuery;
import com.bruce.mp.demo.model.vo.DemoUserVO;
import com.bruce.mp.demo.service.DemoUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Copyright Copyright © 2023 Bruce . All rights reserved.
 * @Desc Controller 接口
 * @ProjectName mp-demo
 * @Date 2023-11-30
 * @Author Bruce
 */
@RestController
@RequestMapping("demoUser")
public class DemoUserController {

    @Resource
    private DemoUserService service;

    @GetMapping("/v1/page")
    @ApiOperation("分页查询")
    public Result<PageData<DemoUserVO>> queryByPage(@Validated DemoUserQuery query) {
        PageData<DemoUserVO> pageData = service.queryByPage(query);
        return Result.success(pageData);
    }

    @GetMapping("/v1/detail/{id}")
    @ApiOperation("查询详情")
    public Result<DemoUser> detail(@PathVariable(value = "id") Long id) {
        DemoUser detail = service.queryById(id);
        return Result.success(detail);
    }

    @PostMapping("/v1/save")
    @ApiOperation("新增")
    public Result<String> save(@RequestBody @Validated DemoUserForm form) {
        Long id = service.save(form);
        return Result.success(String.valueOf(id));
    }

    @PostMapping("/v1/update")
    @ApiOperation("更新")
    public Result<String> update(@RequestBody @Validated DemoUserForm form) {
        service.update(form);
        return Result.success();
    }


    @PostMapping("/v1/remove/{id}")
    @ApiOperation("删除")
    public Result<String> remove(@PathVariable(value = "id") Long id) {
        service.remove(id);
        return Result.success();
    }

}
