package activities;

class CustomException extends Exception {
	private String message=null;

	public CustomException(String msg) {
		message = msg;
	}

	@Override
	public String getMessage() {
		return message;
	}
}

public class Activity8 {

	public void exceptionTest(String msg) throws CustomException {
		if (msg != null)
			System.out.println(msg);
		else
			throw new CustomException("Custom Exception");
	}

	public static void main(String[] args) throws CustomException {
		Activity8 obj = new Activity8();
		try {
			obj.exceptionTest("Exception Test");
			obj.exceptionTest(null);
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}

	}

}
