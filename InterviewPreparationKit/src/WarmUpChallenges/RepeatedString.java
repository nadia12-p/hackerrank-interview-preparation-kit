package WarmUpChallenges;

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

class SolutionProblem4 {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here
        char[] ch = s.toCharArray();
        long overRepetitions = n % s.length();
        long originalStrRepetitions = (n - overRepetitions) / s.length();
        long total = 0,repTotal = 0,overTotal = 0;

        for (int i = 0; i < s.length();i++) {
            if (ch[i] == 'a') {
                repTotal += 1;
            }
        }
        for (int i = 0; i < overRepetitions;i++) {
            if (ch[i] == 'a') {
                overTotal += 1;
            }
        }

        total = (repTotal*originalStrRepetitions) + overTotal;

        return total;

    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = SolutionProblem4.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
