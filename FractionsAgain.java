import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FractionsAgain {
	
	public static void main (String [] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		
		while (s.hasNext()) {
			int k = s.nextInt();
			
			ArrayList<Integer> xvals = new ArrayList<Integer>();
			ArrayList<Integer> yvals = new ArrayList<Integer>();
			
			//System.out.println(k);
			for (int i = k+1; i <= 2*k; i++) {
				if ((k*i) % (i - k) == 0) {
					int yp = ((k*i)/(i - k));
					if (yp >= i) {
						xvals.add(yp);
						yvals.add(i);
						
					}
				}
			}
			
			System.out.println(xvals.size());
			for (int j = 0; j < xvals.size(); j++) {
				System.out.println("1/" + k + " = 1/" + xvals.get(j) + " + 1/" + yvals.get(j));
			}
		}
		
		s.close();
	}
	
}
