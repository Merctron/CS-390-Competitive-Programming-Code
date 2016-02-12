import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 2/11/16.
 */
public class WeddingShopping {

    public static void main (String [] args) throws IOException {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 0; i < n; i++) {
            int m = s.nextInt();
            int c = s.nextInt();

            s.nextLine();

            ArrayList<ArrayList<Integer>> garments = new ArrayList<ArrayList<Integer>>();

            for (int j = 0; j < c; j ++) {
                String ln = s.nextLine();
                String[] strArray = ln.split(" ");
                garments.add(new ArrayList<Integer>());
                for (int k = 0; k < strArray.length; k++) {
                    garments.get(j).add(Integer.parseInt(strArray[k]));
                }
            }



        }

        s.close();

    }
}
