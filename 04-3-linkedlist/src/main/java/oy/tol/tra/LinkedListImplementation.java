package oy.tol.tra;

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

   private Node<E> head = null;
   private int size = 0;

   @Override
   public void add(E element) throws NullPointerException, LinkedListAllocationException {
      Node<E> newNode = new Node(element);
      if (element == null) {
         throw new NullPointerException("Element is null");
      }
      if (head == null) {
         head = newNode;
      }
      Node<E> temp = head;
      for (int i = 0; i < size - 1; i++) {
         temp = temp.next;
      }
      temp.next = newNode;
      size++;
   }

   @Override
   public void add(int index, E element) throws NullPointerException, LinkedListAllocationException, IndexOutOfBoundsException {
      if (element == null) {
         throw new NullPointerException("Element is null");
      }
      if (index < 0 || index > size) {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      Node<E> newNode = new Node(element);
      if (index == 0) {
         newNode.next = head;
         head = newNode;
      } else {
         Node<E> temp = head;
         for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
         }
      newNode.next = temp.next;
      temp.next = newNode;
      }
      size++;
   }

   @Override
   public boolean remove(E element) throws NullPointerException {
      if (element == null) {
         throw new NullPointerException("Element is null");
      }
      Node<E> temp = head;
      for (int i = 0; i < size; i++) {
         if (temp.element.equals(element)) {
            size--;
            return true;
         }
         temp = temp.next;
      }
      return false;
   }

   @Override
   public E remove(int index) throws IndexOutOfBoundsException {
      if (size == 0) {
         throw new IndexOutOfBoundsException("List is empty");
      }
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      Node<E> temp = head;
      Node<E> prev = null;
      if (temp == null) {
         return (E) head;
      }
      if (index == 0) {
         head = temp.next;
      } else {
         for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
         }
         if (temp != null) {
            prev.next = temp.next;
         }
      }
      size--;
      return temp.element;
   }

   @Override
   public E get(int index) throws IndexOutOfBoundsException {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("Index out of bounds");
      }
      Node<E> temp = head;
      for (int i = 0; i < index; i++) {
         temp = temp.next;
      }
      return temp.element;
   }

   @Override
   public int indexOf(E element) throws NullPointerException {
      if (element == null) {
         throw new NullPointerException("Element is null");
      }
      Node<E> temp = head;
      for (int i = 0; i < size; i++) {
         if (temp.element.equals(element)) {
               return i; 
         }
         temp = temp.next;
      }
      return -1;
   }

   @Override
   public int size() {
      return size;
   }

   @Override
   public void clear() {
      head = null;
      size = 0;
   }

   @Override
   public void reverse() {
      Node<E> prev = null;
      Node<E> temp = head;
      Node<E> next = null;
      for (int i = 0; i < size; i++) {
         next = temp.next;
         temp.next = prev;
         prev = temp;
         temp = next;
      }
      head = prev;
   }

   @Override
   public String toString() {
      // TODO: Implement this.
      if (size == 0) {
         return "[]";
      } else {
         String res = "";
         Node<E> temp = head;
         for (int i = 0; i < size - 1; i++) {
            res += temp.element + ", ";
            temp = temp.next;
         }
         return "[" + res + temp.element + "]";
      }
   }
}
