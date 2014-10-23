import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class Animation
{
    private BufferedImage[] imgs;
    private int timescale;
    private BufferedImage currentImg;
    private int state;
    private boolean repeat;
    private boolean aktiverad;

    public Animation(BufferedImage[] imgs,int timescale,boolean repeat)
    {
        this.imgs = imgs;
        this.timescale = timescale;
        state = 1;
        currentImg = imgs[state-1];
        this.repeat = repeat;
        aktiverad = true;
    }

    public Animation(){}

    public void spring()
    {
        if((double)state/timescale == state/timescale)
        {
            if(state < imgs.length*timescale)
            {
                currentImg = imgs[(int)((double)state/timescale)];
            }
            else
            {
                if(repeat)
                {
                    state = 0;
                    currentImg = imgs[(int)((double)state/timescale)];
                }
                else
                {
                    aktiverad = false;
                }
            }
        }
        state++;
    }

    public BufferedImage getCurrentImg()
    {
        return currentImg;
    }

    public int getCurrentImgID()
    {
        return (int)(state/timescale);
    }

    public boolean getAktiverad()
    {
        return aktiverad;
    }

    public void setRepeat(boolean value)
    {
        repeat = value;
    }
}