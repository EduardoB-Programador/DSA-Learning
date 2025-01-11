package com.eduardo.dataStructures;

public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }

    public Node() {}

    @Override
    public String toString() {
        return "[" + this.value + ", " + this.next + "]";
    }
}
