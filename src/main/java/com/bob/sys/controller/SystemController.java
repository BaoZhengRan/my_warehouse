package com.bob.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class SystemController {

/*
 *跳转到登陆界面
 */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "system/index/login";
    }

    /*
     *跳转到首页
     */
    @RequestMapping("index")
    public String index(){
        return "system/index/index";
    }

    /*
     *跳转到工作台
     */
    @RequestMapping("toDeskManager")
    public String toDeskManager(){
        return "/system/index/deskManager";
    }

    /*
     *跳转到日志管理
     */
    @RequestMapping("toLogLoginManager")
    public String toLogLoginManager(){
        return "system/logLogin/logLoginManager";
    }


}
