package com.aka.Enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BusinessStoreStatusEnum {
    UNAUDITED(1,"未审核"),
    NORMAL(2,"正常"),
    BAN(3,"封禁");
    private Integer statusNum;
    private String statusValues;

    BusinessStoreStatusEnum(Integer statusNum, String statusValues) {
        this.statusNum = statusNum;
        this.statusValues = statusValues;
    }

    public static BusinessStoreStatusEnum getStatus (Integer status){
        //values（）可以枚举类转化为枚举类型的数组，里面放的是枚举  即UNAUDITED、NORMAL、BAN 可以通过get方法获取其中数值
        for (BusinessStoreStatusEnum value: values()) {
            if (status.equals(value.getStatusNum())){
                return value;
            }
        }
        return null;
    }

    public Integer getStatusNum() {
        return statusNum;
    }

    public String getStatusValues() {
        return statusValues;
    }
}
