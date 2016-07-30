public class SelectSort{
	
	public static void sort(int[] array) {
		int length = array.length;
		int min,flag = 0;
		for (int i = 0; i < length; i++) {
			min = array[i];
			flag = i;
			for (int j = i+1; j < length; j++) {
				if (array[j] < min) {
					min = array[j];
					flag = j;
				}
			}
			if (flag != i){
				array[flag] = array[i];
				array[i] = min;
			}
		}
	}
	public static void main (String []args){
		int [] array ={1,9,4,5};
		sort(array);
		for(int i: array)
			System.out.println(i);
	}
}