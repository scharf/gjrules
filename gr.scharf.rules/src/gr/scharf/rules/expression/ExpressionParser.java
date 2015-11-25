package gr.scharf.rules.expression;

import gr.scharf.expr.parser.builder.ExprParser;
import gr.scharf.rules.expression.impl.ExpressionBuilder;

public class ExpressionParser extends ExprParser<IExpression, ExpressionException> {

    public ExpressionParser() {
        super(new ExpressionBuilder(), true);
    }

}
