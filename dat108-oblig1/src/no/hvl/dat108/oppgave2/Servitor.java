package no.hvl.dat108.oppgave2;

public class Servitor extends Thread {

	private HamburgerBrett brett;
	private String navn;
	
	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}

}
