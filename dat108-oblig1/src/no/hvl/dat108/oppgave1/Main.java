package no.hvl.dat108.oppgave1;

import static javax.swing.JOptionPane.showInputDialog;

public class Main {

	public static void main(String[] args) {

		Traad t = new Traad();
		t.setInput("Hallo verden!");
		t.start();
		String input = "";
		
		while(input != null && !input.equals("slutt")) {
			input = showInputDialog("Skriv inn din melding. Skriv \"slutt\" for å avslutte.");
			t.setInput(input);
		}	
		
		t.stopp();

	}

}
