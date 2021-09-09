package no.hvl.dat108.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class HamburgerBrett {

	private AtomicInteger teller;
	private BlockingQueue<Integer> brett;
	
	public HamburgerBrett(int kapasitet) {
		teller = new AtomicInteger(0);
		brett = new LinkedBlockingQueue<>(kapasitet);
	}
	
	/**
	 * Legger til burger på brettet på første ledige indeks, som i en kø.
	 * @return Tallet på burgeren som er lagt inn.
	 * @throws InterruptedException 
	 */
	public int leggTil() throws InterruptedException {
		/*
		 * På grunn av egen teller, kan burger komme i feil rekkefølge. Se ellers
		 * kommentar om synchronized i Main.
		 */
		
		int burger = teller.incrementAndGet();
		brett.put(burger);
		
		return burger;
	}
	
	/** 
	 * Tar vekk burger på første indeks, og flytter resterende burgere frem én indeks.
	 * @return Tallet på burgeren som er tatt vekk.
	 * @throws InterruptedException 
	 */
	public int taAv() throws InterruptedException {
		return brett.take();
	}
	
	@Override
	public String toString() {
		
		Integer[] burgerArray = (Integer[]) brett.toArray(new Integer[0]);
		
		String burgere = "";
		for (int i = 0; i < burgerArray.length; i++) {
			if(burgerArray[i] == 0) {
				break;
			}
			if(i != 0) {
				burgere += ", ";
			}
			burgere += "◖ " + burgerArray[i] + " ◗";
		}
		return "[" + burgere + "]";

	}
	
}
