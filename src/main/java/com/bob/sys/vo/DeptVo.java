package com.bob.sys.vo;

import com.bob.sys.entity.Dept;
import lombok.Data;
import lombok.EqualsAndHashCode;

/*
 * @Author  :bob
 * @Date    :Created in 11:19 2019/12/27
 * @Description:vo
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class DeptVo extends Dept {

    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

}
