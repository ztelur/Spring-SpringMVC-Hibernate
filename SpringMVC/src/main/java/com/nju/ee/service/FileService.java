package com.nju.ee.service;

import com.nju.ee.po.RestResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface FileService {
    public RestResult saveFile(MultipartFile file, HttpServletRequest request);
}
