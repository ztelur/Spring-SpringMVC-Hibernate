package com.nju.ee.controller;

import com.nju.ee.service.ArticleService;
import com.nju.ee.vo.ArticleVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.ArrayBlockingQueue;

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
    public RestResult get( Integer pageNum,  Integer pageSize){
        RestResult result = articleService.getArticles(pageNum, pageSize);
        return result;
    }

    /**
     * 获取具体新闻,将在model中存入属性：key为"article",
     * value为RestResult(其data属性为ArticleVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * 若存在属性：key为"update_success",
     * value为"1",则表示上一步成功更新新闻
     *
     * @param id    新闻编号
     * @param model 该参数无需传入
     * @return 跳转到详情页面
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  String articleDetail(@PathVariable("id") Integer id, Model model) {
        RestResult result = articleService.getArticleDetail(id);
        model.addAttribute("article", result);
        return "article_detail";
    }

    /**
     * @return 跳转至管理新闻的列表页面
     */
    @RequestMapping(value = "/manage/list")
    public String manageArticles(){
        return "manage_article";
    }

    /**
     * 将在model中存入属性：key为"article_detail"，
     * value为RestResult对象（其data属性为新闻对象，
     * result属性为是否成功，error属性为出错信息）
     *
     * 若存在属性：key为"update_fail_result"，
     * value为出错原因,表示上一步更新新闻出错；
     *
     * @param id    新闻编号
     * @param updateResult 上一步更新新闻时的出错信息
     * @param model
     * @return 跳转至具体新闻信息编辑界面
     */
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable("id")  Integer id,
                              @ModelAttribute(value = "update_fail_result")String updateResult, Model model) {
        if(updateResult.equals("")) { //若不是从更新新闻页面跳转而来的，无需恢复未成功更新的新闻信息
            RestResult result = articleService.getArticleDetail(id);
            model.addAttribute("article_detail", result);
        }
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
     * 新增新闻,将在model中存入属性：key为"result",
     * value为RestResult(其data属性为ArticleVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param article 完整的新闻对象（需传入与其属性相对应的参数）
     * @return 重定向至新闻管理列表
     */
    @RequestMapping(value = "/manage" , method = RequestMethod.POST)
    public String post(ArticleVo article,Model model) {
        System.out.println(article.getContent()+"ddd");
        RestResult result = articleService.addArticle(article);
        model.addAttribute("result",result);
        return  "redirect:/articles/manage/list";
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param id 新闻编号
     * @param article 新闻对象（需传入与其属性相对应的参数）
     * @return 若修改成功则重定向至新闻详情界面,同时存入属性：
     * key为“update_success”,value为“1”；
     *
     * 若修改失败则重定向至新闻编辑界面，同时存入属性1：
     * key为“update_fail_result",value为出错原因
     * 属性2：key为“article_detail”，value为RestResult对象
     * (data为ArticleVo，包含编辑过的新闻信息）
     */
    @RequestMapping(value = "/manage/update/{id}", method = RequestMethod.POST)
    public String put(@PathVariable("id") Integer id, ArticleVo article, RedirectAttributes ra) {
        RestResult result = articleService.modifyArticle(id, article);
        if(result.getResult() == 1){//修改成功跳转至新闻详情界面
            ra.addFlashAttribute("update_success","1");
            return "redirect:/articles/"+((ArticleVo) result.getData()).getId();
        }else{//修改失败跳转至编辑界面
            ra.addFlashAttribute("update_fail_result","result："+result.getError().getMessage());
            article.setId(id);
            ra.addFlashAttribute("article_detail",RestResult.CreateResult(1,article));
            return "redirect:/articles/manage/"+article.getId();
        }
    }

    /**
     * 删除新闻
     *
     * @param id 新闻编号
     * @return json格式的RestResult对象（其data属性为ArticleVo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        return articleService.deleteArticle(id);
    }
}
