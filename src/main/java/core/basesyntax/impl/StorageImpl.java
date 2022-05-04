package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int count = 0;
    private int encounter = 0;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[LENGTH];
        this.valueArray = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == keyArray[i]) {
                valueArray[i] = value;
                keyArray[i] = key;
            }
        }
        keyArray[count] = key;
        valueArray[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null && null == keyArray[i]) {
                return valueArray[i];
            }
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
        }
        return null;
    }
}
