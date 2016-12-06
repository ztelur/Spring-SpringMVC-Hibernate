package com.nju.ee.controller;

import com.nju.ee.po.ArticlePo;
import com.nju.ee.po.RestResult;
import com.nju.ee.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by homer on 16-12-1.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @return 跳转到文章列表页
     */
    @RequestMapping(method = RequestMethod.GET)
    public String articleMain(Integer page, Integer num, Model model) {
        RestResult result = articleService.getArticles(page, num);
        model.addAttribute("articles", result);
        //TODO: 封装page,并将页面信息存入model
        //model.addAttribute("");

        return "article";
    }

    @RequestMapping("edit")
    public String articleEdit() {
        return "article_edit";
    }

    /**
     * 获取具体文章,将在model中存入属性：key为"article",
     * value为RestResult(其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    文章编号
     * @param model 该参数无需传入
     * @return 跳转到详情页面
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String articleDetail(@PathVariable("id") Integer id, Model model) {
        RestResult result = articleService.getArticleDetail(id);
        model.addAttribute("article", result);
        //TODO: 新增文章详情页
        return "article_detail";
    }
    /**
     * 跳转至添加文章的编辑页面
     **/
    @RequestMapping(value = "/add")
    public String addArticle(){
        return "add_article";
    }

    /**
     * 新增文章。
     *
     * @param article 完整的文章对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResult post(ArticlePo article) {
        return articleService.addArticle(article);
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param article 文章对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public RestResult put(@PathVariable("id") Integer id, ArticlePo article) {
        return articleService.modifyArticle(id, article);
    }

    /**
     * 删除文章
     *
     * @param id 文章编号
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        return articleService.deleteArticle(id);
    }
}
