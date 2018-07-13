import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParserContactList {
	private String currentElement;
	private int contactCount = 1;
	static private StringBuffer buf = new StringBuffer();

	public SAXParserContactList() {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			System.out.println("********** xml -> text **********");
			saxParser.parse(new File("contactList.xml"), new MyHandler());		//contactList.xml 을 parse 해서 Myhandler로 처리
			System.out.println("\n********** xml -> html **********");
			saxParser.parse(new File("contactList.xml"), new HtmlHandler());	//conttactList.xml 을 parse 해서 HtmlHandler로 처리
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	class MyHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			// TODO Auto-generated method stub
			currentElement = qName;		
			if (currentElement.equals("contact")) {
				System.out.println("Contact" + contactCount);
				contactCount++;
				
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			// TODO Auto-generated method stub
			currentElement = "";
		}
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			// TODO Auto-generated method stub

			if (currentElement.equals("name")) {
				System.out.println("\tNAME \t:" + new String(ch, start, length));
			} 
			else if (currentElement.equals("address")) {
				System.out.println("\tADDRESS :" + new String(ch, start, length));
			} 
			else if (currentElement.equals("tel")){
				System.out.println("\tTEL \t:" + new String(ch, start, length));
			}
			else if (currentElement.equals("email")) {
				System.out.println("\tEMAIL \t:" + new String(ch, start, length));
			}
			
		}
	}

}
