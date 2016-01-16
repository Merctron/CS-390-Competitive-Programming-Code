import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static BufferedReader cin;
    static StringTokenizer tk;
    public static String token () throws IOException {
        try {
            while (!tk.hasMoreTokens())
                tk = new StringTokenizer(cin.readLine());
            return tk.nextToken();
        }
        catch (Exception e) {
        }
        return null;
    }
    public static int gInt () throws IOException {
        return Integer.parseInt(token());
    }
    public static long gLong () throws IOException {
        return Long.parseLong(token());
    }
    public static double gDouble () throws IOException {
        return Double.parseDouble(token());
    }
    public static void init () {
        cin = new BufferedReader(new InputStreamReader(System.in));
        tk = new StringTokenizer("");
    }
    public static void quit () throws IOException {
        System.out.flush();
        System.exit(0);
    }
    /*
     * H - Height of Well
     * U - Distance travelled
     * D - slide down
     * F - Fatigue %
     * 
     * 
     * */
    
    public static boolean solve(String inp) {
    	String[] strArray = inp.split(" ");
    	int[] intArray = new int[strArray.length];
    	for(int i = 0; i < strArray.length; i++) {
    	    intArray[i] = Integer.parseInt(strArray[i]);
    	}
    	
    	int H = intArray[0];
    	
    	if (H == 0) {
    		return false;
    	}
    	
    	double HP = H;
    	double CP = 0;
    	double U = intArray[1];
    	double D = intArray[2];
    	double F = intArray[3];
    	
    	double FD = (U*F)/100;
    	//FD = (double)Math.round(FD * 100000d) / 100000d;
    	
    	int counter = 0;
    	
    	while (HP >= 0) {
    		HP = HP - U;
    		//HP = (double)Math.round(HP * 100000d) / 100000d;
    		if (HP >= 0) {
    			HP = HP + D;
    			//HP = (double)Math.round(HP * 100000d) / 100000d;
    		}
    		CP = CP + U - D;
    		//CP = (double)Math.round(CP * 100000d) / 100000d;
    		//System.out.println(HP + " , " + CP + " , " + U);
    		U = U - FD;
            if (U < 0) {
                U = 0;
            }
    		//U = (double)Math.round(U * 100000d) / 100000d;
    		counter++;
    		
    		if (CP < 0) {
    			System.out.println("failure on day " + counter);
    			return true;
    		}
    	}
    	
    	System.out.println("success on day " + counter);
    	
    	
    	return true;
    }
    
    public static void main (String [] args) throws IOException {
        init();
        boolean stop = false;
        String input;
        while (!stop) {
        	input = cin.readLine();
        	if (!solve(input)) {
        		break;
        	}
        }
       
        quit();
    }

}
