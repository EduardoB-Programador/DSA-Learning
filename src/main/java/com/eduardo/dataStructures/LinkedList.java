package com.eduardo.dataStructures;

public class LinkedList<T> {
    private Node<T> head;
    private Integer size = 0;

    public LinkedList() {}

    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (this.head == null)
            this.head = newNode;

        else {
            Node<T> lastNode = this.head;
            while (lastNode.next != null)
                lastNode = lastNode.next;

            lastNode.next = newNode;
        }

        this.size++;
    }

    public void add(int index, T value) {

        if (index <= 0)
            this.addFirst(value);

        else if (index >= this.size) {
            this.add(value);

        } else {
            Node<T> indexNode = new Node<>(value);

            Node<T> n = this.head;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            indexNode.next = n.next;
            n.next = indexNode;
            this.size++;
        }
    }

    public void addFirst(T value) {
        Node<T> temp = this.head;
        this.head = new Node<>(value);
        this.head.next = temp;
        this.size++;
    }

    public T get(int index) {
        if (this.head == null)
            return null;

        Node<T> n = this.head;

        if (index <= 0)
            return this.head.value;

        else if (index >= this.size) {
            while (n.next != null) {
                n = n.next;
            }
        } else {
            for (int i = 0; i < index; i++)
                n = n.next;
        }

        return n.value;
    }

    public void remove() {
        if (this.head == null)
            return ;

        Node<T> n = this.head;
        while (n.next.next != null)
            n = n.next;

        n.next = null;

        this.size--;
    }

    public void remove(int index) {

        if (this.head == null)
            return ;

        if (index <= 0)
            this.removeFirst();

        else if (index >= size)
            this.remove();

        else {
            Node<T> n = this.head;

            for (int i = 0; i < index-1; i++)
                n = n.next;

            n.next = n.next.next;

            this.size--;
        }
    }

    public void removeFirst() {

        if (this.head == null)
            return ;

        this.head = this.head.next;

        this.size--;
    }

    public void show() {
        if (this.head == null) {
            System.out.println("null");
            return ;
        }

        StringBuilder sb = new StringBuilder("[ ");

        Node<T> n = this.head;
        do {
            sb.append(n.value).append(" ");
            n = n.next;
        } while (n != null && n.next != null);

        if (n != null)
            sb.append(n.value).append(" ");

        sb.append("]");
        System.out.println(sb);
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public String toString() {
        if (this.head == null)
            return null;

        return this.head.toString();
    }

}
