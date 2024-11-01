import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Data {

    private final Map<String, List<Result>> results = new HashMap<>();

    public void addData(String type, Result result) {

        results.putIfAbsent(type, new ArrayList<>());
        results.get(type).add(result);

        System.out.printf("%s: Tempo %.2f ms / Iterações: %d / Mudanças: %d\n",
                type, result.getExecutionTime(), result.getInteractions(), result.getChanges());
    }

    public void showData() {
        for (String type : results.keySet()) {

            System.out.println("\nResults para: " + type);

            for (Result result : results.get(type)) {
                System.out.printf("Tempo: %.2f ms / Iterações: %d / Mudanças: %d\n",
                        result.getExecutionTime(), result.getChanges(), result.getInteractions());
            }
        }
    }
}