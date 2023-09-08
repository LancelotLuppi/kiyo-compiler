import org.apache.commons.lang3.StringUtils;
import syntax.Kind;
import syntax.Token;

public class Lexer {
    private String input;
    private int position;

    public Lexer(String in) {
        this.input = in;
    }

    private char current() {
        if(position >= input.length())
            return '\0';

        return input.charAt(position);
    }
    private void nextPosition() {
        position++;
    }

    public Token nextToken() {
        // numbers
        // + - * ( )
        // whitespaces

        if(position >= input.length())
            return new Token(Kind.END_OF_FILE, position, "\0", null);


        // Keep reading numbers
        if(Character.isDigit(current())) {
            int start = position;

            while(Character.isDigit(current()))
                nextPosition();
            int length = position - start;
            String text = input.substring(start, start + length);
            int value = tryParseInt(text);
            return new Token(Kind.NUMBER, start, text, value);
        }
        // Keep reading whitespaces
        if(Character.isWhitespace(current())) {
            int start = position;

            while(Character.isWhitespace(current()))
                nextPosition();
            int length = position - start;
            String text = input.substring(start, start + length);
            return new Token(Kind.WHITESPACE, start, text, null);
        }
        // Reads everything else
        switch (current()) {
            case '+':
                return new Token(Kind.PLUS, position++, "+", null);
            case '-':
                return new Token(Kind.MINUS, position++, "-", null);
            case '*':
                return new Token(Kind.ASTERISK, position++, "*", null);
            case '/':
                return new Token(Kind.SLASH, position++, "/", null);
            case '(':
                return new Token(Kind.OPEN_PARENTHESIS, position++, "(", null);
            case ')':
                return new Token(Kind.CLOSE_PARENTHESIS, position++, ")", null);
            default:
                return new Token(Kind.BAD_SYNTAX, position++, String.valueOf(input.charAt(position-1)), null);
        }
    }

    private int tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception ex) {
            return 0;
        }
    }
}
