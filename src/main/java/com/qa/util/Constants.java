package com.qa.util;

import java.io.File;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Constants {
	
	
	public static int IMPLICIT_WAIT = 20;
	
	
	
	
	private static final Logger LOGGER = LogManager.getLogger(Constants.class);
	
	
// Check XML file is exist or not
	public boolean checkIfFileExist(String filePath, String fileName) {
        try {
        	LOGGER.info("Inside Check File Exist method"+filePath + fileName);
                      File file = new File(filePath + fileName);                      
                      //file.createNewFile();
                      return file.exists();

        } catch (Exception e) {
                      e.printStackTrace();
        }
        return false;
}
	
// Convert XML Document to String
	public  String convertXMLDocumentToString(String filePath, String fileName) throws InterruptedException {		 
		Thread.sleep(3000);
        // Create a new object of TransformerFactory
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;

        try {
                      // creating a constructor of file class and parsing an XML file
                      File file = new File(filePath + fileName);

                      // an instance of factory that gives a document builder
                      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                      // an instance of builder to parse the specified xml file
                      DocumentBuilder db;
                      db = dbf.newDocumentBuilder();
                      Document doc = db.parse(file);
                      transformer = transformerFactory.newTransformer();

                      // Creating object of the Source document that is xml doc
                      DOMSource source = new DOMSource(doc);
                      StringWriter strWriter = new StringWriter();
                      StreamResult stResult = new StreamResult(strWriter);
                      transformer.transform(source, stResult);
                      String xmlString = strWriter.getBuffer().toString();
        //           System.out.println(xmlString);
                      Thread.sleep(8000);
                      return xmlString;

        } catch (TransformerException e) {
                      e.printStackTrace();

        } catch (ParserConfigurationException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
        } catch (SAXException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
        } catch (IOException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
        }
        return null;

}
	
	
	
	public String fetchElementById(String response, String elementName, String attributeName) throws InterruptedException {       

        String entitlementLAC = "";
        Thread.sleep(3000);
        try {             

                      // creating a constructor of file class and parsing an XML file
                      File file = new File(response);
                      // an instance of factory that gives a document builder
                      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                      // an instance of builder to parse the specified xml file
                      DocumentBuilder db = dbf.newDocumentBuilder();
                      
                      Document doc = db.parse(file);
                      doc.getDocumentElement().normalize();
                      System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                      NodeList nodeList = doc.getElementsByTagName("Payload");
                      System.out.println(nodeList.getLength());

                      // nodeList is not iterable, so we are using for loop
                      for (int itr = 0; itr < nodeList.getLength(); itr++) {
                                     Node node = nodeList.item(itr);
                                     System.out.println("\nNode Name :" + node.getNodeName());
                                     if (node.getNodeType() == Node.ELEMENT_NODE) {
                                                   Element eElement = (Element) node;
                                                   if ( eElement != null && (eElement.getElementsByTagName(elementName) != null)  && (eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName)!=null)) {
                                                   entitlementLAC = eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName).toString();
                                                   System.out.println("entitlementLAC"+elementName + " :" + entitlementLAC);

                                                   }
                                     }
                      }
        } catch (Exception e) {

                      System.out.println(elementName + " or " + attributeName +" doesn't exist");
                      return entitlementLAC;
        }
        if (entitlementLAC.equalsIgnoreCase("")) {

                      System.out.println(elementName + " or " + attributeName +" doesn't exist");
        }

        return entitlementLAC;

}

	
// Fetch element ID from String Method
public String fetchElementByIdFromString(String xmlToString, String elementName, String attributeName) {

        String entitlementLAC = "";

        try {

                      // an instance of factory that gives a document builder

                      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                      // an instance of builder to parse the specified xml file

                      DocumentBuilder db = dbf.newDocumentBuilder();
                      
                      Document doc = db.parse(new InputSource(new StringReader(xmlToString)));

                      doc.getDocumentElement().normalize();

                      //System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

                      NodeList nodeList = doc.getElementsByTagName("Payload");

                      //System.out.println(nodeList.getLength());

                      // nodeList is not iterable, so we are using for loop

                      for (int itr = 0; itr < nodeList.getLength(); itr++) {

                                     Node node = nodeList.item(itr);

                                     System.out.println("\nNode Name :" + node.getNodeName());

                                     if (node.getNodeType() == Node.ELEMENT_NODE) {

                                                   Element eElement = (Element) node;
                                                  if ( eElement != null && (eElement.getElementsByTagName(elementName) != null)  && (eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName)!=null)) {
                                               	  entitlementLAC = eElement.getElementsByTagName(elementName).item(0).getAttributes().getNamedItem(attributeName).toString();
                                               	  String[] entitlementLAC2 = entitlementLAC.split("=");
                                               	  entitlementLAC = entitlementLAC2[1].replace("\"", "");
                                                  System.out.println(elementName + " :" + entitlementLAC);

                                                   }

                                     }

                      }
       

        } catch (Exception e) {

                      System.out.println(elementName + " or " + attributeName +" doesn't exist"+"ErrorMessage"+e.getMessage());
                      return entitlementLAC;

        }
      

        if (entitlementLAC.equalsIgnoreCase("")) {

                      System.out.println(elementName + " or " + attributeName +" doesn't exist");

        }

        return entitlementLAC;

}	
	
	
}
