public class DeepthFirstPaths{
	private boolean [] marked;
	private int [] edgeTo;
	private final int s;

	public DeepthFirstPaths(Graph G,int s){
		marked = new boolean[G.V()];
		edgeTo = new in[G.v()];
		this.s = s;
		dfs(G,s);
	}

	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(G, w);
			}
		}
	}

	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer> ();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}

/*借助于深度优先的遍历算法，实现对于给定两个结点的路径搜索，首先一个结点是在构造函数中传入的，然后根据创建其
路径图
能够到达的结点通过marked数组进行一个标记，表示可以到达，然后获取其路径的时候，先做一个判断，如果两个点之间存在路径
那么其就要进行向下一个结点进行转移，通过数组标记其到达该结点的上一个结点，一旦该点被标记过之后，不会被重复标记。
*/