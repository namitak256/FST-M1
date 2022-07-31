package activities;

import java.util.HashSet;
import java.util.Set;

public class Activity10 {

	public static void main(String[] args) {
		Set<Integer> hs= new HashSet<Integer>();
		hs.add(1);
		hs.add(11);
		hs.add(2);
		hs.add(6);
		hs.add(3);
		hs.add(34);
		System.out.println(hs.size());

		hs.remove(1);
		hs.remove(4);
		
		System.out.println(hs.contains(34));
		System.out.println(hs.contains(4));
		
		System.out.println(hs.size());
		
		System.out.println(hs);
	}

}
