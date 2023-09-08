//import syntax.Kind;
//import syntax.Token;
//import syntax.tree.expression.Binary;
//import syntax.tree.expression.Expression;
//import syntax.tree.expression.Number;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Parser {
//    private List<Token> tokens;
//    private int position;
//
//    public Parser(String input) {
//        List<Token> tokenList = new ArrayList<>();
//        Lexer lexer = new Lexer(input);
//        Token token;
//        do {
//            token = lexer.nextToken();
//            if(token.kind != Kind.WHITESPACE && token.kind != Kind.BAD_SYNTAX) {
//                tokenList.add(token);
//            }
//        } while (token.kind != Kind.END_OF_FILE);
//        tokens = tokenList;
//    }
//
//    public Expression Parse() {
//        Expression left = parsePrimary();
//        while(current().kind == Kind.PLUS || current().kind == Kind.MINUS) {
//            Token operator = nextToken();
//            Expression right = parsePrimary();
//            left = new Binary(left, operator, right);
//        }
//        return left;
//    }
//
//    private Expression parsePrimary() {
//        Token numberToken = match(Kind.NUMBER);
//        return new Number(numberToken);
//    }
//    private Token match(Kind kind) {
//        if(current().kind == kind) {
//            return  nextToken();
//        }
//        return new Token(kind, current().position, null, null);
//    }
//
//    private Token nextToken() {
//        Token current = current();
//        position++;
//        return current;
//    }
//
//    private Token peek(int offset) {
//        int index = position + offset;
//        if (index >= tokens.size())
//            return tokens.get(tokens.size() - 1);
//
//        return tokens.get(index);
//    }
//    private Token current() {
//        return peek(0);
//    }
//}
