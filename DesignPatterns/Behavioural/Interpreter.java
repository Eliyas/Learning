package Behavioural;



public class Client {

	public static void main(String args[]) {
		Expression result = new MultiplicationExpression(
		new AddExpression(new NumberExpression(3), new NumberExpression(5)),
		new NumberExpression(2)
		);
		System.out.println("Interpreted value: " + result.interpret());
	}

}


interface Expression {
	int interpret();
}


class NumberExpression implements Expression {

	int expressionValue;

	public NumberExpression(int expressionValue) {
		this.expressionValue = expressionValue;
	}

	@Override
	public int interpret() {
		return expressionValue;
	}
}


class AddExpression implements Expression {
	Expression leftHandSideExpression;
	Expression rightHandSideExpression;

	public AddExpression(Expression leftHandSideExpression, Expression rightHandSideExpression) {
		this.leftHandSideExpression = leftHandSideExpression;
		this.rightHandSideExpression = rightHandSideExpression;
	}

	@Override
	public int interpret() {
		return this.leftHandSideExpression.interpret() + this.rightHandSideExpression.interpret();
	}
}

class MultiplicationExpression implements Expression {
	Expression leftHandSideExpression;
	Expression rightHandSideExpression;

	public MultiplicationExpression(Expression leftHandSideExpression, Expression rightHandSideExpression) {
		this.leftHandSideExpression = leftHandSideExpression;
		this.rightHandSideExpression = rightHandSideExpression;
	}

	@Override
	public int interpret() {
		return this.leftHandSideExpression.interpret() * this.rightHandSideExpression.interpret();
	}
}

