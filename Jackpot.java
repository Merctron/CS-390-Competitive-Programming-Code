import java.io.IOException;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 2/11/16.
 */
public class Jackpot {

    public static void main (String [] args) throws IOException {

        Scanner s = new Scanner(System.in);
        while (true) {
            int n = s.nextInt();
            if (n == 0) break;

            int winStreak = 0;
            int winCount = 0;

            for (int i = 0; i < n; i++) {
                int curr = s.nextInt();
                //System.out.println(curr + ", " + winCount + ", " +  winStreak);
                winCount += curr;
                if (winCount < 0) {
                    winCount = 0;
                }
                else if (winCount > 0) {
                    if (winCount > winStreak) {
                        winStreak = winCount;
                    }
                }
            }

            if (winStreak > 0) {
                System.out.println("The maximum winning streak is " + winStreak + ".");
            }
            else {
                System.out.println("Losing streak.");
            }
        }

        s.close();
    }
}
