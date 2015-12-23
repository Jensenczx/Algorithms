public class RabinKarp{
	private String pat;
	private long patHash;
	private int M;
	private long Q;
	private int R = 256;
	private long RM;

	public RabinKarp(){
		this.pat = pat;
		this.M = pat.length();
		Q = longRandomPrime();
		RM = 1;
		for(int i=1; i<=M-1; i++)
			RM = (R*RM)%Q;
		patHash = hash(pat,M);
	}

	public boolean check(int i){return true;}

	private long hash(String key,int M){
		long h =0;
		for(int j=0; j<M; j++)
			h = (R*h+key.chatAt(j))%Q;
		return h;
	}

	private int search(String txt){
		int N = txt.length();
		long txtHash = hash(txt,M);
		if(patHash==tetHash&&check(0)) return true;
		for(int i=M; i<N; i++){
			txtHash = (txtHash+Q-RM*text.charAt(i-M)%Q)%Q;
			txtHash = (texHash*R+txt.charAt(i))%Q;
			if(patHash==txtHash)
				if(check(i-M+1)) return i-M+1;
		}
		return N;
	}
}
/*对于该种算法，和我们常规使用的通过hash值的方式进行一个比对，但是由于每次都需要进行一个计算，时间复杂度会很高
因此对该种算法我们进行了改进，改进在对于hash值的计算提升上，当我们得出了第一个长度匹配串之后，对于后面的hash值的计算，每增加一个值的时候，我们
只需要在此基础上进行一个计算就好了，而不需要在从字符串的开始进行一个计算比对。计算过程先计算一个匹配的，然互根据这个值前进*/