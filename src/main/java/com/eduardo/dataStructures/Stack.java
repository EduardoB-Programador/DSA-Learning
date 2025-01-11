package com.eduardo.dataStructures;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract sealed class Stack<T> permits StaticStack, DynamicStack {
    protected int top = 0;
    protected Object[] stack;
    protected int currentSize = 0;
    public static final int DEFAULT_SIZE = 5;

    public Stack(int size) {
        if (size <= 0)
            this.stack = new Object[DEFAULT_SIZE];

        else
            this.stack = new Object[size];
    }

    public Stack() {
        this.stack = new Object[DEFAULT_SIZE];
    }

    public abstract void push(T t);

    public abstract T pop();

    @SuppressWarnings("unchecked")
    public T peek() {
        return (T) this.stack[top];
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    @Override
    public String toString() {
        return "";
    }

    public void clear() {
        this.top = 0;
        this.currentSize = 0;

        Arrays.fill(this.stack, null);

    }

    public void show() {
        System.out.println(toList().toString());
    }

    //For test purposes
    @SuppressWarnings("unchecked")
    public List<T> toList() {
        return (List<T>) Arrays.stream(this.stack)
                .filter(Objects::nonNull)
                .toList();
    }

    public int getStackCapacity() {
        return this.stack.length;
    }

}
