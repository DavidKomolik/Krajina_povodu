package com.google.firebase.samples.apps.mlkit.java;

public class ContactItem {
    private int imgResource;
    private String textBigger;
    private String textSmaller;

    public ContactItem(int imgResource, String textBigger, String textSmaller) {
        this.imgResource = imgResource;
        this.textBigger = textBigger;
        this.textSmaller = textSmaller;
    }

    public int getImgResource() {
        return imgResource;
    }

    public String getTextBigger() {
        return textBigger;
    }

    public String getTextSmaller() {
        return textSmaller;
    }
}
