package oblig1_oppg1;

import static javax.swing.JOptionPane.*;

public class Main {

	public static void main(String[] args) {

		Traad t = new Traad("Auto-tråd");
		
		t.start();
		
		showInputDialog("Skriv inn din melding. Cancel for å avslutte.");

		t.stopp();

	}
}
