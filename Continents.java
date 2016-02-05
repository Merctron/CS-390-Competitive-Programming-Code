import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Continents {

	public static void main (String [] args) throws IOException {
		Scanner s = new Scanner(System.in);
		
		while (true) {
			if (!s.hasNextInt()) {
				break;
			}
			
			int M = s.nextInt();
			int N = s.nextInt();
			s.nextLine();
		
			char[][] map = new char[M][N];
			
			for (int i = 0; i < M; i++) {
				map[i] = s.nextLine().toCharArray();	
			}
			
			int X = s.nextInt();
			int Y = s.nextInt();
			
			char ld = map[X][Y];
			
			ArrayList<pair> toExclude = new ArrayList<pair>();
			traverseToExclude(map, toExclude, new pair(X, Y), ld);
			
			int cities = 0;
			
			for (int p = 0; p < M; p++) {
				for (int q = 0; q < N; q++) {
					if (map[p][q] == ld) {
						int nc = traverseToCount(map, toExclude, new pair(p, q), ld);
						if (nc > cities) {
							cities = nc;
						}
					}
				}
			}
			
			System.out.println(cities);
			
		}
		
		s.close();
	}
	
	static void traverseToExclude(char[][] map, ArrayList<pair> tracker, pair start, char ld) {
		map[start.ap][start.bp] = ' ';
		if (map[start.ap + 1][start.bp] == ld) {
			traverseToExclude(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap - 1][start.bp] == ld) {
			traverseToExclude(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap][start.bp + 1] == ld) {
			traverseToExclude(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap][start.bp - 1] == ld) {
			traverseToExclude(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
	}
	
	static int traverseToCount(char[][] map, ArrayList<pair> tracker, pair start, char ld) {
		int toReturn  = 1;
		if (map[start.ap + 1][start.bp] == ld) {
			toReturn += traverseToCount(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap - 1][start.bp] == ld) {
			toReturn += traverseToCount(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap][start.bp + 1] == ld) {
			toReturn += traverseToCount(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		if (map[start.ap][start.bp - 1] == ld) {
			toReturn += traverseToCount(map, tracker, new pair(start.ap + 1, start.bp), ld);
		}
		return toReturn;
	}
	
	static class pair {
		
		int ap;
		int bp;
		
		public pair(int a, int b) {
			this.ap = a;
			this.bp = b;
		}
		
	}
}
