package Arrays;
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

class ArraySolution4 {

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, int m, List<List<Integer>> queries) {
        // Write your code here
        /* MY SOLUTION -RAN OUT OF TIME
        long[] zeroesArray = new long[n];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = queries.get(i).get(0) - 1; j < queries.get(i).get(1);j++) {
                zeroesArray[j] += queries.get(i).get(2);
                if (zeroesArray[j] > max) {
                    max = zeroesArray[j];
                }
            }
        }
        System.out.println(max);
         */

        long [] array = new long[n + 1];
        while (m-- > 0) {
            int a = queries.get(m).get(0);
            int b = queries.get(m).get(1);
            int k = queries.get(m).get(2);
            array[a-1] += k;
            array[b]   -= k;
        }

        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }

        //System.out.println(max);

        return max;

    }

}

public class ArrayManipulation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
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

        long result = ArraySolution4.arrayManipulation(n, m, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}