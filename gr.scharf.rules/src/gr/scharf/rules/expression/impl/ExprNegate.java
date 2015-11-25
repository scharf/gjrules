package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ExprNegate extends AbstractExpr {

    private IExpression inner;

    public ExprNegate(IToken token, IExpression inner) {
        super(token);
        this.inner = inner;
    }

    @Override
    public Object eval(StateStore store) throws ExpressionException {
        return !toBoolean(inner.eval(store));
    }

    @Override
    public String toString() {
        return "not " + inner;
    }
}
