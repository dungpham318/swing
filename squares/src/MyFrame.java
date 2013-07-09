import java.awt.BorderLayout;

import java.awt.HeadlessException;
import javax.swing.JFrame;



public class MyFrame extends JFrame {
	
	private Canvas canvas =new Canvas();
	
		
	public MyFrame() throws HeadlessException {
		super();
		
		setLayout(new BorderLayout());
		add(canvas,BorderLayout.CENTER);
		
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		}

	public static void main(String [] args){
		new MyFrame();
		
	}



}
