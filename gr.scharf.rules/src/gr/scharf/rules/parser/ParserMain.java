package gr.scharf.rules.parser;

import gr.scharf.expr.parser.parser.ParseException;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ParserMain {

    public static void main(String[] args) throws ParseException, ExpressionException {
        ExpressionParser parser = new ExpressionParser();
        IExpression expr = parser.parseVQL("1 && 2");
        System.out.println(expr);
    }

}
