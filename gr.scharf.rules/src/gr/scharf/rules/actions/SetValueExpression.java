package gr.scharf.rules.actions;

import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.ExpressionParser;
import gr.scharf.rules.expression.IExpression;

public class SetValueExpression extends AbstractStoreAction {
    String      name;
    IExpression expression;

    public SetValueExpression(String name, String expression) throws ExpressionException {
        super();
        this.name = name;
        this.expression = new ExpressionParser().parseVQL(expression);
    }

    @Override
    public void run() throws ExpressionException {
        store.setValue(name, expression.eval());
    }

    @Override
    public void setStore(StateStore store) throws ExpressionException {
        expression.setStore(store);
        super.setStore(store);
    }
}
