package com.bob.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 控制跳转的controller
 */
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

    /**
     * 跳转到公告管理
     * @return
     */
    @RequestMapping("toNoticeManager")
    public String toNoticeManager(){
        return "/system/notice/noticeManager.html";
    }

    /**
     * 跳转到部门管理
     */
    @RequestMapping("toDeptManager")
    public String toDeptManager(){
        return "/system/dept/deptManager";
    }

    /**
     * 跳转到部门管理左栏
     * @return
     */
    @RequestMapping("toDeptLeft")
    public String toDeptLeft(){
        return "/system/dept/deptLeft";
    }

    /**
     * 跳转到部门管理右栏
     * @return
     */
    @RequestMapping("toDeptRight")
    public String toDeptRight(){
        return "/system/dept/deptRight";
    }

}
