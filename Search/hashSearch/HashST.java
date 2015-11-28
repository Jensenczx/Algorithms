public class HashST <Key,Value>{
	private int M;
	private int N;
	private SequenceST <Key,Value>[]st;
	public HashST(int M){
		this.M = M;
		st = (SequenceST <Key,Value>[]) new SequenceST[M];
		for(int i=0; i<M; i++)
			st[i] = new SequenceST();
	}

	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}

	public Value get(Key key){
		return (Value)st[hash(key)].get(key);
	}

	public void put(Key key,Value val){
		st[hash(key)].put(key,val);
	}
}