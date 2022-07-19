package DirectionariesAndHashmaps;

import jdk.swing.interop.SwingInterOpUtils;

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

class DirectionariesSolution1 {

    /*
     * Complete the 'twoStrings' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s1
     *  2. STRING s2
     */

    public static String twoStrings(String s1, String s2) {
        // Write your code here
        HashMap<Character,Integer> chars = new HashMap<>();

        for(int i = 0; i <s1.length(); i++ ) {
            chars.put(s1.charAt(i),1);
        }


        for(int i = 0; i <s2.length(); i++ ) {
            if (chars.containsKey(s2.charAt(i))) {
                int old = 1;
                chars.put(s2.charAt(i),old+1);
            }
            else {
                chars.put(s2.charAt(i),1);
            }

            if (chars.containsValue(2)) {
                return "YES";
            }
        }

        return "NO";


    }

}

public class TwoStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s1 = bufferedReader.readLine();

                String s2 = bufferedReader.readLine();

                String result = DirectionariesSolution1.twoStrings(s1, s2);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
