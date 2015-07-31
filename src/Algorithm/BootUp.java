package Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import Utilities.SerializationUtil;


public class BootUp {
	
	public static void retriveData() throws ClassNotFoundException, InterruptedException, IOException{
		
		try {
			CoreData.cd = (CoreData) SerializationUtil.deserialize("CoreData.ser");		
			CoreData.print("Deserialization successful.");
			CoreData.cd.Update();
		} catch (IOException e) {
			Salutations.Greetings();
		}
	}
	
	public static void testDeserializedData() throws InterruptedException{
		for(int i =0;i<CoreData.cd.Projects.size();i++){
			CoreData.print(CoreData.cd.Projects.get(i).name);
			CoreData.print(CoreData.cd.Projects.get(i).author);
			CoreData.print(CoreData.cd.Projects.get(i).description);			
			CoreData.print(CoreData.cd.Projects.get(i).path);
			CoreData.print("File Names:");
			for(int z = 0;z<CoreData.cd.Projects.get(i).files.size();z++){
				CoreData.print(CoreData.cd.Projects.get(i).files.get(z).name);
			}
			CoreData.print("Category Names:");
			for(int z = 0;z<CoreData.cd.Projects.get(i).categories.size();z++){
				CoreData.print(CoreData.cd.Projects.get(i).categories.get(z).name);
			}
		}			
	}
}
