package uvg.edu;

public class InsertionSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            Comparable key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
