import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class BoJKeyListener implements KeyListener
{
    public void keyTyped(KeyEvent e){}

    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:  Kontroller.left = true;
                                    break;
            case KeyEvent.VK_RIGHT: Kontroller.right = true;
                                    break;
            case KeyEvent.VK_UP:    Kontroller.up = true;
                                    break;
            case KeyEvent.VK_DOWN:  Kontroller.down = true;
                                    break;
            case KeyEvent.VK_C:     Kontroller.c = true;
                                    break;
            case KeyEvent.VK_X:     Kontroller.x = true;
        }
    }

    public void keyReleased(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:  Kontroller.left = false;
                                    break;
            case KeyEvent.VK_RIGHT: Kontroller.right = false;
                                    break;
            case KeyEvent.VK_UP:    Kontroller.up = false;
                                    break;
            case KeyEvent.VK_DOWN:  Kontroller.down = false;
                                    break;
            case KeyEvent.VK_C:     Kontroller.c = false;
                                    break;
            case KeyEvent.VK_X:     Kontroller.x = false;
        }
    }
}