import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Tree {
  Node root;

  class Node {
    int key;
    String data;

    Node parent;
    List<Node> children;

    Node(int key, String data) {
      this.key = key;
      this.data = data;
      this.children = new ArrayList<>();
      this.parent = null;
    }
  }

  public void buildTree() {
    // build a tree from the array "parent"
    Node[] nodes = new Node[this.parent.length];
    for (int key = 0; key < this.parent.length; key++) {
      Node node = new Node(key, "");
      nodes[key] = node;
    }
    for (int key = 0; key < this.parent.length; key++) {
      if (parent[key] != -1) {
        nodes[key].parent = nodes[parent[key]];
        nodes[parent[key]].children.add(nodes[key]);
      } else {
        this.root = nodes[key];
      }
    }
  }

  int n;
  int[] parent;

  void read() throws IOException {
    FastScanner in = new FastScanner();
    n = in.nextInt();
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = in.nextInt();
    }
  }

  public int optimizedComputeHeight() {
    return optimizedComputeHeight(this.root);
  }

  public int optimizedComputeHeight(Node node) {
    if (node == null) {
      return 0;
    }
    int maxHeight = 0;
    for (Node child : node.children) {
      int height = optimizedComputeHeight(child);
      if (maxHeight < height) {
        maxHeight = height;
      }
    }
    return maxHeight + 1;
  }

  int naiveComputeHeight() {
    // Replace this code with a faster implementation
    int maxHeight = 0;
    for (int vertex = 0; vertex < n; vertex++) {
      int height = 0;
      for (int i = vertex; i != -1; i = parent[i])
        height++;
      maxHeight = Math.max(maxHeight, height);
    }
    return maxHeight;
  }

  class FastScanner {
    StringTokenizer tok = new StringTokenizer("");
    BufferedReader in;

    FastScanner() {
      in = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
      while (!tok.hasMoreElements())
        tok = new StringTokenizer(in.readLine());
      return tok.nextToken();
    }

    int nextInt() throws IOException {
      return Integer.parseInt(next());
    }
  }
}
