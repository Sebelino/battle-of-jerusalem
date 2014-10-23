import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

class Huvud
{
    public Huvud()
    {
        JFrame framA;
        JFrame framB;
        framA = new Startruta();
        initiera(framA);
        framA.addMouseListener(new BoJMouseListener() );
        
        ((Startruta)framA).run();
      	if(!((Startruta)framA).getStart()){
      		System.exit(1);
      		}
		
		framB = new Spel(); 
		initiera(framB);
		destroy(framA);
		framB.addKeyListener(new BoJKeyListener());
        ((Spel)framB).run();
		
        
		


        
        if(Spel.getWin())
        {
            framA = new Slutruta();
            initiera(framA);
            destroy(framB);
            ((Slutruta)framA).run();
        }
        else
        {
            framA = new Gameoverruta();
            initiera(framA);
            destroy(framB);
            ((Gameoverruta)framA).run();
        }
    }

    public void initiera(JFrame frame)
    {
        frame.setTitle("Battle of Jerusalem");
        frame.addWindowListener(new WindowAdapter()
                                    {
                                        public void windowClosing(WindowEvent event)
                                        {
                                            System.exit(0);
                                        }
                                    });
        frame.setSize(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
    public void destroy(JFrame frame)
    {
        frame.setVisible(false);
        frame.dispose();
    }
}