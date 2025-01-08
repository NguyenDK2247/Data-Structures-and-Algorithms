package oy.tol.tra;

public class QueueImplementation<E> implements QueueInterface<E> {
    private Object[] myObject;
    private int head; 
    private int tail;  
    private int size;

    public QueueImplementation(int capacity) throws QueueAllocationException {
        this.myObject = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    } 

    @Override
    public int capacity() {
        return myObject.length;
    }

    @Override
    public void enqueue(E element) throws QueueAllocationException, NullPointerException {
        if (element == null) {
            throw new NullPointerException("Element is null");
        }
        if (size == myObject.length) { // full array
            // reallocate
            try {
                int newCapacity = capacity() * 2;
                Object[] newObject = new Object[newCapacity];
                for (int i = 0; i < myObject.length; i++) {
                    newObject[i] = myObject[(head + i) % myObject.length];
                }
                int temp = myObject.length;
                myObject = newObject;
                myObject[temp] = element;
                tail = temp;
                head = 0;
                tail++;
            } catch (OutOfMemoryError e) {
                throw new QueueAllocationException("Out of memory");
            }
        } else {
            if (tail == myObject.length) {
                tail = 0;
            }
            myObject[tail] = element;
            tail++;
        }
        size++;
    }

    @Override
    public E dequeue() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }
        E temp = (E) myObject[head];
        myObject[head] = null;
        if (head == myObject.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        return temp;
    }

    @Override
    public E element() throws QueueIsEmptyException {
        if (isEmpty()) {
            throw new QueueIsEmptyException("Queue is empty");
        }

        return (E) myObject[head];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            myObject[(head + i) % myObject.length] = null; 
        }
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String res = "";
        if (tail >= head) {
            for (int i = head; i < tail - 1; i++) {
                res += myObject[i] + ", ";
            }
        } else {
            for (int i = head; i < myObject.length; i++) {
                res += myObject[i] + ", ";
            }
            for (int i = 0; i < tail - 1; i++) {
                res += myObject[i] + ", ";
            }
        }
        return "[" + res + myObject[tail - 1] + "]";
    }
}
