package gr.scharf.rules;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
	private StateStore store = new StateStore();
	private List<Rule> rules = new ArrayList<Rule>();

	public RuleEngine() {
		super();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			store.clearDirtyState();
			for (Rule rule : rules) {
				rule.execute();
			}

			if (!store.isDirtyState()) {
				break;
			}
		}
	}

	public void addRule(Rule rule) {
		rule.setStore(store);
		rules.add(rule);
	}

	public void defineState(String name, State state) {
		store.define(name, state);
	}
}
