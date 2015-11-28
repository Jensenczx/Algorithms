public class LinearProbingHashST<Key,Value>{
	private int N;
	private int M =16;
	private Key[] keys;
	private Value[] values;
	public LinearProbingHashST(){
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}
	private int hash(Key key){
		return (key.hashCode()&0x7fffffff)%M;
	}
/*为了保持较高的效率，当我们的值的数量已经达到我们给定区间的一半的时候，我们对其进行一个扩充，然后对其进行扩充，
	//我们因此还需要对其进行散列，这个时候，我们需要按照我们当前的大小进行一个插入操作，这个时候,我们要对其再进行一次更新，
	这个时候，我们需要借助于一个相同的对象来实现我们的这些操作。
	*/
	private void reSize(int capcity){
		LinearProbingHashST <Key,Value> t = new LinearProbingHashST<Key,Value>(capcity);
		for(int i=0; i<M; i++)
			if(keys[i]!=null)
				t.put(keys[i],values[i]);
			keys = t.keys;
			values = t.values;
			M = t.M;
	}

	public void put(Key key,Value value){
		if(N>=M/2)
			reSize(2*M);
		int i;
		for(i=hash(key);keys[i]!=null; i=(i+1)%M){
			if(keys[i].equals(key)){
				values[i] = value;
				return;
			}
			keys[i] = key;
			values[i] = value;
			N++;
		}
	}

	public Value get(Key key){
		for(int i=hash(key);keys[i]!=null; i=(i+1)%M)
			if(keys[i]==key)
				return values[i];
		return null;
	}
}