package com.bob.sys.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :bob
 * @Date    :Created in 20:07 2019/12/23
 * @Description:首页左边导航菜单栏
 *
 */
@Data
public class TreeNode {
    private Integer id;
    private Integer pid;
    private String type;
    private String title;
    private String href;
    private Boolean spread;
    private List<TreeNode> children = new ArrayList<TreeNode>();

    public TreeNode(Integer id, Integer pid, String type, String title, String href, Boolean spread) {
        this.id = id;
        this.pid = pid;
        this.type = type;
        this.title = title;
        this.href = href;
        this.spread = spread;
    }
}

