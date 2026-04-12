package com.hashTables;

import java.lang.reflect.Array;

public class hashTable<K, V> {

    private static final int MAX_SIZE = 5;

    public hashItem<K, V>[] HashTable;
    public int size;
    public int capacity;

    @SuppressWarnings("unchecked")
    public hashTable() {
        this.HashTable = (hashItem<K, V>[]) Array.newInstance(hashItem.class, MAX_SIZE);
        this.capacity = MAX_SIZE;
    }

    @SuppressWarnings("unchecked")
    public hashTable(int capacity) {
        this.HashTable = (hashItem<K, V>[]) Array.newInstance(hashItem.class, capacity);
        this.capacity = capacity;
    }
}
