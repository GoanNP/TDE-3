public class RadixSort {

    private static int changes;
    private static int interactions;
    private static void countSort(int[] array, int size, int exp) {
        int[] output = new int[size];
        int[] count = new int[10];

        // Contador
        for (int i = 0; i < size; i++) {
            int index = (array[i] / exp) % 10;
            count[index]++;
        }

        // Atualizar count[i] para posições acumuladas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Array de saida
        for (int i = size - 1; i >= 0; i--) {
            int index = (array[i] / exp) % 10;
            output[count[index] - 1] = array[i];
            count[index]--;
        }

        for (int i = 0; i < size; i++) {
            array[i] = output[i];
        }
    }
    private static int getMax(int[] array, int size) {
        int max = array[0];
        for (int i = 1; i < size; i++) {
            interactions++;
            if (array[i] > max) {
                max = array[i];
                changes++;
            }
        }
        return max;
    }
    public static Result sort(int[] array, int size) {
        changes = 0;
        interactions = 0;
        long start = System.nanoTime();

        int max = getMax(array, size);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, size, exp);
        }

        long end = System.nanoTime();
        double executionTime = (end - start) / 1_000_000.0;
        return new Result(executionTime, changes, interactions);
    }
}
