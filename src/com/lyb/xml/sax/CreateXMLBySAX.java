package com.lyb.xml.sax;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

/**
 * 
 * <1>创建保存xml的结果流对象StreamResult；

   <2>然后利用SAXTransformerFactory这个工厂创建TransformerHandler这个操作者；

   <3>操作这个TransformerHandler获取Transformer，利用Transformer创建节点信息；
   
 * */
public class CreateXMLBySAX {

	public void createXML() throws TransformerConfigurationException, SAXException{
		try {
			//创建保存xml的结果流对象
			Result StreamResult = new StreamResult(new FileOutputStream("persons.xml"));
			
			//获取sax生产工厂对象实例
			SAXTransformerFactory transformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();

			TransformerHandler transformerHandler = transformerFactory.newTransformerHandler();
			
			transformerHandler.setResult(StreamResult);
			//获取sax生产器
			Transformer transformer = transformerHandler.getTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING,"utf-8");//换行
			transformer.setOutputProperty(OutputKeys.INDENT,"yes");//换行
			
			transformerHandler.startDocument();
			
			AttributesImpl attributes = new AttributesImpl();
			
			attributes.addAttribute("", "id", "id", "String", "123");
			
			transformerHandler.startElement("", "", "users", attributes);
			String value = "";
			transformerHandler.characters(value.toCharArray(), 0, value.length());
			
			transformerHandler.endElement("", "", "users");
			
			transformerHandler.endDocument();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		CreateXMLBySAX createXML = new CreateXMLBySAX();
		try {
			createXML.createXML();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
