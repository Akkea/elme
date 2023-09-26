package com.aka.Service.impl;

import com.aka.Entity.Business;
import com.aka.Mapper.BusinessMapper;
import com.aka.Service.BusinessService;
import com.aka.Vo.LayuiVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return LayuiVo.success(pageInfo.getTotal(),pageInfo.getList());
    }
}
