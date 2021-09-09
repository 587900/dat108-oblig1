package no.hvl.dat108.oppgave3;

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
				int tattVekk = brett.taAv();
				System.out.println(
						navn + " (servitør) tar av hamburger ◖ " + tattVekk + " ◗. Brett: " + brett.toString());
			} catch (InterruptedException e1) {
				System.out.println(navn + " INTERRUPTED");
				break;
			}
		}
	}
}
