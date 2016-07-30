public class InsertSort{

	public static void exch (int[]nums, int num1, int num2){
		int tmp = nums[num1];
		nums[num1] = nums[num2];
		nums[num2] = tmp;
	}

	public static void sort (int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			for (int j = i; j >= 1 && nums[j] < nums[j-1]; j--) {
				exch (nums, j , j-1);
			}
		}
	}

	public static void main(String[] args){
		int [] array = {9,2,3,4,3,1,5};
		sort(array);
		for(int i: array)
			System.out.println(i);

	}
}