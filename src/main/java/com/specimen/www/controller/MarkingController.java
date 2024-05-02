package com.specimen.www.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.specimen.www.bean.ImageWithSignPath;
import com.specimen.www.bean.ImgInfo;
import com.specimen.www.impl.ImgInfoServiceImpl;
import com.specimen.www.impl.ImgSVGServiceImpl;
import com.specimen.www.util.GetImgMD5;
import com.specimen.www.util.ImgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.core.type.TypeReference;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import static com.specimen.www.util.StingUtil.getFileExtensionFromMimeType;

@RestController
public class MarkingController {
    @Autowired
    private ImgInfoServiceImpl imgInfoService;
    @Autowired
    private ImgSVGServiceImpl imgSVGService;
    @Autowired
    private ImgUtil imgUtil;
    @RequestMapping("/marking")
    public ResponseEntity<String> markingPhoto(@RequestParam("svgPath")String svgPath,
                                       @RequestParam("svgName") String svgName,
                                       @RequestParam("file") MultipartFile file ) {

        try {
            String md5 = GetImgMD5.getMD5(GetImgMD5.multipartFileToBufferedImage(file));
            ImgInfo imgInfoByMD5 = imgInfoService.getImgInfoByMD5(md5);
            if (imgInfoByMD5 != null){
                imgSVGService.addSVG(svgPath,imgInfoByMD5.getId(),svgName);
            }else {
                BufferedImage bufferByFile = imgUtil.getBufferByFile(file);
                ImgInfo imgInfo = imgInfoService.addImgInfo(file.getOriginalFilename(), md5, bufferByFile.getWidth(), bufferByFile.getHeight());
                imgSVGService.addSVG(svgPath,imgInfo.getId(),svgName);
                imgUtil.saveImg(bufferByFile,file.getOriginalFilename(),getFileExtensionFromMimeType(file.getContentType()));
            }
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("处理成功", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:5173")
    @RequestMapping("/SendSVGPath")
    public ResponseEntity<String> SendSVGPath(@RequestParam("file") MultipartFile file,
                                              @RequestParam("svgPaths") String svgPathsString) {
        List<ImageWithSignPath> svgPaths = JSON.parseArray(svgPathsString, ImageWithSignPath.class);
            try {
            String md5 = GetImgMD5.getMD5(GetImgMD5.multipartFileToBufferedImage(file));
            ImgInfo imgInfoByMD5 = imgInfoService.getImgInfoByMD5(md5);
            if (imgInfoByMD5 != null){
                for (ImageWithSignPath svgPath : svgPaths) {
                    svgPath.setImageId(imgInfoByMD5.getId());
                imgSVGService.addSVG(svgPath);
                 }
            }else {
                BufferedImage bufferByFile = imgUtil.getBufferByFile(file);
                ImgInfo imgInfo = imgInfoService.addImgInfo(file.getOriginalFilename(), md5, bufferByFile.getWidth(), bufferByFile.getHeight());
                for (ImageWithSignPath svgPath : svgPaths) {
                    svgPath.setImageId(imgInfo.getId());
                    imgSVGService.addSVG(svgPath);
                }
                imgUtil.saveImg(bufferByFile,file.getOriginalFilename(),getFileExtensionFromMimeType(file.getContentType()));
            }
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("处理成功", HttpStatus.OK);
    }
}
