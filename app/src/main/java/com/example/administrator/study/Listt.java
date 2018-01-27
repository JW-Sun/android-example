package com.example.administrator.study;

/**
 * Created by Administrator on 2018/1/23.
 */

public class Listt {
    private String name;
    private int imgId;
    public Listt(String name, int imgId){
        this.imgId=imgId;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public int getImgId(){
        return imgId;
    }
}
