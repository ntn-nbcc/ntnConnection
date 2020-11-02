/**
 * 
 */
package com.ntn.singletons.beans;

import java.util.ArrayList;

/**
 * @author sjhaveri
 *
 */
public class SystemConstantsBean {
	private String environment_name="";
	private String companyCode ="";
	private String logistixExceptionEmailTo="";
	private ArrayList logistyxExceptionEmailCc=null;
	private String logistyxTechEmailTo="";
	

	/**
	 * 
	 */
	public SystemConstantsBean() {
		// TODO Auto-generated constructor stub
	}


	public SystemConstantsBean(String environment_name, String companyCode, String logistixExceptionEmailTo,
			ArrayList logistyxExceptnEmailCc, String logistyxTechEmailTo) {
		super();
		logistyxExceptionEmailCc = new ArrayList(1);
		this.environment_name = environment_name;
		this.companyCode = companyCode;
		this.logistixExceptionEmailTo = logistixExceptionEmailTo;
		
		for (int i=0; i <logistyxExceptnEmailCc.size() ; i++) {
			this.logistyxExceptionEmailCc.add(logistyxExceptnEmailCc.get(i));
		}
		System.out.println(this.logistyxExceptionEmailCc.size());
		this.logistyxTechEmailTo = logistyxTechEmailTo;
	}


	public String getEnvironment_name() {
		return environment_name;
	}


	public void setEnvironment_name(String environment_name) {
		this.environment_name = environment_name;
	}


	public String getCompanyCode() {
		return companyCode;
	}


	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}


	public String getLogistixExceptionEmailTo() {
		return logistixExceptionEmailTo;
	}


	public void setLogistixExceptionEmailTo(String logistixExceptionEmailTo) {
		this.logistixExceptionEmailTo = logistixExceptionEmailTo;
	}


	public ArrayList getLogistyxExceptionEmailCc() {
		return logistyxExceptionEmailCc;
	}

	public String getLogistyxExceptionEmailCc(int index) {
		String emailcc = (String)logistyxExceptionEmailCc.get(index);
		return emailcc;
	}

	public void setLogistyxExceptionEmailCc(ArrayList logistyxExceptionEmailCc) {
		this.logistyxExceptionEmailCc = logistyxExceptionEmailCc;
	}


	public String getLogistyxTechEmailTo() {
		return logistyxTechEmailTo;
	}


	public void setLogistyxTechEmailTo(String logistyxTechEmailTo) {
		this.logistyxTechEmailTo = logistyxTechEmailTo;
	}

}
