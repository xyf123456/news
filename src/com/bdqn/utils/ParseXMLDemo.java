package com.bdqn.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * @ClassName: xml.ParseXMLDemo
 * @Description: 解析XML文件
 * @Author: Administrator
 * @CreateDate: 2019/6/2 0002 下午 10:32
 * @UpdateUser: Administrator
 * @Version: 1.0
 **/
public class ParseXMLDemo {
    private Document document = null;

    /**
     * @ Description:
     * @params: * @param
     * @return:void
     **/
    public void getDocument() {
        //获得解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //        根据解析器工厂获得解析器
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            //        解析器来解析XML文件来获取Document对象
            document = documentBuilder.parse("src/xml1/shoucang.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Document getDocument(String url) {

        //获得解析器工厂
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            //        根据解析器工厂获得解析器
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            //        解析器来解析XML文件来获取Document对象
            document = documentBuilder.parse(url);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }




    /**
     * @ Description: 展示XML文档信息
     * @params: * @param
     * @return:void
     **/
    public void showInfo() {
        //获取Brand元素或标签下的所有节点
        NodeList brands = document.getElementsByTagName("Brand");
        for (int i = 0; i < brands.getLength(); i++) {
            Node note = brands.item(i);
            Element eleBrand = (Element) note;
            System.out.println(eleBrand.getAttribute("name"));

            //获取Brand元素或标签所有节点的子节点
            NodeList types = eleBrand.getChildNodes();
            for (int j = 0; j < types.getLength(); j++) {
                Node typeNode = types.item(j);
                if (typeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eleType = (Element) typeNode;
                    System.out.println(eleType.getAttribute("name"));
                }
            }
        }
    }

    public void showInfo1(Document document) {
        //获取Brand元素或标签下的所有节点
        NodeList brands = document.getElementsByTagName("Brand");
        for (int i = 0; i < brands.getLength(); i++) {
            Node note = brands.item(i);
            Element eleBrand = (Element) note;
            System.out.println(eleBrand.getAttribute("name"));

            //获取Brand元素或标签所有节点的子节点
            NodeList types = eleBrand.getChildNodes();
            for (int j = 0; j < types.getLength(); j++) {
                Node typeNode = types.item(j);
                if (typeNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eleType = (Element) typeNode;
                    System.out.println(eleType.getAttribute("name"));
                }
            }
        }
    }

    /**
     * @ Description: 添加元素
     * @params: * @param
     * @return:void
     **/
    public void add() {
        Element element = document.createElement("Brand");
        element.setAttribute("name", "苹果");
        Element ele1 = document.createElement("Type");
        ele1.setAttribute("name", "IPhoneXS");
        element.appendChild(ele1);
        document.getElementsByTagName("PhoneInfo").item(0).appendChild(element);
        //保存到指定的XML文档中
//        this.savaXML("src/xml1/new.xml");
        this.savaXML("src/xml1/shoucang.xml");
        System.out.println("保存成功！");
    }

    /**
     * @Description: 修改xml文件
     * @param: []
     * @return: void
     * @Date: 2019/06/03 上午 8:25
     */
    public void update(){
        NodeList brands=document.getElementsByTagName("Brand");
        for(int i=0;i<brands.getLength();i++){
            Node brand=brands.item(i);
            Element eleBrand=(Element)brand;
            eleBrand.setAttribute("id", i+"");
        }
        this.savaXML("src/xml1/new.xml");
    }

    public void delete(){
        NodeList brands=document.getElementsByTagName("Brand");
        for (int i = 0; i < brands.getLength(); i++) {
            Node brand=brands.item(i);
            Element eleBrand=(Element)brand;
            if (eleBrand.getAttribute("name").equals("华为")){
                eleBrand.getParentNode().removeChild(eleBrand);
            }
            this.savaXML("src/xml1/new.xml");
        }
    }

    /**
     * @ Description:保存XML文件(需要借助到转换器)
     * @params: * @param path
     * @return:void
     **/
    public void savaXML(String path) {

        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute("indent-number", 4);//设置首行缩进，提高可读性

        try {
//            此抽象类的实例能够将源树转换为结果树。
            Transformer transformer = factory.newTransformer();//得到转换器
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            indent 指定了当输出结果树时，Transformer 是否可以添加额外的空白
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记。
            StreamResult streamResult = new StreamResult(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
//            以 Document Object Model（DOM）树的形式充当转换 Source 树的持有者。
//            源（最新的DOM树）--》目的地（存储的新的位置 xml）
            DOMSource source = new DOMSource(document);
            transformer.transform(source, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public DOMSource savaXML1(Document document,String path) {
        DOMSource source = null;
        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute("indent-number", 4);//设置首行缩进，提高可读性

        try {
//            此抽象类的实例能够将源树转换为结果树。
            Transformer transformer = factory.newTransformer();//得到转换器
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
//            indent 指定了当输出结果树时，Transformer 是否可以添加额外的空白
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记。
            StreamResult streamResult = new StreamResult(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
//            以 Document Object Model（DOM）树的形式充当转换 Source 树的持有者。
//            源（最新的DOM树）--》目的地（存储的新的位置 xml）
            source = new DOMSource(document);
            transformer.transform(source, streamResult);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        return source;
    }

    public static void main(String[] args) {
        ParseXMLDemo parseXMLDemo = new ParseXMLDemo();
        String URL = "http://192.168.3.182:8080/news/xml/shoucang.xml";
        Document document = null;
        document = parseXMLDemo.getDocument(URL);
//        parseXMLDemo.getDocument();
        parseXMLDemo.showInfo1(document);
//        parseXMLDemo.delete();
//        parseXMLDemo.add();
//        parseXMLDemo.update();
    }
}
