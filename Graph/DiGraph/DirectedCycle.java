public class DirectedCycle{
	private boolean [] marked;
	private int [] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;

	public DirectedCycle(Digraph G){
		onStack = new boolean[G.V()];
		edgeTo = new int [G.V()];
		marked = new boolean[G.V()];
		for(int v=0; v<G.V(); v++)
			if(!marked[v]) dfs(G,v);
	}

	private void dfs(Digraph G,int v){
		onStack[v] = true;
		marked[v] = true;
		for(int w: G.adj(v))
			if(this.hasCycle()) return;
		else if(!marked[w]){
			edgeTo[w] = v;
			dfs(G,w);
		}else if(onStack[w]){
			cycle = new Stack<Integer>();
			for(int x=v; x!=w; x=edgeTo[x])
				cycle.push(x);
			cycle.push(w);
			cycle.push(v);
		}
		onStack[v] = false;
	}

	private boolean hasCycle(){
		return cycle != null;
	}

	public Iterable<Integer> cycle(){
		return cycle;
	}
}
/*对于求无向图中的环，我们根据其中的是否出现两次被标记过的点即可，但是对于我们在有向图中，
我们需要对于这个图中的一些每一次压入栈中进行一个保存，只要同时被压入一个栈中的出现两次，我们
就可以认为这个有向图中是存在一个环路的*/