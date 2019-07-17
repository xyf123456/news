package com.bdqn.servlet;

import com.bdqn.utils.ParseXMLDemo;
import org.w3c.dom.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.dom.DOMSource;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "XmlServlet",urlPatterns = "/servletXml")
public class XmlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String URL = "http://localhost:8080/news/xml/shoucang.xml";
//        String URL1 = "http://localhost:8080/news/xml/abc.xml";
//        ParseXMLDemo parseXMLDemo = new ParseXMLDemo();
//        Document document = parseXMLDemo.getDocument(URL);
//        DOMSource source =parseXMLDemo.savaXML1(document,URL1);
        StringBuffer source = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        source.append("<PhoneInfo>");
        source.append("这是手机信息");
        source.append("<Brand name=\"华为\">这是Brand的文本节点\n" +
                "    <Type name=\"U8650\">这是Type1的文本节点</Type>\n" +
                "    <Type name=\"HW123\">这是Type2的文本节点</Type>\n" +
                "    <Type name=\"HW321\">这是Type3的文本节点</Type>\n" +
                "</Brand>");
        source.append("</PhoneInfo>");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/xml;charset=utf-8");

        PrintWriter out = response.getWriter();
        out.println(source);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
