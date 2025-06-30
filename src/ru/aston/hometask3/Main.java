package ru.aston.hometask3;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Генадий", List.of(
                        new Book.Builder("Толстой", "Война и мир")
                                .setPages(200)
                                .setYear(2001)
                                .build(),
                        new Book.Builder("Джойс", "Улисс")
                                .setPages(150)
                                .setYear(1900)
                                .build(),
                        new Book.Builder("Фолкнер", "Звук и ярость")
                                .setPages(10)
                                .setYear(2000)
                                .build(),
                        new Book.Builder("Вулф", "На маяк")
                                .setPages(55)
                                .setYear(1765)
                                .build(),
                        new Book.Builder("Ачебе", "Распад")
                                .setPages(100)
                                .setYear(1800)
                                .build()
                )),

                new Student("Александр", List.of(
                        new Book.Builder("Митчелл", "Унесенные ветром")
                                .setPages(90)
                                .setYear(2005)
                                .build(),
                        new Book.Builder("Рушди", "Дети полуночи")
                                .setPages(222)
                                .setYear(1650)
                                .build(),
                        new Book.Builder("Геродот", "История")
                                .setPages(60)
                                .setYear(1500)
                                .build(),
                        new Book.Builder("Гоббс", "Левиафан")
                                .setPages(80)
                                .setYear(2015)
                                .build(),
                        new Book.Builder("Милн", "Винни-Пух")
                                .setPages(100)
                                .setYear(1999)
                                .build()
                ))
        );

        students.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBookList().stream())
                .sorted(Comparator.comparingInt(Book::getPages))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .map(Book::getYear)
                .findFirst()
                .ifPresentOrElse(year -> System.out.println("Год выпуска книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}