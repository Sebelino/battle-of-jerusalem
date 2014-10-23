import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;

class Startruta extends JFrame
                implements Runnable
{
    public StartUI startUI;
    BufferedImage bild;
    BufferedImage initBild;

    BufferedImage buffer;
    Graphics2D bufferg;

    public Startruta()
    {
    		
    	startUI = new StartUI();
    	bild =  ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Bakgrund.png",new Color(255,128,128)),Consts.FRAMESIZEX,Consts.FRAMESIZEY);
    	initBild =  ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Loading.png",new Color(255,128,128)),Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        startUI.start = false;
    }

    public void run()
    {
        buffer = (BufferedImage)createImage(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        while(startUI.getLife())
        {
            rita();
            try
            {
                Thread.sleep((int)(1000/Consts.FPS));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        drawInitBild((Graphics2D)this.getGraphics());
    }

    public void rita()
    {
        if(bufferg == null)
        {
            bufferg = (Graphics2D)buffer.getGraphics();
        }
        radera();
        drawStuffs();
        Graphics2D g = (Graphics2D)this.getGraphics();
        g.drawImage(buffer,0,0,this);
        g.dispose();
    }

    public void drawStuffs()
    {
      	 bufferg.drawImage(bild,null,0,0);
		startUI.draw(bufferg);
		
    }

    public void drawInitBild(Graphics2D g)
    {
    	g.drawImage(initBild,null,0,0);
    }

    public void radera()
    {
        bufferg.setColor(Color.white);
        bufferg.fillRect(0,0,Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        bufferg.setColor(Color.black);
    }
    public boolean getStart()
    {
    	return startUI.getStart();
    }
}