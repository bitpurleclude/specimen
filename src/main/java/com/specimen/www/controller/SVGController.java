package com.specimen.www.controller;

import com.specimen.www.bean.ImageWithSignPath;
import com.specimen.www.bean.ImgId;
import com.specimen.www.impl.ImgSVGServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SVGController {
    @Autowired
    private ImgSVGServiceImpl imgSVGService;
    @CrossOrigin
    @RequestMapping("/api/GetSVGById")
    public List<ImageWithSignPath> getSVGById(@RequestBody ImgId imgId) {
        return imgSVGService.getSVGByImgId(imgId.getImgId());
    }
}
