public class DepthFirstSearch(){
	private  boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph G,int s){
		marked = new boolean[G.V()];
		dfs(G,s);
	}

	private void dfs(Graph G, int v){
		marked[v] = true;
		count++;
		for(int w : G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}

	public boolean marked(int w){
		return marked[w];
	}

	public int count(){
		return count;
	}
}
/*
我们首先创建一个标记数组，然后对其中的节点进行深度遍历，每次遍历的时候检测该节点是否已经是被走过，
如果走过退回到上一层的结点中，继续进行遍历。
*/