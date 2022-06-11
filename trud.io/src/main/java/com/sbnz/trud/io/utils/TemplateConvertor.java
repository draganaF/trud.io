package com.sbnz.trud.io.utils;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;

public class TemplateConvertor {
	
	
	public static TemplateTestRule convertDoubleTestRule(TemplateTestRule doubleTestRule) {
		TemplateTestRule newRule = new TemplateTestRule(doubleTestRule.getCutOffT21(), doubleTestRule.getCutOffT18(), doubleTestRule.getCutOffT13());
		newRule.setSignT21(convertSign(doubleTestRule.getSignT21()));
		newRule.setSignT18(convertSign(doubleTestRule.getSignT18()));
		newRule.setSignT13(convertSign(doubleTestRule.getSignT13()));
		newRule.setResult(convertResult(doubleTestRule.getResult()));
		newRule.setStatusDouble(convertStatusDouble(doubleTestRule.getStatusDouble()));
		newRule.setStatusTriple(convertStatusTriple(doubleTestRule.getStatusTriple()));
		newRule.setStatusQuadriple(convertStatusTriple(doubleTestRule.getStatusQuadriple()));
		return newRule;
	}

	
	public static String convertSign(String sign) {
		if(sign.equals(">")) {
			return "<";
		}else if(sign.equals(">=")) {
			return "<=";
		}else if(sign.equals("<")) {
			return ">";
		}else if(sign.equals("<=")) {
			return ">=";
		}
		return "=";
		
	}
	
	public static String convertResult(String result) {
		if(result.equals("Screen positive")) {
			return "Screen negative";
		}else if(result.equals("Screen negative")) {
			return "Screen positive";
		}
		return "Calculate risks";
		
	}
	
	public static String convertStatusDouble(String statusDouble) {
		if(statusDouble.isEmpty()) {
			return "Positive - not Triple";
		}else if(statusDouble.equals("Positive - not Triple")) {
			return " ";
		}
		return " ";
		
	}
	
	public static String convertStatusTriple(String statusTriple) {
		if(statusTriple.isEmpty()) {
			return "Positive - not Amniocentesis";
		}else if(statusTriple.equals("Positive - not Amniocentesis")) {
			return " ";
		}
		return " ";
		
	}
	
	public static String checkStatus(String status) {
		if(status.isEmpty()) {
			return " ";
		}
		return status;
		
	}

}
