package gr.scharf.rules.expression;

import gr.scharf.expr.parser.builder.ExprParser;
import gr.scharf.expr.parser.lexer.ILexer;
import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.expr.parser.lexer.Lexer;
import gr.scharf.expr.parser.parser.ParseException;
import gr.scharf.rules.Rule;
import gr.scharf.rules.RuleEngine;
import gr.scharf.rules.State;
import gr.scharf.rules.actions.IAction;
import gr.scharf.rules.actions.SetValueExpression;
import gr.scharf.rules.expression.impl.ExpressionBuilder;

public class ExpressionParser {

    private RuleEngine engine;
    private IToken     token;
    private ILexer     lexer;

    public ExpressionParser() {

    }

    public void parseRules(RuleEngine engine, String rules) throws ExpressionException {
        this.engine = engine;
        lexer = new Lexer(rules);
        token = lexer.nextToken();
        switch (token.getString()) {
        case "define":
            nextToken();
            parseDefine();
            break;
        default:
            parseRule();
            break;
        }
    }

    private void parseRule() throws ParseException, ExpressionException {
        IExpression condition = parseExpression();
        lexer.useCurrentTokenAsNextToken();
        nextToken();
        if (":".equals(token.getString())) {
            throw new ParseException(token, ": expected");
        }
        nextToken();
        String name = parseIdentifier();
        IExpression expr = parseExpression();
        IAction action = new SetValueExpression(name, expr);
        engine.addRule(new Rule(condition, action));
    }

    private IExpression parseExpression() throws ExpressionException {
        ExprParser<IExpression, ExpressionException> exprParser = new ExprParser<IExpression, ExpressionException>(
                new ExpressionBuilder(),
                true);
        return exprParser.parse(lexer);
    }

    IAction parseAction() {

        return null;
    }

    private void nextToken() {
        token = lexer.nextToken();
    }

    private void parseDefine() throws ExpressionException {
        String varName = parseIdentifier();
        nextToken();
        if (!"=".equals(token.getString())) {
            throw new ParseException(token, "Identifier expected");

        }
        nextToken();
        IExpression expr = parseExpression();
        expr.setStore(engine.getStore());
        engine.defineState(varName, new State(expr.eval()));
        nextToken();
        if (";".equals(token.getString())) {
            throw new ParseException(token, "; expected");

        }
    }

    private String parseIdentifier() {
        if (!token.getType().isIdentifier()) {
            throw new ParseException(token, "Identifier expected");
        }
        return token.getString();
    }

    public IExpression parseExpression(String expression) throws ExpressionException {
        lexer = new Lexer(expression);
        nextToken();
        return parseExpression();
    }
}
