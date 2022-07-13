package WarmUpChallenges;

import java.io.*;

import static java.util.stream.Collectors.joining;

class SolutionProblem2 {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        char[] direction = new char[path.length()];
        for (int i = 0; i < path.length(); i++) {
            direction[i] = path.charAt(i);
        }
        int movement = 0;
        int countValleys = 0;
        int old;
        for (char c : direction) {
            old = movement;
            if (c == 'D') {
                movement += -1;
            }
            else {
                movement += 1;
            }
            if (old == 0 && movement < 0) {
                countValleys++;
            }
        }

        return countValleys;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = SolutionProblem2.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
