package oy.tol.tra;

public class Algorithms {
    public static <T> void reverse(T [] array) {
        if (array == null || array.length == 0) {
            return; 
         }
        
         int i = 0;
         while (i < array.length / 2) {
            T temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
            i++;
         }
    } 
    
    public static <T> void swap(T [] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    } 

    public static <T extends Comparable<T>> void sort(T [] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true; 
                }
            }
        } while (swapped); 
    }
}
