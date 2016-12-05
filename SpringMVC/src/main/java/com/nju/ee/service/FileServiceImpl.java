package com.nju.ee.service;

import com.nju.ee.po.Error;
import com.nju.ee.po.RestResult;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Service
public class FileServiceImpl extends ApplicationObjectSupport implements FileService {
    public RestResult saveFile(MultipartFile file) {

        if(file.isEmpty()){
            return RestResult.CreateResult(0,new Error(Error.BAD_PARAM,"文件不能为空"));
        }
        long maxUploadSize = ((CommonsMultipartResolver) this.getApplicationContext().getBean("multipartResolver")).getFileUpload().getSizeMax();
//        if(file.getSize()>){}
        return null;
    }
}
