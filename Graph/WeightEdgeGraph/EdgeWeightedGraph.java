public class EdgeWeightedGraph{
	private fianl int V;
	private int E;
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int v){
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int v=0; v<V; v++)
			adj[v] = new Bag<Edge>();
	}

	public EdgeWeightedGraph(In in){
		
	}

	public int V(){return V;}
	public int E(){return E;}

	public void addEdge(Edge e){
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	public Iterable <Edge> adj(int v){return adj[v];}

}