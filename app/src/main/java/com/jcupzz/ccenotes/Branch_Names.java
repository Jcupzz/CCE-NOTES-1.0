package com.jcupzz.ccenotes;

public class Branch_Names {

    private int b_image;
    private String b_name;


    public Branch_Names(int b_image, String b_name) {
        this.b_name = b_name;
        this.b_image = b_image;
    }

    public String getB_name() {
        return b_name;
    }
    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
    public int getB_image() {
        return b_image;
    }

    public void setB_image(int b_image) {
        this.b_image = b_image;
    }

}
