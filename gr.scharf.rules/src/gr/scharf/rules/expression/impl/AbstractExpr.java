package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public abstract class AbstractExpr implements IExpression {
    protected IToken token;

    public AbstractExpr(IToken token) {
        this.token = token;
    }

    @Override
    public boolean test(StateStore store) throws ExpressionException {
        return toBoolean(eval(store));
    }

    protected boolean toBoolean(Object result) throws ExpressionException {
        if (result instanceof Boolean) {
            return ((Boolean) result).booleanValue();
        }
        throw new ExpressionException(token, "value is not boolen but " + result.getClass().getSimpleName());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
