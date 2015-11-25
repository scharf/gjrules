package gr.scharf.rules.parser;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.IExpression;

public abstract class AbstractExpr implements IExpression {
    protected IToken token;

    public AbstractExpr(IToken token) {
        this.token = token;
    }

    @Override
    public void setStore(StateStore store) {
    }

}
