package com.specimen.www.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.specimen.www.bean.ImageWithSignPath;
import com.specimen.www.mapper.ImageWithSignMapper;
import com.specimen.www.service.ImgSVGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ImgSVGServiceImpl implements ImgSVGService {
    @Autowired
    private ImageWithSignMapper imageWithSignMapper;
    public List<String> getSVGByImgId(int imgId){
        List<ImageWithSignPath> imageWithSignPaths = imageWithSignMapper.selectList(new QueryWrapper<ImageWithSignPath>().eq("img_id", imgId));
        ArrayList<String> svgs = new ArrayList<>();
        for (ImageWithSignPath imageWithSignPath : imageWithSignPaths) {
            svgs.add(imageWithSignPath.getSvgPath());
        }
        return svgs;
    }
    public void addSVG(ImageWithSignPath imageWithSignPath){
        imageWithSignMapper.insert(imageWithSignPath);
    }
}
