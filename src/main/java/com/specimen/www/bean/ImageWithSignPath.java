package com.specimen.www.bean;


public class ImageWithSignPath {
    private int id;
    private String path;

    public ImageWithSignPath() {
    }

    public ImageWithSignPath(int id, String path) {
        this.id = id;
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

    public String toString() {
        return "ImageWithSign{id = " + id + ", path = " + path + "}";
    }


}
