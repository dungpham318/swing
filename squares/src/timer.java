
public class timer implements Runnable{
	
	public Canvas c;
	
	public timer(Canvas s) {
		c=s;
	}

	@Override
	public void run() {
		int i=0;
		while(true) {
			try {
				System.out.println("Thread going to sleep");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(" Thread has been interrupted.");
				return;
			}
			System.out.println("Thread woke up");
			c.currentCol = c.tableColor[i%2];
			c.repaint();
			i++;
		}
		
	}

}
