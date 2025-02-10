package uvg.edu;

import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 3000};
        Sorter[] algorithms = {
            new InsertionSort(), new MergeSort(), new QuickSort(), new RadixSort(), new BucketSort(), new CustomSort()
        };

        for (int size : sizes) {
            Comparable[] data = generateRandomArray(size);
            for (Sorter algorithm : algorithms) {
                Comparable[] copy = data.clone();
                long start = System.nanoTime();
                algorithm.sort(copy);
                long end = System.nanoTime();
                System.out.println(algorithm.getClass().getSimpleName() + " | Tamaño: " + size + " | Tiempo: " + (end - start) + " ns");
            }
        }
    }

    private static Comparable[] generateRandomArray(int size) {
        Random rand = new Random();
        Comparable[] array = new Comparable[size];
        for (int i = 0; i < size; i++) array[i] = rand.nextInt(10000);
        return array;
    }
}