package Utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import Algorithm.CoreData;

public class SaveProjecti {

	public static Scanner input = new Scanner(System.in);

	public static void newSave() throws IOException, InterruptedException{
		CoreData cd = CoreData.cd;
		SerializationUtil.serialize(cd, "CoreData.ser");
		print("Serializaton complete!");
	}
	
	public static void print(String data) throws InterruptedException {
		String newLine = "\n";
		newLine = newLine.concat(data); 
		data = newLine;
		TimeUnit unit = TimeUnit.MILLISECONDS; long delay = 40;
	    for (char ch:data.toCharArray()) {
	        System.out.print(ch);
	        unit.sleep(delay);
	    }
	}

}
