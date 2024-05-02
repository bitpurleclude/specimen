package com.specimen.www.controller;

import com.specimen.www.bean.ImgId;
import com.specimen.www.bean.ImgInfo;
import com.specimen.www.bean.ImgName;
import com.specimen.www.impl.ImgInfoServiceImpl;
import com.specimen.www.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class ShowPageController {
    @Autowired
    private ImgInfoServiceImpl imgInfoService;
    @Autowired
    private ImgUtil imgUtil;
    @CrossOrigin
    @RequestMapping("/api/getImgByName")
    public ResponseEntity<byte[]> getImgByName(@RequestBody ImgName imgName) {
        ImgInfo imgInfoByName = imgInfoService.getImgInfoByName(imgName.getName());
        try {
            ResponseEntity<byte[]> responseEntity = imgUtil.returnImgInfo(imgInfoByName);
            return responseEntity;
        }catch (IOException e) {
            return null;
        }
    }
    @CrossOrigin
    @RequestMapping("/api/getImgById")
    public ResponseEntity<byte[]> getImgById(@RequestBody ImgId imgId) {
        ImgInfo imgInfoById = imgInfoService.getImgInfoById(imgId.getImgId());
        try {
            ResponseEntity<byte[]> responseEntity = imgUtil.returnImgInfo(imgInfoById);
            return responseEntity;
        }catch (IOException e) {
            return null;
        }
    }
    @CrossOrigin
    @RequestMapping("/api/getAllImgInfo")
    public List<ImgInfo> getAllImgInfo(){
        return imgInfoService.getAllImgInfo();
    }


}
