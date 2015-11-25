package gr.scharf.rules;

import gr.scharf.rules.actions.IAction;
import gr.scharf.rules.condition.ICondition;

public class Rule {
	private ICondition condition;
	private IAction action;

	public Rule(ICondition condition, IAction action) {
		this.condition = condition;
		this.action = action;
	}

	public void setStore(StateStore store) {
		condition.setStore(store);
		action.setStore(store);
	}

	public void execute() {
		if (condition.test()) {
			action.run();
		}
	}
}
