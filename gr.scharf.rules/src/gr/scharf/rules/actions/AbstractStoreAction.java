package gr.scharf.rules.actions;

import gr.scharf.rules.StateStore;

public abstract class AbstractStoreAction implements IAction {

	protected StateStore store;

	public void setStore(StateStore store) {
		this.store = store;
	}

}
