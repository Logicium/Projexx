package Algorithm;

import java.util.Vector;


public class Projecti {

	public static void main(String[] args) throws Throwable {
		
		BootUp.retriveData();
		Scenarios.SecondEncounter((CoreData.cd.Projects.get(CoreData.synchronize)));
		Scenarios.GoodTime((CoreData.cd.Projects.get(CoreData.synchronize)));
		
	}
	
}
