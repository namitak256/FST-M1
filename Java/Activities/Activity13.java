package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		ArrayList<Integer> li = new ArrayList<>();

		while (scan.hasNextInt()) {
			li.add(scan.nextInt());
			
		}

		Random indexGen = new Random();
		int index;
		index= indexGen.nextInt(li.size());
		System.out.println(index);
		System.out.println(li.get(index));
		
		scan.close();
	}

}
