package uvg.edu;

public class QuickSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(Comparable[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                Comparable temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Comparable temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
