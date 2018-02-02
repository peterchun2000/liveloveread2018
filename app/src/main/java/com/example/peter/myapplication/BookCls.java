package com.example.peter.myapplication;


public class BookCls {
    private String title;
    private String author;
    private int image;


    private String date;

    public BookCls(String title, String author, int image,String date) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.date = date;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
