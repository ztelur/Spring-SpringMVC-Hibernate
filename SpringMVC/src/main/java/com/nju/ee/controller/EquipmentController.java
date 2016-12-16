package com.nju.ee.controller;

import com.nju.ee.Constant.Constant;
import com.nju.ee.service.EquipmentService;
import com.nju.ee.vo.EquipmentForm;
import com.nju.ee.vo.EquipmentVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.nju.ee.vo.Error;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by homer on 16-12-1.
 */

@Controller
@RequestMapping("/equipments")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * @return 跳转到设备列表页
     */
    @RequestMapping(value ="/main",method = RequestMethod.GET)
    public String equipmentMain() {
        return "equipment";
    }

    /**
     * 获取每页设备列表及相关信息
     * @param pageNum 页码
     * @param pageSize 每页大小
     * @return RestResult(其data属性为VoPage，包含分页信息和数据，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public RestResult get( Integer pageNum,  Integer pageSize){
        Pageable pageable=new PageRequest(pageNum, Constant.PAGE_COUNT);
        Page<EquipmentVo> page = equipmentService.query(pageable);
        RestResult result=new RestResult(1,page);
        return result;
    }

    /**
     * 获取具体设备,将在model中存入属性：key为"equipment",
     * value为RestResult(其data属性为EquipmentVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    新闻编号
     * @param model 该参数无需传入
     * @return 跳转到详情页面
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public  String equipmentDetail(@PathVariable("id") Integer id, Model model) {
        EquipmentVo vo= equipmentService.findById(id);
        RestResult result=null;
        if(vo==null) {
            Error error=new Error(Error.BAD_PARAM,"NotFound");
            result = new RestResult(0,error);
        }else{
            result=new RestResult(1,vo);
        }
        model.addAttribute("equipment", result);
        return "equipment_detail";
    }

    /**
     * @return 跳转至管理设备的列表页面
     */
    @RequestMapping(value = "/manage/list")
    public String manageEquipments(){
        return "manage_equipment";
    }

    /**
     * 将在model中存入属性：key为"equipment_detail"，
     * value为RestResult对象（其data属性为新闻对象，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param id    新闻编号
     * @param model
     * @return 跳转至具体设备信息编辑界面
     */
    @RequestMapping(value = "/manage/{id}", method = RequestMethod.GET)
    public String editEquipment(@PathVariable("id")  Integer id, Model model) {
        EquipmentVo vo = equipmentService.findById(id);
        if(vo==null)
            ;//跳转到错误页面;
        else {
            RestResult result=new RestResult(1,vo);
            model.addAttribute("equipment_detail", result);
            model.addAttribute("is_add_page", "0");
        }
        return "add_equipment";
    }

    /**
     * 将在model中存入属性：key为"is_add_page",value为"1"
     * @param model
     * @return 跳转至添加设备的编辑页面
     */

    @RequestMapping(value = "/manage/add")
    public String addEquipment(Model model){
        model.addAttribute("is_add_page","1");
        return "add_equipment";
    }



    /**
     * 新增设备,将在model中存入属性：key为"result",
     * value为RestResult(其data属性为EquipmentVo，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param equipmentForm 完整的新闻对象（需传入与其属性相对应的参数）
     * @return 重定向至新闻管理列表
     */
    @RequestMapping(value = "/manage" , method = RequestMethod.POST)
    public String post(EquipmentForm equipmentForm,Model model) {
        EquipmentVo vo=equipmentService.addEquipment(equipmentForm);
        RestResult result = new RestResult(1,vo);
        model.addAttribute("result",result);
        return  "redirect:/equipments/manage/list";
    }

    /**
     * 在服务器更新资源（客户端提供改变后的完整资源)
     *
     * @param id 设备编号
     * @param equipmentForm 新闻对象（需传入与其属性相对应的参数）
     * @return 若修改成功则重定向至新闻详情界面,同时存入属性：
     * key为“update_success”,value为“1”；
     * 若修改失败则重定向至新闻编辑界面，同时存入属性：
     * key为“fail_result",value为出错原因
     */
    @RequestMapping(value = "/manage/update/{id}", method = RequestMethod.GET)
    public String put(@PathVariable("id") Integer id, EquipmentForm equipmentForm, RedirectAttributes ra) {
        EquipmentVo vo=equipmentService.modifyEquipment(equipmentForm,id);
        if(vo!=null){//修改成功跳转至新闻详情界面
            ra.addFlashAttribute("update_success","1");
            return "redirect:/equipments/"+vo.getId();
        }else{//修改失败跳转至编辑界面
            ra.addFlashAttribute("fail_result","修改失败");
            return "redirect:/equipments/manage/"+vo.getId();
        }
    }

    /**
     * 删除新闻
     *
     * @param id 新闻编号
     * @return json格式的RestResult对象（其data属性为EquipmentVo，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(value = "/manage/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult delete(@PathVariable("id") Integer id) {
        if (id == null) {
                return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "缺少编号"));
        }
        boolean res=equipmentService.deleteEquipment(id);
        if(!res){
            return RestResult.CreateResult(0,new Error(Error.SYS_ERROR,"删除过程出错"));
        }else
            return new RestResult(1,"");
    }
}
