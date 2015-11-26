package gr.scharf.rules.actions;

import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;

public interface IAction extends Runnable {

    void setStore(StateStore store) throws ExpressionException;

}
