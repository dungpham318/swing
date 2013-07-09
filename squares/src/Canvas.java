import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener{
	
	ArrayList<sqare> table = new ArrayList<sqare>();
	Color tableColor[] = {Color.RED, Color.BLUE};
	Color currentCol = Color.RED;
	
	

	public Canvas() {
		super();
		setPreferredSize(new Dimension(500,500));
		addMouseListener(this);
		new Thread (new timer(this)).start();
	}
	
	public void paint(Graphics g){
		g.setColor(currentCol);
		System.out.println("in paint size "+ table.size());
		int i;
		for (i=0;i<table.size();i++) {
			g.fillRect(table.get(i).x, table.get(i).y, table.get(i).sizex,table.get(i).sizey);
		}
			
	}
	
	private boolean inSqare (int x, int y,sqare s) {
		
		
		System.out.println();
		
		if ((x>s.x) && (x<(s.x+s.sizex)) && (y<(s.y+s.sizey)) && (y>s.y)) 
			return true;
		else 
			return false;
		
		
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int i;
		boolean found=false;
		for (i=0;i<table.size();i++) {
			if (inSqare(arg0.getX(),arg0.getY(),table.get(i))) {
				found = true;
				break;
			}
		}
		if (!found) {
			int sizex = (int)(Math.random()*1000)/10;
			int sizey = (int)(Math.random()*1000)/10;
			int x = arg0.getX() - sizex/2;
			int y = arg0.getY() - sizey/2;
			sqare s = new sqare(x,y,sizex,sizey);
			table.add(s);
		} else {
			table.remove(i);
			System.out.println(i);
		}
		System.out.println(found);
		repaint();
		System.out.println("clicked");
	
	}

	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
