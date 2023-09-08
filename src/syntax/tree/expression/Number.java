package syntax.tree.expression;

import syntax.Kind;
import syntax.Token;
import syntax.tree.expression.Expression;

public class Number extends Expression {
    public Token token;
    public Number(Token token) {
        this.token = token;
    }
    public Kind kind = Kind.NUMBER_EXPRESSION;
}
