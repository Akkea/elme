package com.aka.Mapper;

import com.aka.Entity.Business;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BusinessMapper {
    List<Business> list();
    List<Business> listDynamics(@Param("storeName") String storeName,
                                @Param("orderType") Integer orderType,
                                @Param("storeStatus") Integer[] storeStatus);
    int dynamicsUpdateById(Business business);
}
