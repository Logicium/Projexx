package Objects;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.Vector;
import java.util.concurrent.TimeUnit;


public class FileObject implements Serializable {

	//The file object contains metadata for the file being worked on
	//Including edit date timelines descriptions of expected work,

	private static final long serialVersionUID = 8944407083082974535L;
	public String name = "";
	public String path = "";
	public File javaFile;
	public boolean wasEdited;
	public boolean sizeChange;
	public boolean readable;
	public boolean writable;
	public Vector<String> descriptions = new Vector<String>();
	public Vector<String> keywords = new Vector<String>();
	public Vector<Date> editTimeline  = new Vector<Date>();
	public Vector<Long> sizeTimeline = new Vector<Long>();
	public ProjectObject parentProject;
	
	public FileObject(String name,String path,File fileObject,boolean readable, boolean writable, 
			Vector<Date> editTimeline, Vector<Long> sizeTimeline, ProjectObject parentProject){
		this.name = name;
		this.path = path;
		this.javaFile = fileObject;
		this.readable = readable;
		this.writable = writable;
		this.editTimeline = editTimeline;
		this.sizeTimeline = sizeTimeline;
		this.parentProject = parentProject;
	}
	
	public FileObject(){}

	public void detectChanges() {
		wasEdited = updateEditTimeline();
		sizeChange = updateSizeTimeline();
	}

	public boolean updateSizeTimeline() {
		long currentSize = javaFile.length();
		long lastSize = sizeTimeline.get(sizeTimeline.size()-1);
		if(currentSize == lastSize){
		return false;
		}
		else{
			sizeTimeline.add(currentSize);
			parentProject.sizeChangeCount+=1;
			return true;
		}
	}

	public boolean updateEditTimeline() {
		long lastModified = javaFile.lastModified();
		Date lastModifiedDate = new Date(lastModified);
		Date lastTimelineDate = editTimeline.get(editTimeline.size()-1);
		long difference = getDateDiff(lastModifiedDate,lastTimelineDate,TimeUnit.HOURS);
		if(difference == 0){
			return false;
		}
		else{
			editTimeline.add(new Date());
			parentProject.wasModifiedCount+=1;
			return true;
		}
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}
	
}
