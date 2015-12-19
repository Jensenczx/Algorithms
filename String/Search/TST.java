public class TST<Value>{
	private Node root;
	private class Node{
		char c;
		Node left,mid ,right;
		Value val;
	}

	private Node get(Node x,String key,int d){
		if(x==null) return null;
		char c = key.charAt(d);
		if(c<x.c) return get(x.left,key,d);
		if(c>x.c)  return get(x.right,key,d);
		else if(d<key.length()-1)
			return get(x.mid,key,d+1);
		else return x;
	}

	public void put(String key,Value val){
		root = put(root,key,val,0);
	}

	private Node put(Node x,String key,Value val,int d){
		char c = key.charAt(d);
		if(x==null){x= new Node(); x.c=c};
		if(c<x.c) x.left = put(x.left,key,val,d);
		else if(c>x.c) x.right = put(x.right,key,val,d);
		else if(d<key.length()-1)
			 x.mid = put(x.mid,key,val,d+1);
		else x.val = val;
		return x;
	}
}

/*相比于单词查找树，三向单词查找树减少了对于空间的消耗，但是增加了在查找和插入的时间复杂度，采用首字母为单词表的
形式可以提升我们的查找速度的同时减少空间消耗。*/