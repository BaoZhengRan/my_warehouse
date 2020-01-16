package com.bob.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bob.sys.common.DataGridView;
import com.bob.sys.common.TreeNode;
import com.bob.sys.entity.Dept;
import com.bob.sys.service.IDeptService;
import com.bob.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 琵琶晚翠
 * @since 2020-01-09
 */
@RestController
@RequestMapping("/sys/dept")
public class DeptController {

    @Autowired
    private IDeptService deptService;


    /**
     * 加载部门树
     * @return
     */
    @RequestMapping("loadDeptTreeJson")
    public DataGridView loadDeptTreeJson(){
        List<Dept> list = this.deptService.list();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();

        for(Dept dept:list){
           Boolean spread = dept.getOpen()==1?true:false;
           treeNodes.add(new TreeNode(dept.getId(), dept.getPid(), dept.getTitle(), spread));
        }

        return new DataGridView(treeNodes);
    }

    /**
     * 获得查询数据
     */
    @RequestMapping("loadAllDept")
    public DataGridView loadAllDept(DeptVo vo){
        IPage<Dept> page = new Page<Dept>(vo.getPage(),vo.getLimit());
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<Dept>();
        queryWrapper.like(!StringUtils.isEmpty(vo.getTitle()),"title",vo.getTitle() );
        queryWrapper.like(!StringUtils.isEmpty(vo.getAddress()), "address",vo.getAddress());
        queryWrapper.like(!StringUtils.isEmpty(vo.getRemark()),"remark",vo.getRemark());
        queryWrapper.eq(vo.getId()!=null,"id",vo.getId()).or().eq(vo.getId()!=null, "pid",vo.getId());
        queryWrapper.orderByAsc("ordernum");
        this.deptService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

}

