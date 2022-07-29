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
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        HashMap<Integer, Integer> elementFreq = new HashMap<>();
        HashMap<Integer, Integer> freqCount = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            int operation = queries.get(i).get(0);
            int data = queries.get(i).get(1);

            if (operation == 1) {
                if (freqCount.containsKey(elementFreq.get(data))) {
                    int newValue = freqCount.get(elementFreq.get(data))-1;
                    if (newValue == 0 ) {
                        freqCount.remove(elementFreq.get(data));
                    }
                    else {
                        freqCount.put(elementFreq.get(data), newValue);
                    }
                }
                elementFreq.put(data,elementFreq.getOrDefault(data,0)+1);
                freqCount.put(elementFreq.get(data),freqCount.getOrDefault(elementFreq.get(data),0)+1);
            }
            else if (operation == 2) {
                if (elementFreq.containsKey(data)) {
                    int newValue = freqCount.get(elementFreq.get(data))-1;
                    if (newValue == 0 ) {
                        freqCount.remove(elementFreq.get(data));
                    }
                    else {
                        freqCount.put(elementFreq.get(data), newValue);
                    }
                    int newValueElement = elementFreq.get(data)-1;
                    if (newValueElement == 0 ) {
                        elementFreq.remove(data);
                    }
                    else {
                        elementFreq.put(data,newValueElement);
                    }
                    freqCount.put(elementFreq.get(data),freqCount.getOrDefault(elementFreq.get(data),0)+1);
                }

            }
            else {
                if (freqCount.containsKey(data) && freqCount.getOrDefault(data,0) != 0) {
                    result.add(1);
                }
                else {
                    result.add(0);
                }

            }

        }

        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
