package com.nju.ee.controller;

import com.nju.ee.service.FileService;
import com.nju.ee.vo.RestResult;
import com.nju.ee.Constant.Extension;
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
     * 上传文件
     *
     * @param file
     * @return json:{"link":"url"}
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String post(@RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        RestResult result = fileService.saveFile(file);
        if(result.getResult()==1) {
            return "{\"link\":\""+(String) result.getData()+"\"}";
        }else{
            return null;
        }
    }

    @RequestMapping(value = "/{file_type}/{file_name}.{extension_name}", method = RequestMethod.GET)
    public void get(@PathVariable(value = "file_name") String fileName,
                    @PathVariable(value = "extension_name") String extensionName
            , HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType(Extension.extension2ContentType(extensionName));
        try (FileInputStream fis = fileService.getFile(fileName+"."+extensionName);
             OutputStream os = response.getOutputStream()){

            int count = 0;
            byte[] buffer = new byte[1024 * 1024];
            while ((count = fis.read(buffer)) != -1) {
                os.write(buffer, 0, count);
                os.flush();
            }
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
