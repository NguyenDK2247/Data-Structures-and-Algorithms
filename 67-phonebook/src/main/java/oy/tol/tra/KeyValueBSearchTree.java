package oy.tol.tra;

public class KeyValueBSearchTree<K extends Comparable<K>, V> implements Dictionary<K, V> {

    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public KeyValueBSearchTree() {
        root = null;
        size = 0;
    }

    @Override
    public Type getType() {
        return Type.BST;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String getStatus() {
        return "Tree size: " + size +
            "\nHeight: " + height(root) +
            "\nBalance Factor: " + balanceFactor(root) +
            "\nMaximum Depth: " + maxDepth(root) +
            "\nMinimum Depth: " + minDepth(root) +
            "\nAverage Depth: " + averageDepth(root, 0, 0);
    }

    private int height(Node node) {
        if (node == null) {
            return -1; // Height of an empty tree is -1
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private int maxDepth(Node node) {
        if (node == null) {
            return 0; // Maximum depth of an empty node is 0
        }
        return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }

    private int minDepth(Node node) {
        if (node == null) {
            return 0; // Minimum depth of an empty node is 0
        }
        if (node.left == null && node.right == null) {
            return 1; // Leaf node
        }
        if (node.left == null) {
            return 1 + minDepth(node.right);
        }
        if (node.right == null) {
            return 1 + minDepth(node.left);
        }
        return 1 + Math.min(minDepth(node.left), minDepth(node.right));
    }

    private double averageDepth(Node node, int depth, int count) {
        if (node == null) {
            return count == 0 ? 0 : (double) depth / count;
        }
        count++;
        return averageDepth(node.left, depth + 1, count) +
            averageDepth(node.right, depth + 1, count);
    }

    private int balanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    @Override
    public boolean add(K key, V value) throws IllegalArgumentException, OutOfMemoryError {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key or value cannot be null");
        }
        root = addRecursive(root, key, value);
        size++;
        return true;
    }

    private Node addRecursive(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = addRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = addRecursive(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V find(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        Node node = findRecursive(root, key);
        return node == null ? null : node.value;
    }

    private Node findRecursive(Node node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return findRecursive(node.left, key);
        } else if (cmp > 0) {
            return findRecursive(node.right, key);
        } else {
            return node;
        }
    }

    @Override
    public void ensureCapacity(int size) throws OutOfMemoryError {
        // Not needed for BST implementation
    }

    @Override
    public Pair<K, V>[] toSortedArray() {
        Pair<K, V>[] array = new Pair[size];
        inOrderTraversal(root, array, new int[1]);
        return array;
    }

    private void inOrderTraversal(Node node, Pair<K, V>[] array, int[] index) {
        if (node != null) {
            inOrderTraversal(node.left, array, index);
            array[index[0]++] = new Pair<>(node.key, node.value);
            inOrderTraversal(node.right, array, index);
        }
    }

    @Override
    public void compress() throws OutOfMemoryError {
        // Not needed for BST implementation
    }
}