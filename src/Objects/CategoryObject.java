package Objects;
import java.io.Serializable;
import java.util.Vector;


public class CategoryObject implements Serializable {
	
	private static final long serialVersionUID = 8899348781312758281L;
	public String name;
	public String path;
	public Vector<FileObject> files = new Vector<FileObject>();
	public Vector<CategoryObject> subCategories = new Vector<CategoryObject>();
	public String description;
	public ProjectObject parentProject;
	
	public CategoryObject(String name,String path, Vector<FileObject> files,Vector<CategoryObject> subCategories, ProjectObject parentProject){
		this.name = name;
		this.path = path;
		this.files = files;
		this.subCategories = subCategories;
		this.parentProject = parentProject;
	}
	
	public CategoryObject(String name, String path){
		this.name = name;
		this.path = path;
	}
	
	public CategoryObject(){
		
	}

	public void detectChanges() {
		for(int i=0;i<subCategories.size();i++){
			subCategories.get(i).detectChanges();	
		}
		for(int i = 0;i<files.size();i++){
			files.get(i).detectChanges();
		}		
		
	}

}
