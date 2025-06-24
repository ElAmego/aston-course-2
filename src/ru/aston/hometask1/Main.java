package ru.aston.hometask1;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> mySet = new HashSet<>();

        mySet.add(5);
        mySet.add(2);
        mySet.add(2);
        mySet.add(10);
        mySet.remove(10);

        System.out.println(mySet.size());
        System.out.println(mySet.contains(3));
        System.out.println(mySet);
    }
}