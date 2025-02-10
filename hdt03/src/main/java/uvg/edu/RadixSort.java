package uvg.edu;

import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(array, exp);
    }

    private void countingSort(Comparable[] array, int exp) {
        int n = array.length;
        Comparable[] output = new Comparable[n];
        int[] count = new int[10];

        for (Comparable num : array) count[((Integer) num / exp) % 10]++;

        for (int i = 1; i < 10; i++) count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[((Integer) array[i] / exp) % 10] - 1] = array[i];
            count[((Integer) array[i] / exp) % 10]--;
        }
        System.arraycopy(output, 0, array, 0, n);
    }

    private int getMax(Comparable[] array) {
        int max = (Integer) array[0];
        for (Comparable num : array)
            if ((Integer) num > max) max = (Integer) num;
        return max;
    }
}
