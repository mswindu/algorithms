package com.nilov.algorithms.structures;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] elementData;
    private int elementCount;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Create empty Stack.
     */
    public Stack() {
        this.elementData = new Object[10];
        this.elementCount = 0;
    }

    /**
     * Pushed an item into the top of this Stack.
     *
     * @param item the item to be pushed into this stack.
     * @return the <code>item</code> argument
     */
    public T push(T item) {
        addElement(item);

        return item;
    }

    /**
     * Removes the object at the top of this stack and returns that
     * object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException if this stack is empty.
     */
    public T pop() {
        if(isEmpty())
            throw new EmptyStackException();
        T item = peek();
        elementCount--;
        return item;
    }

    /**
     * Returns at the object at the top of this stack without removing it
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException if this stack is empty.
     */
    public T peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return (T) elementData[size() - 1];
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains
     *          no items; <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return (elementCount == 0);
    }

    /**
     * @param   o   Object that we want to find
     * @return  the 1-based position from the top of the stack where
     *          the object is located; the return value <code>-1</code>
     *          indicates that the object is not on the stack.
     */
    public int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    private void addElement(T obj) {

        if(elementCount + 1 - elementData.length > 0) {
            grow(elementCount + 1);
        }
        elementData[elementCount++] = obj;
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

    private synchronized int lastIndexOf(Object o) {
        int index = elementCount - 1;
        if (o == null) {
            for (int i = index; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = index; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
}