package com.hashTables;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class hashItem<K, V> {

    private K key;
    @NonNull
    private V value;
}
