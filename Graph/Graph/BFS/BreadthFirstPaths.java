public class BreadthFirstPaths{
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;

	public BreadthFirstPaths(Graph G,int s){
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s = s;
		bfs(G,s);
	}

	private void bfs(Graph G,int s){
		Queue<Integer> queue = new Queue();
		marked[s] = true;
		queue.enqueue(s);
		while(!queue.isEmpty()){
			int v = queue.dequeue();
			for(int w: G.adj(v))
				if(!marked[w]){
					edgeTo[w] = v;
					marked[w] = true;
					queue.enqueue(w);
				}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v; x!=s; x=edgeTo(x))
			path.push(x);
		path.push(s);
		return path;
	}

}

/*对于图的广度遍历，通过广度遍历，我们可以得到我们到该点的最短路径，首先我们创建一个队列，然后将我们的顶点加入到其中
然后将我们的结点加入到该队列之中，然后在对队列中的点所到达的点进行遍历遍历过的点进行一个标记，然后从队列中删除掉。
不断的删除，最后沟构造出我们的最短路径图。*/