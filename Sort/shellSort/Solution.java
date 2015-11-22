public class Solution{
	public static void shellSort(int [] array){
		if(array==null)
			return;
		int length = array.length;
		int h = 1;
		while(h<length/3)
			h = h*3+1;
		while(h>=1){
			for(int i=h; i<length; i++){
				for(int j=i;j>=h&&array[j]<array[j-h];j-=h){
					int tmp = array[j];
					array[j] = array[j-h];
					array[j-h] = tmp;
				}
			}
			h=h/3;
		}
	}

	public static void main(String []args){
		int []array = {3,4,5,7,2,1};
		shellSort(array);
		for(int i: array){
			System.out.println(i);
		}
	}
}