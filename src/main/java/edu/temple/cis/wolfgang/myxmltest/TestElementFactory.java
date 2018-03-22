package edu.temple.cis.wolfgang.myxmltest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class to generate DOM element objects for testing.
 * @author Paul Wolfgang
 */
public class TestElementFactory {
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder;
    
    public TestElementFactory() {
        try {
            builder = factory.newDocumentBuilder();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public Element newElement(String text) throws Exception {
        InputStream ss = new ByteArrayInputStream(text.getBytes());
        Document d = builder.parse(ss);
        return d.getDocumentElement();
    }

    public Document newDocument(String text) throws Exception {
        InputStream ss = new ByteArrayInputStream(text.getBytes());
        Document d = builder.parse(ss);
        return d;
    }
}
