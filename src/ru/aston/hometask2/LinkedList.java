package ru.aston.hometask2;

import java.util.Collection;
import java.util.NoSuchElementException;

final public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(final T value) {
        final Node<T> node = new Node<>(value);

        if (head == null) {
            head = node;
        } else {
            tail.nextNode = node;
        }

        node.prevNode = tail;
        tail = node;

        size++;
    }

    public void add(final int index, final T value) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        final Node<T> node = new Node<>(value);

        if (index == 0) {
            if (size != 0) {
                head.prevNode = node;
                node.nextNode = head;
            }

            head = node;
            tail = node;

        } else if (index == size) {
            tail.nextNode = node;
            node.prevNode = tail;
            tail = node;
        } else {
            final Node<T> currentNode = getNecessaryNode(index);

            node.prevNode = currentNode.prevNode;
            node.prevNode.nextNode = node;
            node.nextNode = currentNode;
            currentNode.prevNode = node;
        }

        size++;
    }

    public T get(final int index) {
        if (index >= size || index < 0) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        final Node<T> currentNode = getNecessaryNode(index);

        return (T) currentNode.value;
    }

    public void remove() {
        if (size == 0) throw new NoSuchElementException();
        else if (size == 1) {
            head = null;
            tail = null;
        } else {
            tail.prevNode.nextNode = null;
        }

        size--;
    }

    public void remove(final int index) {
        if (size == 0) throw new NoSuchElementException();

        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
            } else {
                head = head.nextNode;
                head.prevNode = null;
            }
        } else if (index == size-1) {
            tail = tail.prevNode;
            tail.nextNode = null;
        } else {
            final Node<T> currentNode = getNecessaryNode(index);

            currentNode.prevNode.nextNode = currentNode.nextNode;
            currentNode.nextNode.prevNode = currentNode.prevNode;
        }

        size--;
    }

    public String toString() {
        Node<T> currentNode = head;
        String result = "";
        while (currentNode != null) {
            result += currentNode.value + " ";
            currentNode = currentNode.nextNode;
        }
        return result;
    }

    public int size() {
        return size;
    }

    public void addAll(final Collection<T> collection) {
        for (T item: collection) {
            add(item);
        }
    }

    public void addAll(int index, final Collection<T> collection) {
        for (T item: collection) {
            add(index++, item);
        }
    }

    private Node<T> getNecessaryNode(final int index) {
        Node<T> currentNode = head;
        int counter = 0;

        while (counter != index) {
            currentNode = currentNode.nextNode;
            counter++;
        }

        return currentNode;
    }
}