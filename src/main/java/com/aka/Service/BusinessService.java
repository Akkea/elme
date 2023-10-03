package com.aka.Service;


import com.aka.Vo.LayuiVo;
import com.aka.form.BusinessForm;
import org.springframework.web.bind.annotation.RequestParam;

public interface BusinessService {
    LayuiVo listPage(Integer pageNum,Integer pageSize);
    LayuiVo listDynamics(Integer pageNum, Integer pageSize, String storeName,Integer orderType,Integer[] storeStatus);
    LayuiVo dynamicsUpdateById(BusinessForm businessForm);
}
