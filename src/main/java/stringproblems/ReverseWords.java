package stringproblems;

/**
 * Created by gopalbala on 30/4/17.
 */
public class ReverseWords {
    public static void reverseWords(String s) {
        int i = s.length();
        for (int j = s.length()-1; j >= 0; j--) {
            if (s.charAt(j) == ' ' || j == 0) {
                reverse(s, i, j );
                i = j + 1;
            }
        }
    }

    private static void reverse(String s, int i, int j) {
        System.out.print(s.substring(j, i));
    }

    public static void main(String[] args) {
        reverseWords("the sky is blue");
    }
}
