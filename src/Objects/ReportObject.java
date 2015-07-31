package Objects;

public class ReportObject {

	public String origin;
	public String name;
	public int reportValue;
	public String message;
	
	public ReportObject(String name, String origin, int reportValue, String message){
		this.origin = origin;
		this.name = name;
		this.reportValue = reportValue;
		this.message = message;
	}
	
}
