package componentes.xmlParser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class xmlParse {
	
	private File Xmlfile;
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	NodeList nl;
	
	public xmlParse(String URL, String preset){
		try{	
			
			Xmlfile = new File(URL);
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(Xmlfile);
			doc.getDocumentElement().normalize();
			nl = doc.getElementsByTagName(preset);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String $ (String elmt){
		
		Node nNode = nl.item(0);
		String x = null;
		
		if (nNode.getNodeType() == Node.ELEMENT_NODE){
			
			Element eElement = (Element) nNode;
			
			x = eElement.getElementsByTagName(elmt).item(0).getTextContent();
			
		}
		
		return x;
	}
	
}
