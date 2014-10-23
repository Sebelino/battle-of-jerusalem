import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

class Grafik extends JFrame
                     implements GameInterface
{
    UI ui;
    boolean life;
    BufferedImage bakgrund;

    BufferedImage buffer;
    Graphics2D bufferg;

    public Grafik()
    {
        life = true;
        bakgrund = ImageUtil.resize(ImageUtil.makeColorTransparent("Bakgrund.png",new Color(255,128,128)),FRAMESIZEX,FRAMESIZEY);
        addMouseListener(new BoJMouseListener());
        ui = new UI();
    }

    public void spring()
    {
        buffer = (BufferedImage)createImage(FRAMESIZEX,FRAMESIZEY);
        while(life)
        {
            rita();
            try
            {
                Thread.sleep((int)(1000/FPS));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            if(!ui.getLife())
            {
                life = false;
            }
        }
    }

    public void rita()
    {
        if(bufferg == null)
        {
            bufferg = (Graphics2D)buffer.getGraphics();
        }
        radera();
        drawStuffs();
        Graphics2D bufferg = (Graphics2D)this.getGraphics();
        bufferg.drawImage(buffer,0,0,this);
        bufferg.dispose();
    }

    public void drawStuffs()
    {
        bufferg.drawImage(bakgrund,
                    null,
                    0,
                    0);
	ui.draw(bufferg);
    }

    public void radera()
    {
        bufferg.setColor(Color.white);
        bufferg.fillRect(0,0,FRAMESIZEX,FRAMESIZEY);
        bufferg.setColor(Color.black);
    }
}