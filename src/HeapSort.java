public class HeapSort {
    private static int changes;
    private static int interactions;
    private static void heapify(int[] array, int size, int i) {

        int x = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && array[left] > array[x]) x = left;

        if (right < size && array[right] > array[x]) x = right;


        if (x != i) {

            int swap = array[i];

            array[i] = array[x];
            array[x] = swap;

            changes++;
            heapify(array, size, x);
        }
        interactions++;
    }
    public static Result sort(int[] array, int size) {

        changes = 0;
        interactions = 0;
        long start = System.nanoTime();

        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, size, i);
        }

        for (int i = size - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            changes++;
            heapify(array, i, 0);
        }

        long end = System.nanoTime();
        double executionTime = (end - start) / 1_000_000.0;

        return new Result(executionTime, changes, interactions);
    }
}
