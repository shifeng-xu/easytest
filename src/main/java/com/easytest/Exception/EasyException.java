package com.easytest.Exception;

public class EasyException extends RuntimeException {

    private Code code;

    private String msg;



    public enum Code{
        STATUS_OK (0),
        API_PARAM_INVALID (4001),       // 输入参数错误
        NAME_EXIST (4002),              // 名称重复错误
        PATH_NOT_FOUND (4003),          // 路径未找到
        NOT_LOGIN (4040),               // 为登录
        AXIS_NO_PERMIT (5003);         // 无权限操作此账户

        private int num;

        private Code(Integer num){this.num=num;}


        public int getNum() {
            return num;
        }
    }

    public EasyException(Code code, String msg) {
        super(code + ": " + msg);
        this.code = code;
        this.msg = msg;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }



}
