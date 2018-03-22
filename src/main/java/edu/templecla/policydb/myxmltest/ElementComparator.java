package edu.templecla.policydb.myxmltest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Class to determine if two DOM elements are isEqual.
 * 
 * @author Paul Wolfgang
 */
public class ElementComparator {
    
    /**
     * Method to determine if two DOM elements are isEqual.
     * Elements are considered isEqual if they have the same
     * name, attributes, and children. However, whitespace between child
     * elements is ignored.
     * @return true if the elements are isEqual.
     */
    public static boolean isEqual(Element e1, Element e2) {
        normalize(e1);
        normalize(e2);
        return e1.isEqualNode(e2);
    }
    
    /**
     * Method to remove empty white-space between child elements.
     * 
     */
    private static void normalize(Element e) {
        e.normalize();
        Node child = e.getFirstChild();
        while (child != null) {
            if (child.getNodeType() == Node.TEXT_NODE) {
                String text = child.getTextContent().trim();
                if (text.isEmpty()) {
                    Node nextChild = child.getNextSibling();
                    e.removeChild(child);
                    child = nextChild;
                } else {
                    child.setTextContent(text);
                    child = child.getNextSibling();
                }
            } else if (child.getNodeType() == Node.ELEMENT_NODE) {
                normalize((Element)child);
                child = child.getNextSibling();
            } else {
                child = child.getNextSibling();
            }
        }
    }
        
    
    

}
