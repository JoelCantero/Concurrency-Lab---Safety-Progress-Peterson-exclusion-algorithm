public class Neighbor extends Thread {

	private Flags flags;
	private int turn;

	public Neighbor(Flags flags, int turn) {
		
		this.flags = flags;
		this.turn = turn;

	}

	public void run() {

		while(true) {

			try {

				String name = Thread.currentThread().getName();
				
				flags.set_true(name);

				flags.set_turn(name);
				// To model greedy write the sleep as follows
				Thread.sleep((int)(200*Math.random()));

				while ( flags.query_flag(name) == true && flags.query_turn() != turn ) {
					System.out.println("try again, my name is: " + name);
					Thread.sleep(400);
					
				}
				System.out.println(name + " enter");
				Thread.sleep((int)(200*Math.random()));
				System.out.println(name + " exits");
				flags.set_false(name);
			}

			catch (InterruptedException e) {};
		}
	}
	
}