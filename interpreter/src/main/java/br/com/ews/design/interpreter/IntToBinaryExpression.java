package br.com.ews.design.interpreter;

public class IntToBinaryExpression implements Expression {

	private int i;

	public IntToBinaryExpression(int i) {
		this.i = i;
	}

	@Override
	public String interpret(InterpreterContext ic) {
		return ic.getBinaryFormat(this.i);
	}

}
