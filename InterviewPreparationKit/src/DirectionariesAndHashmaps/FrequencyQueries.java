package DirectionariesAndHashmaps;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {

        HashMap<Integer, Integer> array = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            int operation = queries[i][0];
            int data = queries[i][1];

            if (operation == 1) {
                if (array.containsKey(data)) {
                    int value = array.get(data);
                    array.put(data, value + 1);
                } else {
                    array.put(data, 1);
                }
            }

            if (operation == 2) {
                if (array.containsKey(data)) {
                    int value = array.get(data);
                    array.put(data, value - 1);
                }
            }

            if (operation == 3) {
                if (array.containsValue(data)) {
                    result.add(1);
                } else {
                    result.add(0);
                }
            }

        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];

            for (int i = 0; i < q; i++) {
                String[] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(System.getenv("OUTPUT_PATH")))) {

                bufferedWriter.write(ans.stream().map(Object::toString)
                        .collect(joining("\n")) + "\n");
            }
        }
    }
}
