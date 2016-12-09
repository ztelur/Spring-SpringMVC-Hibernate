package com.nju.ee.service;

import com.nju.ee.vo.FileType;

import com.nju.ee.vo.Error;
import com.nju.ee.vo.RestResult;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.*;

/**
 * Created by 克崽兽 on 2016/12/5.
 */
@Service
public class FileServiceImpl extends ApplicationObjectSupport implements FileService {
    public RestResult saveFile(MultipartFile file, FileType fileType) {
        if (file == null || file.isEmpty()) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "文件不能为空"));
        }
        long maxUploadSize = ((CommonsMultipartResolver) this.getApplicationContext().getBean("multipartResolver"))
                .getFileUpload().getSizeMax();
        if (file.getSize() > maxUploadSize) {
            return RestResult.CreateResult(0, new Error(Error.BAD_PARAM, "文件大小不得超过5M"));
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取扩展名
        String extensionName = fileName
                .substring(fileName.lastIndexOf(".") + 1);
        // 新的文件名 = 获取时间戳+"."+扩展名
        String newFileName = String.valueOf(System.currentTimeMillis())
                + "." + extensionName;
        //文件目录路径
        //TODO:新增属性文件保存路径，方便读取修改
        String filePath =   "d:/fileUpload";

        try {
            InputStream input = file.getInputStream();
            File savePath = new File(filePath);
            if (!savePath.exists()) {
                savePath.mkdir();
            }
            long byteSaved = saveFileFromInputStream(input, savePath.toString(), newFileName);
            if (byteSaved != file.getSize()) {
                return RestResult.CreateResult(0, new Error(Error.SYS_ERROR,
                        "文件保存出错（成功存储的文件大小不符合实际大小)"));
            }
            String fileUrl = filePath2Url(filePath + "/" + newFileName, fileType);
            return RestResult.CreateResult(1, fileUrl);
        } catch (IOException e) {
//            e.printStackTrace();
            return RestResult.CreateResult(0, new Error(Error.SYS_ERROR, e.getMessage()));
        }

    }

    public FileInputStream getFile(String fileName) {
        String filePath = fileName2FilePath(fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            try {
                fis = new FileInputStream( filePath.substring(0,filePath.lastIndexOf("/")+1)+"default.png");
            } catch (FileNotFoundException e1) {
//                e1.printStackTrace();
            }
        }
        return fis;
    }

    private String filePath2Url(String filePath, FileType fileType) {
        String fileName = filePath
                .substring(filePath.lastIndexOf("/") + 1);
        //TODO:新增属性文件保存路径，方便读取修改
        String contextRoot = "http://localhost:8080/ee/files";
        switch (fileType) {
            case DEFAULT:
                contextRoot += "";
                break;
            case IMAGE:
                contextRoot += "/img";
                break;
            case PDF:
                contextRoot += "/pdf";
                break;
        }
        return contextRoot + "/" + fileName;
    }

    private String fileName2FilePath(String fileName) {
        //TODO:新增属性文件保存路径，方便读取修改
        String fileRoot = "d:/fileUpload";
        return fileRoot + "/" + fileName;
    }

    private long saveFileFromInputStream(InputStream input, String path, String filename) throws IOException {
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        byte[] buffer = new byte[1024 * 1024];
        long byteSum = 0;
        int byteRead = 0;
        while ((byteRead = input.read(buffer)) != -1) {
            byteSum += byteRead;
            fs.write(buffer, 0, byteRead);
            fs.flush();
        }
        fs.close();
        input.close();
        return byteSum;
    }
}
