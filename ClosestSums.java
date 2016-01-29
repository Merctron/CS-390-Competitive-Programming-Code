import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClosestSums {
	
	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(System.in);
		int count = 1;
		
		while (true) {
			int n = s.nextInt();
			
			if (n == 0) {
				break;
			}
			
			ArrayList<Integer> set = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(s.nextInt());
			}
			
			int m = s.nextInt();
			System.out.println("Case " + count + ":");
			for (int j = 0; j < m; j++) {
				solve(set, s.nextInt());
			}
			count++;
		}
		
		s.close();
	}
	
	public static void solve(ArrayList<Integer> set, int num) {
		
		int cl = Integer.MAX_VALUE;
		int sum = 0;
		
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < set.size(); j++) {
				if (j != i) {
					if (Math.abs(num - (set.get(i) + set.get(j))) < cl) {
						cl = Math.abs(num - (set.get(i) + set.get(j)));
						sum = set.get(i) + set.get(j);
					}
				}	
			}
		}
		
		System.out.println("Closest sum to " + num + " is " + sum + ".");
	}

}
