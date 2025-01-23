mport java.util.Scanner;

public class Q2 {
	public static int singleNumber(int[] nums) {
		int max = 0;
		for(int i=0; i<nums.length; i++) {
			if( max < nums[i])
				max = nums[i];
		}
		
		int[] arr= new int[max+1];
		for(int i=0; i<arr.length; i++) {
			arr[nums[i]]++;
		}
		
		int index = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] ==1)
				index = i;
		}
		return index;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("배열의 크키를 입력하시오:");
		int index = scanner.nextInt();
		
		
		int[] arr = new int[index];
		
		System.out.println("배열의 입력값을 띄어쓰기를 활용하여 입력하시오:");
		for (int i=0; i<index; i++) {
			arr[i] = scanner.nextInt();
		}
		System.out.println("결과: "+ singleNumber(arr));
	}
}
