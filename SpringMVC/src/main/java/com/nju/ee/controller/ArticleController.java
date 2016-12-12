package com.nju.ee.controller;

import com.nju.ee.vo.ArticleVo;
import com.nju.ee.vo.RestResult;
import com.nju.ee.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by homer on 16-12-1.
 */
@Controller
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @return 跳转到新闻列表页
     */
    @RequestMapping(value ="/main",method = RequestMethod.GET)
    public String articleMain() {
        return "article";
    }

    /**
     * 获取每页新闻列表及相关信息
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return RestResult(其data属性为VoPage，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public RestResult get(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize){
        RestResult result = articleService.getArticles(pageNum, pageSize);
        return result;
    }

    /**
     * 获取具体新闻,将在model中存入属性：key为"article",
     * value为RestResult(其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    新闻编号
     * @param model 该参数无需传入
     * @return 跳转到详情页面
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String articleDetail(@PathVariable("id") Integer id, Model model) {
        RestResult result = articleService.getArticleDetail(id);
        model.addAttribute("article", result);
        //TODO: 新增新闻详情页
        return "article_detail";
    }

    /**
     * 获取新闻列表信息并跳转至管理界面,
     * 将在model中存入属性：key为"articles",
     * value为RestResult(其data属性为VoPage，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     * @param page 页码
     * @param num  每页大小
     * @param model
     * @return 跳转至管理新闻的列表页面
     */
    @RequestMapping(value = "/manage/list")
    public String manageArticles(Integer page, Integer num, Model model){
        RestResult result = articleService.getArticles(page, num);
        model.addAttribute("articles",result);
        return "manage_article";
    }

    /**
     * 将在model中存入属性：key为"article_detail"，
     * value为RestResult对象（其data属性为新闻对象，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    新闻编号
     * @param model
     * @return 跳转至具体新闻信息编辑界面
     */
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable("id")  Integer id, Model model) {
        RestResult result = articleService.getArticleDetail(id);
        model.addAttribute("article_detail", result);
        model.addAttribute("is_add_page","0");
        return "add_article";
    }

    /**
     * 将在model中存入属性：key为"is_add_page",value为"1"
     * @param model
     * @return 跳转至添加新闻的编辑页面
     */

    @RequestMapping(value = "/manage/add")
    public String addArticle(Model model){
        model.addAttribute("is_add_page","1");
        return "add_article";
    }

    
    
    /**
     * 新增新闻。
     *
     * @param article 完整的新闻对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage" , method = RequestMethod.POST)
    public String post(ArticleVo article) {
        System.out.println(article.getContent()+"ddd");
        articleService.addArticle(article);
        return  "redirect:/articles/manage/list";
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param article 新闻对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/update/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult put(@PathVariable("id") Integer id, ArticleVo article) {
        return articleService.modifyArticle(id, article);
    }

    /**
     * 删除新闻
     *
     * @param id 新闻编号
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        return articleService.deleteArticle(id);
    }
}
