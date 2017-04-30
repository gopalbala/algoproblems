import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by gopalbala on 28/4/17.
 */
public class PairWithGivenSumInArray {

    public static HashMap<String,Integer> findPair(int[] inputArray, int sum) {
        HashSet<Integer> hi = new HashSet<>();
        HashMap<String,Integer> sumMap = new HashMap<>(inputArray.length);
        Arrays.stream(inputArray).forEach(i -> hi.add(i));
        Arrays.stream(inputArray).forEach(i -> {
            if (hi.contains(sum-i) && i != sum-i){
               sumMap.put(i + ":" + (sum -i),sum);
            }
        });
        return sumMap;
    }

    public static void main(String[] args) {
        int[]  arr = {8, 7, 2, 5, 3, 1};
        findPair(arr,10).forEach((k,v) -> System.out.println(k + ":" + v));
    }
}
