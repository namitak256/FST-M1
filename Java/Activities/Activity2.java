package activities;

public class Activity2 {

	public static void main(String[] args) {
		int[] numArr = {10, 77, 10, 54, -11, 10};
		
		System.out.println(SumCheck(numArr));
		
	}
	
	public static boolean SumCheck(int[] numArr) {
		boolean flag ;
		
		int sum = 0;
		
		for(int i:numArr) {
			if(i==10) {
				sum = sum + i;
			}
		}
		
		if(sum == 30) 
			flag= true;
		
		else 
			flag = false;
		
		
		return flag;
	}

}
