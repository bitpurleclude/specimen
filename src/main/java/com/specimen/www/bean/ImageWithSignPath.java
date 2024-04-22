package com.specimen.www.bean;


import java.awt.image.BufferedImage;

public class ImageWithSignPath {
    private int id;
    private String svg;
    private BufferedImage image;
    private String hashCode;
    private String sign;
    private String path;

    public ImageWithSignPath() {
    }

    public ImageWithSignPath(int id, String svg) {
        this.id = id;
        this.svg = svg;
    }

    public ImageWithSignPath(int id, String svg, BufferedImage image, String hashCode, String sign, String path) {
        this.id = id;
        this.svg = svg;
        this.image = image;
        this.hashCode = hashCode;
        this.sign = sign;
        this.path = path;
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
     * @return path
     */
    public String getSvg() {
        return svg;
    }

    /**
     * 设置
     * @param svg
     */
    public void setSvg(String svg) {
        this.svg = svg;
    }

    public String toString() {
        return "ImageWithSign{id = " + id + ", path = " + svg + "}";
    }


    /**
     * 获取
     * @return image
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * 获取
     * @return hashCode
     */
    public String getHashCode() {
        return hashCode;
    }

    /**
     * 设置
     * @param hashCode
     */
    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    /**
     * 获取
     * @return sign
     */
    public String getSign() {
        return sign;
    }

    /**
     * 设置
     * @param sign
     */
    public void setSign(String sign) {
        this.sign = sign;
    }

    /**
     * 获取
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }
}
