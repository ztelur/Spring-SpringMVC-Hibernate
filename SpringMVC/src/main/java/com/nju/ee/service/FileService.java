package com.nju.ee.service;

import com.nju.ee.po.FileType;
import com.nju.ee.po.RestResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
public interface FileService {
    public RestResult saveFile(MultipartFile file, String realPath, FileType fileType);

    public FileInputStream getFile(String fileName);
}
