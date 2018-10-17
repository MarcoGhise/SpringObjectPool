package it.blog.springobjectpool.response;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultRest {

	final static Logger log = Logger.getLogger("GTWLOGGER");
	
	private int retCode; 
	private String retDesc;
	
	private int idStepError;
	private String idStepErrorDescr;
	
	
	
	public ResultRest(){
		
		log.info("Object Created:" + this.hashCode());
	}
	
	public ResultRest(int retCode, String retDesc)
	{
		this.retCode = retCode;
		this.retDesc = retDesc;
	}
	
	@JsonProperty("retcode")
	public int getRetCode() {
		return retCode;
	}
	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}
	@JsonProperty("retdesc")
	public String getRetDesc() {
		return retDesc;
	}
	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}
	
	@JsonProperty("id_step_err_desc")
	public String getIdStepErrorDescr() {
		return idStepErrorDescr;
	}
	public void setIdStepErrorDescr(String idStepErrorDescr) {
		this.idStepErrorDescr = idStepErrorDescr;
	}
	
	@Override
	public String toString()
	{
		return "retCode=" + retCode + ";retDesc=" + retDesc + ";idStepError=" + getIdStepError() + ";idStepErrorDescr=" + idStepErrorDescr;
	}
	@JsonProperty("id_step_err")
	public int getIdStepError() {
		return idStepError;
	}
	public void setIdStepError(int idStepError) {
		this.idStepError = idStepError;
	}
	
}
