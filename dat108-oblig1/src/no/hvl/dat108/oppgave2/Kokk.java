package no.hvl.dat108.oppgave2;

public class Kokk extends Thread {

	private HamburgerBrett brett;
	private String navn;

	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((long) (Math.floor((Math.random() * 5) + 2) * 1000));
			} catch (InterruptedException e1) {
			}
			synchronized (brett) {
				while (brett.erFull()) {
					try {
						System.out.println(navn + " (kokk) klar med hamburger, men brett fullt. Venter!");
						brett.wait();
					} catch (InterruptedException e) {
					}
				}
				int lagtTil = brett.leggTil();
				System.out
						.println(navn + " (kokk) legger på hamburger ◖ " + lagtTil + " ◗. Brett: " + brett.toString());
				brett.notifyAll();
			}
		}
	}

}
