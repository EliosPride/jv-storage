package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int LENGTH = 10;
    private K[] keyArray;
    private V[] valueArray;
    private int iterator = 0;

    public StorageImpl() {
        this.keyArray = (K[]) new Object[LENGTH];
        this.valueArray = (V[]) new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < iterator; i++) {
            if (isPresent(key, i)) {
                valueArray[i] = value;
                return;
            }
        }
        keyArray[iterator] = key;
        valueArray[iterator] = value;
        iterator++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < iterator; i++) {
            if (isPresentOnIndex(key, i)) {
                return valueArray[i];
            }
        }
        return null;
    }

    private boolean isPresentOnIndex(K key, int i) {
        return (key == null && null == keyArray[i]) || (keyArray[i] != null && keyArray[i].equals(key));
    }

    private boolean isPresent(K key, int i) {
        return (key == null && null == keyArray[i]) || (key != null && key.equals(keyArray[i]));
    }
}
