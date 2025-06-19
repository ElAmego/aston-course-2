package dz1;

import java.util.LinkedList;

/**
 * Метод add(E value) – добавление элемента во множество.
 * Метод remove(E value) – удаление элемента.
 * Метод contains(E value) – возвращает true или false в зависимости есть ли элемент или нет.
 * Метод size() – возвращает размер множества.
 * Метод toString() – возвращает строковое представление множества.
 */

final public class HashSet<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    private LinkedList<E>[] buckets;
    private int size;

    public HashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void add(final E element) {
        if (contains(element)) return;

        if ((float)size / buckets.length >= LOAD_FACTOR) {
            resize();
        }

        final int bucketIndex = getBucketIndex(element);
        buckets[bucketIndex].add(element);
        size++;
    }

    public void remove(final E element) {
        final int bucketIndex = getBucketIndex(element);
        final LinkedList<E> bucket = buckets[bucketIndex];

        for (E e : bucket) {
            if (e.equals(element)) {
                bucket.remove(e);
                size--;
            }
        }
    }

    public boolean contains(final E element) {
        final int bucketIndex = getBucketIndex(element);
        final LinkedList<E> bucket = buckets[bucketIndex];

        for (E e : bucket) {
            if (e.equals(element)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    private int getBucketIndex(final E element) {
        if (element == null) {
            return 0;
        }

        return Math.abs(element.hashCode()) % buckets.length;
    }

    private void resize() {
        final LinkedList<E>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        size = 0;
        for (LinkedList<E> bucket : oldBuckets) {
            for (E element : bucket) {
                add(element);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;

        for (LinkedList<E> bucket : buckets) {
            for (E element : bucket) {
                result += element != null ? element.hashCode() : 0;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";

        for (LinkedList<E> bucket : buckets) {
            for (E element : bucket) {
                result += element + " ";
            }
        }

        return result;
    }
}