import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 9/24/16.
 */
public class InverseFactorial {

    public static void main(String args[]) {
        Scanner s  = new Scanner(System.in);
        BigInteger toCalc = new BigInteger(s.nextLine());
        BigInteger divBy = new BigInteger("1");
        while (!toCalc.equals(BigInteger.ONE)) {
            divBy = divBy.add(BigInteger.ONE);
            toCalc = toCalc.divide(divBy);
        }
        System.out.println(divBy.toString());
    }
}
