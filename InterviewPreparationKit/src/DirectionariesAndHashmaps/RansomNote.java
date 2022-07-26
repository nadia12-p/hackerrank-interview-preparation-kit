package DirectionariesAndHashmaps;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class DirectionariesSolution2 {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        HashMap<String, Integer> hashMagazine = new HashMap<>();

        for (String a : magazine) {
            if (hashMagazine.containsKey(a)) {
                int old = hashMagazine.get(a);
                hashMagazine.put(a,old+1);
            }
            else {
                hashMagazine.put(a,1);
            }
        }

        for (String word : note) {
            if (hashMagazine.containsKey(word)) {
                int newValue = hashMagazine.get(word)-1;
                if (newValue == 0 ) {
                    hashMagazine.remove(word);
                }
                else {
                    hashMagazine.put(word, newValue);
                }
            }
            else {
                System.out.println("No");
                return;
            }
        }

        System.out.println("Yes");





    }

}

public class RansomNote {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        DirectionariesSolution2.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
