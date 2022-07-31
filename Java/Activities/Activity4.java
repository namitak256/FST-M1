package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int[] arr= {4,3,2,8,1};
		
		System.out.println("Before sorting: "+ Arrays.toString(arr));
		
		int min, temp;
		for(int i=0; i<arr.length; i++) {			
			for(int j=i+1; j<arr.length;j++) {	
				min = arr[i];						
				if(min > arr[j]) {					
					temp=arr[j];				
					arr[j]=min;				
					min=temp;					
					arr[i]=min;			
				}
			}
			
		}
		
		System.out.println("After sorting:  "+ Arrays.toString(arr));
	}

}
