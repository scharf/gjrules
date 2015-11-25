package gr.scharf.rules.condition;

import gr.scharf.rules.StateStore;

public class EqualsCondition implements ICondition {

	private StateStore store;
	private String name;
	private Object value;

	public EqualsCondition(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public boolean test() {
		return value.equals(store.getValue(name));
	}

	public void setStore(StateStore store) {
		this.store = store;
	}

}
