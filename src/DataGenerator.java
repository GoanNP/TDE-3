import java.util.Random;

public class DataGenerator {
    private final Random random;

    public DataGenerator(int seed) {
        random = new Random(seed);
    }

    public int[] createArray(int size) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }

        return array;
    }
}
