package com.binaryHeap;

public class minHeap {

    @SuppressWarnings("rawtypes")
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
            } else {
                break;
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public void insert(Comparable x) {

        if (this.currentSize + 1 == this.array.length) {
            this.doubleArray();
        }

        int i = ++this.currentSize;
        this.array[i] = x;

        while (i > 0 && x.compareTo(this.array[i / 2]) < 0) {
            this.array[i] = this.array[i / 2]; // heapify the parent down
            i = i / 2;
        }

        this.array[i] = x;

    }

    @SuppressWarnings("rawtypes")
    private void doubleArray() {
        int newSize = this.array.length * 2;
        Comparable[] newArray = new Comparable[newSize];

        System.arraycopy(this.array, 0, newArray, 0, this.array.length);

        this.array = newArray;
    }

    @SuppressWarnings("unused")
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--) {
            this.heapify(i);
        }
    }
}
