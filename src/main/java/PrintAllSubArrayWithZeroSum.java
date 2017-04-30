import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by gopalbala on 28/4/17.
 */
public class PrintAllSubArrayWithZeroSum {

    public static void printEmAllNaive(int[] input) {
        // int sum = Arrays.stream(input).sum();

        for (int i = 0; i < input.length; i++) {
            int subSum = 0;
            for (int j = i; j < input.length; j++) {
                subSum += input[j];
                if (subSum == 0) {
                    System.out.println("Found in sub array " + i + " to " + j);
                }
            }
        }
    }

    private static void insertToHash(Map<Integer, ArrayList> hashMap, Integer key, Integer val) {
        if (hashMap.containsKey(key)) {
            hashMap.get(key).add(val);
        } else {
            ArrayList<Integer> listVal = new ArrayList<>();
            listVal.add(val);
            hashMap.put(key, listVal);
        }

    }

    private static void printEmAllLittleIntelligently(int[] input) {
        //here use hashMap
        Map<Integer, ArrayList> hashMap = new HashMap<>();
        insertToHash(hashMap, 0, -1);
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (hashMap.containsKey(sum)) {
                ArrayList<Integer> found = hashMap.get(sum);
                for (Integer f : found) {
                    System.out.println("Found in sub array [" + (f + 1) + ".." +
                            i + "]");
                }
            }
            insertToHash(hashMap, sum, i);
        }
    }

    public static void main(String[] args) {
        int[] ints = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        printEmAllNaive(ints);
        printEmAllLittleIntelligently(ints);
    }
}
