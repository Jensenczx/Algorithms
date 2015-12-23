public class NFA{
	private char[] a;
	private Digraph G;
	private int M;

	public NFA(String regexp){
		//构造一个栈
		Stack<Integer> ops = new Stack<Integer>();
		//将正则表达式转化为字符数组
		re = regexp.toCharArray();
		// the length of the char array
		M = re.length;
		// construct a graph
		G = new Digraph(M+1);
		//add edge to the digraph
		for(int i=0; i<M; i++){
			int lp = i;
			if(re[i]=='('||re[i]=='|'))
				ops.push(i);
			//when it arrival ),we can get 
			else if(re[i]==')'){
				int or = ops.pop();
				if(re[or]=='|'){
					G.addEdge(lp,or+1);
					G.addEdge(or,i);
				}
				else lp = or;
			}
			if(i<M-1&&re[i+1]=='*'){
				G.addEdge(lp,i+1);
				G.addEdge(i+1,lp);
			}
			if(re[i]=='('||re[i]=='*'||re[i]==')')
				G.addEdge(i,i+1);
		}
	}

	public boolean recognizes(String txt){
		Bag<Integer> pc = new Bag<Integer>();
		DirectedDFS dfs = new DirectedDFS(G,0);
		for(int v=0; v<G.V(); v++)
			if(dfs.marked(v)) pc.add(v);
		//travel the text for finding the item;
		for(int i=0; i<txt.length; i++){
			Bag<Integer> match = new Bag<Integer>();
			//according the probelm to add the edge to the Bag,the edge is we can get to.
			for(int v:pc)
				if(v<M)
					if(re[v]==txt.charAt(i)||re[v]=='.')
						match.add(v+1);
			//then create a new bag which include the status next we will get to 
			pc = new Bag<Integer>();
			//according the DirectedDFS we can get to the where we want to go .
			dfs = new DirectedDFS(G,match);
			for(int v=0; v<G.V(); v++)
				if(dfs.marked(v)) pc.add(v);
		}
		for(int v:pc)if(v==M) return true;
		return false;
	}
}