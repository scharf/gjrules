package gr.scharf.rules;

import gr.scharf.rules.actions.SetValueAction;
import gr.scharf.rules.expression.ExpressionException;

public class RuleMain {

    public static void main(String[] args) throws ExpressionException {
        RuleEngine ruleEngine = createStore();

        System.out.println("Run");
        ruleEngine.run();

        ruleEngine = createStore();
        System.out.println("");
        System.out.println("Rune each rule at most one time:");
        ruleEngine.runOnce();
    }

    private static RuleEngine createStore() throws ExpressionException {
        RuleEngine ruleEngine = new RuleEngine();

        ruleEngine.defineState("SVNR", new State(42));
        ruleEngine.defineState("Background", new State("blue"));
        ruleEngine.defineState("style", new State("male"));
        ruleEngine.addRule(new Rule("SVNR==44", new SetValueAction("SVNR", 42)));
        ruleEngine.addRule(new Rule("SVNR==43", new SetValueAction("SVNR", 44)));
        ruleEngine.addRule(new Rule("SVNR==42", new SetValueAction("Background", "red")));
        ruleEngine.addRule(new Rule("SVNR!=42", new SetValueAction("Background", "blue")));
        ruleEngine.addRule(new Rule("SVNR==42", new SetValueAction("SVNR", 43)));
        ruleEngine.addRule(new Rule("SVNR>=44", new SetValueAction("SVNR", 100)));
        ruleEngine.addRule(new Rule("Background == 'red'", new SetValueAction("style", "female")));
        ruleEngine.addRule(new Rule("Background == 'blue'", new SetValueAction("style", "male")));
        return ruleEngine;
    }

}
