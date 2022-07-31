package activities;

interface BicycleParts {
	public int gears=0;
	public int speed=0;
}

interface BicycleOperations {
	public void applyBrake(int decrement);
	public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations {
	int gears, currentSpeed;
	
	public Bicycle(int gear, int speed) {
		gears = gear;
		currentSpeed = speed;
	}

	public void applyBrake(int decrement) {
		currentSpeed = currentSpeed - decrement;
	}

	public void speedUp(int increment) {
		currentSpeed = currentSpeed + increment;
	}
	
	public void bicycleDesc() {
		System.out.println("Gears : "+gears);
		System.out.println("Speed : "+currentSpeed);
	}
}

class MountainBike extends Bicycle{
	int seatHeight;
	
	public MountainBike(int gears, int speed, int height) {
		super(gears,speed);
		seatHeight= height;
	}
	
	public void setHeight(int newValue) {
		seatHeight= newValue;
	}
	
	public void bicycleDesc() {
		super.bicycleDesc();
		System.out.println("Height : "+seatHeight);
	}
}

public class Activity7 {

	public static void main(String[] args) {
		MountainBike obj = new MountainBike(21, 20, 7);
		obj.bicycleDesc();
		obj.speedUp(1);
		obj.applyBrake(3);
	}

}
