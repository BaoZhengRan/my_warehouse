package com.bob.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.sys.common.DataGridView;
import com.bob.sys.common.ResultObj;
import com.bob.sys.common.WebUtils;
import com.bob.sys.entity.Notice;
import com.bob.sys.entity.User;
import com.bob.sys.service.INoticeService;
import com.bob.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 琵琶晚翠
 * @since 2020-01-02
 */
@RestController
@RequestMapping("/sys/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    /*
     *全部查询出来
     */
    @RequestMapping("loadAllNotice")
    public DataGridView loadAllNotice(NoticeVo noticeVo){
        IPage<Notice> page = new Page<>(noticeVo.getPage(),noticeVo.getLimit());
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(!StringUtils.isEmpty(noticeVo.getTitle()),"title", noticeVo.getTitle());
        queryWrapper.like(!StringUtils.isEmpty(noticeVo.getOpername()), "opername", noticeVo.getOpername());
        queryWrapper.ge(noticeVo.getStartTime()!=null, "createtime", noticeVo.getStartTime());
        queryWrapper.le(noticeVo.getEndTime()!=null, "createtime", noticeVo.getEndTime());
        queryWrapper.orderByDesc("createtime");
        this.noticeService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }



    /**
     * 添加通知
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(NoticeVo noticeVo){
        try{
            noticeVo.setCreatetime(new Date());
            //user里有这么多东西。。。。
            User user = (User)WebUtils.getSession().getAttribute("user");
            System.out.println("==================================================");
            System.out.println(user.getName());
            System.out.println(user.getPwd());
            System.out.println(user.getSalt());
            System.out.println(user.getSex());
            System.out.println(user.getLoginname());
            System.out.println("==================================================");
            noticeVo.setOpername(user.getName());

            this.noticeService.save(noticeVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }



    /**
     * 删除通知
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(Integer id){
        try{
            this.noticeService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


    /*
     *批量删除
     *
     */
    @RequestMapping("batchDeleteNotice")
    public ResultObj batchDeleteNotice(NoticeVo noticeVo){
        try{
            Collection<Serializable> idList = new ArrayList<Serializable>();
            for(Integer id : noticeVo.getIds()){
                idList.add(id);
            }
            this.noticeService.removeByIds(idList);
            return ResultObj.DELETE_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }






}

