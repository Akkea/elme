package com.aka.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/")
public class IndexController {

    @GetMapping("/index")
    public String index(){
        System.out.println(1);
        return "index";
    }


}
