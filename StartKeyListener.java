import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class StartKeyListener implements KeyListener
{
    private static boolean starta;

    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_ENTER: starta = true;
        }
    }

    public void keyReleased(KeyEvent e){}

    public static boolean getStarta()
    {
        return starta;
    }

    public static void setStarta(boolean value)
    {
        starta = value;
    }
}