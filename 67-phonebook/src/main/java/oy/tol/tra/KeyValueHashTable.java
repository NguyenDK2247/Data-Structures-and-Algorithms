package oy.tol.tra;

import java.util.Arrays;
import java.util.Collections;

public class KeyValueHashTable<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private LinkedListInterface<Pair<K, V>>[] buckets;
    private int size = 0;
    private float loadFactor;
    private int reallocationCount = 0;

    public KeyValueHashTable(int capacity, float loadFactor) throws OutOfMemoryError {
        this.loadFactor = loadFactor;
        ensureCapacity(capacity);
    }

    public KeyValueHashTable(int capacity) throws OutOfMemoryError {
        this(capacity, 0.75f);
    }

    public KeyValueHashTable() throws OutOfMemoryError {
        this(20, 0.75f);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void ensureCapacity(int size) throws OutOfMemoryError {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");
        buckets = new LinkedListImplementation[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedListImplementation<>();
        }
    }

    @Override
    public Type getType() {
        return Type.HASHTABLE;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError {
        if (null == key || value == null) throw new IllegalArgumentException("Not Key nor value can be null");

        int bucketIndex = getBucketIndex(key);
        LinkedListInterface<Pair<K, V>> bucket = buckets[bucketIndex];

        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                pair.setvalue(value);
                return true;
            }
        }

        bucket.add(new Pair<>(key, value));
        size++;

        if ((float) size / buckets.length > loadFactor) {
            rehashing();
        }

        return true;
    }

    private void rehashing() {
        LinkedListInterface<Pair<K, V>>[] oldBuckets = buckets;
        ensureCapacity(oldBuckets.length * 2);
        reallocationCount++;

        this.size = 0;
        for (LinkedListInterface<Pair<K, V>> bucket : oldBuckets) {
            for (Pair<K, V> pair : bucket) {
                add(pair.getKey(), pair.getValue());
            }
        }
    }

    @Override
    public V find(K key) throws IllegalArgumentException {
        if (null == key) throw new IllegalArgumentException("Key to find cannot be null");

        int bucketIndex = getBucketIndex(key);
        LinkedListInterface<Pair<K, V>> bucket = buckets[bucketIndex];

        for (Pair<K, V> pair : bucket) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null; // Key not found
    }

    @Override
    public Pair<K, V>[] toSortedArray() {
        Pair<K, V>[] allPairs = new Pair[size];

        int index = 0;
        for (LinkedListInterface<Pair<K, V>> bucket : buckets) {
            for (Pair<K, V> pair : bucket) {
                allPairs[index++] = pair;
            }
        }
        Algorithms.fastSort(allPairs);
        Arrays.sort(allPairs);
        return allPairs;
    }

    @Override
    public void compress() throws OutOfMemoryError {
        LinkedListInterface<Pair<K, V>>[] oldBuckets = buckets;
        ensureCapacity(size);

        this.size = 0;
        for (LinkedListInterface<Pair<K, V>> bucket : oldBuckets) {
            for (Pair<K, V> pair : bucket) {
                add(pair.getKey(), pair.getValue());
            }
        }
    }

    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder();
        int nonEmptyBuckets = 0;
        int collisions = 0;

        for (LinkedListInterface<Pair<K, V>> bucket : buckets) {
            if (bucket.size() > 0) {
                nonEmptyBuckets++;
                if (bucket.size() > 1) collisions += bucket.size() - 1;
            }
        }

        status.append("HashTable Status:\n")
                .append("Total Buckets: ").append(buckets.length).append("\n")
                .append("Non-Empty Buckets: ").append(nonEmptyBuckets).append("\n")
                .append("Collisions: ").append(collisions).append("\n")
                .append("reallocationCount: ").append(reallocationCount).append(" times, each time doubles the size").append("\n");

        return status.toString();
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
}
