public class DirectedDFS{
	private boolean [] marked;
	public DirectedDFS(Digraph G,int s){
		marked = new boolean[G,V()];
		dfs(G,s);
	}

	public DirectedDFS(Digraph G,Iterable<Integer> sources){
		marked = new boolean[G.V()];
		for(int s: sources)
			if(!marked[s]) dfs(G,s);
	}

	private void dfs(Digraph G,int v){
		marked[v] = true;
		for(int w: G.adj(v))
			if(!marked[w]) dfs(G,w);
	}

	public boolean marked(int v){
		return marked[v];
	}

}

/*实际应用，垃圾回收机制，我们将每一个对象表示成一个结点，然后每一个对其的引用作为一个边
如果是对其进行引用就是指向这个点，然后我们检测这个对象当前还是否处于可到达的状态，
然后对于那些当前不可以到达 的结点进行一个清理操作，如何实现呢？当前程序中可以直接访问的对象出发，然后进行
遍历，遍历一遍之后，检测一下，还有那些结点没有到达的，删除清理掉。*/