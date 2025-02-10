package uvg.edu;

import java.util.Arrays;

public class MergeSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        if (array.length < 2) return;
        int mid = array.length / 2;
        Comparable[] left = Arrays.copyOfRange(array, 0, mid);
        Comparable[] right = Arrays.copyOfRange(array, mid, array.length);
        sort(left);
        sort(right);
        merge(array, left, right);
    }

    private void merge(Comparable[] array, Comparable[] left, Comparable[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) array[k++] = left[i++];
            else array[k++] = right[j++];
        }
        while (i < left.length) array[k++] = left[i++];
        while (j < right.length) array[k++] = right[j++];
    }
}
