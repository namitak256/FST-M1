package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
	
	public Plane(int num) {
		this.maxPassengers = num;
		passengers = new ArrayList<>();
	}
	
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    
    public void onboard(String cust) {
    	passengers.add(cust);
    }
    
    public Date takeOff() {
    	this.lastTimeTookOf= new Date();
    	return this.lastTimeTookOf;
    }
    
    public void land() {
    	this.lastTimeLanded	= new Date();
    }
    
    public Date getLastTimeLanded() {
    	return lastTimeLanded;
    }
    
    public List<String> getPassesngers() {
    	return passengers;
    }
}


public class Activity6 {

	public static void main(String[] args) throws InterruptedException {
		
		Plane plane= new Plane(10);
		plane.onboard("Robin");
		plane.onboard("Batman");
		
		System.out.println("Flight took off at : "+plane.takeOff());
		
		System.out.println("Passengers at the time of take off : "+ plane.getPassesngers());
		
		Thread.sleep(5000);
		
		plane.land();
		
		System.out.println("Flight landed at : "+plane.getLastTimeLanded());
		
		System.out.println("Passengers at the time of landing : "+plane.getPassesngers());
		
		

	}

}
