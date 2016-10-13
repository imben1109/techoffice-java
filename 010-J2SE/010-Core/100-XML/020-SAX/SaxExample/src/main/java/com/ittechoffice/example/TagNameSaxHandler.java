package com.ittechoffice.example;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TagNameSaxHandler extends DefaultHandler {

    List<String> tagNameList;

    public TagNameSaxHandler() {
        tagNameList = new ArrayList<String> ();
    }

    public void startDocument() throws SAXException {

    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        tagNameList.add(localName);
    }

    public void characters(char ch[], int start, int length) {

    }

    public void endDocument() throws SAXException {

    }

    public List<String> getTagNameList() {
        return tagNameList;
    }


}	