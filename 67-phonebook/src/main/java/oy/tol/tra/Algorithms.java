package oy.tol.tra;

import java.util.function.Predicate;

public class Algorithms {
    public static <T> void reverse(T[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int i = 0;
        while (i < array.length / 2) {
            swap(array, i, array.length - 1 - i);
            i++;
        }
    }

    public static <T> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(temp) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }

    public static class ModeSearchResult<T> {
        public T theMode;
        public int count = 0;
    }

    public static <T extends Comparable<T>> ModeSearchResult<T> findMode(T[] array) {
        ModeSearchResult<T> result = new ModeSearchResult<>();
        int temp = 0;
        if (array == null || array.length <= 1) {
            result.theMode = null;
            result.count = -1;
        } else {
            sort(array);
            T last_element = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i].compareTo(last_element) == 0) {
                    temp++;
                }
                if (array[i].compareTo(last_element) != 0 || i == array.length - 1) {
                    if (temp > result.count) {
                        result.count = temp;
                        result.theMode = last_element;
                    }
                    last_element = array[i];
                    temp = 1;
                }
            }
        }
        return result;
    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<T> predicate) {
        int index = findFirstConformingIndex(array, count, predicate);

        // If no conforming element is found, return the count
        if (index >= count) {
            return count;
        }

        int nextIndex = index + 1;

        while (nextIndex < count) {
            if (!predicate.test(array[nextIndex])) {
                swap(array, index, nextIndex);
                index++;
            }
            nextIndex++;
        }

        return index;
    }

    private static <T> int findFirstConformingIndex(T[] array, int count, Predicate<T> predicate) {
        for (int i = 0; i < count; i++) {
            if (predicate.test(array[i])) {
                return i;
            }
        }
        return count; // No conforming element found
    }

    public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
        while (fromIndex <= toIndex) {
            int midIndex = (fromIndex + toIndex) / 2;
            if (fromArray[midIndex].compareTo(aValue) == 0) {
                return midIndex;
            } else if (fromArray[midIndex].compareTo(aValue) > 0) {
                toIndex = midIndex - 1;
            } else {
                fromIndex = midIndex + 1;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> void fastSort(Comparable<T>[] array) {
        if (array != null && array.length > 0) {
            quickSort(array, 0, array.length - 1);
        }
    }

    public static <T extends Comparable<T>> void quickSort(Comparable<T>[] array, int left, int right) {
        if (left >= right)
            return;

        int randomIndex = left + (int) (Math.random() * (right - left));
        T pivot = (T) array[randomIndex];
        int start = left;

        for (int i = left; i <= right; i++) {
            if (array[i].compareTo(pivot) < 0) {
                swap(array, i, start);
                start++;
            }
        }

        int end = right;
        for (int i = right; i >= start; i--) {
            if (array[i].compareTo(pivot) > 0) {
                swap(array, i, end);
                end--;
            }
        }

        quickSort(array, left, start - 1);
        quickSort(array, end + 1, right);
    }
}
