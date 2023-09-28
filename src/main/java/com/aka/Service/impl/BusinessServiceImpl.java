package com.aka.Service.impl;

import com.aka.Entity.Business;
import com.aka.Enumeration.BusinessStoreStatusEnum;
import com.aka.Mapper.BusinessMapper;
import com.aka.Service.BusinessService;
import com.aka.Vo.BusinessVO;
import com.aka.Vo.LayuiVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public LayuiVo listPage(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Business> businessList = businessMapper.list();
        PageInfo pageInfo = PageInfo.of(businessList);
        return LayuiVo.success(pageInfo.getTotal(),entityList2VoList(businessList));
    }
    private BusinessVO entity2vo(Business business){
        BusinessVO businessVO = new BusinessVO();
        BeanUtils.copyProperties(business,businessVO);
        businessVO.setStoreStatus(BusinessStoreStatusEnum.getStatus(business.getStoreStatus()));
        return businessVO;
    }
    private List<BusinessVO> entityList2VoList(List<Business> businessList){
        List<BusinessVO> businessVOList = new ArrayList<>();
        for (Business business: businessList) {
            businessVOList.add(entity2vo(business));
        }
        return businessVOList;
    }

}
