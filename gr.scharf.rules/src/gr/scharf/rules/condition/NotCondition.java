package gr.scharf.rules.condition;

import gr.scharf.rules.StateStore;

public final class NotCondition implements ICondition {
	ICondition filter;

	public NotCondition(ICondition filter) {
		this.filter = filter;
	}

	public boolean test() {
		return !filter.test();
	}

	public void setStore(StateStore store) {
		filter.setStore(store);
	}
}
