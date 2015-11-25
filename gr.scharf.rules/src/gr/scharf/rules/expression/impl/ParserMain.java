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
        parse("t and dontknow");
        parse("f and t");
        parse("f and t or false");
        parse("t and print(42)");
        parse("t = 6");
        parse("t then");
        parse("1 + 2 * 3 / 4 % 5 ^ 6 | 7 & 8 >> 9 << 10 mod 12");
    }

    private static void parse(String expression) {
        StateStore store = new StateStore();
        store.define("t", new State(true));
        store.define("f", new State(false));
        store.define("a", new State(1));
        store.define("b", new State(2));

        ExpressionParser parser = new ExpressionParser();
        try {
            IExpression expr = parser.parseVQL(expression);
            expr.setStore(store);
            System.out.println(expr + " -> " + expr.eval());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
