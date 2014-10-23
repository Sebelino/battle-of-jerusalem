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

class Slutruta extends JFrame
               implements Runnable
{
    BufferedImage bild;

    BufferedImage buffer;
    Graphics2D bufferg;

    public Slutruta()
    {
        bild = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Victory.png",new Color(255,128,128)),Consts.FRAMESIZEX,Consts.FRAMESIZEY);
    }

    public void run()
    {
        buffer = (BufferedImage)createImage(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        while(true)
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
        bufferg.drawString("CONGRATULATIONS, YOU WON!",(int)(0.6*Consts.FRAMESIZEX),(int)(0.35*Consts.FRAMESIZEY));
        bufferg.drawString("Jerusalem is spared from the evil nazis all thanks to you! You're awesome!",(int)(0.6*Consts.FRAMESIZEX),(int)(0.4*Consts.FRAMESIZEY));
    }

    public void radera()
    {
        bufferg.setColor(Color.white);
        bufferg.fillRect(0,0,Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        bufferg.setColor(Color.black);
    }
}