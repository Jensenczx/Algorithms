public class TwoColor{
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable = true;
	public TwoColor(Graph G){
		marked = new boolean[G.V()];
		color = new boolean[G.V()];
		for(int s=0; s<G.V(); s++)
			if(!marked[s])
				dfs(G,s);
	}

	private void dfs(Graph G,int v){
		marked[v] = true;
		for(int w: G.adj(v))
			if(!marked[w]){
				color[w] = !color[v];
				dfs(G,w);
			}else if(color[w]==color[w]) isTwoColorable = false;
	}

	public boolean ifBipartite(){
		return isTwoColorable;
	}
}

/*对于每一个结点，通过booleanl类型的变量进行标记，然后每当我们经过深度遍历再向下遍历
当前结点未被标记的时候，做一个判断，然后根据这个结点将其置为和上一个结点相同的值，这样
遇到被标记的点，判断该点的颜色和当前点是否一样，如果一样则说明无法将其拆分为一个二分图。*/


/*对于图的一些操作，我们进行的操作大多为通过标记数组的形式来对其进行标记判断*/