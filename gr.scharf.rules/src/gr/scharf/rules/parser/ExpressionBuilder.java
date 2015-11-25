package gr.scharf.rules.parser;

import gr.scharf.expr.parser.builder.AbstractExpressionBuilder;
import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ExpressionBuilder extends AbstractExpressionBuilder<IExpression, ExpressionException> {

    @Override
    public IExpression buildLiteral(IToken token, Object value) throws ExpressionException {
        return new ExprLiteral(token, value);
    }

    @Override
    public IExpression buildFunction(IToken token, IExpression self, String function, Object... args)
            throws ExpressionException {
        throw new ExpressionException(token, function);
    }

    @Override
    public IExpression buildVariable(IToken token, String name) throws ExpressionException {
        return new ExprVariable(token, name);
    }

}
