package gr.scharf.rules.parser;

import gr.scharf.expr.parser.builder.ExprParser;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ExpressionParser extends ExprParser<IExpression, ExpressionException> {

    public ExpressionParser() {
        super(new ExpressionBuilder(), true);
    }

}
