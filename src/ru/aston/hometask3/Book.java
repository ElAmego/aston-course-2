package ru.aston.hometask3;

final public class Book {
    private String author;
    private String bookName;
    private int pages;
    private int year;

    public Book(final String author, final String bookName, final int pages, final int year) {
        this.author = author;
        this.bookName = bookName;
        this.pages = pages;
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }
}