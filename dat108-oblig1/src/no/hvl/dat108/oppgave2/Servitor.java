package no.hvl.dat108.oppgave2;

public class Servitor extends Thread {

	private HamburgerBrett brett;
	private String navn;

	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.floor((Math.random() * 5) + 2) * 1000));
				
				synchronized (brett) {
					while (brett.erTom()) {
						System.out.println(navn + " (servitør) ønsker å ta hamburger, men brett tomt. Venter!");
						brett.wait();
					}
					int tattVekk = brett.taAv();
					System.out.println(navn + " (servitør) tar av hamburger ◖ " + tattVekk + " ◗. Brett: " + brett.toString());
					brett.notifyAll();
				}
				
			} catch (InterruptedException e1) {
				System.out.println(navn + " INTERRUPTED");
				break;
			}
		}
	}

}
