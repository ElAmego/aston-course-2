package dz2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(0, 15);
        myList.add(20);
        myList.add(2, 5);
        myList.remove(1);
        myList.addAll(1, Arrays.asList(1, 2, 3, 4));
        System.out.println(myList.size() + " -> размер");
        System.out.println(myList + " -> строка всех элементов");
        System.out.println(myList.get(3) + " -> получение элемента по индексу");
    }
}