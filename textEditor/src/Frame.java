import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Frame extends JFrame implements ActionListener{
	
	
	JButton save = new JButton();
	TextArea text = new TextArea();
	
		
	public Frame() throws HeadlessException, IOException {
		super();
		
		
		setLayout(new BorderLayout());
		text.setPreferredSize(new Dimension(500,500));
		add(text,BorderLayout.CENTER);
		
		String content="";
		BufferedReader source = new BufferedReader(new FileReader(
				"somefile.txt"));

		
		String line = null;
		while ((line = source.readLine()) != null)
			content = content + line + "\n";

		source.close();
		
		text.setText(content);
		
		
		
		JPanel pnl = new JPanel();
		pnl.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		save.setText("SAVE");
		save.addActionListener(this);
		pnl.add(save);
		
		add(pnl, BorderLayout.NORTH);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pack();
		new Thread (new Autosave(text)).start(); 
		
		}

	public static void main(String [] args) throws HeadlessException, IOException{
		new Frame();
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof JButton){
			String s = text.getText();
			System.out.println(s);
			BufferedWriter destination = null;
			
			try {
				destination = new BufferedWriter(new FileWriter(
							"somefile.txt"));
				destination.append(s);
				destination.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
			
		}
		
	}

}
