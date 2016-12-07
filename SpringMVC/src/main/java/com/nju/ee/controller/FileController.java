package com.nju.ee.controller;

import com.nju.ee.vo.FileType;
import com.nju.ee.vo.RestResult;
import com.nju.ee.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Controller
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    /**
     * @return 跳转至文件上传测试主页
     */
    @RequestMapping(method = RequestMethod.GET)
    public String fileMain() {
        return "file";
    }

    /**
     * 上传图像
     *
     * @param file
     * @return json格式的RestResult对象（其data属性为图像url，
     * result属性为是否成功，error属性为出错信息）
     */
    //TODO:将路径中的img修改为路径变量以适用于任何类型的文件
    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    public RestResult post(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        return fileService.saveFile(file, request.getSession().getServletContext().getRealPath("/"), FileType.IMAGE);
    }

    @RequestMapping(value = "/img/{file_name}", method = RequestMethod.GET)
    public void get(@PathVariable(value = "file_name") String fileName, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        //TODO：需要根据文件类型设置内容类型
        response.setContentType("image/png");

        FileInputStream fis = fileService.getFile(fileName);
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            int count= 0 ;
            byte[] buffer = new byte[1024*1024];
            while((count=fis.read(buffer))!=-1){
                os.write(buffer,0,count);
                os.flush();
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }finally{
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }
        }

    }
}
