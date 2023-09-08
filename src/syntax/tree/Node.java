package syntax.tree;

import syntax.Kind;

import java.util.List;

public abstract class Node {
    public Kind kind;
    public List<Node> children;

//    public abstract List<Node> getChildren();
}
