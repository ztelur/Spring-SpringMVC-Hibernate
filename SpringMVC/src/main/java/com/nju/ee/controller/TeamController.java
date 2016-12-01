package com.nju.ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by homer on 16-12-1.
 */
@Controller
@RequestMapping("/teams")
public class TeamController {
    @RequestMapping(method = RequestMethod.GET)
    public String getTeamsPage(){
        return "team";
    }
}
