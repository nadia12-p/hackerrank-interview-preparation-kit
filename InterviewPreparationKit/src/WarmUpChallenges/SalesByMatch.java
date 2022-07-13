package WarmUpChallenges;

import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */
    public static int sockMerchant(int n, List<Integer> ar) {
        HashMap<Integer, Integer> socks = new HashMap<>();
        for (Integer a : ar) {
            if (socks.containsKey(a)) {
                int old = socks.get(a);
                socks.put(a,old+1);
            }
            else {
                socks.put(a,1);
            }
        }
        System.out.println(socks);
        int sum = 0;
        int total = 0;
        for(Integer value: socks.values()) {
            System.out.print(value);
            sum = value/2;
            System.out.print(" = " + sum + "   ");
            total = sum + total;
        }
        return total;
    }

}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Solution.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
