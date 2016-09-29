import java.util.Arrays;

/**
 * Created by DiGiT_WiZARD on 8/30/16.
 */

public class LongestSubstring {


    public static void main(String args[]) {
        System.out.println(longestSubstring("acbcabebebe", 3));
    }

    /*
    * Finds the longest substring with exactly M unique characters.
    * String passed as argument must be lower case.
    * */
    public static String longestSubstring(String str, int M) {
        int uniqueCount = 0;
        int start = 0;
        int end = 0;
        int max = 0;
        int maxStart = 0;
        int[] counters = new int[27];
        Arrays.fill(counters,0);

        for (int i = 0; i < str.length(); i++) {
            if (counters[str.charAt(i) - 'a'] == 0) {
                uniqueCount++;
            }
            counters[str.charAt(i) - 'a']++;
        }
        if (uniqueCount < M) {
            return null;
        }
        Arrays.fill(counters,0);

        counters[str.charAt(0) - 'a']++;
        for (int i = 1; i < str.length(); i++) {
            counters[str.charAt(i) - 'a']++;
            end++;
            while (!isValid(counters, M)) {
                counters[str.charAt(start) - 'a']--;
                start++;
            }
            if((end - start + 1) > max) {
                max = end - start + 1;
                maxStart = start;
            }
        }

        return str.substring(maxStart, end + 1);
    }

    /*
    * Determines if the number of unique chars recorded exceeds M.
    * */
    public static boolean isValid(int[] counters, int M) {
        int uniqueCount = 0;
        for (int i = 0; i < 26; i++) {
            if (counters[i] > 0) {
                uniqueCount++;
            }
        }
        return (M >= uniqueCount);
    }
}
