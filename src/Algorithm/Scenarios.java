package Algorithm;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Objects.FlagObject;
import Objects.ProjectObject;
import Utilities.WebSearch;


public class Scenarios {
	public static Scanner input = new Scanner(System.in);
	
	public static void SecondEncounter(ProjectObject Project) throws InterruptedException{
		String author = Project.author;
		String lastFileName = Project.lastFileObject.name;
		long previousFileSize = Project.lastFileObject.sizeTimeline.get(CoreData.synchronize);
		CoreData.print("...I'm giving you a moment to edit....");
		long previousSpeed = CoreData.printSpeed;
		CoreData.printSpeed = 1000;
		CoreData.print("                                       ");
		CoreData.printSpeed = previousSpeed;
		CoreData.print("Hi "+author+", remember me? I'm back again to check on your progress! c: ");
		CoreData.print("I remember last time you were working on file: "+Project.lastFileObject.name);
		CoreData.print("When we first worked on it, it was "+previousFileSize+" bytes long.");
		long currentFileSize = Project.lastFileObject.javaFile.length();
		CoreData.print("And as of now it's "+currentFileSize+" bytes long.");
		if(currentFileSize == previousFileSize){
			CoreData.print("Wow. Looks like the file didn't change at all. :/");
		}
		else if(currentFileSize > previousFileSize){
			CoreData.print("Well, well! Looks who's the firecracker now! You've just earned 15 Productvity Points!");
		}
		else{
			CoreData.print("Oh dear me...It looks like the file has shrunk since you've been on it. Are you feeling ill?");
		}
		CoreData.print("I'll be keeping an eye on your progress. See you on the other side "+author+"!");
	}
	
	public static void GoodTime(ProjectObject Project) throws InterruptedException, URISyntaxException, IOException{
		//Possible precondition if other files are 'idle'
		String author = Project.author;
		CoreData.print("So, ah, "+author+" is this a good time to pop in for a moment?");
		String response = input.nextLine();
		if(response.contains("yes")){
			CoreData.print("Wonderful! Are you ready to be productive on your project today?");
			String newResponse = input.nextLine();
			if(newResponse.contains("yes")){
				CoreData.print("Brilliant. Shall I make the selection or shall you?");
				CoreData.print("Note, you can pick up where you left off with the 'last file(s)' command:");
				String fileSelection = input.nextLine();
				if(fileSelection.contains("last file")){
					CoreData.print("");
				}
				else if(fileSelection.contains("you")){
					CoreData.print("");
				}
				else{
					CoreData.print("");
				}
			}
			else{
				CoreData.print("Oh dear. Well, luckily I was thinking about you and found some cool articles "+
				"to get you inspired. Check it out!");
				WebSearch.testWebSearch(Project.description);
				CoreData.print("But wait...Before I open those, will you promise to be more productive next time?");
				String nextResponse = input.nextLine();
				if(nextResponse.matches("yes")){ 
					CoreData.print("Excellent! I've saved your promise into my memory with high priority.");
					Project.flags.add(new FlagObject("Promise Productivity",3.0,true));
					CoreData.print("Now I can see if you're true to your word. ;)");
				}
				else{//No, I won't be more productive next time.
					CoreData.print("You'll have to start making commitments eventually.");
					CoreData.print("Before you run off, tell me why you're not feeling so hot today?");
					String excuse = input.nextLine();
					CoreData.print("Thanks! I'll be checking to see if you use the same excuses. Goodbye!");
					Project.flags.add(new FlagObject("Concern Trolling",2.0,true));
				}
			}
		}
		else{//No, this is not a good time.
			CoreData.print("Oh my goodness! I'm so sorry! I'll definitely come back later.");
			CoreData.print("Remember you can fine tune my pop-up times in the system settings.");
			CoreData.print("I shall make a note to open those for you when I return.");
			Project.flags.add(new FlagObject("Show Timer Settings",2.0,true));
			//SaveProjecti.newSave(CoreData.cd);
		}
	}
	
	
}
