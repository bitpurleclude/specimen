package com.specimen.www.controller;

import com.specimen.www.bean.ImgInfo;
import com.specimen.www.bean.ImgName;
import com.specimen.www.impl.ImgInfoServiceImpl;
import com.specimen.www.util.GetImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ShowPageController {
    @Autowired
    private ImgInfoServiceImpl imgInfoService;
    @Autowired
    private GetImg getImg;
    @RequestMapping("/getImgByName")
    public ResponseEntity<byte[]> getImgByName(@RequestBody ImgName imgName){
        ImgInfo imgInfoByName = imgInfoService.getImgInfoByName(imgName.getName());
        if (imgInfoByName == null){
            return null;
        }
        BufferedImage img = getImg.getImg(imgInfoByName.getImgName());
        System.out.println(img);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(img,"png",byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}