package org.workspace.qua;

public class Queue {
    private final int[] arr;
    private final int capacity;
    private int currSize, start, end;

    Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.currSize = 0;
        this.start = -1;
        this.end = -1;
    }

    public void push(int newElement) {
        if(currSize == capacity) throw new RuntimeException("Queue max capacity reached");
        else if(currSize == 0) {
            start = 0;
            end = 0;
        } else {
            end = (end+1)%capacity;
        }
        arr[end] = newElement;
        currSize++;
        System.out.printf("Pushed %d to queue %n", newElement);
    }

    public int pop() {
        if(currSize == 0) throw new RuntimeException("Queue is empty");
        int poppedElement = arr[start];
        if(currSize == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start+1)%capacity;
        }
        currSize--;
        System.out.printf("Popped %d from the queue %n", poppedElement);
        return poppedElement;
    }

    public int top() {
        if(currSize == 0) throw new RuntimeException("Queue is empty");
        return arr[start];
    }

    public int size() {
        return currSize;
    }
}
