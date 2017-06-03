import java.io.*;
import java.util.*;

public class FlashcardMaker{
	public FlashcardMaker() throws IOException{
		
		FileWriter fw = new FileWriter("E:\\AP CS\\Programs and Labs 2016-17\\FlashcardsExperimental2\\data.txt");
		PrintWriter output = new PrintWriter(fw);
		Scanner kbReader = new Scanner(System.in);
		kbReader.useDelimiter("\n");
		boolean carryOn = true;
		int i = 1;
		while(carryOn){
		    System.out.println("Card " + i + " : ");
		    i++;
			String l = kbReader.next();
			String l2 = kbReader.next();
			String l3 = "stop";
			output.printf("%s\t%s\t", l,l2);
			if(l.equals(l2)){
				carryOn=false;
			}
		}
		output.close();
		fw.close();
		
		

	}
}
	
