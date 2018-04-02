package com.lyb.xml;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class JavaXML {
 public String BuildXMLDoc() throws IOException, JDOMException {
  
      Element root = new Element("list");  // 创建根节点 list;
      Document Doc = new Document(root);   // 根节点添加到文档中；
      Element elements = new Element("company"); //创建节点 user;
  
      elements.setAttribute("id", "1");    //给company节点添加属性id
      elements.addContent(new Element("name").setText(""));
      elements.addContent(new Element("email").setText(""));
      root.addContent(elements);  // 给父节点list添加company子节点;
      XMLOutputter XMLOut = new XMLOutputter();

      XMLOut.output(Doc, new FileOutputStream("c://list1.xml"));
      Format f = Format.getPrettyFormat();
      f.setEncoding("GBK");
      f.setIndent("  "); //setIndent是设置分隔附的意思，一般都是用空格，就是当你新节点后，自动换行并缩进，有层次感，如果这样写setIndent("")，就只有换行功能，而不会缩进了，如果写成setIndent(null)，这样就即不换行也不缩进，全部以一行显示了
      XMLOut.setFormat(f);
      return XMLOut.outputString(Doc);
 }

 public static void main(String[] args) {
  try {
      JavaXML javaXML = new JavaXML();
      System.out.println(javaXML.BuildXMLDoc());
  } catch (Exception e) {
      e.printStackTrace();
  }
 }
}