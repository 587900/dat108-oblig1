package no.hvl.dat108.oppgave3;

import java.util.Arrays;

/* Vi har prøvd å unngå synchronized i denne oppgaven, noe som gjør seg gjeldende
 * i bruk av AtomicInteger bl.a. Dette skaper to utfordringer:
 * 
 * 1:
 * I HamburgerBrett.leggTil(): På grunn av egen teller, kan burger komme i feil rekkefølge.
 * 
 * 2:
 * Vi registrerer at en kokk kan rekke å legge på burger på brettet, før utskriften kommer. Derfor
 * vil eksempelvis burger A printes ut på en servitør-print, men også på påfølgende kokk-print.
 * For å unngå dette måtte man ha brukt synchronized, men dette tolket vi at vi skulle unngå
 * i oppgave 3
 */

public class Main {

	public static void main(String[] args) {
		final String[] kokker = { "Anne", "Erik", "Knut" };
		final String[] servitorer = { "Mia", "Per" };
		final int KAPASITET = 5;

		skrivUtHeader(kokker, servitorer, KAPASITET);

		HamburgerBrett brett = new HamburgerBrett(KAPASITET);

		for (String navn : kokker) {
			new Kokk(brett, navn).start();
		}

		for (String navn : servitorer) {
			new Servitor(brett, navn).start();
		}
	}

	private static void skrivUtHeader(String[] kokker, String[] servitorer, int kAPASITET) {
		System.out.println("I denne simuleringen har vi"
				+ "\n\t" + kokker.length + " kokker " + Arrays.toString(kokker)
				+ "\n\t" + servitorer.length + " servitører " + Arrays.toString(servitorer)
				+ "\n\t" + "Kapasiteten til brettet er " + 4 + " hamburgere"
				+ "\n\n" + "Vi starter...\n");		
	}

}