package arrayproblems;

/**
 * Created by gopalbala on 1/5/17.
 */
public class FindTwoNumbersOccurOnce {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int xor_res = 0;
        for (int i = 0; i < nums.length; ++i) {
            xor_res ^= nums[i];
        }

        int mask = xor_res ^ (xor_res & (xor_res-1));

        int p = 0;
        int q = 0;

        for (int i=0;i<nums.length;i++){
            if ((nums[i] & mask) == 0){
                p ^= nums[i];
            }
            else {
                q ^= nums[i];
            }
        }

        System.out.println(p + " " + q);
    }
}
