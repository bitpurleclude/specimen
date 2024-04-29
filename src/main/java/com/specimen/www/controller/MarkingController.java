package com.specimen.www.controller;

import com.specimen.www.bean.ImageWithSignPath;
import com.specimen.www.bean.ImgInfo;
import com.specimen.www.impl.ImgInfoServiceImpl;
import com.specimen.www.impl.ImgSVGServiceImpl;
import com.specimen.www.util.GetImgMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class MarkingController {
    @Autowired
    private ImgInfoServiceImpl imgInfoService;
    @Autowired
    private ImgSVGServiceImpl imgSVGService;
    @RequestMapping("/marking")
    public void markingPhoto(@RequestParam("svgPath")String svgPath,
                                    @RequestParam("svgName") String svgName,
                                    @RequestParam("file") MultipartFile file ) {

        try {
            String md5 = GetImgMD5.getMD5(GetImgMD5.multipartFileToBufferedImage(file));
            ImgInfo imgInfoByMD5 = imgInfoService.getImgInfoByMD5(md5);
            if (imgInfoByMD5 != null){
                ImageWithSignPath imageWithSignPath = new ImageWithSignPath();
                imageWithSignPath.setSvgPath(svgPath);
                imageWithSignPath.setImageId(imgInfoByMD5.getId());
                imgSVGService.addSVG(imageWithSignPath);
            }else {
                ImgInfo imgInfo = new ImgInfo();
                imgInfo.setMD5(md5);
                imgInfo.setImgName(file.getOriginalFilename());
                imgInfoService.addImgInfo(imgInfo);
                ImageWithSignPath imageWithSignPath = new ImageWithSignPath();
                imageWithSignPath.setSvgPath(svgPath);
                imageWithSignPath.setImageId(imgInfo.getId());
                imgSVGService.addSVG(imageWithSignPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
