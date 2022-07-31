package activities;

public class Activity3 {

	public static void main(String[] args) {

		double seconds = 1000000000;
		double EarthSeconds = 31557600;
		double MercurySeconds = 0.2408467;
		double VenusSeconds = 0.61519726;
		double MarsSeconds = 1.8808158;
		double JupiterSeconds = 11.862615;
		double SaturnSeconds = 29.447498;
		double UranusSeconds = 84.016846;
		double NeptuneSeconds = 164.79132;

		System.out.println("Age on Earth is: " + String.format("%.2f", seconds / EarthSeconds));
		
		System.out.println("Age on Mercury is: " + String.format("%.2f", seconds / (EarthSeconds * MercurySeconds)));

		System.out.println("Age on Venus is: " + String.format("%.2f", seconds / (EarthSeconds * VenusSeconds)));

		System.out.println("Age on Mars is: " + String.format("%.2f", seconds / (EarthSeconds * MarsSeconds)));

		System.out.println("Age on Jupiter is: " + String.format("%.2f", seconds / (EarthSeconds * JupiterSeconds)));

		System.out.println("Age on Saturn is: " + String.format("%.2f", seconds / (EarthSeconds * SaturnSeconds)));

		System.out.println("Age on Uranus is: " + String.format("%.2f", seconds / (EarthSeconds * UranusSeconds)));

		System.out.println("Age on Neptune is: " + String.format("%.2f", seconds / (EarthSeconds * NeptuneSeconds)));

	}

}
