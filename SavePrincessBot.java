import java.util.Scanner;

/**
 * Created by DiGiT_WiZARD on 9/2/16.
 *
 * Solution to the hackerrank bot saves princess problem.
 */
public class SavePrincessBot {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        s.nextLine();
        String[] grid = new String[N];
        for (int i = 0; i < N; i++) {
            grid[i] = s.nextLine();
        }

        int tarR = 0;
        int tarC = 0;

        if (grid[0].charAt(0) == 'p') {
            tarR = 0;
            tarC = 0;
        }
        if (grid[0].charAt(N-1) == 'p') {
            tarR = 0;
            tarC = N-1;
        }
        if (grid[N-1].charAt(0) == 'p') {
            tarR = N-1;
            tarC = 0;
        }
        if (grid[N-1].charAt(N-1) == 'p') {
            tarR = N-1;
            tarC = N-1;
        }

        travel(tarR, tarC, (N+1)/2 - 1, (N+1)/2 - 1);
    }

    public static void travel(int dr, int dc, int cr, int cc) {
        if (dr == cr && dc == cc) return;
        if (!(dr == cr)) {
            if (dr < cr) {
                System.out.println("UP");
                travel(dr, dc, cr - 1, cc);
            }
            else {
                System.out.println("DOWN");
                travel(dr, dc, cr + 1, cc);
            }
        }
        else {
            if (dc < cc) {
                System.out.println("LEFT");
                travel(dr, dc, cr, cc - 1);
            }
            else {
                System.out.println("RIGHT");
                travel(dr, dc, cr, cc + 1);
            }
        }
    }
}
