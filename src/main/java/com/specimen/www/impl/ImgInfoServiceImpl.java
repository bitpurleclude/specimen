package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.ImgInfo;
import com.specimen.www.mapper.ImgInfoMapper;
import com.specimen.www.service.ImgInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgInfoServiceImpl implements ImgInfoService {
    @Autowired
    ImgInfoMapper imgInfoMapper;
    @Override
    public ImgInfo getImgInfoByName(String name){
        List<ImgInfo> imgInfos = imgInfoMapper.selectList(new QueryWrapper<ImgInfo>().eq("img_name", name));
        if (imgInfos.size() == 0){
            return null;
        }
        return imgInfos.get(0);
    }
    @Override
    public ImgInfo getImgInfoByMD5(String md5){
        List<ImgInfo> imgInfos = imgInfoMapper.selectList(new QueryWrapper<ImgInfo>().eq("md5", md5));
        if (imgInfos.size() == 0){
            return null;
        }
        return imgInfos.get(0);
    }
    @Override
    public List<ImgInfo> getAllImgInfo(){
        return imgInfoMapper.selectList(null);
    }
    @Override
    public void addImgInfo(ImgInfo imgInfo){
        imgInfoMapper.insert(imgInfo);
    }
    @Override
    public ImgInfo addImgInfo(String imgName, String md5){
        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setImgName(imgName);
        imgInfo.setMD5(md5);
        imgInfoMapper.insert(imgInfo);
        return imgInfo;
    }
}
