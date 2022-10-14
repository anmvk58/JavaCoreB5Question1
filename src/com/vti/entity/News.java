package com.vti.entity;

public class News implements INews{
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private int[] rates;
    private float averageRate;


    public News(String title, String publishDate, String author, String content, int[] rates) {
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.content = content;
        this.rates = rates;
    }

    @Override
    public void display() {
        System.out.println("\n************************");
        System.out.println("Title: " + title);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Average Rate: " + averageRate);
    }

    @Override
    public float calculate() {
        int sumRate = 0;
        for(int i = 0; i < rates.length; i++){
            sumRate += rates[i];
        }
        float result = (float) sumRate/rates.length;
        averageRate = result;
        return result;
    }
}
