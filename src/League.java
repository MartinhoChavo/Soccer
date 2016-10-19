import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class League extends Extractor {
	private int id;
	private String name;
	private int total_rounds;
	private int current_round;
	
	public League(int id, String name, int total_rounds, int current_round) {
		super();
		this.id = id;
		this.name = name;
		this.total_rounds = total_rounds;
		this.current_round = current_round;
	}
	
	public League() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotal_rounds() {
		return total_rounds;
	}
	public void setTotal_rounds(int total_rounds) {
		this.total_rounds = total_rounds;
	}
	public int getCurrent_round() {
		return current_round;
	}
	public void setCurrent_round(int current_round) {
		this.current_round = current_round;
	}

	@Override
	public ArrayList<League> extract(String xml) {
		// TODO Auto-generated method stub
		return null;
		
	}
	private ArrayList<League> extractLeagues(String xml) {
	ArrayList<League> list = new ArrayList<League>();
	try {

		XPath xpath = XPathFactory.newInstance().newXPath();
		String expression = "/leagues/league/name/text()";
		InputSource is = new InputSource(new StringReader(xml));
		NodeList listNames = (NodeList) xpath.evaluate(expression, is, XPathConstants.NODESET);
		
		
		for(int i=0;i<listNames.getLength();i++){
			Node n = listNames.item(i);
			String value = n.getNodeValue();
			System.out.println(value);
			League l = new League();
			l.setName(value);
			list.add(l);
		}
		
	} catch (XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
	
}

	@Override
	public String toString(){
		return null ;
		
	}
	
}
