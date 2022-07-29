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

class SortingSolution4 {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
        // Write your code here
        double [] trailingExp = new double[d];
        double median = 0.0;
        int notifications = 0;

        for (int i = d; i < expenditure.size(); i ++) {
            int a = 0;
            for (int j = i-d; j < i; j++) {
                trailingExp[a] = expenditure.get(j);
                a++; //binary index/binary tree
            }
            Arrays.sort(trailingExp);
            int posMed = d/2;
            if (posMed % 2 == 0) {
                median = (trailingExp[posMed-1] + trailingExp[posMed]) / 2;
            }
            else {
                median = trailingExp[posMed];
            }
            if (expenditure.get(i) >= 2 * median) {
                notifications += 1;
            }
        }

        return notifications;
    }

}

public class FraudalentActivityNotification {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> expenditure = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = SortingSolution4.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}