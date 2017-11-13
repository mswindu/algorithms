package com.nilov.algorithms.structures;

public class Deque<T> {
    // Количество элементов должно быть числом 2^k, k > 2
    private Object[] elementData;
    private int head;
    private int tail;

    public Deque() {
        this.elementData = new Object[8];
    }

    public void addFirst(T item) {
        if (item == null)
            throw new NullPointerException();

        head = (head - 1) & (elementData.length - 1);
        elementData[head] = item;

        System.out.println("addFirst: " + head);
        if (head == tail)
            doubleCapacity();
    }

    public void addLast(T item) {
        if (item == null)
            throw new NullPointerException();

        elementData[tail] = item;
        tail = (tail + 1) & (elementData.length - 1);
        System.out.println("addLast: " + tail);
        if (head == tail)
            doubleCapacity();
    }

    public T peekFirst() {
        return (T) elementData[head];
    }

    public T peekLast() {
        return (T) elementData[(tail - 1) & (elementData.length - 1)];
    }

    public T popFirst() {
        T resultItem = (T) elementData[head];

        if (resultItem == null)
            return null;

        elementData[head] = null;
        head = (head + 1) & (elementData.length - 1);
        return resultItem;
    }

    public T popLast() {
        int t = (tail - 1) & (elementData.length - 1);
        T resultItem = (T) elementData[t];

        if (resultItem == null)
            return null;

        elementData[t] = null;
        tail = t;
        return resultItem;
    }

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
    public int size() {
        return (tail - head) & (elementData.length - 1);
    }

    /**
     * Когда хвост и голова встречаются:
     * Хвост всегда слева
     * Голова всегда справа
     */
    private void doubleCapacity() {
        int elementDataLength = elementData.length;
        int numberItemRight = elementDataLength - head;

        int newCapacity = elementDataLength << 1;

        if (newCapacity < 0)
            throw new IllegalThreadStateException("Deque too big");

        Object[] newElementData = new Object[newCapacity];

        System.arraycopy(elementData, head, newElementData, 0, numberItemRight);
        System.arraycopy(elementData, 0, newElementData, numberItemRight, head);

        elementData = newElementData;

        head = 0;
        tail = elementDataLength;
        System.out.println("new capacity: " + newCapacity);
    }
}
