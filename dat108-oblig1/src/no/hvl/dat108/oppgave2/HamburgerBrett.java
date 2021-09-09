package no.hvl.dat108.oppgave2;

public class HamburgerBrett {

	private int[] hamburgerBrett;
	private int antall = 0;
	private int teller = 0;
	
	public HamburgerBrett(int kapasitet) {
		hamburgerBrett = new int[kapasitet];
	}
	
	/**
	 * Legger til burger på brettet på første ledige indeks, som i en kø.
	 * @throws Unntak hvis fullt.
	 * @return Tallet på burgeren som er lagt inn.
	 */
	public int leggTil() {
		if(erFull()) {
			throw new IndexOutOfBoundsException("Burgerbrettet er fullt!");
		}
		
		hamburgerBrett[antall++] = ++teller;
		return teller;
	}
	
	/** 
	 * Tar vekk burger på første indeks, og flytter resterende burgere frem én indeks.
	 * @throws Unntak hvis tomt.
	 * @return Tallet på burgeren som er tatt vekk.
	 */
	public int taAv() {
		if(erTom()) {
			throw new IndexOutOfBoundsException("Burgerbrettet er tomt!");
		}
		int tattVekk = hamburgerBrett[0];
		for(int i = 1, len = Math.min(antall+1, hamburgerBrett.length); i < len; i++) {
			hamburgerBrett[i-1] = hamburgerBrett[i];
		}
		hamburgerBrett[hamburgerBrett.length-1] = 0;
		antall--;
		return tattVekk;
	}
	
	public boolean erFull() {
		return hamburgerBrett.length == antall;
	}
	
	public boolean erTom() {
		return antall == 0;
	}
	
	@Override
	public String toString() {
		String burgere = "";
		for (int i = 0; i < antall; i++) {
			if(i != 0) burgere += ", ";
			burgere += "◖ " + hamburgerBrett[i] + " ◗";
		}
		return "[" + burgere + "]";

	}
	
}
