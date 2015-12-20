public class KMP{
	private String pat;
	private int [][] dfa;
	public KMP(String pat){
		this.pat = pat;
		int M = pat.length();
		int R = 256;
		dfa = new int [R][M];
		dfa[pat.charAt(0)][0]=1;
		for(int x=0,j=1;j<M;j++){
			for(int c=0; c<R; c++)
				dfa[c][j] = dfa[c][X];
			dfa[pat.charAt(j)[j]] = j+1;
			X = dfa[pat.charAt(j)][X];
		}
	}

	public int search(String txt){
		int i,j,N=tex.length(),M = pat.length();
		for(i=0,j=0; i<N&&j<M;i++)
			j = dfa[txt.charAt(i)][j];
		if(j==M) return i-M;
		else return N;
	}
}
/*构造有限状态机，然后根据有限状态机进行对输入文本的全部全文遍历，最后得到我们所要求的结果*/
