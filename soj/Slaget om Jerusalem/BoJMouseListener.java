import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFrame;


class BoJMouseListener implements MouseListener
{

    public static int mousex;
	public static int mousey;
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e){
		
	}
	public void mouseExited(MouseEvent e){
		
	}
	public void mousePressed(MouseEvent e){
		System.out.println("mouse released anropad");
		mousex = e.getX();
		mousey = e.getY();
		System.out.println(mousex +", " + mousey+"!");
	}
	public void mouseReleased(MouseEvent e){				
		
	}
}