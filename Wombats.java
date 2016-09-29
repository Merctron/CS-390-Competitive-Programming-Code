import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 9/9/16.
 */
public class Wombats {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[][] tetra = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (2*i - 1); j++) {
                tetra[i][j] = s.nextInt();
            }
        }

        for (int i = 0; i < tetra.length; i++) {
            System.out.println(Arrays.toString(tetra[i]));
        }
    }
}
