import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Minesweeper {
	
	public static void main (String [] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		String nl = "";
		
		ArrayList<String> field = new ArrayList<String>();
		int fieldCount = 1;
		
		while (true) {
			nl = s.nextLine();
			String[] strArray = nl.split(" ");
			
			int n = Integer.parseInt(strArray[0]);
			int m = Integer.parseInt(strArray[1]);
			
			if (n == 0 && m == 0 ) break;
			if (fieldCount > 1) System.out.println();
			
			for (int i = 0; i < n; i++) {
				field.add(s.nextLine());
			}
			
			int mineCount = 0;
			
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (!(field.get(j).charAt(k) == '*')) {
						if (k + 1 < m) {
							if (field.get(j).charAt(k + 1) == '*') mineCount++;
						}
						if (k - 1 >= 0) {
							if (field.get(j).charAt(k - 1) == '*') mineCount++;
						}
						if (j + 1 < n) {
							if (field.get(j + 1).charAt(k) == '*') mineCount++;
						}
						if (j - 1 >= 0) {
							if (field.get(j - 1).charAt(k) == '*') mineCount++;
						}
						if (k + 1 < m && j + 1 < n) {
							if (field.get(j + 1).charAt(k + 1) == '*') mineCount++;
						}
						if (k + 1 < m && j - 1 >= 0) {
							if (field.get(j - 1).charAt(k + 1) == '*') mineCount++;
						}
						if (k - 1 >= 0 && j + 1 < n) {
							if (field.get(j + 1).charAt(k - 1) == '*') mineCount++;
						}
						if (k - 1 >= 0 && j - 1 >= 0) {
							if (field.get(j - 1).charAt(k - 1) == '*') mineCount++;
						}
						StringBuilder sb = new StringBuilder(field.get(j));
						sb.setCharAt(k, Integer.toString(mineCount).charAt(0));
						field.set(j, sb.toString());
					}
					mineCount = 0;
				}	
			}
			
			System.out.println("Field #" + fieldCount + ":");
			
			for (int l = 0; l < n; l++) {
				System.out.println(field.get(l));
			}
			
			field.clear();
			fieldCount++;
		}
		
		s.close();
		
	}

}
