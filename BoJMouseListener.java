import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class BoJMouseListener implements MouseListener
{
    private static double mouseX;
    private static double mouseY;
    public static final double DEAD = -32768;
    private static int presses;

    public BoJMouseListener()
    {
        mouseX = DEAD;
        mouseY = DEAD;
        presses = 0;
    }

    public void mouseClicked(MouseEvent e)
    {
	mouseX = e.getX();
	mouseY = e.getY();
        increasePresses();
    }

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}

    public void mousePressed(MouseEvent e){}

    public void mouseReleased(MouseEvent e){}

    public static double getX()
    {
        return mouseX;
    }

    public static double getY()
    {
        return mouseY;
    }

    public static void setX(double value)
    {
        mouseX = value;
    }

    public static void setY(double value)
    {
        mouseY = value;
    }

    private static int getPresses()
    {
        return presses;
    }

    private static void increasePresses()
    {
        presses++;
    }
}