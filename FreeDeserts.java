import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by DiGiT_WiZARD on 9/24/16.
 */
public class FreeDeserts {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        BigInteger toCalc = new BigInteger(s.nextLine());
        BigInteger b = new BigInteger("1");
        BigInteger m = toCalc.subtract(BigInteger.ONE);
        ArrayList<Pair> bills = new ArrayList<Pair>();
        while (m.compareTo(b) == 1) {
            if (!hasSameChars(b.toString(), m.toString()) && !hasSameChars(m.toString(), toCalc.toString())
                    && !hasSameChars(b.toString(), toCalc.toString())) {
                bills.add(new Pair(new BigInteger(b.toString()), new BigInteger(m.toString())));
            }
            b = b.add(BigInteger.ONE);
            m = m.subtract(BigInteger.ONE);
        }

        System.out.println(bills.size());
        for (int i = 0; i < bills.size(); i++) {
            if (i > 5000) {
                break;
            }
            System.out.println(bills.get(i).b.toString() + " " + bills.get(i).m.toString());
        }
    }

    static class Pair {
        BigInteger b;
        BigInteger m;

        public Pair(BigInteger bb, BigInteger mm) {
            this.b = bb;
            this.m = mm;
        }
    }

    static boolean hasSameChars(String s1, String s2) {
        HashSet<Character> h1 = new HashSet<Character>(), h2 = new HashSet<Character>();
        for (int i = 0; i < s1.length(); i++) {
            h1.add(s1.charAt(i));
        }
        for (int j = 0; j < s2.length(); j++) {
            h2.add(s2.charAt(j));
        }
        h1.retainAll(h2);
        return (h1.size() > 0);
    }
}
