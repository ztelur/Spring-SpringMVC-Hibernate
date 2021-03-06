package com.nju.ee.service;

import com.nju.ee.vo.RestResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface FileService {
    public RestResult saveFile(MultipartFile file);

    public FileInputStream getFile(String fileName);

    public RestResult deleteFile(String fileUrl);
}
