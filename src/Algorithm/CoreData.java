package Algorithm;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import Objects.ProjectObject;


public class CoreData implements Serializable{

	private static final long serialVersionUID = 1388401397070232365L;
	public static Date currentMoment;
	public static Date lastSaveTime;
	public Vector<ProjectObject> Projects = new Vector<ProjectObject>();
	public static Vector<String> projectNames = new Vector<String>();
	public static Vector<String> projectPaths = new Vector<String>();
	public static int synchronize=0;
	public static String lastProjectDirectory = "";
	public static int lastFileSize;
	public static String saveLocation="";
	public static CoreData cd = new CoreData();
	public static long printSpeed=20;
	
	
	public CoreData(){
		
	}

	public void Update() throws InterruptedException {
		for(int i=0;i<Projects.size();i++){
			Projects.get(i).detectChanges();
		}
	}
	
	public static void print(String data) throws InterruptedException {
		String newLine = "\n";
		newLine = newLine.concat(data);
		data = newLine;
		TimeUnit unit = TimeUnit.MILLISECONDS;
		long delay = CoreData.printSpeed;
		for (char ch : data.toCharArray()) {
			System.out.print(ch);
			unit.sleep(delay);
		}
	}
	
}
