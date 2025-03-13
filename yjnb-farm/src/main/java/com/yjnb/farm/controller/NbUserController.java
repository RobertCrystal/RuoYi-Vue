package com.yjnb.farm.controller;

import com.yjnb.common.core.controller.BaseController;
import com.yjnb.common.core.domain.AjaxResult;
import com.yjnb.farm.domain.NbUser;
import com.yjnb.farm.service.INbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class NbUserController extends BaseController {
    @Autowired
    private INbUserService nbUserService;

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

    @PostMapping("/register")
    public AjaxResult userRegister(@RequestBody NbUser nbUser) {
        return toAjax(nbUserService.userRegister(nbUser));
    }
}
