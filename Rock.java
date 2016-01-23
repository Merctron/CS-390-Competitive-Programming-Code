import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Rock {
	
	static ArrayList<String> grid;
	static ArrayList<String> mgrid;
	static int r, c, n;
	
	public static void main (String [] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		s.nextLine();
		
		String gi, gl, cl;
		
		grid = new ArrayList<String>();
		mgrid = new ArrayList<String>();
		
		//System.out.println(tc);
		
		for (int i = 0; i < tc; i++) {
			gi = s.nextLine();
			//System.out.println(gi);
			String[] strArray = gi.split(" ");
			int[] intArray = new int[strArray.length];
	    	for(int j = 0; j < strArray.length; j++) {
	    	    intArray[j] = Integer.parseInt(strArray[j]);
	    	}
	    	
	    	r = intArray[0];
	    	c = intArray[1];
	    	n = intArray[2];
	    	
	    	if (r == 0 && c == 0) {
	    		s.nextLine();
	    	}
	    	
	    	//System.out.println(n);
	    	
	    	for (int k = 0; k < r; k++) {
	    		cl = s.nextLine();
	    		grid.add(cl);
	    		mgrid.add(new String(cl));
	    	}
	    	
	    	for (int x = 0; x < n; x++) {
	    		for (int y = 0; y < r; y++) {
	    			for (int z = 0; z < c; z++) {
	    				solve(mgrid.get(y).charAt(z), y, z);
	    			}
	    		}
	    		
	    		grid.clear();
	    		for (int d = 0; d < r; d++) {
	    			grid.add(new String(mgrid.get(d)));
	    		}
	    	}
	    	
	    	for (int e = 0; e < r; e++) {
	    		System.out.println(mgrid.get(e));
	    	}
	    	
	    	if (i < tc - 1) {
	    		System.out.println();
	    	}
	    	mgrid.clear();
	    	grid.clear();
		}
		
		s.close();
	}
	
	static void solve(char H, int gy, int gx) {
		switch (H) {
		case 'R':
			check('P', gy, gx);
			break;
		case 'P':
			check('S', gy, gx);
			break;
		case 'S':
			check('R', gy, gx);
			break;
		}
	}
	
	static void check(char HN, int gy, int gx) {
		
		boolean weak = false;
		
		if (gx + 1 < c) {
			if (grid.get(gy).charAt(gx + 1) == HN) weak = true;
		}
		if (gx - 1 >= 0) {
			if (grid.get(gy).charAt(gx - 1) == HN) weak = true;
		}
		if (gy + 1 < r) {
			if (grid.get(gy + 1).charAt(gx) == HN) weak = true;
		}
		if (gy - 1 >= 0) {
			if (grid.get(gy - 1).charAt(gx) == HN) weak = true;
		}
		
		if (weak) {
			StringBuilder sb = new StringBuilder(mgrid.get(gy));
			sb.setCharAt(gx, HN);
			mgrid.set(gy, sb.toString());
		}
	}
	
}
