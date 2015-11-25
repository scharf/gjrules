package gr.scharf.rules.expression;

import gr.scharf.rules.StateStore;

public interface IExpression {
    Object eval(StateStore store) throws ExpressionException;

    /**
     * @param store
     * @return calls eval and makes sure the result is boolean (or throws an
     *         exception)
     * @throws ExpressionException
     */
    boolean test(StateStore store) throws ExpressionException;
}
