package com.nju.ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by homer on 16-12-21.
 */
@Controller
@RequestMapping("/contact")
public class ContactController {
    /**
     * @return 跳转到新闻列表页
     */
    @RequestMapping(value ="/main",method = RequestMethod.GET)
    public String articleMain() {
        return "contact";
    }
}
