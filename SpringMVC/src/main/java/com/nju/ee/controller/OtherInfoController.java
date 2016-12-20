package com.nju.ee.controller;

import com.nju.ee.service.OtherInfoService;
import com.nju.ee.vo.OtherInfoVo;
import com.nju.ee.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by zangxiaojie on 2016/12/20.
 */
@Controller
@RequestMapping("/otherInfos")
public class OtherInfoController {
    @Autowired
    private OtherInfoService otherInfoService;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public RestResult get(){
        RestResult restResult=otherInfoService.getOtherInfo();
        return restResult;
    }

    @RequestMapping(value="/manage/list")
    public String manageOtherInfo(Model model){
        RestResult result=otherInfoService.getOtherInfo();
        model.addAttribute("otherInfo",result);
        return "manage_otherInfo";
    }

    /**
     *
     * @param otherInfoVo
     * @param ra
     * @return
     */
    @RequestMapping(value="/manage/update",method = RequestMethod.POST)
    public String update(OtherInfoVo otherInfoVo, RedirectAttributes ra){
        String errorMessage="";
        RestResult result=otherInfoService.modifyOtherInfo(otherInfoVo);
        if(result.getResult()!=1){
            errorMessage=result.getError().getMessage();
        }
        if(!errorMessage.equals("")){
            ra.addFlashAttribute("update_fail_result",errorMessage);
            ra.addFlashAttribute("otherInfo",RestResult.CreateResult(1,otherInfoVo));

        }else{
            ra.addFlashAttribute("update_success","1");

        }
        return "redirect:/otherInfos/manage/list";

    }

}
