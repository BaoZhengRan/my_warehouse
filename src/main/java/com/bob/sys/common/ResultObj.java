package com.bob.sys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
    public static final ResultObj LOGIN_SUCCESS = new ResultObj(Const.OK,"登陆成功");
    public static final ResultObj LOGIN_ERROR_PASS = new ResultObj(Const.ERROR,"登陆失败，用户或密码不正确");
    public static final ResultObj LOGIN_ERROR_CODE = new ResultObj(Const.ERROR,"登陆失败，验证码不正确");
    private Integer code;
    private String msg;
}
