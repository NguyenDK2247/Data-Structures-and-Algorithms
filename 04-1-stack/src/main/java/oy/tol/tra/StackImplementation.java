package oy.tol.tra;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * 
 * Note that you need to implement construtor(s) for your concrete StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value of 10.
 * - StackImplementation(int size), which allocates an array of Object's with size.
 *  -- remember to maintain the capacity and/or currentIndex when the stack is manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   // TODO: Add member variables needed.
   // Do not use constant values in code, e.g. 10. Instead, define a constant for that. For example:
   private Object[] myObject;
   private static final int MY_CONSTANT_VARIABLE = 10;
   private static int currentIndex = -1;
   private static int size;


   /**
    * Allocates a stack with a default capacity.
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException {
      // TODO: call the constructor with size parameter with default size (see member variable!).
      this(MY_CONSTANT_VARIABLE);
   }

   /** TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    *   throw StackAllocationException.
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      size = capacity;
      myObject = new Object[capacity];
      if (capacity < 2) {
         throw new StackAllocationException("Cannot allocate room for the internal array");
      }
   }  

   @Override
   public int capacity() {
      // TODO: Implement this
      return myObject.length;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      // TODO: Implement this
      if (element == null) {
         throw new NullPointerException("Element is null");
      }
      try {
         if (currentIndex == size - 1) { // currentIndex = 3; size = 4, myObject has length 4 [0, 1, 2, 3]
            int temp = size + 1; // temp = 5
            Object[] tempArr = new Object[capacity() + 1]; // tempArr has capacity 5
            for (int i = 0; i <= currentIndex; i++) {
               tempArr[i] = myObject[i]; // tempArr is now [0, 1, 2, 3, _]
            }
            myObject = tempArr; // myObject now becomes [0, 1, 2, 3, _] having one blank spot at the end
            size = temp; // new size is now 5 as well
         }
         currentIndex++; // update currentIndex to 4
         myObject[currentIndex] = element; // and then squeeze in the element for the newly open spot in myObject
      }  catch (OutOfMemoryError e) {
            throw new StackAllocationException("Out of memory");
      }
      
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      // TODO: Implement this
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty");
      }
      E temp = (E) myObject[currentIndex];
      currentIndex--;
      return temp;
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      // TODO: Implement this
      if (isEmpty()) {
         throw new StackIsEmptyException("Stack is empty");
      }
      return (E) myObject[currentIndex];
   }

   @Override
   public int size() {
      // TODO: Implement this
      return currentIndex + 1;
   }

   @Override
   public void clear() {
      // TODO: Implement this
      currentIndex = -1;
   }

   @Override
   public boolean isEmpty() {
      // TODO: Implement this
      if (currentIndex <= -1) {
         return true;
      }
      return false;
   }

   @Override
   public String toString() {
      // TODO: Implement this
      if (isEmpty()) {
         return "[]";
      }
      String res = "";
      for (int i = 0; i < size() - 1; i++) {
         res += myObject[i] + ", ";
      }
      return "[" + res + myObject[size() - 1] + "]";
   }
}
