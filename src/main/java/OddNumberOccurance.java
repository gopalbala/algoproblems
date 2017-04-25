import java.util.Arrays;

/**
 * Created by gopalbala on 25/4/17.
 */
public class OddNumberOccurance {
    public static int findOddOccuranceNumber(int[] inputArray) {
        if (null == inputArray || inputArray.length == 0 ) {
            System.out.println("Come on give me some input.");
            return Integer.MAX_VALUE;
        }
        int currentElem = inputArray[0];
        for(int i =1; i<inputArray.length;i++){
            currentElem = currentElem ^ inputArray[i];
        }
        return currentElem;
    }
    public static void main(String[] args) {
        int[] inputArray = {2, 3, 4, 3, 1, 4, 5, 1, 4, 2, 5, 6, 4};
        System.out.println("Element that occurred odd number of times is: " + findOddOccuranceNumber(inputArray));
    }
}
