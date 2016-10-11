package com.cnfwsy.spider.txt.bean;

/**
 * 说明:
 * Created by zhangjh on 2016-08-16.
 */
public class Jc_pantone {
    private String color_no;
    private String en_name;
    private String zh_name;
    private int kind;
    private String pantone_id;

    public String getPantone_id() {
        return pantone_id;
    }

    public void setPantone_id(String pantone_id) {
        this.pantone_id = pantone_id;
    }

    public String getColor_no() {
        return color_no;
    }

    public void setColor_no(String color_no) {
        this.color_no = color_no;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getZh_name() {
        return zh_name;
    }

    public void setZh_name(String zh_name) {
        this.zh_name = zh_name;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "Jc_pantone{" +
                "color_no='" + color_no + '\'' +
                ", en_name='" + en_name + '\'' +
                ", zh_name='" + zh_name + '\'' +
                ", kind=" + kind +
                '}';
    }
}

