package ru.aston.hometask3;

final public class Book {
    private String author;
    private String bookName;
    private int pages;
    private int year;

    private Book(Builder builder) {
        this.author = builder.author;
        this.bookName = builder.bookName;
        this.pages = builder.pages;
        this.year = builder.year;
    }

    public int getYear() {
        return year;
    }

    public int getPages() {
        return pages;
    }

    public static class Builder {
        private String author;
        private String bookName;

        private int pages = 0;
        private int year = 0;

        public Builder(final String author, final String bookName) {
            this.author = author;
            this.bookName = bookName;
        }

        public Builder setPages(int pages) {
            this.pages = pages;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}