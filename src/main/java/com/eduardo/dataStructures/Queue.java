package com.eduardo.dataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Queue<T> {
    protected int end = 0;
    protected int start = 0;
    protected Object[] queue;
    protected int currentSize = 0;
    public static final int DEFAULT_SIZE = 5;

    public Queue() {
        this.queue = new Object[DEFAULT_SIZE];
    }

    public Queue(int size) {
        this.queue = new Object[size];
    }

    public void enqueue(T t) {
        if (currentSize +1 > getQueueCapacity())
            throw new ArrayIndexOutOfBoundsException("Capacity exceeded\ncurrent size: " + currentSize + "\ncapacity:" + getQueueCapacity());


        if (queue[end] == null)
            queue[end] = t;

        else
            queue[start] = t;

        start = (start+1) % getQueueCapacity();
        currentSize++;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (currentSize -1 <= -1)
            throw new ArrayIndexOutOfBoundsException("index -1");

        T t = (T) queue[end];
        queue[end] = null;

        end = (end+1) % getQueueCapacity();
        currentSize--;

        return t;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) this.queue[end];
    }

    public void clear() {
        this.end = 0;
        this.currentSize = 0;

        Arrays.fill(queue, null);
    }

    public void show() {
        System.out.println(toList().toString());
    }

    @SuppressWarnings("unchecked")
    public List<T> toList() {
        List<T> l = new ArrayList<>();

        for (int i = 0; i < currentSize; i++) {
            l.add((T) queue[(end+i) % getQueueCapacity()]);
        }

        return l;
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getQueueCapacity() {
        return this.queue.length;
    }

}
