package oy.tol.tra;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImplementation<E> implements LinkedListInterface<E> {

    private class Node<T> {
        Node(T data) {
            element = data;
            next = null;
        }

        T element;
        Node<T> next;

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node<E> dummyHead = new Node(null);
    private int size = 0;


    @Override
    public void add(E element) throws NullPointerException, LinkedListAllocationException {
        add(size, element);
    }


    @Override
    public void add(int index, E element) throws NullPointerException, LinkedListAllocationException, IndexOutOfBoundsException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node<E> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(element);
        size++;
    }


    @Override
    public boolean remove(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        int indexOf = indexOf(element);
        if (indexOf == -1) {
            return false;
        }
        return remove(indexOf) != null;
    }


    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty");
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> prev = dummyHead;
        for (int i = 0; i < size; i++) {
            prev = prev.next;
        }
        E toReturn = prev.next.element;
        prev.next = prev.next.next;
        size--;
        return toReturn;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> head = dummyHead.next;
        for (int i = 0; i < index; i++) {
            head = head.next;
        }
        return head.element;
    }

    @Override
    public int indexOf(E element) throws NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }

        Node<E> head = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (head.element.equals(element)) {
                return i;
            }
            head = head.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        dummyHead.next = null;
        size = 0;
    }

    @Override
    public void reverse() {
        Node<E> prev = null;
        Node<E> temp = dummyHead.next;
        Node<E> next = null;
        for (int i = 0; i < size; i++) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        dummyHead.next = prev;
    }

    @Override
    public String toString() {
        // TODO: Implement this.
        if (size == 0) {
            return "[]";
        } else {
            String res = "";
            Node<E> temp = dummyHead.next;
            for (int i = 0; i < size - 1; i++) {
                res += temp.element + ", ";
                temp = temp.next;
            }
            return "[" + res + temp.element + "]";
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = dummyHead.next;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E data = current.element;
            current = current.next;
            return data;
        }
    }
}
