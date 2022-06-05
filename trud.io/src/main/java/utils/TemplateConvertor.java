package utils;

import com.sbnz.trud.io.apiContracts.request.TemplateTestRule;

public class TemplateConvertor {
	
	
	public static TemplateTestRule convertDoubleTestRule(TemplateTestRule doubleTestRule) {
		TemplateTestRule newRule = new TemplateTestRule(doubleTestRule.getCutOffT21(), doubleTestRule.getCutOffT18(), doubleTestRule.getCutOffT13());
		newRule.setSignT21(convertSign(doubleTestRule.getSignT21()));
		newRule.setSignT18(convertSign(doubleTestRule.getSignT18()));
		newRule.setSignT13(convertSign(doubleTestRule.getSignT13()));
		newRule.setResult(convertResult(doubleTestRule.getResult()));
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

}
