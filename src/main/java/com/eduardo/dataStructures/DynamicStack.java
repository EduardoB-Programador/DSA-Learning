package com.eduardo.dataStructures;


public non-sealed class DynamicStack<T> extends Stack<T> {

    public DynamicStack(int size) {
        super(size);
    }

    public DynamicStack() {
        super();
    }

    @Override
    public void push(T t) {
        if (top +1 >= stack.length)
            grow();

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

        if (top <= stack.length /4)
            shrink();

        if (top -1 <= -1)
            top = 0;
        else
            top--;
        currentSize--;

        return lastTop;
    }

    //doubles the stack's capacity
    protected void grow() {
        Object[] newStack = new Object[stack.length *2];

        System.arraycopy(stack, 0, newStack, 0, stack.length);

        stack = newStack;
    }

    //halves the stack's capacity
    protected void shrink() {
        Object[] newStack = new Object[stack.length /2];

        if (top + 1 >= 0) System.arraycopy(stack, 0, newStack, 0, top + 1);

        stack = newStack;
    }

}
