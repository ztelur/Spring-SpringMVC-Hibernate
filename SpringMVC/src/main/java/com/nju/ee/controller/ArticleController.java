package com.nju.ee.controller;

import com.nju.ee.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by homer on 16-12-1.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {
    @RequestMapping(method = RequestMethod.GET)
    public String getArticlesPage(){
        return "article";
    }
}
