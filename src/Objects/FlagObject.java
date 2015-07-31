package Objects;
import java.io.Serializable;


public class FlagObject implements Serializable {

	//FlagObjects are used in the BootUp function to mention useful things before starting the usual tasks. 
	//Most flags are used to launch flag-specific code. This is handled by a separate class. :> 

	private static final long serialVersionUID = 1911302511025140700L;
	
	public String name;
	public String message;
	public double weight;
	public boolean state =  false;
	
	public FlagObject(String name, double weight, boolean state){
		this.name=name;
		this.weight = weight;
		this.state = state;
	}
	
	public FlagObject(){

	}
}
