public class DepthFirstOrder{
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;

	public DepthFirstOrder(DiGraph G){
		pre = new Queue<Integer>();
		post = new Queue<Integer>();
		reversePost = new Stack<Integer>();
		marked = new boolean[G.V()];
		for(int v=0; v<G.V; v++)
			if(!marked[v]) dfs(G,v);
	}

	private void dfs(DiGraph G,int v){
		pre.enqueue(v);
		marked[v] = true;
		for(int w:G.adj(v))
			if(!marked[w])
				dfs(G,w);
		post.enqueue(v);
		reversePost.push(v);
	}

	public Itreable<Integer> pre(){return pre;}
}