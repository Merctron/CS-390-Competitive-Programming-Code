import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class CancerOrScorpio {
	
	public static void main (String [] args) throws IOException {
        
		Scanner s = new Scanner(System.in);
		int numData = s.nextInt();
		int m, d, y, count;
		String line = "";
		
		ArrayList<sign> signs = new ArrayList<sign>();
		signs.add(new sign("aquarius", 21, 1, 19, 2));
		signs.add(new sign("pisces", 20, 2, 20, 3));
		signs.add(new sign("aries", 21, 3, 20, 4));
		signs.add(new sign("taurus", 21, 4, 21, 5));
		signs.add(new sign("gemini", 22, 5, 21, 6));
		signs.add(new sign("cancer", 22, 6, 22, 7));
		signs.add(new sign("leo", 23, 7, 21, 8));
		signs.add(new sign("virgo", 22, 8, 23, 9));
		signs.add(new sign("libra", 24, 9, 23, 10));
		signs.add(new sign("scorpio", 24, 10, 22, 11));
		signs.add(new sign("sagittarius", 23, 11, 22, 12));
		signs.add(new sign("capricorn", 23, 12, 20, 1));
		
		String month;
		Date curr;
		
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/");
		
		s.nextLine();
		count = 1;
		
		for (int i = 0; i < numData; i++) {
			line = s.nextLine();
			
			m = Integer.parseInt(line.substring(0, 2));
			d = Integer.parseInt(line.substring(2, 4));
			y = Integer.parseInt(line.substring(4, 8));
			
			//System.out.println(line + " " + m + "/" + d + "/" + y);
			
			curr = new Date();
			curr.setDate(d);
			curr.setMonth(m - 1);
			curr.setYear(y);
			
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(curr);
		    calendar.add(Calendar.DATE, 40*7);
		    curr.setTime(calendar.getTime().getTime());
		    
		    d = curr.getDate();
		    m = curr.getMonth() + 1;
		    y = curr.getYear();
		    
		    //System.out.println(line + " " + m + "/" + d + "/" + y);
			

			for (int j = 0; j < signs.size(); j++) {
				sign cs = signs.get(j);
				if ((cs.ssd <= d && cs.ssm == m) || (cs.sed >= d && cs.sem == m)) {
					System.out.println(count + " " + df.format(curr) + y + " " + cs.sname);
					break;
				}
			}
			count++;
		}
		
		s.close();
    }
	
	static class sign {		
		String sname;
		int ssd, ssm, sed, sem;

		public sign (String name, int sd, int sm, int ed, int em) {
			this.sname = name;
			this.ssd = sd;
			this.ssm = sm;
			this.sed = ed;
			this.sem = em;
		}
	}

}
