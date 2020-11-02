/**
 * 
 */
package com.ntn.singletons.commands;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ntn.commands.ServerIPAddress;
import com.ntn.singletons.beans.SystemConstantsBean;
import com.ntn.utils.Constants;
import com.ntn.utils.NTNLogger;
import com.ntn.utils.ResourceXML;

/**
 * @author sjhaveri
 *
 */
public class SystemConstantsSingleton {
	NTNLogger logger = new NTNLogger("SystemConstants");

	private static SystemConstantsSingleton instance;
	private static boolean initialized = false;
	private ArrayList systemConstantsArrayList = null;
	private  int systemConstantsArrayLength = 0;
	private String lib="";
	private String comlib="";
	private String sqlLib="";
	private String jdeUrl="";
	private String urlPassword="";
	private String datasource="";
	private String itemManagerbssv_endpoint=" ";
	private String orderManagerbssv_endpoint=" ";
	private String mode="";
	private ResourceXML resourceXML = new ResourceXML();
	private ServerIPAddress sipAddress = new ServerIPAddress();
	private String sqlUrl=" ";
	private String SQLdatasource="";
	
	/**
	 * 
	 */
	protected SystemConstantsSingleton() {
		String hostIpAddress = sipAddress.getHostIP();
		System.out.println("hostIpAddress :"+hostIpAddress);
		if(hostIpAddress.equals("10.211.1.16")) {
			this.setLib("PRODDTA");
			this.setComlib("PRODCTL");
			this.sqlLib="dbo";
			this.mode="P";
			this.itemManagerbssv_endpoint = "https://10.204.1.184:8989/PD920/NTN_ItemManager";
			this.orderManagerbssv_endpoint = "https://10.204.1.184:8989/PD920/NTN_OrderManager";
			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.34:1521/jdeorcl";
			this.datasource = "java:/comp/env/jdbc/jde92pd";
			this.urlPassword = "7svzej4p"; 
			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces";
			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface";
		//	this.urlPassword = "KQXulT30";
			
//			this.setLib("PY2DTA");
//			this.setComlib("PY2CTL");
//			this.sqlLib="dbo";
//			this.mode="T";
//			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
//			this.datasource = "java:/comp/env/jdbc/jde92py";
//			this.urlPassword = "zerx6vtd";
//			this.itemManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_ItemManager";
//			this.orderManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_OrderManager";
		}
		else {
			//// special data connection - oracle - prod and sql - interace test
//			this.setLib("PRODDTA");
//			this.setComlib("PRODCTL");
//			this.sqlLib="dbo";
//			this.mode="T";
//			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
//			this.datasource = "java:/comp/env/jdbc/jde92pd";
//			this.urlPassword = "zerx6vtd";
//			this.itemManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_ItemManager";
//			this.orderManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_OrderManager";
//			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces_test";
//			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface_test";
			
//			this.setLib("PY2DTA");
//			this.setComlib("PY2CTL");
//			this.sqlLib="dbo";
//			this.mode="T";
//			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
//			this.datasource = "java:/comp/env/jdbc/jde92py";
//			this.urlPassword = "zerx6vtd";
//			this.itemManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_ItemManager";
//			this.orderManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_OrderManager";
//			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces_test";
//			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface_test";
			
			
			this.setLib("PRODDTA");
			this.setComlib("PRODCTL");
			this.sqlLib="dbo";
			this.mode="P";
			this.itemManagerbssv_endpoint = "https://10.204.1.184:8989/PD920/NTN_ItemManager";
			this.orderManagerbssv_endpoint = "https://10.204.1.184:8989/PD920/NTN_OrderManager";
			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.34:1521/jdeorcl";
			this.datasource = "java:/comp/env/jdbc/jde92pd";
			this.urlPassword = "7svzej4p"; 
			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces";
			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface";

		}
		
		if(hostIpAddress.equals("10.211.120.44")) {
			this.setLib("PY2DTA");
			this.setComlib("PY2CTL");
			this.sqlLib="dbo";
			this.mode="T";
			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
			this.datasource = "java:/comp/env/jdbc/jde92py";
			this.urlPassword = "zerx6vtd";
			this.itemManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_ItemManager";
			this.orderManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_OrderManager";
			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces_test";
			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface_test";
		}
		if(hostIpAddress.equals("10.211.20.50")) {
			this.setLib("PY2DTA");
			this.setComlib("PY2CTL");
			this.sqlLib="dbo";
			this.mode="T";
			this.jdeUrl = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
			this.datasource = "java:/comp/env/jdbc/jde92py";
			this.urlPassword = "zerx6vtd";
			this.itemManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_ItemManager";
			this.orderManagerbssv_endpoint = "https://10.204.1.183:8988/PY920/NTN_OrderManager";
			this.sqlUrl = "jdbc:sqlserver://10.204.1.181;databaseName=Interfaces_test";
			this.SQLdatasource = "java:/comp/env/jdbc/sqlInterface_test";
		}
		
		
		try{
			systemConstantsArrayList = new ArrayList(1);
			init();
			setInitialized(true); // construction was successful
		}	
		catch(Exception e){
			System.out.println("SystemConstantsSingleton::SystemConstantsSingleton - error creating SystemConstantsSingleton : "+e);
			setInitialized(false); // bad construction
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SystemConstantsSingleton systemConstantsSingleton = SystemConstantsSingleton.getInstance();
		systemConstantsSingleton.destroyInstance();
		systemConstantsSingleton = SystemConstantsSingleton.getInstance();
		SystemConstantsBean systemConstantsBean  = systemConstantsSingleton.getSystemConstantBeanByCompany("00010");
		System.out.println("company code: "+systemConstantsBean.getLogistyxExceptionEmailCc(1));
	}


	public void init() throws Exception  {
		try {
			Document doc = resourceXML.getResourceFile("systemConstants.xml");
			Element docElement = doc.getDocumentElement();
			
				NodeList environment_name_list = doc.getElementsByTagName(Constants.ENVIORNMENT_NAME_TAG);
				Node environment_name_node = environment_name_list.item(0);

				String environment_name = environment_name_node.getFirstChild().getNodeValue();
			//	System.out.println("environment_name :"+environment_name);


				NodeList company_list = doc.getElementsByTagName(Constants.COMPANY_TAG);
				int company_len =  company_list.getLength();
				
				for (int i = 0; i < company_len ; i++){
					Element company_element = (Element)company_list.item(i);
					NodeList id_list = company_element.getElementsByTagName(Constants.ID_TAG);
					NodeList logistyxExceptionEmailTo_list = company_element.getElementsByTagName(Constants.LOGISTYXEXCEPTIONEMAILTO_TAG);
					NodeList logistyxExceptionEmailCc_list = company_element.getElementsByTagName(Constants.LOGISTYXEXCEPTIONEMAILCC_TAG);
					NodeList logistyxTechEmailTo_list = company_element.getElementsByTagName(Constants.LOGISTYXTECHEMAILTO_TAG);

					Node id_node = id_list.item(0);
					String id_code = id_node.getFirstChild().getNodeValue();

					Node logistyxExceptionEmailTo_node = logistyxExceptionEmailTo_list.item(0);
					String logistyxExceptionEmailTo = logistyxExceptionEmailTo_node.getFirstChild().getNodeValue();

					Node logistyxTechEmailTo_node = logistyxTechEmailTo_list.item(0);
					String logistyxTechEmailTo = logistyxTechEmailTo_node.getFirstChild().getNodeValue();
				

					int logistyxExceptionEmailCc_length = logistyxExceptionEmailCc_list.getLength();

					ArrayList emailcc = new ArrayList(1);
					for (int j = 0; j < logistyxExceptionEmailCc_length ; j++){
						Node logistyxExceptionEmailCc_node = logistyxExceptionEmailCc_list.item(j);
						emailcc.add(logistyxExceptionEmailCc_node.getFirstChild().getNodeValue());
					}
			
					SystemConstantsBean systemConstantsBean = new SystemConstantsBean(environment_name,id_code,logistyxExceptionEmailTo,emailcc,logistyxTechEmailTo);
					addSystemConstantsBean(systemConstantsBean);
				}
		//	}
		
		}
		catch (Exception e){System.out.println("error in SystemConstantsSingleton :"+e);}
	}


	public void addSystemConstantsBean(SystemConstantsBean systemConstantsBean ){
		try
		{
			systemConstantsArrayList.add (systemConstantsBean);
			systemConstantsArrayLength+=1;
			//System.out.println("locnid :"+gisLcnBean.getLocationID() +" erpid :"+gisLcnBean.getErpID()+" supplier name :"+gisLcnBean.getErpName());
		} 
		catch (Exception ex) {
			System.out.println("Error in addGISLocationBean :" +ex);
		}		
	}

	public SystemConstantsBean getSystemConstantsBean (int index)  {
		SystemConstantsBean sConstantsBean = new SystemConstantsBean();
		try {
			sConstantsBean = (SystemConstantsBean) systemConstantsArrayList.get (index);
		}
		catch (Exception ex) {

		}
		return (sConstantsBean);	
	}

	public SystemConstantsBean getSystemConstantBeanByCompany (String company_code)  {
		SystemConstantsBean sConstantsBean = new SystemConstantsBean();
		for(int i=0; i<systemConstantsArrayList.size() ; i++){
			SystemConstantsBean cConstantsBean = (SystemConstantsBean) systemConstantsArrayList.get(i);

			if(cConstantsBean.getCompanyCode().trim().equals(company_code.trim())){
				sConstantsBean = cConstantsBean;
			}
		}
		return (sConstantsBean);	
	}

	public static void setInitialized(boolean newInitialized) {
		initialized = newInitialized;
	}

	public static synchronized void destroyInstance() {
		instance = null;     
	}


	public static synchronized SystemConstantsSingleton getInstance(){
		if(instance == null){
			instance = new SystemConstantsSingleton();
		}
		return instance;
	}

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}

