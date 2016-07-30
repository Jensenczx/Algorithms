public class PrimMST{
	private Edge[] edgeTo;
	private double[] distTo;
	private boolean[] marked;
	private IndexMinPQ<Double> pq;

	public PrimMST(EdgeWeightedGraph G){
		//初始化边的数组，标记数组
		edgeTo = new Edge[G.V();
		distTo = new double[G.V()];
		marked = new boolean[G.V()];
		for(int v=0; v<G.V(); v++)
			distTo[v] = Double.POSITIVE_INFINITY;
		pq = new IndexMinPQ<Double>(G.V());
		distTo = 0.0;
		pq.insert(0,0.0);
		while(!pq.isEmpty())
			visit(G,pq.delMin());
	}

	private void visit(EdgeWeightedGraph G,int v){
		marked[v] = true;
		for(Edge e: G.adj(v)){
			int w = e.other(v);
			if(marked[w]) continue;
			if(e.weight()<distTo[w]){
				edgeTo[w] = e;
				distTo[w] = e.weight;
				if(pq.contains(w)) pq.change(w,distTo[w]);
				else pq.change[w,distTo[w]];
			}
		}
	}
}
