package arrayproblems;

import java.util.Arrays;

/**
 * Created by gopalbala on 1/5/17.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int stepsToRotate = 3;
        int firstHalf = arr.length - stepsToRotate;
        reverse(arr, 0, firstHalf - 1);
        reverse(arr, firstHalf, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void reverse(int[] arr, int left, int right) {
        if (arr == null || arr.length == 1)
            return;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
