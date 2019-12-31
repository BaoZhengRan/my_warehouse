package com.bob.sys.controller;


import com.bob.sys.common.ActiveUser;
import com.bob.sys.common.ResultObj;
import com.bob.sys.common.WebUtils;
import com.bob.sys.entity.LogLogin;
import com.bob.sys.service.ILogLoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/*
 *
 * 登陆前端控制器
 */

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private ILogLoginService logLoginService;

/*
    前端登陆控制器
 */
    @RequestMapping("login")
    public ResultObj login(String loginname,String pwd){
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(loginname,pwd);
       try{
           subject.login(token);
           ActiveUser activeUser = (ActiveUser) subject.getPrincipal();
           WebUtils.getSession().setAttribute("user",activeUser.getUser());
           LogLogin entity=new LogLogin();
           entity.setLoginname(activeUser.getUser().getName()+"-"+activeUser.getUser().getLoginname());
           entity.setLoginip(WebUtils.getRequest().getRemoteAddr());
           entity.setLogintime(new Date());
           logLoginService.save(entity);
           return ResultObj.LOGIN_SUCCESS;
       }catch (AuthenticationException e){
           e.printStackTrace();
           return ResultObj.LOGIN_ERROR_PASS;
       }

    }
}



