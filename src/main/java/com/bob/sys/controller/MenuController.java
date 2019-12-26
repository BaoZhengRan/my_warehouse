package com.bob.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bob.sys.common.*;
import com.bob.sys.entity.Permission;
import com.bob.sys.entity.User;
import com.bob.sys.service.IPermissionService;
import com.bob.sys.vo.PermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :bob
 * @Date    :Created in 20:24 2019/12/23
 * @Description:菜单管理前端控制器
 *
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private IPermissionService permissionService;

    @RequestMapping("loadIndexLeftMenuJson")
    public DataGridView loadIndexLeftMenuJson(PermissionVo permissionVo){
        //查询所有菜单
        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
        //设置只能查询菜单
        queryWrapper.eq("type", Const.TYPE_MENU);
        queryWrapper.eq("available", Const.AVAILABLE_TRUE);

        User user = (User) WebUtils.getSession().getAttribute("user");
        List<Permission> list = null;
        if(user.getType() == Const.USER_TYPE_SUPER){
            list = permissionService.list(queryWrapper);
        }else {
            list = permissionService.list(queryWrapper);
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        for(Permission p:list){
            Integer id = p.getId();
            Integer pid = p.getPid();
            String type = p.getType();
            String href = p.getHref();
            String title = p.getTitle();
            Boolean spread = p.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(id,pid, type,title,href,spread));
        }
        //构建层级关系
        List<TreeNode> list2 = TreeNodeBuilder.build(treeNodes,1);
        return new DataGridView(list2);
    }

}
