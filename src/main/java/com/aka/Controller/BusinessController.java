package com.aka.Controller;

import com.aka.Service.BusinessService;
import com.aka.Vo.LayuiVo;
import com.aka.form.BusinessForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @GetMapping("/list")
    public String list(){
        return "Business/list";
    }
    @GetMapping("/listPage")
    //返回json形式的数据
    @ResponseBody
    public LayuiVo listpage(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "1") Integer pageSize){
        return businessService.listPage(pageNum,pageSize);
    }
    @GetMapping("/listDynamics")
    @ResponseBody
   public LayuiVo listDynamics(@RequestParam(defaultValue = "1") Integer pageNum,
                               @RequestParam(defaultValue = "1") Integer pageSize,
                               String storeName,Integer orderType,Integer[] storeStatus){
        return businessService.listDynamics(pageNum,pageSize,storeName,orderType,storeStatus);
    }

    @PostMapping("dynamicsUpdateById")
    @ResponseBody
    public LayuiVo dynamicsUpdateById(BusinessForm businessForm){
        if (businessForm.getId()== null){
            LayuiVo.error(1,"id不能为空");
        }
        return businessService.dynamicsUpdateById(businessForm);
    }



}
