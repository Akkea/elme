package com.aka.Enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BusinessStoreTypeEnum {
    BREAKFAST(1,"早餐"),
    LUNCH(2,"午餐"),
    DINNER(3,"晚餐");

    private Integer typeId;
    private String typeValue;

    BusinessStoreTypeEnum(Integer typeId,String typeValue) {
        this.typeId = typeId;
        this.typeValue = typeValue;
    }

    public Integer getTypeId() {
        return typeId;
    }
    public String getTypeValue(){
        return typeValue;
    }
    public static BusinessStoreTypeEnum getType(Integer id){
        for (BusinessStoreTypeEnum value : values()) {
            if (value.getTypeId().equals(id)){
                return value;
            }
        }
        return null;
    }

}
