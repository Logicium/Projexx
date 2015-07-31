package Objects;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

import Algorithm.CoreData;


public class ProjectObject implements Serializable{
	
	public static Scanner input = new Scanner(System.in);
	private static final long serialVersionUID = 3247132244256617363L;
	public Vector<CategoryObject> categories = new Vector<CategoryObject>();
	public Vector<FileObject> files = new Vector<FileObject>();
	public Vector<FileObject> bookmarks = new Vector<FileObject>();
	public Vector<String> categoryList = new Vector<String>();
	public Vector<Date> clock = new Vector<Date>();
	public Vector<Date> dueDates = new Vector<Date>();
	public String name;
	public String author;
	public String description;
	public String path;
	public String lastFile;
	public File javaFile;
	
	//DELTA PROJECT VARIABLES:
	public int fileShift=0;
	public int directoryShift=0;
	public int wasModifiedCount; 
	public int sizeChangeCount;
	//*************************//
	
	public int fileCount;
	public static FileObject lastFileObject;
	public static int productivityPoints;
	public static int projectIndex;
	public int directoryCount;
	public Vector<FlagObject> flags = new Vector<FlagObject>();
	public File[] filesArray;
	public Vector<ReportObject> reports = new Vector<ReportObject>();
	public static Date estimatedCompletion;
	
	public ProjectObject(String author, String description,String projectName, Vector<CategoryObject> categories,
			Vector<FileObject> topLevelFiles, Vector<String> categoryList ){
		this.author = author;
		this.description = description;
		this.name = projectName;
		this.categories = categories;
		this.files = topLevelFiles;
		this.categoryList = categoryList;
	}
	
	public ProjectObject(){}
	
	
	public void detectChanges() throws InterruptedException{
		for(int i =0; i<categories.size();i++){
			categories.get(i).detectChanges();
		}
		for(int i =0;i<files.size();i++){
			files.get(i).detectChanges();
		}
		CoreData.print("Project "+name+" has the following changes:");
		CoreData.print("Files with new modification dates: "+wasModifiedCount);
		CoreData.print("Files with new storage size: "+sizeChangeCount);
		compareDirectorySize();
	}
	
	public void compareDirectorySize() throws InterruptedException {
		
		fileShift = updateFileCount() - files.size();
		directoryShift = updateDirectoryCount()- categories.size();
		CoreData.print("File shift is: "+fileShift);
		CoreData.print("Directory shift is: "+directoryShift);
		
	}

	private int updateFileCount() {
		File[] newFileArray = javaFile.listFiles();
		int newFileCount=0;
		for(int i=0;i<newFileArray.length;i++){
			if(newFileArray[i].isFile()){
				newFileCount++;
			}
		}
		return newFileCount;
	}

	private int updateDirectoryCount() {
		File[] newFileArray = javaFile.listFiles();
		int newDirectoryCount=0;
		for(int i=0;i<newFileArray.length;i++){
			if(newFileArray[i].isDirectory()){
				newDirectoryCount++;
			}
		}
		return newDirectoryCount;
	}
	
	public void launchRandomFile() throws InterruptedException, IOException{
		if (directoryCount > 0) {
			CoreData.print("Pick a category and I'll launch a random file in there for you: ");
			String categoryChoice = input.nextLine();
			pickRandomFile(categoryChoice);
		} else {
			CoreData.print("Since we're not using categories in this Project, I'll select a random file for you to edit!");
			//Consider placing a flag here to enable or disable this notification. 
			int randomFile = new Random().nextInt(files.size());
			lastFileObject = files.get(randomFile);
			Launch(files.get(randomFile).path);
			CoreData.print("Happy working " + author + "!!");
		}
	}
	
	public void createNewProject(String path, String name, String author, String description){
		this.path = path;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	
	public void pickRandomFile(String target)throws InterruptedException, IOException {
		
		for (int i = 0; i < categories.size(); i++) {
			if (categories.get(i).name.contains(target)) {
				CoreData.print("Found your topic! I'll pick a random file for you.");
				int randomFile = new Random()
						.nextInt(categories.get(i).files.size());
				Launch(categories.get(i).files.get(randomFile).path);
				CoreData.cd.Projects.get(projectIndex).lastFile = categories
						.get(i).files.get(randomFile).path;
				CoreData.cd.Projects.get(projectIndex).lastFileObject = categories
						.get(i).files.get(randomFile);
				lastFileObject = files.get(randomFile);
				CoreData.print("Happy working " + author + "!!");
				return;
			}
		}
		CoreData.print("I could not find the topic you specified.");
		CoreData.print("Here are the categories you may choose from:");
		printDirectories();
		target = input.nextLine();
		pickRandomFile(target);
	}
	
	public void printDirectories() throws InterruptedException{
		for(int i =0;i<categories.size();i++){
			CoreData.print(categories.get(i).name);
		}
	}

	public static void Launch(String file) throws IOException {
		Desktop.getDesktop().open(new File(file));
	}
	
	public void exploreDirectory(File[] files, int i) throws InterruptedException{
		Vector<CategoryObject> subCategories = new Vector<CategoryObject>();
		Vector<FileObject> categoryFiles = new Vector<FileObject>();
		
		String foundDirectory = files[i].toString();
		File directoryPath = new File(foundDirectory);
		String directoryName = directoryPath.getName();
		File[] directoryFiles = directoryPath.listFiles();
		
		for(int z =0; z<directoryFiles.length;z++){
			if(directoryFiles[z].isDirectory()){
				directoryCount++;
				subCategories.add(new CategoryObject(directoryFiles[z].getName(),directoryFiles[z].toString().replace("\\", "/")));
				exploreDirectory(directoryFiles,z);
			}
			else{
				fileCount++;
				String fileName = directoryFiles[z].getName();
				String filePath = directoryFiles[z].toString().replace("\\", "/");
				Vector<Date> editTimeline = new Vector<Date>();
				Date lastEdit = new Date(directoryFiles[z].lastModified());
				editTimeline.add(lastEdit);
				Vector<Long> sizeTimeline = new Vector<Long>();
				sizeTimeline.add(directoryFiles[z].length());
				categoryFiles.add(new FileObject(fileName,filePath,directoryFiles[z],
						directoryFiles[z].canRead(),directoryFiles[z].canWrite(),editTimeline,sizeTimeline, this));
			}
		}
		categories.add(new CategoryObject(directoryName,foundDirectory.replace("\\", "/"),categoryFiles,subCategories, this));
	}
	
	public void beginExploration(File[] fileArray) throws InterruptedException{
		for(int i = 0;i<fileArray.length;i++){
			if(fileArray[i].isDirectory()){
				directoryCount++;
				categoryList.add(fileArray[i].toString().replace("\\", "/"));
				exploreDirectory(fileArray,i);
			}else{
				fileCount++;
				String fileName = fileArray[i].getName();
				String filePath = fileArray[i].toString().replace("\\", "/");
				Vector<Date> editTimeline = new Vector<Date>();
				Date lastEdit = new Date(fileArray[i].lastModified());
				editTimeline.add(lastEdit);
				Vector<Long> sizeTimeline = new Vector<Long>();
				sizeTimeline.add(fileArray[i].length());
				files.add(new FileObject(fileName,filePath,fileArray[i],fileArray[i].canRead(),fileArray[i].canWrite(),editTimeline,sizeTimeline, this));
			}
		}
	}
	
	
	
}
