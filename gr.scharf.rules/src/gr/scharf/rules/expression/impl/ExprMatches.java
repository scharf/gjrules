package gr.scharf.rules.expression.impl;

import java.util.regex.PatternSyntaxException;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

public class ExprMatches extends AbstractBinaryExpr {

    public ExprMatches(IToken token, IExpression self, IExpression arg) {
        super(token, self, arg);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object eval() throws ExpressionException {
        Object self = left.eval();
        if (!(self instanceof String)) {
            throw new ExpressionException(token, "this is not a String but a " + self.getClass().getSimpleName());
        }
        Object regex = right.eval();
        if (!(self instanceof String)) {
            throw new ExpressionException(token, "regex is not a String but a " + regex.getClass().getSimpleName());
        }
        try {
            return ((String) self).matches((String) regex);
        } catch (PatternSyntaxException e) {
            throw new ExpressionException(token, e.getLocalizedMessage());
        }
    }

    @Override
    public String toString() {
        return left.toString() + ".matches(" + right.toString() + ")";
    }
}
