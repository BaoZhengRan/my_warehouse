package com.bob.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @Author  :bob
 * @Date    :Created in 20:01 2019/12/23
 * @Description:好像用来显示数据库的数据
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataGridView {
    private Integer code = 0;
    private String msg = "";
    private Long count = 0L;
    private Object data;

    public DataGridView(Long count, Object data) {
        super();
        this.count = count;
        this.data = data;
    }

    public DataGridView(Object data) {
        super();
        this.data = data;
    }
}

