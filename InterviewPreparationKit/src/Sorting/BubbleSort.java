package Sorting;
import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.SQLOutput;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class SortingSolution1 {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static void countSwaps(List<Integer> a) {
        // Write your code here

        Integer[] myArray = new Integer[a.size()];
        a.toArray(myArray);

        int swap = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (myArray[j] > myArray[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    swap++;
                }
            }

        }

        System.out.println("Array is sorted in " + swap + " swaps.");
        System.out.println("First Element: " + myArray[0]);
        System.out.println("Last Element: " + myArray[myArray.length - 1]);

    }

}

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        SortingSolution1.countSwaps(a);

        bufferedReader.close();
    }
}
