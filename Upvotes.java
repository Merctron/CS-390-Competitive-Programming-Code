import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 8/31/16.
 *
 * Quora upvote problem. Determine contiguous non-increasing/decreasing
 * subranges of upvotes in windows of size K days.
 *
 * N = 8, K = 4;
 1 1 2 3 4 4 1 1;

 Window 1: 1 1 2 3 - Gap: 5

 Non-Increasing: 1 1,
 Non-Decreasing: 1 1, 1 2, 2 3, 1 1 2, 1 2 3, 1 1 2 3;

 Window 2: 1 2 3 4 - Gap: 6

 Window 3: 2 3 4 4 - Gap: 5

 Window 4: 3 4 4 1 - Gap: 0

 Non-Increasing: 4 4, 4 1, 4 4 1
 Non-Decreasing: 3 4, 4 4, 3 4 4

 Window 5: 4 4 1 1 - Gap: -4

 Non-Increasing: 1 1, 4 4, 4 1, 4 4 1, 4 1 1, 4 4 1 1
 Non-Decreasing: 4 4, 1 1

 3 3 4 4 1 1
 */
public class Upvotes {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int[] upvotes = new int[N + 1];
        int[][] inc = new int[2][N + 1];
        int[][] dec = new int[2][N + 1];
        for (int i = 0; i < N; i++) {
            upvotes[i] = s.nextInt();
        }
        s.close();

        for (int i = 0; i < N; i++) {
            inc[0][i] = 1 + ((i > 0) && (upvotes[i] >= upvotes[i - 1]) ? inc[0][i - 1] : 0);
            dec[0][i] = 1 + ((i > 0) && (upvotes[i] <= upvotes[i - 1]) ? dec[0][i - 1] : 0);
        }

        for (int i = N - 1; i >= 0; i--) {
            inc[1][i] = 1 + ((i < N - 1) && (upvotes[i] >= upvotes[i + 1]) ? inc[1][i + 1] : 0);
            dec[1][i] = 1 + ((i < N - 1) && (upvotes[i] <= upvotes[i + 1]) ? dec[1][i + 1] : 0);
        }

        int nInc = 0;
        int nDec = 0;

        System.out.println(Arrays.deepToString(inc));
        System.out.println(Arrays.deepToString(dec));

        for (int i = 0; i < K - 1; i++) {
            nInc += inc[0][i];
            nDec += dec[0][i];
        }

        for (int i = K - 1; i < N; i++) {
            nInc += Math.min(K, inc[0][i]);
            nDec += Math.min(K, dec[0][i]);
            System.out.println("nInc: " + nInc + ", nDec: " + nDec);
            System.out.println(nInc - nDec);
            nInc -= Math.min(K, dec[1][i-(K-1)]);
            nDec -= Math.min(K, inc[1][i-(K-1)]);
            System.out.println("nInc: " + nInc + ", nDec: " + nDec);
        }

//        for (int i = 0; i < N; i++) {
//            if (i + K > N) {
//                break;
//            }
//            System.out.println(processWindow(upvotes, i, K));
//        }
    }

//    public static int processWindow(int[] upvotes, int start, int K) {
//        int numNdRanges = 0;
//        int numNiRanges = 0;
//
//        for (int i = start; i < start + K; i++) {
//            for (int j = i; j < start + K; j++) {
//
//            }
//        }
//    }

//    public static int processWindow(int[] upvotes, int start, int K) {
//        boolean nd = true;
//        int numNdRanges = 0;
//        int numNiRanges = 0;
//        int beacon = start;
//
//        System.out.println(start + ", " + (start + K - 1));
//
//        for (int j = start; j < start + K; j++) {
//            if (j == start + K - 1) {
//                if (nd) {
//                    numNdRanges += (j - beacon + 1) * (j - beacon) / 2;
//                }
//                else {
//                    numNiRanges += (j - beacon + 1) * (j - beacon) / 2;
//                }
//            }
//            else {
//                if (nd) {
//                    if (!(upvotes[j] <= upvotes[j + 1])) {
//                        numNdRanges += ((j - beacon + 1) * (j - beacon) / 2);
//                        nd = false;
//                        beacon = j;
//                        j--;
//                    }
//                }
//                else {
//                    if (!(upvotes[j] >= upvotes[j + 1])) {
//                        numNiRanges += ((j - beacon + 1) * (j - beacon) / 2);
//                        nd = true;
//                        beacon = j;
//                        j--;
//                    }
//                }
//            }
//        }
//
//        int toReturn  = numNdRanges - numNiRanges;
//        System.out.println("Returned: " + toReturn);
//        if (toReturn > 0) {
//            toReturn = toReturn - numDuplicates(upvotes, start, start + K - 1);
//        }
//        else if (toReturn < 0) {
//            toReturn = toReturn + numDuplicates(upvotes, start, start + K - 1);
//        }
//        return toReturn;
//    }
//
//    /* Returns a value to discount from the current window gap based on duplicates*/
//    public static int numDuplicates(int[] upvotes, int strt, int end) {
//        int prev = upvotes[strt];
//        int numDups = 1;
//        int numDupsDist = 0;
//        for (int i = strt + 1; i < end + 1; i++) {
//            if (upvotes[i] == prev) {
//                numDups++;
//            }
//            else {
//                numDupsDist += (numDups * (numDups - 1) / 2);
//                numDups = 1;
//            }
//            prev = upvotes[i];
//            if (i == end) {
//                numDupsDist += (numDups * (numDups - 1) / 2);
//            }
//        }
//        //System.out.println("numd: " + numDupsDist);
//        return numDupsDist;
//    }
}
