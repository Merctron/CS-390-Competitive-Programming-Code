import java.io.IOException;
import java.util.Scanner;


public class MotherBear {
	
	public static void main (String [] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		String sen = "";
		String ssen = "";
		boolean p = false;
		
		while (true) {
			sen = s.nextLine();
			if (sen.equals("DONE")) {
				break;
			}
			String words = sen.replaceAll("\\W", "").toLowerCase();
			for (int i = 0; i < words.length()/2; i++) {
				if (words.charAt(i) != words.charAt(words.length() - 1 - i)) {
					System.out.println("Uh oh..");
					p = true;
					break;
				}
			}
			
			if (!p) {
				System.out.println("You won't be eaten!");
			}
			p = false;
		}
		
		s.close();
		
	}

}
