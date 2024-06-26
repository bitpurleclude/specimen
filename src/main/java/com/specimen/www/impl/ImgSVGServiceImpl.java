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
    public List<ImageWithSignPath> getSVGByImgId(int imgId){
        List<ImageWithSignPath> imageWithSignPaths = imageWithSignMapper.selectList(new QueryWrapper<ImageWithSignPath>().eq("img_id", imgId));
        return imageWithSignPaths;
//        ArrayList<String> svgs = new ArrayList<>();
//        for (ImageWithSignPath imageWithSignPath : imageWithSignPaths) {
//            svgs.add(imageWithSignPath.getSvgPath());
//        }
//        return svgs;
    }
    @Override
    public void addSVG(ImageWithSignPath imageWithSignPath){
        imageWithSignMapper.insert(imageWithSignPath);
    }
    @Override
    public void addSVG(String svgPath, int imgId, String svgName){
        ImageWithSignPath imageWithSignPath = new ImageWithSignPath();
        imageWithSignPath.setSvgPath(svgPath);
        imageWithSignPath.setImageId(imgId);
        imageWithSignPath.setSvgName(svgName);
        imageWithSignMapper.insert(imageWithSignPath);
    }
}
