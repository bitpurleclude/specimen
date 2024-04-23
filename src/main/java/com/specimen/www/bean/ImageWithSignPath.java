package com.specimen.www.bean;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.awt.image.BufferedImage;

public class ImageWithSignPath {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField("path")
    private String svgPath;
    @TableField("img_id")
    private int imageId;

    public ImageWithSignPath() {
    }

    public ImageWithSignPath(int id, String svgPath, int imageId) {
        this.id = id;
        this.svgPath = svgPath;
        this.imageId = imageId;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return svgPath
     */
    public String getSvgPath() {
        return svgPath;
    }

    /**
     * 设置
     * @param svgPath
     */
    public void setSvgPath(String svgPath) {
        this.svgPath = svgPath;
    }

    /**
     * 获取
     * @return imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * 设置
     * @param imageId
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String toString() {
        return "ImageWithSignPath{id = " + id + ", svgPath = " + svgPath + ", imageId = " + imageId + "}";
    }
}
