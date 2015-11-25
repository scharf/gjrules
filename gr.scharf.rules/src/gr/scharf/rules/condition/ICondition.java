package gr.scharf.rules.condition;

import gr.scharf.rules.StateStore;

public interface ICondition {
	boolean test();

	void setStore(StateStore store);
}
