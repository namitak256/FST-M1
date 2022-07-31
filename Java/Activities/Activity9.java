package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		
		myList.add("Bob");
		myList.add("Marleen");
		myList.add("Tim");
		myList.add("Joey");
		myList.add("Ross");
		
		for(String names: myList) {
			System.out.print(names + " ");
		}
		
		System.out.println("\n"+myList.get(2));
		
		System.out.println(myList.contains("Marleen"));
		
		System.out.println(myList.size());
		
		myList.remove(1);
		
		System.out.println(myList.size());

	}

}
