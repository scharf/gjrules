package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;

public class ExprVariable extends AbstractExpr {

    private final String name;

    public ExprVariable(IToken token, String name) {
        super(token);
        this.name = name;
    }

    @Override
    public Object eval(StateStore store) throws ExpressionException {
        try {
            return store.getValue(name);

        } catch (Exception e) {
            throw new ExpressionException(token, e.getLocalizedMessage());
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
