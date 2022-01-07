package com.example.demo.service;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.StringReader;


public class XMLparser {

    //Parses an XML-string, don't know if this is the correct way of doing this yet, but it works?
    public String parseString(String input) throws IOException, SAXException {

        InputSource is = new InputSource(new StringReader(input));
        DOMParser dp = new DOMParser();
        dp.parse(is);
        Document doc = dp.getDocument();
        NodeList nl = doc.getElementsByTagName("name");
        Node n = nl.item(0);
        System.out.println(n.getTextContent());
        //System.out.println(n.toString());
        return n.getTextContent();

    }
}
