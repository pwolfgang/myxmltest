package edu.templecla.policydb.myxmltest;

import java.io.Reader;
import java.io.StringReader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import org.w3c.dom.Document;

/**
 * Class to generate Stax XMLEventReader for objects for testing.
 * @author Paul Wolfgang
 */
public class StaxElementFactory {
    private XMLInputFactory factory = XMLInputFactory.newInstance();
    
    public StaxElementFactory() {
    }
    
    public XMLEventReader newElement(String text) throws Exception {
        Reader ss = new StringReader(text);
        XMLEventReader r = factory.createXMLEventReader(ss);
        while (!r.peek().isStartElement()) r.next();
        return r;
    }

}