	public String getSqlLib() {
		return sqlLib;
	}

	public void setSqlLib(String sqlLib) {
		this.sqlLib = sqlLib;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getComlib() {
		return comlib;
	}

	public void setComlib(String comlib) {
		this.comlib = comlib;
	}

	public String getJdeUrl() {
		return jdeUrl;
	}

	public void setJdeUrl(String jdeUrl) {
		this.jdeUrl = jdeUrl;
	}

	public String getDatasource() {
		return datasource;
	}

	public void setDatasource(String datasource) {
		this.datasource = datasource;
	}

	public String getUrlPassword() {
		return urlPassword;
	}

	public void setUrlPassword(String urlPassword) {
		this.urlPassword = urlPassword;
	}

	public String getItemManagerbssv_endpoint() {
		return itemManagerbssv_endpoint;
	}

	public void setItemManagerbssv_endpoint(String itemManagerbssv_endpoint) {
		this.itemManagerbssv_endpoint = itemManagerbssv_endpoint;
	}

	public String getOrderManagerbssv_endpoint() {
		return orderManagerbssv_endpoint;
	}

	public void setOrderManagerbssv_endpoint(String orderManagerbssv_endpoint) {
		this.orderManagerbssv_endpoint = orderManagerbssv_endpoint;
	}

	public String getSqlUrl() {
		return sqlUrl;
	}

	public void setSqlUrl(String sqlUrl) {
		this.sqlUrl = sqlUrl;
	}

	public String getSQLdatasource() {
		return SQLdatasource;
	}

	public void setSQLdatasource(String sQLdatasource) {
		SQLdatasource = sQLdatasource;
	}
}
