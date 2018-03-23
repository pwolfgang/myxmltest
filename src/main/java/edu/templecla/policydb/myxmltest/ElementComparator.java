/* 
 * Copyright (c) 2018, Temple University
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * * All advertising materials features or use of this software must display 
 *   the following  acknowledgement
 *   This product includes software developed by Temple University
 * * Neither the name of the copyright holder nor the names of its 
 *   contributors may be used to endorse or promote products derived 
 *   from this software without specific prior written permission. 
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
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
