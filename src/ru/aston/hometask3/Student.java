package ru.aston.hometask3;

import java.util.List;

final public class Student {
    private String name;
    private List<Book> bookList;

    public Student(final String name, final List<Book> bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    @Override
    public String toString() {
        final String formattedString = String.format("Имя студента: %s", name);
        return formattedString;
    }
}