package com.nju.ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by mark on 4/24/15.
 */

@Controller
@RequestMapping("/")
public class MainController {


    @RequestMapping("")
    public String home(){
        return "index";
    }

}
