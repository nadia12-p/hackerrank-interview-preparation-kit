package Sorting;
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

class SortingSolution2 {

    /*
     * Complete the 'maximumToys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY prices
     *  2. INTEGER k
     */

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here

        int[] items = new int[prices.size()];
        for (int i = 0; i < prices.size(); i++) {
            items[i] = prices.get(i);
        }

        Arrays.sort(items);
        int count = 0;
        for (int i=0; i<items.length; i++) {
            if (k-items[i] > 0) {
                k -= items[i];
                count+=1;
            }
            else {
                break;
            }

        }

        return count;

    }

}

public class MarkAndToys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SortingSolution2.maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}