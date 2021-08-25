package no.hvl.dat108.hamburger_rush;

/** Ein kokk brukar ei tilfeldig tid mellom 2 og 6 sekundar på å lage ein burger. */
public class Kokk extends Thread {
	
	private Rutsjebane rutsjebane;
	
	public Kokk(Rutsjebane rutsjebane, int id) {
		super("Kokk" + id);
		this.rutsjebane = rutsjebane;
	}
	
	@Override
	public void run() {
	
		while (true) {
			int timeToWait = ((int)(Math.random() * 5) + 2) * 1000;
			try { Thread.sleep(timeToWait); } catch (InterruptedException e) { return; }
			
			synchronized(rutsjebane) {
				
				while (rutsjebane.isFull()) {
					System.out.println("### " + Thread.currentThread().getName() + " er klar med en hamburger, men rutsjebanen er full. Venter! ###");
					try { rutsjebane.wait(); } catch (InterruptedException e) { return; }
				}
				
				int index = rutsjebane.addBurger();
				rutsjebane.notifyAll();
				System.out.println(getName() + " legger på hamburger  ("+index+") => " + rutsjebane.toString());
				
			}
		}
				
	}

}
