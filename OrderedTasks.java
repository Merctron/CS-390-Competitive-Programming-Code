import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class OrderedTasks {
	
	public static void main (String [] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		ArrayList<pair> pred = new ArrayList<pair>();
		ArrayList<Integer> toPrint = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		
		
		while (true) {
			
			int n = s.nextInt();
			int m = s.nextInt();
			
			if (m == 0 && n == 0) break;
			
			for (int i = 0; i < m; i++) {
				pred.add(new pair(s.nextInt(), s.nextInt()));
			}
			
			for (int k = 0; k < m; k ++) {
				if (ll.contains(pred.get(k).ap) && ll.contains(pred.get(k).bp)) {
					if (!(ll.indexOf(pred.get(k).ap) < ll.indexOf(pred.get(k).bp))) {
						ll.remove(ll.indexOf(pred.get(k).ap));
						ll.add(ll.indexOf(pred.get(k).bp), pred.get(k).ap);
					}
				}
				else if (ll.contains(pred.get(k).ap)) {
					ll.get(ll.indexOf(pred.get(k).ap));
					ll.add(pred.get(k).bp);
				}
				else if (ll.contains(pred.get(k).bp)) {
					ll.add(ll.indexOf(pred.get(k).bp), pred.get(k).ap);
				}
				else {
					ll.add(pred.get(k).ap);
					ll.add(pred.get(k).bp);
				}
			}
			
			for (int q = 0; q < ll.size(); q++) {
				toPrint.add(ll.get(q));
			}
			
			for (int j = 1; j <= n; j++) {
				if (!toPrint.contains(j)) {
					toPrint.add(j);
				}
			}
			
			
			for (int r = 0; r < toPrint.size(); r++) {
				
				if (r == toPrint.size()-1) {
					System.out.print(toPrint.get(r));
				}
				else {
					System.out.print(toPrint.get(r) + " ");
				}
			}
			System.out.println();
			
			pred.clear();
			toPrint.clear();
			ll.clear();
		}
		
		s.close();
	}
	
	private static class pair {
		
		int ap;
		int bp;
		
		public pair(int a, int b) {
			this.ap = a;
			this.bp = b;
		}
		
	}

}
