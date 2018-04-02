package com.lyb.xml.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Attribute;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * <p>标题: 解析XML文件</p>
 * <p>描述: </p>
 * <p>公司: www.tydic.com</p>
 * @autho Yubo Lee
 * @time 2016-5-27 下午10:47:17
*/
public class ParseXMLByDom4j {

	
	@SuppressWarnings("unchecked")
	public void parseXML() throws DocumentException{
		SAXReader saxReader = new SAXReader();
		Document documnet = saxReader.read(new File("src/config/system.xml"));
		//将字符串转换为xml，整个的取出来
		System.out.println(documnet.asXML());
		Element root = documnet.getRootElement();
		
		System.out.println("根节点：" + root.getName());
		
		Element root_servers = root.element("servers");
		Iterator<Element> iteratorServer = root_servers.elementIterator("server");
		while(iteratorServer.hasNext()){
			Element elemebtServer = (Element)iteratorServer.next();
			Attribute attr_Server = elemebtServer.attribute("id");
			
			System.out.println(attr_Server.getText());
			
			Iterator<Element> iteratorChild = elemebtServer.elementIterator();
			while(iteratorChild.hasNext()){
				Element elemebtChild = (Element)iteratorChild.next();
				
				System.out.println("elemebtChild = "+elemebtChild.getName());
				
				String name = elemebtChild.getName();
				String text = elemebtChild.getText();
				if("hostname".equals(name)){
					System.out.println("    hostname = "+text);
				}
				if("hostip".equals(name)){
					System.out.println("    hostip = "+text);
				}
				if("username".equals(name)){
					System.out.println("    username = "+text);
				}
				if("password".equals(name)){
					System.out.println("    password = "+text);
				}
				if("application".equals(name)){
					Attribute attrApp = elemebtChild.attribute("id");
					System.out.println("        application id = "+attrApp.getText());
					
					Iterator<Element> iteratorApp = elemebtChild.elementIterator();
					while(iteratorApp.hasNext()){
						Element elemebtApp = (Element)iteratorApp.next();
						String appAttr = elemebtApp.getName();
						String appText = elemebtApp.getName();
						if("appname".equals(appAttr)){
							System.out.println("        appname = "+appText);
						}
						if("logpath".equals(appAttr)){
							System.out.println("        logpath = "+appText);
						}
						if("logname".equals(appAttr)){
							System.out.println("        logname = "+appText);
						}
						if("stage".equals(appAttr)){
							System.out.println("        stage = "+appText);
						}
					}
				}
			}
		}
		
		Element root_system = root.element("system");
		Element root_localpath = root_system.element("localpath");
		System.out.println("localpath = "+root_localpath.getText());
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileWriter(new File("src/config/system2.xml")),format);
			writer.write(documnet);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void createXML() throws DocumentException{
		Document documnet = DocumentHelper.createDocument();
		Element root = documnet.addElement("configinfo");
		
		Element root_Servers = root.addElement("servers");
		Element root_Server1 = root_Servers.addElement("server");
		root_Server1.addAttribute("id", "server");
		
		Element root_hostname = root_Server1.addElement("hostname");
		Element root_hostip = root_Server1.addElement("hostip");
		Element root_username = root_Server1.addElement("username");
		Element root_password = root_Server1.addElement("password");
		root_hostname.setText("web");
		root_hostip.setText("192.168.44.236");
		root_username.setText("root");
		root_password.setText("qazwsx");
		
		Attribute attr = (Attribute)documnet.selectNodes("id");
		root_Server1.remove(attr);
		
		OutputFormat format=OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		XMLWriter writer;
		try {
			writer = new XMLWriter(new FileWriter(new File("src/config/system_new.xml")),format);
			writer.write(documnet);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParseXMLByDom4j parseXMLByDom4j = new ParseXMLByDom4j();
		try {
			
			parseXMLByDom4j.parseXML();
//			parseXMLByDom4j.createXML();
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}
