import java.awt.TextArea;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Autosave implements Runnable{
	String text;
	TextArea textarea;
	public Autosave(TextArea t) {
		textarea = t;
		text = t.getText();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Thread going to sleep");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(" Thread has been interrupted.");
				return;
			}
			if (text.equals(textarea.getText())) {
				BufferedWriter destination = null;
				
				try {
					destination = new BufferedWriter(new FileWriter(
								"somefile.txt"));
					destination.append(text);
					destination.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			text=textarea.getText();
			
		}
		
		
	}

}
