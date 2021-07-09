package JavaConcepts;

public class Objects {

	public static void main(String[] args) {
		carclass c1 = new carclass();
		c1.year = 2000;
		System.out.println(c1.year);
		System.out.println(c1.getYear());
	}
}

class carclass {

	int year;
	String model;

	public int getYear() {
		return this.year;
	}
}