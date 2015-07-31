package Algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Objects.ProjectObject;
import Utilities.ChooseFile;
import Utilities.SaveProjecti;


public class Salutations {

	public static Scanner input = new Scanner(System.in);
	public static ProjectObject project = new ProjectObject();

	public static void Greetings() throws InterruptedException, IOException {

		CoreData.print("Hello! I’ve never seen you before! My name is Projecti. I’ll be your personal project assistant!");
		
		//print("If we’re going to get started on this journey together, I have to know a bit about you first.");
		
		CoreData.print("What’s your name stranger?\n");
		project.author = input.nextLine();
		
		CoreData.print("Alright! I'm really excited to start working with you "+ project.author + "!");
		CoreData.print("So let’s get your first project started. Select the folder address:\n");
		
		project.path = (new ChooseFile().getFile().getAbsolutePath().replace("\\", "/"));
		project.javaFile = new File(project.path);
		project.name = project.javaFile.getName();
		CoreData.print("Is the name of your project: " + project.name + "?\n");

		String response = input.nextLine();

		if (response.contains("ye")) {
			CoreData.print("Awesome! Let's get started on Project "
					+ project.name + "!");
		} else {
			CoreData.print("Enter your prefered Project name: \n");
			project.name = input.nextLine();
			CoreData.print("Project " + project.name + " begins!");
		}
		project.filesArray = project.javaFile.listFiles();

		project.beginExploration(project.filesArray);

		CoreData.print("I’ve detected " + project.directoryCount+ " folder directories. ");
		
		if (project.directoryCount > 0) {
			CoreData.print("I will organize your project by the folder categories.");
		} else {
			CoreData.print("So, I'll skip organizing this project by folder categories.");
		}
		CoreData.print("I’ve found " + project.fileCount + " project files. ");
		
		
		if (project.fileCount > 0) {
			CoreData.print("I will launch these for you when you’re ready.");
		} else {
			CoreData.print("Um...I didn't find any files in my search so...Give me a different project directory:");
			project.path = input.nextLine().replace("\\", "/");
			while (project.fileCount == 0) {
				project.javaFile = new File(project.path);
				project.filesArray = project.javaFile.listFiles();
				project.beginExploration(project.filesArray);
				if (project.fileCount == 0) {
					CoreData.print("Wow. Another defective folder directory. Try again.");
					project.path = input.nextLine().replace("\\", "/");
				} else {
					CoreData.print("Success! Let's move on.");
				}
			}
		}

		CoreData.print("Lastly, give me a short description of your project. I'll be helping you with research later on.\n");
		project.description = input.nextLine();
		
		CoreData.cd.Projects.add(project);
		
		
		CoreData.print("From now on, I'll be popping in to get you started with your files.");
		
		CoreData.print("So let's launch our first file... ");
		
		project.launchRandomFile();
		
		SaveProjecti.newSave();
		
		//Exit to command line
	}


}
