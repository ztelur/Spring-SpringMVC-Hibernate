package com.nju.ee.service;

import com.nju.ee.po.RestResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface FileService {
    public RestResult saveFile(MultipartFile file);
}
