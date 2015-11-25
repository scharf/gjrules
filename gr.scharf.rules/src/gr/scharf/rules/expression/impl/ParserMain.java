package gr.scharf.rules.expression.impl;

import gr.scharf.rules.State;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionParser;
import gr.scharf.rules.expression.IExpression;

public class ParserMain {

    public static void main(String[] args) {
        parse("42");
        parse("t");
        parse("f");
        parse("not true");
        parse("not f");
        parse("f or f");
        parse("f or t");
        parse("f and t");
        parse("f and t or false");
    }

    private static void parse(String expression) {
        StateStore store = new StateStore();
        store.define("t", new State(true));
        store.define("f", new State(false));

        ExpressionParser parser = new ExpressionParser();
        try {
            IExpression expr = parser.parseVQL(expression);
            System.out.println(expr + " -> " + expr.eval(store));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
