public class CPM{
	public static void main (String []args){
		int N = StdIn.readInt(); 
		StdIn.readLine();
		EdgeWeightedDigraph G;
		G = new EdgeWeightedDigraph(N*2+2);
		int s = 2*N, t = 2*N+1;
		for(int i=0; i<N; i++){
			String[] a = StdIn.readLine().split("\\s+");
			double duration = Double.parseDouble(a[0]);
			G.addEdge(new DirectedEdge(i,i+N,duration));
			G.addEdge(new DirectedEdge(s,i,0.0));
			G.addEdge(new DirectedEdge(s,i,0.0));
			for(int j=1; j<a.length; j++){
				
			}
		}
	}
}