package com.example.helloword.controller;

import org.apache.commons.logging.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileController {

    @PostMapping("/upload")
    public String up(String name , MultipartFile photo, HttpServletRequest request){
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(photo.getContentType());
        System.out.println(photo.getName());
        System.out.println(path);
        saveFile(path,photo);
        return "上传中";
    }

    public void saveFile(String path,MultipartFile photo){
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }
        File file= new File(path+photo.getOriginalFilename());
        try {
            photo.transferTo(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
