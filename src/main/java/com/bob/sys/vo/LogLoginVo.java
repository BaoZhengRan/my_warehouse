package com.bob.sys.vo;

import com.bob.sys.entity.LogLogin;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/*
 * @Author  :bob
 * @Date    :Created in 11:19 2019/12/27
 * @Description:vo
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LogLoginVo extends LogLogin {

    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer limit=10;

    private Integer[] ids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
