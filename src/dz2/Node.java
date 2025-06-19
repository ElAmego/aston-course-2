package dz2;

final public class Node<T> {
    public Node<T> prevNode;
    public Node<T> nextNode;
    T value;

    public Node(T value) {
        this.value = value;
    }
}