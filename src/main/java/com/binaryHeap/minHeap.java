package com.binaryHeap;

public class minHeap {

    public Comparable[] array;
    public int currentSize;

    public minHeap(int capacity) {
        this.array = new Comparable[capacity + 1];
        this.currentSize = 0;
    }

    @SuppressWarnings("rawtypes")
    public void heapify(int i) {

        int child;

        while (i * 2 <= this.currentSize) {

            child = i * 2;

            if (child != currentSize && this.array[child + 1].compareTo(this.array[child]) < 0) {
                child++;
            }
            if (this.array[child].compareTo(this.array[i]) < 0) {
                Comparable temp = this.array[i];
                this.array[i] = this.array[child];
                this.array[child] = temp;
                i = child;
            }
            else {
                break;
            }
        }
    }
}
