public class LazyPrimMST{
	private boolean[] marked;
	private Queue<Edge> mst;
	private MinPQ<Edge> pq;

	public LazyPrimMST(EdgeWeightedGraph G){
		pq = new MinPQ<Edge>();
		marked = new boolean[G.V()];
		mst = new Queue<Edge>();
		visit(G,0);
		while(!pq.isEmpty()){
			Edge e = pq.delMin();
			int v = e.either(),w=e.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.enqueue(e);
			if(!marked[v]) visit(G,v);
			if(!marked[w]) visit(G,w);
		}
	}

	private void visit(EdgeWeightedGraph G,int v){
		marked[v] = true;
		for(Edge e: G.adj(v))
			if(!marked[e.other(v)]) pq.insert(e);
	}

	public Iterable<Edge> edges(){return mst;}

	public double weight(){}
}

/*the impleamtion of algorithm Prim,First we add a node to the MST
by the method visit,we will add all the node which can arrived to,then
we then ,we get the min Edge to see if the edge to point has been marked,
if the point has been marked,we should add it to the minqueue*/