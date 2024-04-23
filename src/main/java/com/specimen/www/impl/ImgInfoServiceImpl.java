package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.ImgInfo;
import com.specimen.www.mapper.ImgInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgInfoServiceImpl {
    @Autowired
    ImgInfoMapper imgInfoMapper;
    public ImgInfo getImgInfoByName(String name){
        List<ImgInfo> imgInfos = imgInfoMapper.selectList(new QueryWrapper<ImgInfo>().eq("img_name", name));
        if (imgInfos.size() == 0){
            return null;
        }
        return imgInfos.get(0);
    }
}
