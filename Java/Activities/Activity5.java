package activities;

abstract class Book {
	static String title;

	public abstract void setTitle(String s);

	public String getTitle() {
		return title;
	}
}

class MyBook extends Book {

	public void setTitle(String s) {
		title = s;
	}
}

public class Activity5 {
	public static void main(String[] args) {
		
		String title= "Who killed the mocking bird";
		MyBook newNovel = new MyBook();
		newNovel.setTitle(title);
		System.out.println(newNovel.getTitle());
	}
}
