package com.nju.ee.controller;

import com.nju.ee.service.PaperService;
import com.nju.ee.vo.PaperVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by homer on 16-12-16.
 */
@Controller
@RequestMapping("/papers")
public class PaperController {
    @Autowired
    private PaperService paperService;

    /**
     * @return 跳转到论文列表页
     */
    @RequestMapping(value ="/main",method = RequestMethod.GET)
    public String articleMain() {
        return "paper";
    }

    /**
     * 获取每页论文列表及相关信息
     * @param pageNum 页码 非必须
     * @param pageSize 每页大小　非必须
     * @return RestResult(其data属性为${genericVoPage}，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public RestResult get(Integer pageNum, Integer pageSize){
        RestResult result = paperService.getPapers(pageNum, pageSize);
        return result;
    }

    /**
     * 获取具体论文pdf
     * @param id    论文编号
     * @return 论文pdf
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  String articleDetail(@PathVariable("id") Integer id) {
//        RestResult result = articleService.getArticleDetail(id);
//        TODO: 新增新闻详情页
        return "paper_detail";
    }

    /**
     * 获取论文列表信息并跳转至管理界面,
     * 将在model中存入属性：key为"pages",
     * value为RestResult(其data属性为${GenericVoPage}，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     * @param page 页码
     * @param num  每页大小
     * @param model
     * @return 跳转至管理论文的列表页面
     */
    @RequestMapping(value = "/manage/list")
    public String manageArticles(Integer page, Integer num, Model model){
        RestResult result = paperService.getPapers(page, num);
        model.addAttribute("papers",result);
        return "manage_paper";
    }

    /**
     * 将在model中存入属性：key为"paper_detail"，
     * value为RestResult对象（其data属性为新闻对象，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    新闻编号
     * @param model
     * @return 跳转至具体新闻信息编辑界面
     */
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
    public String editArticle(@PathVariable("id")  Integer id, Model model) {
        RestResult result = paperService.getPaperDetail(id);
        model.addAttribute("paper_detail", result);
        model.addAttribute("is_add_page","0");
        return "add_paper";
    }

    /**
     * 将在model中存入属性：key为"is_add_page",value为"1"
     * @param model
     * @return 跳转至添加论文的编辑页面
     */

    @RequestMapping(value = "/manage/add")
    public String addPaper(Model model){
        model.addAttribute("is_add_page","1");
        return "add_paper";
    }



    /**
     * 新增论文。
     *
     * @param paper 完整的论文对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage" , method = RequestMethod.POST)
    public String post(PaperVo paper) {
        paperService.addPaper(paper);
        return  "redirect:/papers/manage/list";
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param paperVo 论文对象（需传入与其属性相对应的参数）
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/update/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult put(@PathVariable("id") Integer id, PaperVo paperVo) {
        return paperService.modifyPaper(id, paperVo);
    }

    /**
     * 删除论文
     *
     * @param id 论文编号
     * @return json格式的RestResult对象（其data属性为ArticlePo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        return paperService.deletePaper(id);
    }
}
