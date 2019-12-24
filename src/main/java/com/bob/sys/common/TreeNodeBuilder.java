package com.bob.sys.common;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author  :bob
 * @Date    :Created in 20:12 2019/12/23
 * @Description:把没有层级关系的集合变成有层级关系的
 *
 */
public class TreeNodeBuilder {

    public static List<TreeNode> build(List<TreeNode> treeNodes,Integer topPid){
        List<TreeNode> list = new ArrayList<>();
        for(TreeNode n1:treeNodes){
            if(n1.getPid().equals(topPid)){
                list.add(n1);
            }
            for (TreeNode n2:treeNodes){
                if(n2.getPid().equals(n1.getId())){
                    n1.getChildren().add(n2);
                }
            }
        }
        return list;
    }

}
