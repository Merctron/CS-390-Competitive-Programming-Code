import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 9/24/16.
 */
public class QuickEstimates {

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();

        BigInteger toCalc;
        int mag = 0;
        BigInteger sub;
        for (int i = 0; i < N; i++) {
            toCalc = new BigInteger(s.nextLine());
            while (!toCalc.equals(BigInteger.ZERO)) {
                sub = toCalc.mod(BigInteger.TEN);
                toCalc = toCalc.subtract(sub);
                toCalc = toCalc.divide(BigInteger.TEN);
                mag++;
            }
            if (mag == 0) {
                mag = 1;
            }
            System.out.println(mag);
            mag = 0;
        }

        s.close();
    }
}
