package gr.scharf.rules.expression;

import gr.scharf.rules.StateStore;

public interface IExpression {
    Object eval() throws ExpressionException;

    void setStore(StateStore store);

}
