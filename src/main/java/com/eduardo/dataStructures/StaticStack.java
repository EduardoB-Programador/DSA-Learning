package com.eduardo.dataStructures;

public non-sealed class StaticStack<T> extends Stack<T> {

    public StaticStack(int size) {
        super(size);
    }

    public StaticStack() {
        super();
    }

    @Override
    public void push(T t) {
        if (top+1 > stack.length)
            throw new ArrayIndexOutOfBoundsException("Current size:" + currentSize + " Capacity:" + stack.length);

        if (stack[top] != null)
            top++;

        stack[top] = t;
        currentSize++;

    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (currentSize -1 <= -1)
            throw new ArrayIndexOutOfBoundsException("Current size:" + currentSize);

        T lastTop = (T) stack[top];
        stack[top] = null;

        if (top -1 <= -1)
            top = 0;
        else
            top--;

        currentSize--;

        return lastTop;
    }

}
