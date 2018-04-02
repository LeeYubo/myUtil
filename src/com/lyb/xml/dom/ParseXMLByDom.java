package com.lyb.xml.dom;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseXMLByDom {
	
	/**
	 * @param args
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws SAXException 
	 */
	public static void parseXML() throws ParserConfigurationException, IOException, SAXException {
		
		//获得DOM解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		//从DOM解析器工厂中获取DOM解析器
		DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
		//解析一个XML文档
		Document document = documentBuilder.parse("src/config/system.xml");
		
		//获得文档的根元素节点
		Element elementRoot = document.getDocumentElement();
		System.out.println("root element = "+elementRoot.getNodeName());
		
		
		//获取所有的“server节点”，返回一个类似于List的节点List（NodeList）
		NodeList nodeListServer = document.getElementsByTagName("server");
		
		NodeList nodeListHostname = document.getElementsByTagName("hostname");
		Element elementHostName = (Element)nodeListHostname.item(0);
		System.out.println("test = "+elementHostName.getFirstChild().getNodeValue());
		elementHostName = (Element)nodeListHostname.item(1);
		System.out.println("test = "+elementHostName.getFirstChild().getNodeValue());
		
		for(int i=0;i<nodeListServer.getLength();i++){
			//通过NodeList的item(int)方法，获取list中的第几个节点，返回的是Node类型（有可能是元素，也有可能是属性，也有可能是文本），根据自己的需要进行强转。
			//此时获取的是server元素，可以通过getNodeType()来查看是否为元素。
			Element elementServer = (Element) nodeListServer.item(i);
			//获取server元素的id属性
			
			String propertyID = "";
			String hostnameValue = "";
			String hostipValue = "";
			String usernameValue = "";
			String passwordValue = "";
			
			propertyID = elementServer.getAttribute("id");
			
			System.out.println("id = "+propertyID);
			
			hostnameValue = elementServer.getElementsByTagName("hostname").item(0).getFirstChild().getNodeValue();
			hostipValue = elementServer.getElementsByTagName("hostip").item(0).getFirstChild().getNodeValue();
			usernameValue = elementServer.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
			passwordValue = elementServer.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();
			
			System.out.println("hostnameValue = "+hostnameValue);
			System.out.println("hostipValue = "+hostipValue);
			System.out.println("usernameValue = "+usernameValue);
			System.out.println("passwordValue = "+passwordValue);
			
			NodeList nodeListApplication = elementServer.getElementsByTagName("application");
			for(int j=0;j<nodeListApplication.getLength();j++){
				Element elementApp = (Element) nodeListApplication.item(j);
				
				String propertyAppID = "";
				String appname = "";
				String logpath = "";
				String logname = "";
				String stage = "";

				propertyAppID = elementApp.getAttribute("id");
				
				if(elementApp.getElementsByTagName("appname").item(0).getFirstChild().getNodeType() == Node.TEXT_NODE){
					System.out.println("这是文本类型！");
				}
				
				appname = elementApp.getElementsByTagName("appname").item(0).getFirstChild().getNodeValue();
				logpath = elementApp.getElementsByTagName("logpath").item(0).getFirstChild().getNodeValue();
				logname = elementApp.getElementsByTagName("logname").item(0).getFirstChild().getNodeValue();
				stage = elementApp.getElementsByTagName("stage").item(0).getFirstChild().getNodeValue();
				
				System.out.println("propertyAppID = "+propertyAppID);
				System.out.println("appname = "+appname);
				System.out.println("logpath = "+logpath);
				System.out.println("logname = "+logname);
				System.out.println("stage = "+stage);
			}
			
			System.out.println("\n");
		}
		
		String localpath = "";
		NodeList nodeListSystem = document.getElementsByTagName("system");
		Element elementSystem = (Element)nodeListSystem.item(0);
		localpath = elementSystem.getElementsByTagName("localpath").item(0).getFirstChild().getNodeValue();
		System.out.println("localpath = "+localpath);
	}
	
	public static void main(String[] args) {
		try {
			parseXML();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
