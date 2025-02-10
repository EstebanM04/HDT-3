package uvg.edu;

public class CustomSort implements Sorter {
    @Override
    public void sort(Comparable[] array) {
        int n = array.length;

        // Construcción del heap (reorganizar el array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Extraer elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            Comparable temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Llamar a heapify en el heap reducido
            heapify(array, i, 0);
        }
    }

    private void heapify(Comparable[] array, int n, int i) {
        int largest = i; // Inicializar el nodo más grande como la raíz
        int left = 2 * i + 1; // Hijo izquierdo
        int right = 2 * i + 2; // Hijo derecho

        // Si el hijo izquierdo es mayor que la raíz
        if (left < n && array[left].compareTo(array[largest]) > 0) {
            largest = left;
        }

        // Si el hijo derecho es mayor que el mayor actual
        if (right < n && array[right].compareTo(array[largest]) > 0) {
            largest = right;
        }

        // Si el nodo más grande no es la raíz
        if (largest != i) {
            Comparable swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente hacer heapify en el subárbol afectado
            heapify(array, n, largest);
        }
    }
}
