package com.lyb.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseXMLBySAX extends DefaultHandler {

	private List<Server> listServer = null;
	private Server server = null;
	private Application application = null;
	private String tagName;
	
	private String localpath;
	
	
	/**
	 * @author Yubo Lee
	 * 开始解析文档时触发该事件
	 * 
	 * */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始解析XML文档！");
		listServer = new ArrayList<Server>();
	}
	
	/**
	 * @author Yubo Lee
	 * 结束解析文档时触发该事件
	 * 
	 * */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析XML文档完毕！");
	}
	
	/**
	 * @author Yubo Lee
	 * 当解析器遇到元素开始标志（<）时触发该事件
	 * @param uri：名称空间URI，如果元素没有任何名称空间 URI，或者没有正在执行名称空间处理，则为空字符串。
	 * @param localName：本地名称（不带前缀），如果没有正在执行名称空间处理，则为空字符串。
	 * @param qName：限定的名称（带有前缀），如果限定的名称不可用，则为空字符串。
	 * @param attributes：附加到元素的属性。如果没有属性，则它将是空的 Attributes 对象。
	 * */
	@Override
	public void startElement(String uri, String localName, String name,
			Attributes attributes) throws SAXException {
		System.out.println("开始解析XML文档中的元素！");
		if("server".equals(name)){
			server = new Server();
			server.setListApp(new ArrayList<Application>());
			for(int i=0;i<attributes.getLength();i++){
				if("id".equals(attributes.getQName(i))){
					server.setId(attributes.getValue(i));
				}
			}
		}
		
		if("application".equals(name)){
			application = new Application();
			for(int i=0;i<attributes.getLength();i++){
				if("id".equals(attributes.getQName(i))){
					application.setId(attributes.getValue(i));
				}
			}
		}
		this.tagName = name;
	}
	
	
	/**
	 * @author Yubo Lee
	 * 当解析器遇到元素结束标志（</）时触发该事件
	 * @param uri：名称空间URI，如果元素没有任何名称空间 URI，或者没有正在执行名称空间处理，则为空字符串。
	 * @param localName：本地名称（不带前缀），如果没有正在执行名称空间处理，则为空字符串。
	 * @param qName：限定的名称（带有前缀），如果限定的名称不可用，则为空字符串。
	 * @param attributes：附加到元素的属性。如果没有属性，则它将是空的 Attributes 对象。
	 * */
	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		
		if("application".equals(name)){
			this.server.getListApp().add(this.application);
		}
		if("server".equals(name)){
			this.listServer.add(this.server);
		}
		this.tagName = "";
		System.out.println("解析XML文档中的元素完毕！");
	}
	
	
	/**
	 * @author Yubo Lee
	 * 当解析器遇到“换行”、 “TAB”时都会触发该事件
	 * 
	 * */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println("解析XML文档中的文本！");
		
		
		String value = new String(ch, start, length);
		System.out.println("本次获取到的内容是="+value);
		
		//服务器Server中的元素
		if("hostname".equals(this.tagName)){
			this.server.setHostname(value);
		}
		if("hostip".equals(this.tagName)){
			this.server.setHostip(value);
		}
		if("username".equals(this.tagName)){
			this.server.setUsername(value);
		}
		if("password".equals(this.tagName)){
			this.server.setPassword(value);
		}
		
		//应用Application中的元素
		if("appname".equals(this.tagName)){
			this.application.setAppname(value);
		}
		if("logpath".equals(this.tagName)){
			this.application.setLogpath(value);
		}
		if("logname".equals(this.tagName)){
			this.application.setLogname(value);
		}
		if("stage".equals(this.tagName)){
			this.application.setStage(value);
		}
		
		//系统元素
		if("localpath".equals(this.tagName)){
			this.localpath = value;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		try {
			//得到SAX解析器的工厂
			SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
			//从工厂中获得SAX解析器
			SAXParser saxParser = saxParserFactory.newSAXParser();
			
			//创建DefaultHandler的实例 ParseXMLBySAX
			ParseXMLBySAX parseXMLBySAX = new ParseXMLBySAX();
			File xmlFile = new File("src/config/system.xml");
			try {
				saxParser.parse(xmlFile, parseXMLBySAX);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			for(int i=0;i<parseXMLBySAX.listServer.size();i++){
				Server server = parseXMLBySAX.listServer.get(i);
				System.out.println("*************************** "+server.getId()+" ***************************");
				System.out.println("hostname = "+server.getHostname());
				System.out.println("hostip = "+server.getHostip());
				System.out.println("username = "+server.getUsername());
				System.out.println("password = "+server.getPassword());
				
				List<Application> listApp = server.getListApp();
				for(int j=0;j<listApp.size();j++){
					Application application = listApp.get(j);
					System.out.println("--------------------- "+application.getId()+" ----------------------");
					System.out.println("Appname = "+application.getAppname());
					System.out.println("Logname = "+application.getLogname());
					System.out.println("Logpath = "+application.getLogpath());
					System.out.println("Stage = "+application.getStage());
				}
			}
			
			System.out.println("system parameter localpath = "+parseXMLBySAX.localpath);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
}
