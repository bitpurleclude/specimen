package com.specimen.www.service;

import com.specimen.www.bean.ImgInfo;

public interface ImgInfoService {
    ImgInfo getImgInfoByName(String name);

    ImgInfo getImgInfoByMD5(String md5);

    void addImgInfo(ImgInfo imgInfo);
}
