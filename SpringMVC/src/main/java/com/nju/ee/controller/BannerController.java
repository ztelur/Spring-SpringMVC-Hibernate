package com.nju.ee.controller;

import com.nju.ee.service.BannerService;
import com.nju.ee.vo.BannerListForm;
import com.nju.ee.vo.BannerVo;
import com.nju.ee.vo.RestResult;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

/**
 * Created by 克崽兽 on 2016/12/17.
 */
@Controller
@RequestMapping("/banners")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    /**
     * 将存入属性：key为“banners”，
     * value为RestResult(其data属性为BannerVo的列表，
     * result属性为是否成功，error属性为出错信息）
     *
     * @param updateResult
     * @param model
     * @return 跳转至banner管理界面
     */
    @RequestMapping(value = "/manage/list")
    public String manageBanner(@ModelAttribute(value = "update_fail_result")String updateResult, Model model) {
        if(updateResult.equals("")) { //若未发生更新失败，无需恢复未成功更新的banner信息
            RestResult result = bannerService.getBanners();
            System.out.println(result);
            System.out.println(result.getData());
            System.out.println(((ArrayList<BannerVo>)result.getData()));
            model.addAttribute("banners", result);
        }
        return "manage_banner";
    }

    /**
     * 供主页调用，获取所有banner信息
     *
     * @return RestResult(其data属性为BannerVo的列表，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public RestResult get(){
        RestResult result = bannerService.getBanners();
        return result;
    }

    /**
     * 更新服务器资源
     *
     * @param banners
     * @param ra
     * @return 重定向至banner管理界面，
     * 若修改成功则存入属性：
     * key为“update_success”,value为“1”；
     *
     * 若修改失败则存入属性1：
     * key为“update_fail_result",value为出错原因
     * 属性2：key为“banners”，value为RestResult对象
     * (data为BannerVo列表，包含编辑过的banner信息）
     */
    @RequestMapping(value = "/manage/update", method =  RequestMethod.GET)
    public String put(@RequestParam(value = "banners") BannerListForm banners, RedirectAttributes ra){
        String errorMessage = "";
        for (BannerVo bannerVo:banners.getBanners()) {
            RestResult result = bannerService.modifyBanner(bannerVo);
            if(result.getResult()!=1){
                errorMessage+= bannerVo.getPosition()+"位置的banner未成功存储，原因："
                        +result.getError().getMessage()+"\r\n";
            }
        }
        if(!errorMessage.equals("")){//若在存储过程中出错
            ra.addFlashAttribute("update_fail_result", errorMessage);
            ra.addFlashAttribute("banners", RestResult.CreateResult(1,banners.getBanners()));
        }else{
            ra.addFlashAttribute("update_success","1");
        }
        return "redirect:/banner/manage/list";
    }
}
