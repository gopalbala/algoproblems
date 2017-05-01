package arrayproblems;

import java.util.Arrays;

/**
 * Created by gopalbala on 1/5/17.
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 3, 2, 1};

        Arrays.stream(nextPermutation(arr)).forEach(System.out::println);
    }

    public static int[] nextPermutation(int[] nums) {
        if (null == nums || nums.length < 2)
            return nums;
        int p = 0;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                p = i;
                break;
            }
        }

        int q = 0;

        for (int i = nums.length - 1; i > p; i--) {
            if (nums[i] > nums[p]) {
                q = i;
                break;
            }
        }

        if (p == 0 && q == 0) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }

        int temp = nums[p];
        nums[p] = nums[q];
        nums[q] = temp;

        if (p < nums.length - 1) {
            reverse(nums, p + 1, nums.length - 1);
        }
        return nums;
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}
