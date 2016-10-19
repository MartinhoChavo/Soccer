import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public abstract class Extractor {
	
	
	public Extractor(){
		


}
	
public abstract ArrayList<? extends Extractor > extract(String xml);


	

	
public static String readUrl(String urlRoute) {
	BufferedReader in = null;
	URL url = null;
	String inputLine;
	String inputText = "";
	try {
		url = new URL(urlRoute);
		in = new BufferedReader(new InputStreamReader(url.openStream(),"UTF8"));
		while ((inputLine = in.readLine()) != null) {
			inputText = inputText + inputLine;
		}
	} catch (IOException e) {

	} finally {
		try {
			if (in != null)
				in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return inputText;
	
}
}