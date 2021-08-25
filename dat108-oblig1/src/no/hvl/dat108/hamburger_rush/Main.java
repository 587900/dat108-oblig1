package no.hvl.dat108.hamburger_rush;

public class Main {
	
	public static final int kokker = 3;
	public static final int servitorer = 2;
		
	public static void main(String[] args) {
		
		Rutsjebane rutsjebane = new Rutsjebane(5);
		
		Kokk k1 = new Kokk(rutsjebane, 0);
		k1.start();
		
		for (int i = 1; i <= kokker; ++i) {
			Kokk kokk = new Kokk(rutsjebane, i);
			kokk.start();
		}
		
		for (int i = 1; i <= servitorer; ++i) {
			Servitor servitor = new Servitor(rutsjebane, i);
			servitor.start();
		}
		
	}

}
