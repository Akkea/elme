package com.aka.Vo;

public class LayuiVo {
    private Integer code;
    private String msg;
    private Long count;
    //data!!data! 名字不能变  不是date
    private Object data;
    public LayuiVo() {
    }
    public static LayuiVo success(Long count , Object data){
        LayuiVo layuiVo = new LayuiVo();
        layuiVo.code = 0;
        layuiVo.msg = "成功";
        layuiVo.count = count;
        layuiVo.data=data;
        return layuiVo;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Long getCount() {
        return count;
    }

    public Object getData() {
        return data;
    }
}
