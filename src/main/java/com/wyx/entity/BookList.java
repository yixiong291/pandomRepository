package com.wyx.entity;

public class BookList {
    private String bookName;
    private String author;
    private String ISBN;
    private String summary;
    private String language;
    private String status;
    private int bookNum;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public BookList(String bookName, String author, String ISBN, String summary, String language, String status, int bookNum) {
        this.bookName = bookName;
        this.author = author;
        this.ISBN = ISBN;
        this.summary = summary;
        this.language = language;
        this.status = status;
        this.bookNum = bookNum;
    }

    public BookList(){
    }

    @Override
    public String toString() {
        return "BookList{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", summary='" + summary + '\'' +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }
}
