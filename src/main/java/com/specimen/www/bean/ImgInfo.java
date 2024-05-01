package com.specimen.www.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class ImgInfo {
    @TableId(type = IdType.AUTO)
    private int id;
    private String imgName;
    @TableField("md5")
    private String MD5;
    private int width;
    private int height;

    public ImgInfo() {
    }


    public ImgInfo(int id, String imgName, String MD5, int width, int height) {
        this.id = id;
        this.imgName = imgName;
        this.MD5 = MD5;
        this.width = width;
        this.height = height;
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
     * @return imgName
     */
    public String getImgName() {
        return imgName;
    }

    /**
     * 设置
     * @param imgName
     */
    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    /**
     * 获取
     * @return MD5
     */
    public String getMD5() {
        return MD5;
    }

    /**
     * 设置
     * @param MD5
     */
    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

    public String toString() {
        return "ImgInfo{id = " + id + ", imgName = " + imgName + ", MD5 = " + MD5 + "}";
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
}
