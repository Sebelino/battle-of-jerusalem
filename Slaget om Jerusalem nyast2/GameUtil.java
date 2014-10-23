import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class GameUtil
{


    public static int avrunda(double value)
    {
        if((int)(2*value) > 2*(int)value)
        {
            return (int)value+1;
        }
        else
        {
            return (int)value;
        }
    }
}