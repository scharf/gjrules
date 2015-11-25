package gr.scharf.rules.expression.impl;

import gr.scharf.expr.parser.lexer.IToken;
import gr.scharf.rules.StateStore;
import gr.scharf.rules.expression.ExpressionException;
import gr.scharf.rules.expression.IExpression;

enum COMP_OP {
    LT, LE, EQ, NE, GE, GT, UNKNOWN
};

class ExprCompare extends AbstractBinaryExpr {
    protected final COMP_OP operation;

    ExprCompare(IToken token, IExpression left, IExpression right) {
        super(token, left, right);
        switch (token.getString()) {
        case "<":
            operation = COMP_OP.LT;
            break;
        case "<=":
            operation = COMP_OP.LE;
            break;
        case "==":
            operation = COMP_OP.EQ;
            break;
        case "!=":
            operation = COMP_OP.NE;
            break;
        case ">=":
            operation = COMP_OP.GE;
            break;
        case ">":
            operation = COMP_OP.GT;
            break;
        default:
            operation = COMP_OP.UNKNOWN;
            break;
        }
    }

    @Override
    public Object eval() throws ExpressionException {
        Object left = this.left.eval();
        Object right = this.right.eval();
        if (left instanceof Number && right instanceof Number && left.getClass() != right.getClass()) {
            if (left instanceof Double) {
                right = new Double(((Number) right).doubleValue());
            } else if (right instanceof Double) {
                left = new Double(((Number) left).doubleValue());
            } else {
                left = new Long(((Number) left).longValue());
                right = new Long(((Number) right).longValue());
            }
        }
        switch (operation) {
        case EQ: {
            if (left == null || right == null)
                return left == right;
            else
                return left.equals(right);
        }
        case NE: {
            if (left == null || right == null)
                return left != right;
            else
                return !left.equals(right);
        }
        default:
            break;
        }
        if (left == null) {
            throw new ExpressionException(token, "left operand is null");
        }
        if (right == null) {
            throw new ExpressionException(token, "right operand is null");
        }
        if (!(left instanceof Comparable)) {
            throw new ExpressionException(token, "left operand is not comparable");
        }
        if (!(right instanceof Comparable)) {
            throw new ExpressionException(token, "right operand is not comparable");
        }
        int cmp = -1;
        try {
            cmp = compareTo(left, right);
        } catch (Throwable t) {
            throw new ExpressionException(token, "" + t);
        }
        switch (operation) {
        case LT:
            return cmp < 0;
        case LE:
            return cmp <= 0;
        case GE:
            return cmp >= 0;
        case GT:
            return cmp > 0;
        default:
            throw new ExpressionException(token, "operator '" + token.getString() + "' not supported");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private int compareTo(Object left, Object right) {
        return ((Comparable) left).compareTo(right);
    }

    @Override
    public void setStore(StateStore store) throws ExpressionException {
        if (operation == COMP_OP.UNKNOWN) {
            throw new ExpressionException(token, "Unknown operator: " + token.getString());
        }
        super.setStore(store);
    }
}
