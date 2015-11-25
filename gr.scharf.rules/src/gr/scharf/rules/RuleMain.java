package gr.scharf.rules;

import gr.scharf.rules.actions.PrintStoreAction;
import gr.scharf.rules.actions.SetValueAction;
import gr.scharf.rules.condition.EqualsCondition;
import gr.scharf.rules.condition.ICondition;

public class RuleMain {

	private static RuleEngine ruleEngine;

	public static void main(String[] args) {
		ruleEngine = new RuleEngine();

		ruleEngine.defineState("SVNR", new State(42));
		ruleEngine.defineState("Background", new State("blue"));
		ruleEngine.addRule(new Rule(new EqualsCondition("SVNR", 42), new SetValueAction("Background", "red")));
		ruleEngine.addRule(new Rule(new EqualsCondition("Background", "red"), new SetValueAction("SVNR", 43)));
		ruleEngine.addRule(new Rule(new EqualsCondition("SVNR", 43), new SetValueAction("SVNR", 42)));
		ruleEngine.addRule(new Rule(new ICondition() {

			public boolean test() {
				return true;
			}

			public void setStore(StateStore store) {

			}
		}, new PrintStoreAction()));

		ruleEngine.run();
	}

}
