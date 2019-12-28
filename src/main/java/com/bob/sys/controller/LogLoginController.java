package com.bob.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.sys.common.DataGridView;
import com.bob.sys.entity.LogLogin;
import com.bob.sys.service.ILogLoginService;
import com.bob.sys.vo.LogLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 琵琶晚翠
 * @since 2019-12-27
 */
@RestController
@RequestMapping("/sys/logLogin")
public class LogLoginController {
    @Autowired
    private ILogLoginService logLoginService;

    /*
     *全部查询出来
     *queryWrapper的参数似乎是（条件，表的列，传入的值）
     * 很明显这个vo
     */
    @RequestMapping("loadAllLogLogin")
    public DataGridView loadAllLogLogin(LogLoginVo logLoginVo){
        IPage<LogLogin> page = new Page<>(logLoginVo.getPage(),logLoginVo.getLimit());
        QueryWrapper<LogLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(logLoginVo.getLoginname()),"loginname", logLoginVo.getLoginname());
        queryWrapper.like(!StringUtils.isEmpty(logLoginVo.getLoginip()), "loginip", logLoginVo.getLoginip());
        queryWrapper.ge(logLoginVo.getStartTime()!=null, "logintime", logLoginVo.getStartTime());
        queryWrapper.le(logLoginVo.getEndTime()!=null, "logintime", logLoginVo.getEndTime());
        queryWrapper.orderByDesc("logintime");
        this.logLoginService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }



}

