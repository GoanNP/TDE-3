import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner key = new Scanner(System.in);

        int[] sizes = {1000, 10000, 100000, 500000, 1000000};

        System.out.print("Digite a seed: ");
        int seed = key.nextInt();

        System.out.print("Digite quantas repeticoes deja realizar: ");
        int repetitions = key.nextInt();

        DataGenerator generator = new DataGenerator(seed);
        Data data = new Data();

        for (int size : sizes) {

            System.out.println("\n--------------------------------- Size: " + size + " ---------------------------------\n");

            for (int c = 0; c < repetitions; c++) {

                int[] array = generator.createArray(size);

                int[] arrayHeap = array.clone();
                data.addData("Heap Sort", HeapSort.sort(arrayHeap, size));

                int[] arrayRadix = array.clone();
                data.addData("Radix Sort", RadixSort.sort(arrayRadix, size));
            }
        }

        data.showData();
    }
}