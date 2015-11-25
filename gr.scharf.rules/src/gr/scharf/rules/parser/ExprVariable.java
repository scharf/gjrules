package gr.scharf.rules.parser;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;

public class ExprVariable extends AbstractExpr {

    private StateStore   store;
    private final String name;

    public ExprVariable(IToken token, String name) {
        super(token);
        this.name = name;
    }

    @Override
    public Object eval() throws ExpressionException {
        return store.getValue(name);
    }

    @Override
    public void setStore(StateStore store) {
        this.store = store;
    }

}
