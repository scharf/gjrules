package gr.scharf.rules.expression;

import gr.scharf.rules.StateStore;

public interface IExpression {
    Object eval(StateStore store) throws ExpressionException;

    boolean test(StateStore store) throws ExpressionException;
}
