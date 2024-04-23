package com.specimen.www.bean;

public class ImgName {
    private String name;

    public ImgName() {
    }

    public ImgName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return imgName
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "ImgName{imgName = " + name + "}";
    }
}
