package arrayproblems;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by gopalbala on 1/5/17.
 */
public class LargestDivisibleSubset {

    public static void main(String[] args) {
        int[] arr = new int[]{
                2, 4, 3, 8
        };
        List<Integer> r = largestDivisibleSubset(arr);
        r.stream().forEach(System.out::println);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0)
            return result;

        Arrays.sort(nums);

        int[] divCount = new int[nums.length];
        int[] index = new int[nums.length];

        Arrays.fill(divCount, 1);
        Arrays.fill(index, -1);


        int max = 0;
        int maxIndex = -1;

        for (int i = 0; i < divCount.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0 && divCount[i] < divCount[j] + 1) {
                    divCount[i] = divCount[j] + 1;
                    index[i] = j;
                }
            }
            if (max < divCount[i]) {
                max = divCount[i];
                maxIndex = i;
            }
        }
        int i = maxIndex;
        while (i >= 0) {
            result.add(nums[i]);
            i = index[i];
        }
        return result;
    }
}
