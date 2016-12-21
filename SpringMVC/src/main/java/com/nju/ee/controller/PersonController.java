package com.nju.ee.controller;

import com.nju.ee.Constant.PersonLevelConstant;
import com.nju.ee.service.PersonService;
import com.nju.ee.vo.PersonDescVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by homer on 16-12-1.
 */
@Controller
@RequestMapping("/people")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 将在model中存入属性：key为"people"，
     * value为RestResult对象（其data属性为根据学历（title）分类的
     * 人员列表，result属性为是否成功，error属性为出错信息）
     *
     * @return 跳转到人员介绍主页
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String personMain(Model model) {
        RestResult result = personService.getPeople();
        model.addAttribute("people", result);
        return "person";
    }

    /**
     *
     * @return estResult对象（其data属性为根据学历（title）分类的
     * 人员列表，result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public RestResult get(){
        System.out.println("in the get");
        RestResult result =personService.getPeople();
        return result;
    }

    /**
     * 将在model中存入属性：key为"people"，
     * value为RestResult对象（其data属性为VoPage，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param model
     * @return 跳转至人员管理的页面
     */
    @RequestMapping(value = "/manage/list")
    public String managePeople(Model model) {
        RestResult result = personService.getPeople();
        model.addAttribute("people", result);

        return "manage_person";
    }

    /**
     * 将在model中存入
     * 属性1：key为"person_detail"，
     * value为RestResult对象（其data属性为人员对象，
     * result属性为是否成功，error属性为出错信息）
     * 属性2：表示其不是新增人员页，key为"is_add_page",value为"0"
     *
     * 若存在属性：key为"update_fail_result"，
     * value为出错原因,表示上一步更新人员出错；
     *
     * @param id    人员编号
     * @param updateResult 上一步更新人员时的出错信息
     * @param model
     * @return 跳转至具体人员信息编辑界面
     */
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable("id") Integer id,
                             @ModelAttribute(value = "update_fail_result")String updateResult, Model model) {
        if(updateResult.equals("")) { //若不是从更新人员页面跳转而来的，无需恢复未成功更新的人员信息
            RestResult result = personService.getPersonDetail(id);
            model.addAttribute("person_detail", result);
        }
        model.addAttribute("level_list",PersonLevelConstant.level_list);
        model.addAttribute("is_add_page", "0");
        return "add_person";
    }

    /**
     * 将在model中存入属性：表示其为新增人员界面，
     * key为"is_add_page",value为"1"
     *
     * @param model
     * @return 跳转至新增人员信息编辑界面
     */
    @RequestMapping(value = "/manage/add")
    public String addPerson(Model model) {
        model.addAttribute("is_add_page", "1");
        return "add_person";
    }


    /**
     * 获取具体人员信息,将在model中存入属性：key为"person_detail",
     * value为RestResult(其data属性为PersonDescVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * 若存在属性：key为"update_success",
     * value为"1",则表示上一步成功更新人员
     *
     * @param id    人员编号
     * @param model 该参数无需传入
     * @return 跳转到人员详情页面
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String personDetail(@PathVariable("id") Integer id, Model model) {
        RestResult result = personService.getPersonDetail(id);
        model.addAttribute("person_detail", result);
        return "person";
    }


    /**
     * 新增人员,将在model中存入属性：key为"result",
     * value为RestResult(其data属性为PersonDescVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param person 完整的人员对象（需传入与其属性相对应的参数）
     * @return 重定向至人员管理列表
     */
    @RequestMapping(value = "/manage", method = RequestMethod.POST)
    public String post(PersonDescVo person, Model model) {
        RestResult result = personService.addPerson(person);
        model.addAttribute("result",result);
        return "redirect:/people/manage/list";
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param person 人员对象（需传入与其属性相对应的参数）
     * @return 若修改成功则重定向至人员详情界面,同时存入属性：
     * key为“update_success”,value为“1”；
     *
     * 若修改失败则重定向至人员编辑界面，同时存入属性1：
     * key为“update_fail_result",value为出错原因
     * 属性2：key为“person_detail”，value为RestResult对象
     * (data为PersonDescVo，包含编辑过的人员信息）
     */
    @RequestMapping(value = "/manage/update/{id}", method = RequestMethod.POST)
    public String put(@PathVariable("id") Integer id, PersonDescVo person, RedirectAttributes ra) {
        RestResult result =  personService.modifyPerson(id, person);
        if(result.getResult() == 1){//修改成功跳转至新闻详情界面
            ra.addFlashAttribute("update_success","1");
            return "redirect:/people/"+((PersonDescVo) result.getData()).getId();
        }else{//修改失败跳转至编辑界面
            ra.addFlashAttribute("update_fail_result","result："+result.getError().getMessage());
            person.setId(id);
            ra.addFlashAttribute("person_detail", RestResult.CreateResult(1,person));//保留编辑的内容
            return "redirect:/people/manage/"+person.getId();
        }
    }

    /**
     * 删除人员
     *
     * @param id 人员编号
     * @return json格式的RestResult对象（其data属性为PersonDescVo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        return personService.deletePerson(id);
    }
}
