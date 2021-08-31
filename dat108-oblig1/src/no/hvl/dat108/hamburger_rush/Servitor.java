package no.hvl.dat108.hamburger_rush;

/** Ein servitør brukar ei tilfeldig tid mellom 2 og 6 sekundar på å servere ein burger. */
public class Servitor extends Thread {
	
	private Rutsjebane rutsjebane;
	
	public Servitor(Rutsjebane rutsjebane, int id) {
		super("Servitør" + id);
		this.rutsjebane = rutsjebane;
	}
	
	@Override
	public void run() {
	
		while (true) {
			int timeToWait = ((int)(Math.random() * 5) + 2) * 1000;
			try { Thread.sleep(timeToWait); } catch (InterruptedException e) { return; }
			
			synchronized(rutsjebane) {
				
				while (rutsjebane.isEmpty()) {
					System.out.println("### " + Thread.currentThread().getName() + " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
					try { rutsjebane.wait(); } catch (InterruptedException e) { return; }
				}
				
				int index = rutsjebane.removeBurger();
				rutsjebane.notifyAll();
				System.out.println(getName() + " tar av hamburger ("+index+") => " + rutsjebane.toString());
				
			}
		}
				
	}

}
