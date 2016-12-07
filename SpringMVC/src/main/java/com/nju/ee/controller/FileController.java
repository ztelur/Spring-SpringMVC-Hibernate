package com.nju.ee.controller;

import com.nju.ee.vo.RestResult;
import com.nju.ee.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Controller
@RequestMapping("/uploadFile")
public class FileController {
    @Autowired
    private FileService fileService;
    @RequestMapping(method = RequestMethod.GET)
    public String fileMain(){
        return "file";
    }
    /**
     * 上传文件
     * @param file
     * @return json格式的RestResult对象（其data属性为图像url，
     * result属性为是否成功，error属性为出错信息）
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public RestResult uploadImg(@RequestParam(value = "file")MultipartFile file, HttpServletRequest request){
        return fileService.saveFile(file,request);
    }
}
