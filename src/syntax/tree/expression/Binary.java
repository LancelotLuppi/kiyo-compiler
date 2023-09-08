package syntax.tree.expression;

import syntax.Kind;
import syntax.Token;
import syntax.tree.Node;

import java.util.List;

public class Binary extends Expression {
    public Expression left;
    public Expression right;
    public  Token operator;
    public Kind kind = Kind.BINARY_EXPRESSION;
    public Binary(Expression left, Token operator, Expression right) {
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

//    @Override
//    public List<Node> getChildren() {
//        return null;
//    }
}
