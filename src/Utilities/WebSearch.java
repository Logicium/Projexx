package Utilities;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import de.tudarmstadt.ke.jfreewebsearch.farooObjects.FarooResult;
import de.tudarmstadt.ke.jfreewebsearch.farooObjects.FarooResultSet;

public class WebSearch {

	public static void testWebSearch(String query) throws URISyntaxException, IOException {

		String key = "PpesCkJAyBma3oH@vowUxwFCySs_"; //Keep this Key SAFE, and don't query more than ONE per SECOND. 
		FarooQueryPoint FQP = new FarooQueryPoint(key);
		FarooResultSet FRS = FQP.query(query);
		System.out.println("I've searched Faroo for "+query+" and found "+FRS.getNrOfResults()+" results!");
		List<FarooResult> fr = FRS.getResults();
		for(int i = 0;i<3;i++){
			System.out.println("Title of result "+i+ " is "+fr.get(i).getTitle());
			System.out.println("Author of result "+i+ " is "+fr.get(i).getAuthor());
			System.out.println("Is the result news: "+fr.get(i).isNews());
			System.out.println("URL of result "+i+ " is "+fr.get(i).getUrl());
			System.out.println("Launching URL...");
			LaunchURL(fr.get(i).getUrl());
			System.out.println("\n");
		}
		System.out.println("YAY! It works!");	
	}
	public static void LaunchURL(String URL) throws URISyntaxException, IOException {
		Desktop d = Desktop.getDesktop();
		d.browse(new URI(URL));
	}

}
