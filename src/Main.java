import java.util.Scanner;

/**
 * Created by Vishal_Mukta on 12/21/2018.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter string:");
        Scanner reader = new Scanner(System.in);
        System.out.println("Length of longest substring: " + lengthOfLongestSubstring(reader.nextLine()));
    }

    private static int lengthOfLongestSubstring(String s) {
        char cs[] = s.toCharArray();
        int len = s.length();
        int i = 0, j = 0, k = 0, max = 0;
        boolean foundRepetition;
        while (i < len) {
            foundRepetition = false;
            while (j < len - 1) {
                for (k = i; k <= j; k++) {
                    if (cs[k] == cs[j + 1]) {
                        max = (j - i + 1 > max) ? j - i + 1 : max;
                        foundRepetition = true;
                        break;
                    }
                }
                if (foundRepetition) {
                    break;
                }
                j++;
            }
            if (j >= len - 1) {
                max = (len - i > max) ? len - i : max;
                break;
            }
            i = k + 1;
            if (i >= len - 1) {
                max = (1 > max) ? 1 : max;
                break;
            }
            j++;
        }
        return max;
    }
}
