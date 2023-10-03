package com.aka.Vo;


import com.fasterxml.jackson.annotation.JsonInclude;

public class LayuiVo {
    private Integer code;
    private String msg;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long count;
    //data!!data! 名字不能变  不是date
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    public LayuiVo() {
    }
    public static LayuiVo success(){
        LayuiVo layuiVo = new LayuiVo();
        layuiVo.code = 0;
        layuiVo.msg = "成功";
        return layuiVo;
    }
    public static LayuiVo success(Long count , Object data){
        LayuiVo layuiVo = new LayuiVo();
        layuiVo.code = 0;
        layuiVo.msg = "成功";
        layuiVo.count = count;
        layuiVo.data=data;
        return layuiVo;
    }
    public static LayuiVo error(Integer code,String msg){
        LayuiVo layuiVo = new LayuiVo();
        layuiVo.code = code;
        layuiVo.msg = msg;
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
