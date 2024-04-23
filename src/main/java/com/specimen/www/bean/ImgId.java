package com.specimen.www.bean;

public class ImgId {
    private int imgId;

    public ImgId() {
    }

    public ImgId(int imgId) {
        this.imgId = imgId;
    }

    /**
     * 获取
     * @return id
     */
    public int getImgId() {
        return imgId;
    }

    /**
     * 设置
     * @param imgId
     */
    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String toString() {
        return "ImgId{id = " + imgId + "}";
    }
}
