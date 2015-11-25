package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;

public class ExprLiteral extends AbstractExpr {

    private final Object value;

    public ExprLiteral(IToken token, Object value) {
        super(token);
        this.value = value;
    }

    @Override
    public Object eval() {
        return value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
