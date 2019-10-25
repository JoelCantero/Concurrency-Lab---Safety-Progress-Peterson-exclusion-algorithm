public class Field {

	public static void main(String args[]) {
		Flags flags = new Flags();
		Thread a = new Neighbor(flags, 1);
		a.setName("alice");
		Thread b = new Neighbor(flags, 2);
		b.setName("bob");
		
		a.start();
		b.start();
	}
	
}