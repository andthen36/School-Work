import java.util.*;
import java.io.*;

public class tree_height {
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

	public class TreeHeight {
		int n;
		int parent[];
		List<Integer>[] list;
		int root;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			list = new ArrayList[n];

			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int c = 0; c < n; c++){
				int parent = in.nextInt();
				if(parent == -1) root  = c;
				else list[parent].add(c);
			}
		}

		int computeHeight() {
			int maxHeight = 0;
			Queue<Integer> queue = new LinkedList<>();
			queue.add(root);
			while(!queue.isEmpty()){
				int pop = queue.remove();
				for(int v : list[pop]){
					 parent[v] = parent[pop] +1;
					 queue.add(v);
				}
				maxHeight = parent[pop] + 1;
			}
			return maxHeight;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
