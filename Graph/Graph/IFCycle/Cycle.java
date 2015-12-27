public class Cycle{
	private boolean [] marked;
	private boolean hasCycle;
	public Cycle(Graph G){
		marked = new boolean(G.V());
		for(int s=0; s<G.V(); s++)
			if(!marked[s])
				dfs(G,s,s);
	}

	private void dfs(Graph G,int v,int u){
		marked[v] = true;
		for(int w: G.adj(v))
			if(!marked[w])
				dfs(G,w,v);
			else if(w!=u) hasCycle = true;
	}
	
	public boolean hasCycle(){
		return hasCycle;
	}
}

/*判断其中的点是否被标识过，在对其进行深度遍历的时候，我们传入两个参数一个是下一个
遍历的结点还有一个当前结点，判断这个结点是否被标记过，如果遇到一个未被标记过的结点
我们对其进行一个判断，判断其值和我们的上一个结点是否相同，如果不相同，则表示出现了环
*/