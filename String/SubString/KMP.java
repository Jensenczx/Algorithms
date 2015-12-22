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
/*x代表我们的当前所要复位的位置，根据这个位置可以方便我们进行复位，对于该数组的构建也是KMP
算法的比较难理解的地方，通过对其前向数组的复制根据其前向数组能够到达的状态，决定当前可以到达的
状态，x表示在当前所处的位置上其回复的时候所要到达的位置。
*/
	public int search(String txt){
		int i,j,N=tex.length(),M = pat.length();
		for(i=0,j=0; i<N&&j<M;i++)
			j = dfa[txt.charAt(i)][j];
		if(j==M) return i-M;
		else return N;
	}
}
/*构造有限状态机，然后根据有限状态机进行对输入文本的全部全文遍历，最后得到我们所要求的结果*/
