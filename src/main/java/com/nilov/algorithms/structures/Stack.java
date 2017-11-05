package com.nilov.algorithms.structures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private int[] elementData;
    private int elementCount;
    private static int defaultInitialCapacity = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public Stack() {
        this(defaultInitialCapacity);
    }

    public Stack(int initialCapacity) {
        elementData = new int[initialCapacity];
        elementCount = 0;
    }

    public void push(int value) {
        addElement(value);
    }

    public int pop() {
        if(isEmpty())
            throw new EmptyStackException();
        int element = peek();
        elementCount--;
        return element;
    }

    public int peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return elementData[size() - 1];
    }

    public boolean isEmpty() {
        return (elementCount == 0);
    }

    private void addElement(int value) {

        if(elementCount + 1 - elementData.length > 0) {
            grow(elementCount + 1);
        }
        elementData[elementCount++] = value;
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity << 1;

        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    private int size() {
        return elementCount;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        if(isEmpty()) {
            return "[]";
        }

        builder.append('[');
        for (int i = 0; i < elementCount; i++) {
            int e = elementData[i];
            if (i == elementCount - 1) {
                builder.append(e);
                continue;
            }
            builder.append(e).append(',').append(' ');
        }
        builder.append(']');
        return builder.toString();
    }
}
