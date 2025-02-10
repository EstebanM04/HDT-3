package uvg.edu;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        int n = array.length;
        if (n <= 0) return;

        // Crear los buckets
        ArrayList<Comparable>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuir los elementos en los buckets
        for (Comparable num : array) {
            int bucketIndex = (int) ((Integer) num / (10000.0 / n));
            buckets[bucketIndex].add(num);
        }

        // Ordenar individualmente cada bucket
        for (ArrayList<Comparable> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenar todos los buckets ordenados en el array original
        int index = 0;
        for (ArrayList<Comparable> bucket : buckets) {
            for (Comparable num : bucket) {
                array[index++] = num;
            }
        }
    }
}