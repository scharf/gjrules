package gr.scharf.rules.condition;

import gr.scharf.rules.StateStore;

public final class AndCondition implements ICondition {
	ICondition[] filters;

	public AndCondition(ICondition... filter) {
		this.filters = filter;
	}

	public boolean test() {
		for (ICondition filter : filters) {
			if (!filter.test()) {
				return false;
			}
		}

		return true;
	}

	public void setStore(StateStore store) {
		for (ICondition iCondition : filters) {
			iCondition.setStore(store);
		}
	}
}
