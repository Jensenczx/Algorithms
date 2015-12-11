public class KruskalMST{
	private Queue<Edge> mst;
	private KruskalMST(EdgeWeightedGraph G){
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>()；
		for(Edge e:G.edges())
			pq.insert(e);
		UF uf = new UF(G.V());
		while(!pq.isEmpty()&&mst.size()<G.V()-1){
			Edge e = pq.delMin();
			int v = e.either();
			int w = e.other(v);
			if(uf.connected(v,w))continue;
			uf.union(v,w);
			mst.enqueue(e);
		}
	}

	public Iterable<Edge> edges(){return mst;}

	public double weight(){
		int weight=0;
		for(Edge e:mst)
			weight+=e.weight;
	}
}