package com.lyb.xml.dom;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreateXMLByDom {

	public void generateXML() throws ParserConfigurationException, TransformerException{
		//1、先获得DocumentBuilderFactory
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		Element element1 = document.createElement("Persons");
		
		for(int i=0;i<5;i++){
			Element element2 = document.createElement("Person");
			Element element3_name = document.createElement("name");
			Element element3_age = document.createElement("age");
			Element element3_sex = document.createElement("sex");
			
			element2.setAttribute("id", (i+1)+"");
			element3_name.setTextContent("liyubo");
			element3_age.setTextContent("20");
			element3_sex.setTextContent("male");
			
			element2.appendChild(element3_name);
			element2.appendChild(element3_age);
			element2.appendChild(element3_sex);
			
			element1.appendChild(element2);
		}
		document.appendChild(element1);
		TransformerFactory transFormerFactory = TransformerFactory.newInstance();
		
		Transformer transformer = transFormerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		
		Source xmlSource = new DOMSource(document);
		
		Result outputTarget = new StreamResult(new File("xml/persons.xml"));
		transformer.transform(xmlSource, outputTarget);
	}
	
	public static void main(String[] args) {
		CreateXMLByDom domOperXML = new CreateXMLByDom();
		try {
			domOperXML.generateXML();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}
