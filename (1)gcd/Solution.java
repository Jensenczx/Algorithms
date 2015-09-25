public class Solution{

	public int gcd(int p,int q){
		if(q==0) return p;
		int r=p%q;
		return gcd(q,r);
	}

	public static void main (String [] args){
		int[] num1={1,2,0};
		int[] num2={0,4,9};
		int[] num3=new int[3];
		for(int i=0; i<3; i++){
			num3[i] = gcd(num1[i])+gcd(num2[i]);
		}
	}
}