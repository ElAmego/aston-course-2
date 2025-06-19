package dz3;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Генадий", List.of(
                        new Book("Толстой", "Война и мир", 200, 2001),
                        new Book("Джойс", "Улисс", 150, 1900),
                        new Book("Фолкнер", "Звук и ярость", 10, 2000),
                        new Book("Вулф", "На маяк", 55, 1765),
                        new Book("Ачебе", "Распад", 100, 1800)
                )),

                new Student("Александр", List.of(
                        new Book("Митчелл", "Унесенные ветром", 90, 2005),
                        new Book("Рушди", "Дети полуночи", 222, 1650),
                        new Book("Геродот", "История", 60, 1500),
                        new Book("Гоббс", "Левиафан", 80, 2015),
                        new Book("Милн", "Винни-Пух", 100, 1999)
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