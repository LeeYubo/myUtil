package com.lyb.xml.sax1;

import java.util.ArrayList;
import java.util.List;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 * 功能描述:采用sax方式解析XML<br>
 * 
 * @author sxyx2008
 *
 */
public class CopyNet extends DefaultHandler{

    //存放遍历集合
    private List<Student> list;
    //构建Student对象
    private Student student;
    //用来存放每次遍历后的元素名称(节点名称)
    private String tagName;
    
    
    public List<Student> getList() {
        return list;
    }


    public void setList(List<Student> list) {
        this.list = list;
    }


    public Student getStudent() {
        return student;
    }


    public void setStudent(Student student) {
        this.student = student;
    }


    public String getTagName() {
        return tagName;
    }


    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


    //只调用一次  初始化list集合  
    @Override
    public void startDocument() throws SAXException {
        list=new ArrayList<Student>();
    }
    
    
    //调用多次    开始解析
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes attributes) throws SAXException {
    	
        if(qName.equals("student")){
            student=new Student();
            //获取student节点上的id属性值
            student.setId(Integer.parseInt(attributes.getValue(0)));
            //获取student节点上的group属性值
            student.setGroup(Integer.parseInt(attributes.getValue(1)));
        }
        this.tagName=qName;
    }
    
    
    //调用多次  
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
    	System.out.println("A00000000001");
        if(qName.equals("student")){
            this.list.add(this.student);
        }
        this.tagName=null;
    }
    
    
    //只调用一次
    @Override
    public void endDocument() throws SAXException {
    }
    
    //调用多次
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if(this.tagName!=null){
            String date=new String(ch,start,length);
            if(this.tagName.equals("name")){
                this.student.setName(date);
            }
            else if(this.tagName.equals("sex")){
                this.student.setSex(date);
            }
            else if(this.tagName.equals("age")){
                this.student.setAge(Integer.parseInt(date));
            }
            else if(this.tagName.equals("email")){
                this.student.setEmail(date);
            }
            else if(this.tagName.equals("birthday")){
                this.student.setBirthday(date);
            }
            else if(this.tagName.equals("memo")){
                this.student.setMemo(date);
            }
        }
    }
}