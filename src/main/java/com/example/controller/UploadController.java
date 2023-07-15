package com.example.controller;

import cn.hutool.core.lang.UUID;
import com.example.entity.RestBean;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth/upload")
public class UploadController {

    final static String AVATAR_PATH = "static/avatar";

    @ResponseBody
    @PostMapping("/uploadtodisk")
    public RestBean<String> uploadAvatar(@RequestParam("imgFile") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        // System.out.println("来到这里啦");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String datePrefix = dateFormat.format(new Date());
        String savePath = "study-project-backend/src/main/resources/"+AVATAR_PATH;

        File folder = new File(savePath+ File.separator+datePrefix);

        if(!folder.isDirectory()){
            folder.mkdirs();
        }

        String originalName = multipartFile.getOriginalFilename();
        String saveName = UUID.randomUUID().toString()+originalName.substring(originalName.lastIndexOf("."),originalName.length());
        String absolutePath = folder.getAbsolutePath();

        try{
            File fileToSave = new File(absolutePath+File.separator+saveName);
            multipartFile.transferTo(fileToSave);
            String returnPath = request.getScheme()+"://"
                    +request.getServerName()+":"+request.getServerPort()
                    +"/api/auth/upload/uploadtodisk/"
                    +datePrefix+"/"+saveName;
            return RestBean.success(returnPath);
        }catch (Exception e){
            e.printStackTrace();
        }
        return RestBean.failure(401, "请上传正确格式的图片");



    }
}
