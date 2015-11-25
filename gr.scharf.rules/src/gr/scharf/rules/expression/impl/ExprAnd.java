package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ExprAnd extends AbstractExpr {

    private IExpression left;
    private IExpression right;

    public ExprAnd(IToken token, IExpression left, IExpression right) {
        super(token);
        this.left = left;
        this.right = right;
    }

    @Override
    public Object eval(StateStore store) throws ExpressionException {
        return left.test(store) && right.test(store);
    }

    @Override
    public String toString() {
        return "(" + left + " and " + right + ")";
    }
}
