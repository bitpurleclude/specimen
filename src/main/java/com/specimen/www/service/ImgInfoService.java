package com.specimen.www.service;

import com.specimen.www.bean.ImgInfo;

import java.util.List;

public interface ImgInfoService {
    ImgInfo getImgInfoByName(String name);

    ImgInfo getImgInfoByMD5(String md5);

    ImgInfo getImgInfoById(int id);

    List<ImgInfo> getAllImgInfo();

    void addImgInfo(ImgInfo imgInfo);

    ImgInfo addImgInfo(String imgName, String md5);
}
