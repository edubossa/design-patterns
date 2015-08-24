package br.com.ews.design.interpreter;

public class InterpreterClient {

	private InterpreterContext ic;

	public InterpreterClient(InterpreterContext ic) {
		this.ic = ic;
	}
	
	public String interpret(String str) {
		Expression expression = null;
		if (str.contains("Hexadecimal")) {
			expression = new IntToHexExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		} else if (str.contains("Binary")) {
			expression = new IntToBinaryExpression(Integer.parseInt(str.substring(0,str.indexOf(" "))));
		} else return str;
		
		return expression.interpret(ic);
	}
	

}
