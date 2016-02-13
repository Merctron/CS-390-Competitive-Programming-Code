import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 2/11/16.
 */
public class Trainsorting {

    public static void main (String [] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i ++) {
            int c = s.nextInt();

            //System.out.println("casel: " + c);
            int[] trains = new int[c];
            int[] fTrains = new int[c];
            int[] bTrains = new int[c];
            int[] mTrains = new int[c];

            for (int j = 0; j < c; j++) {
                trains[j] = s.nextInt();
                mTrains[j] = 0;
            }

            for (int p = c - 1; p >= 0; p--) {
                fTrains[p] = 1;
                for (int q = p + 1; q < c; q++) {
                    if (trains[p] < trains[q]) {
                        if (fTrains[q] + 1 > fTrains[p]) {
                            fTrains[p] = fTrains[q] + 1;
                        }
                        else {
                            fTrains[p] = fTrains[p];
                        }
                    }
                }
            }

            for (int p = c - 1; p >= 0; p--) {
                bTrains[p] = 1;
                for (int q = p + 1; q < c; q++) {
                    if (trains[p] > trains[q]) {
                        if (bTrains[q] + 1 > bTrains[p]) {
                            bTrains[p] = bTrains[q] + 1;
                        }
                        else {
                            bTrains[p] = bTrains[p];
                        }
                    }
                }
            }

            int mlen = 0;
            for (int k = 0; k < c; k++) {
                if (mlen < fTrains[k] + bTrains[k] - 1) {
                    mlen = fTrains[k] + bTrains[k] - 1;
                }
            }
//
//            for (int p = 0; p < c; p++) {
//                if (p == 0) {
//                    fTrains[p] = trains[p];
//                    bTrains[p] = trains[p];
//                    mTrains[p] = 1;
//                }
//                else {
//
//                    for (int r = 0; r < p; r++) {
//                        int lm = mTrains[r];
//                        if (trains[p] >= fTrains[r]) {
//                            lm++;
//                            if (lm > mTrains[p]) {
//                                mTrains[p] = lm;
//                                fTrains[p] = trains[p];
//                                bTrains[p] = bTrains[r];
//                            }
//                        }
//                        else if (trains[p] <= bTrains[r]) {
//                            lm++;
//                            if (lm > mTrains[p]) {
//                                mTrains[p] = lm;
//                                fTrains[p] = fTrains[r];
//                                bTrains[p] = trains[p];
//                            }
//                        }
//                        else {
//                            if (lm > mTrains[p]) {
//                                mTrains[p] = lm;
//                                fTrains[p] = fTrains[r];
//                                bTrains[p] = bTrains[r];
//                            }
//                        }
//
//                    }
//
//                }
//            }

            //Recursive
            //int mt = maxTrains(trains, 0, -1, -1);
            if (c > 0) {
                System.out.println(mlen);
            }
            else {
                System.out.println(0);
            }
        }

        s.close();
    }

    public static int maxTrains(int[] trains, int index, int ft, int bt) {
        int max = 0, val1 = 0, val2 = 0;

        if (index >= trains.length) {
            return max;
        }

        if (index == 0) {
            val1 = 1 + maxTrains(trains, index + 1, trains[0], trains[0]);
            val2 = maxTrains(trains, index + 1, -1, -1);
        }
        else {
            if (ft == -1) {
                val1 = 1 + maxTrains(trains, index + 1, trains[index], trains[index]);
                val2 = maxTrains(trains, index + 1, -1, -1);
            }
            else {
                if (trains[index] >= ft) {
                    val1 = 1 + maxTrains(trains, index + 1, trains[index], bt);
                    val2 = maxTrains(trains, index + 1, ft, bt);
                }
                else if (trains[index] <= bt) {
                    val1 = 1 + maxTrains(trains, index + 1, ft, trains[index]);
                    val2 = maxTrains(trains, index + 1, ft, bt);
                }
                else {
                    val1 = maxTrains(trains, index + 1, ft, bt);
                    val2 = val1;
                }
            }
        }

        if (val1 >= val2) {
            max = val1;
        }
        else {
            max = val2;
        }

        return max;
    }

}
