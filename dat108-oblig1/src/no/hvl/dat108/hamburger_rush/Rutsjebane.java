package no.hvl.dat108.hamburger_rush;

/** This class is NOT thread-safe. Thread safety must be implemented by the consumer */
public class Rutsjebane {

	private int[] rutsjebane;
	private int rutsjebaneIndex;
	private int currentBurgerToBeMade;
	
	public Rutsjebane(int size) {
		rutsjebane = new int[size];
		currentBurgerToBeMade = 1;
		rutsjebaneIndex = 0;
	}
	
	/** Adds a burger to rutsjebane, if full will throw IndexOutOfBoundsException. Returns index of burger made */
	public int addBurger() { 
		rutsjebane[rutsjebaneIndex++] = currentBurgerToBeMade;
		return currentBurgerToBeMade++;
	}
	/** Remove a burger from rutsjebane. If empty, will throw IndexOutOfBoundsException. Returns index of burger served */
	public int removeBurger() {
		int burger = rutsjebane[0];
		for (int i = 0; i < rutsjebaneIndex-1; ++i) rutsjebane[i] = rutsjebane[i+1];
		if (!isFull()) rutsjebane[rutsjebaneIndex] = 0;
		rutsjebaneIndex--;
		return burger;
	}
	
	public boolean isFull() { return rutsjebaneIndex == rutsjebane.length; }
	public boolean isEmpty() { return rutsjebaneIndex == 0; }
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < rutsjebaneIndex; ++i) {
			if (i != 0) sb.append(", ");
			sb.append("("); sb.append(rutsjebane[i]); sb.append(")");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
