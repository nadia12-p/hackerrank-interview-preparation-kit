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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        HashMap<Long, Long> potential = new HashMap<Long, Long>();
        HashMap<Long, Long> counter = new HashMap<Long, Long>();
        long count = 0;

        for(int i = 0; i<arr.size(); i++) {
            long a = arr.get(i);
            long key = a/r;

            if (counter.containsKey(key) && (a % r) == 0) {
                count += counter.get(key);
            }
            if (potential.containsKey(key) && (a % r == 0)) {
                long c = potential.get(key);
                counter.put(a, counter.getOrDefault(a,0L)+c);
            }
            potential.put(a,potential.getOrDefault(a,0L)+1);
        }

        return count;


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
