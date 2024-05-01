package com.specimen.www.service;

import com.specimen.www.bean.ImageWithSignPath;

public interface ImgSVGService {
    void addSVG(ImageWithSignPath imageWithSignPath);


    void addSVG(String svgPath, int imgId, String svgName);
}
