public class BoyerMoore{
	private int[] right;
	private String pat;
	BoyerMoore(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		right = new int[R];
		for(int c=0; c<R; c++){right[c]=-1;}
		for(int j=0; j<M; j++)
			right[pat.charAt(c)] = j;
	}
	//将每一个字母的位置标记为-1，然后根据匹配串，将其更新为最大值

	//构造最右匹配数组
	public int search(String txt){
		int N = txt.length();
		int M = pat.length();
		int skip;
		for(int i=0; i<=N-M; i+=skip){
			skip = 0;
			for(int j=M-1; j>=0; j--)
				if(pat.charAt(j)!=txt.charAt(i+j)){
					skip = j - right[txt.charAt(i+j)];
					if(skip<1) skip = 1;
					break;
				}
				if(skip==0) return i;
		}
		return N;
	}

}

/*查找匹配的时候，从文本第一个位置开始，然后内循环中对匹配字符串从最后一个单词开始，如果匹配则内循环继续向下逐个单词进行匹配，如果不匹配的话
则寻找最后该位单词的最右匹配，判断其是否符合，因此也就是我们所谓的跳数，即为当前当前正在匹配的字符串的位置减去我们的最右子数组的位置得到的就是我们下一条的位置，
外层的循环最大值为N-M,外层循环的前进量为我们的跳数。如果*/