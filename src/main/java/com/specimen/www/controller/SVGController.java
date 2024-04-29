package com.specimen.www.controller;

import com.specimen.www.bean.ImgId;
import com.specimen.www.impl.ImgSVGServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SVGController {
    @Autowired
    private ImgSVGServiceImpl imgSVGService;
    @RequestMapping("/GetSVGById")
    public List<String> getSVGById(@RequestBody ImgId imgId) {
        List<String> svgByImgId = imgSVGService.getSVGByImgId(imgId.getImgId());
        return svgByImgId;
    }
}