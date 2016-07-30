public class Graph{
	//表示图中结点数目
	private final int V;
	//表示图中的边数
	private int E;
	//用来存放图的邻接表
	private Bag<Integer>[] adj;


//邻接表结构，数组中的每一个元素里有一个邻接表。
	public Graph(int V){
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int v = 0; v < V; v++)
			adj[v] = new Bag<Integer>();
	}

//用来读取读取图信息，将边信息加入到图中，传入的数据是结点的编号
	public Graph(In in){
		this(in.readInt());
		int E = in.readInt();
		for(int i = 0; i < E; i++){
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v,w);
		}
	}

	public int V(){return V;}

	public int E(){return E;}

	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public Interable<Integer>adj(int v){
		return adj[v];
	}
}

/*首先根据给予的节点的数目创建一个数组，数组中存放一个邻接链表，然后躲在从外部读入数据，将关于变得信息填充到数组之中
然后再添加边，对于边，然后根据边提供的信息将其填充到邻接表中，然后通过adj我们就可以都得到我们的一个结点的信息，*/