package syntax;

import syntax.tree.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Token extends Node {
    public Kind kind;
    public int position;
    public String input;
    public Object value;
    public Token(Kind kind, int position, String in, Object value) {
        this.kind = kind;
        this.position = position;
        this.input = in;
        this.value = value;
    }


//    @Override
//    public List<T> getChildren() {
//        return new ArrayList<>();
//    }
}
