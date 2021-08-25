package oblig1_oppg1;

public class Traad extends Thread {

	boolean fortsette = true;

	public Traad(String navn) {
		super(navn);
	}

	public void stopp() {
		fortsette = false;
	}

	@Override
	public void run() {
		while (fortsette) {
			System.out.println("Hallo verden!");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
		}
	}

}
