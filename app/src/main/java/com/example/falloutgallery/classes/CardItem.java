package com.example.falloutgallery.classes;

public class CardItem {
    private int imgRsrc;
    private String title;

    public CardItem() {
    }

    public CardItem(int imgRsrc, String title) {
        this.imgRsrc = imgRsrc;
        this.title = title;
    }

    public void setImgRsrc(int imgRsrc) {
        this.imgRsrc = imgRsrc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgRsrc() {
        return imgRsrc;
    }

    public String getTitle() {
        return title;
    }
}
