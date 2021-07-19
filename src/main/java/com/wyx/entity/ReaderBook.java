package com.wyx.entity;

public class ReaderBook {
    private int id;
    private String name;
    private String bookName;
    private String ISBN;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public ReaderBook(int id, String name, String bookName, String ISBN) {
        this.id = id;
        this.name = name;
        this.bookName = bookName;
        this.ISBN = ISBN;
    }

    public ReaderBook(String name, String bookName, String ISBN) {
        this.name = name;
        this.bookName = bookName;
        this.ISBN = ISBN;
    }

    public ReaderBook() {
    }

    @Override
    public String toString() {
        return "ReaderBook{" +
                "name='" + name + '\'' +
                ", bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }
}
