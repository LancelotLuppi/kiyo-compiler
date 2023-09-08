
import org.apache.commons.lang3.StringUtils;
import syntax.Kind;
import syntax.Token;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.print("> ");
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            if(StringUtils.isBlank(line))
                return;

            Lexer lexer = new Lexer(line);
            while (true) {
                Token token = lexer.nextToken();

                if(token.kind == Kind.END_OF_FILE)
                    break;
                System.out.print(token.kind + ": " + "{" + token.input + "} ");
                if(token.value != null)
                    System.out.println(token.value);
                else
                    System.out.println();
            }
        }
    }
}