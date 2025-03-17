package com.yjnb.farm.controller;

import com.yjnb.common.core.controller.BaseController;
import com.yjnb.common.core.domain.AjaxResult;
import com.yjnb.farm.domain.NbUser;
import com.yjnb.farm.service.INbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/user")
public class NbUserController extends BaseController {
    @Autowired
    private INbUserService nbUserService;

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public AjaxResult userLogin(@RequestBody NbUser nbUser) {
        try {
            NbUser loggedInUser = nbUserService.userLogin(nbUser);
            if (loggedInUser != null) {
                return AjaxResult.success("登陆成功", loggedInUser);
            } else {
                return AjaxResult.error("登陆失败");
            }
        } catch (Exception e) {
            return AjaxResult.error("登陆失败" + e.getMessage());
        }
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public AjaxResult userRegister(@RequestBody NbUser nbUser) {
        return toAjax(nbUserService.userRegister(nbUser));
    }
}
