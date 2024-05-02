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
    @TableField("svgName")
    private String svgName;
    @TableField("img_id")
    private int imageId;
    private int width;
    private int height;
    private String description;

    public ImageWithSignPath() {
    }


    public ImageWithSignPath(int id, String svgPath, String svgName, int imageId, int width, int height) {
        this.id = id;
        this.svgPath = svgPath;
        this.svgName = svgName;
        this.imageId = imageId;
        this.width = width;
        this.height = height;
    }

    public ImageWithSignPath(int id, String svgPath, String svgName, int imageId, int width, int height, String description) {
        this.id = id;
        this.svgPath = svgPath;
        this.svgName = svgName;
        this.imageId = imageId;
        this.width = width;
        this.height = height;
        this.description = description;
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

    /**
     * 获取
     * @return svgName
     */
    public String getSvgName() {
        return svgName;
    }

    /**
     * 设置
     * @param svgName
     */
    public void setSvgName(String svgName) {
        this.svgName = svgName;
    }

    /**
     * 获取
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * 设置
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 获取
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
