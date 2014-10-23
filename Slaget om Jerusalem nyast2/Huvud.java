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

class Huvud implements GameInterface
{
    Grafik frame;

    public Huvud()
    {
        frame = new Grafik();

        initiera();

        frame.spring();
        frame.dispose();
    }

    public void initiera()
    {
        frame.setTitle("Battle of Jerusalem");
        frame.addWindowListener(new WindowAdapter()
                                    {
                                        public void windowClosing(WindowEvent event)
                                        {
                                            System.exit(0);
                                        }
                                    });
        frame.setSize(FRAMESIZEX,FRAMESIZEY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.addMouseListener(new BoJMouseListener());
        frame.setVisible(true);
    }
}