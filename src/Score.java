import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Score extends Extractor{

	private String localName;
	private String visitorName;
	private int localGoals;
	private int visitorsGoals;

	public Score(String localName, String visitorName, int localGoals, int visitorsGoals) {
		super();
		this.localName = localName;
		this.visitorName = visitorName;
		this.localGoals = localGoals;
		this.visitorsGoals = visitorsGoals;
	}

	public Score() {

	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public int getLocalGoals() {
		return localGoals;
	}

	public void setLocalGoals(int localGoals) {
		this.localGoals = localGoals;
	}

	public int getVisitorsGoals() {
		return visitorsGoals;
	}

	public void setVisitorsGoals(int visitorsGoals) {
		this.visitorsGoals = visitorsGoals;
	}

	@Override
	public ArrayList<Score> extract(String xml) {
		// TODO Auto-generated method stub
		return null;
		
	}
	private ArrayList<Score> extractScore(String xml){
		ArrayList<Score> list2 = new ArrayList<Score>();
		try{
			XPath xpath=XPathFactory.newInstance().newXPath();
			String expressionLocal="/matchs/match/local/text()";
			InputSource isLocal = new InputSource(new StringReader(xml));
			NodeList listLocal = (NodeList) xpath.evaluate(expressionLocal, isLocal, XPathConstants.NODESET);
			
			String expressionVisitor="/matchs/match/visitor/text()";
			InputSource isVisitor = new InputSource(new StringReader(xml));
			NodeList listVisitor = (NodeList) xpath.evaluate(expressionVisitor, isVisitor, XPathConstants.NODESET);
			
			String expressionGoalsLocal="/matchs/local/visitor/local_goals/text()";
			InputSource isGoalsLocal = new InputSource(new StringReader(xml));
			NodeList listScoreLocal = (NodeList) xpath.evaluate(expressionGoalsLocal, isGoalsLocal, XPathConstants.NODESET);
			
			String expressionGoalsVisitor="/matchs/local/visitor/visitor_goals/text()";
			InputSource isGoalsVisitor = new InputSource(new StringReader(xml));
			NodeList listScoreVisitor = (NodeList) xpath.evaluate(expressionGoalsVisitor, isGoalsVisitor, XPathConstants.NODESET);
			
			for(int i=0;i<listLocal.getLength();i++){
				Node lo = listLocal.item(i);
				String value = lo.getNodeValue();
				System.out.println(value);
				Score s = new Score();
				s.setLocalName(value);
				
				
				Node v=listVisitor.item(i);
				String value2 =v.getNodeValue();
				System.out.println(value2);
				
				s.setVisitorName(value2);
				
				
				Node gl=listScoreLocal.item(i);
				String value3 =gl.getNodeValue();
				System.out.println(value);
				
				
                  if(value3.equals("x")){
                	  s.setVisitorsGoals(-1);
                  }else{s.setVisitorsGoals(Integer.parseInt(value3));
                  
                  }

				Node gv=listScoreVisitor.item(i);
				String value4 =gv.getNodeValue();
				System.out.println(value);
				if(value4.equals("x")){
              	  s.setVisitorsGoals(-1);
                }else{s.setVisitorsGoals(Integer.parseInt(value4));
                
                }
			

				list2.add(s);
				
			
			
		}
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list2;

}

	}
