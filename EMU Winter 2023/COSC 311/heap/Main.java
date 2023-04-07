import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Tree tree = new Tree();
    tree.read();
    tree.buildTree();
    System.out.println(tree.optimizedComputeHeight());
  }
}
