package gr.scharf.rules.actions;

import gr.scharf.rules.StateStore;

public interface IAction extends Runnable {

	void setStore(StateStore store);

}
