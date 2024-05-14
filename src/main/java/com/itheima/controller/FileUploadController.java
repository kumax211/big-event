package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @projectName: big-event
 * @package: com.itheima.controller
 * @className: FileUploadController
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/14 18:54
 * @version: 1.0
 */

@RestController
public class FileUploadController {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        //把文件的内容存到本地磁盘上

        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        //保证名字是唯一的UUID
        String fileName = UUID.randomUUID().toString()+substring;
//        file.transferTo(new File("E:\\BaiduNetdiskDownload\\springboot+vue\\file\\" + fileName));
        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
        return Result.success(url);
    }
}
