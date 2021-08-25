package no.hvl.dat108.oppgave1;

public class Traad extends Thread {

	boolean fortsette = true;
	String input = "";

	public Traad(String navn) {
		super(navn);
	}
	
	public Traad() {
		super();
	}

	public void stopp() {
		fortsette = false;
	}
	
	public void setInput(String input) {
		this.input = input;
	}

	@Override
	public void run() {
		while (fortsette) {
//			input = "Hallo verden!";
			System.out.println(input);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
	}

}
