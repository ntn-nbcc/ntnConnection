/**
 * 
 */
package com.ntn.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.swing.text.html.parser.DocumentParser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.ntn.utils.NTNLogger;

/**
 * @author sjhaveri
 *
 */
public class ResourceXML {
	NTNLogger logger = new NTNLogger("ResourceXML");

	/**
	 * 
	 */
	public ResourceXML() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		ResourceXML resourceXML = new ResourceXML();
		try {

		//	Document doc = resourceXML.getXMLDocument("C://web-conf//xml//Branch_NewSenderID.xml");

		}
		catch(Exception e) {
			System.out.println("Exception :"+e);
		}
	}


	public Document getResourceFile(String inxml) {
		Document doc;
		
		try {
			String inbound_xml = "";
			InputStream is = getClass().getResourceAsStream(inxml);
			BufferedReader br= new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = br.readLine()) != null) {
				inbound_xml+=(line);
			} 

			br.close();
			System.out.println("inbound_xml :"+inbound_xml);

			try{
				
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = null;
				builder = factory.newDocumentBuilder();
				doc = builder.parse(new InputSource(new StringReader(inbound_xml)));


				return doc;
			}
			catch (Exception e){
				System.out.println("error in generting XML in ResourceXML :"+e);
			}


		}
		catch(Exception e) {
			System.out.println("Error :"+e);
		}

		return null;

	}


}



