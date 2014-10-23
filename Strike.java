import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Strike implements Runnable
{
    protected Harm[] harms;
    protected int[] starttimes;
    protected Thread trad;
    protected boolean life;
    protected BufferedImage bild;

    public Strike(Harm[] harms,int[] starttimes)
    {
        if(harms.length == starttimes.length)
        {
            this.harms = harms;
            this.starttimes = starttimes;
            life = true;
            trad = new Thread(this);
            start();
        }
    }

    private void start()
    {
        trad.start();
    }

    public void run()
    {
        while(life)
        {
            checkLife();
            flyt();
            decreaseTime();
            try
            {
                trad.sleep((int)(1000/Consts.FPSSTRIKE));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    private void flyt()
    {
        for(int i = 0;i < harms.length;i++)
        {
            if(harms[i].getLife())
            {
                harms[i].flyt();
            }
        }
    }

    public Harm[] getCurrentHarms()
    {
        Harm[] temp = new Harm[harms.length];
        for(int i = 0;i < starttimes.length;i++)
        {
            if(starttimes[i] <= 0)
            {
                temp[i] = harms[i];
            }
        }
        return GameUtil.kompresseraHarm(temp);
    }

    private void decreaseTime()
    {
        for(int i = 0;i < starttimes.length;i++)
        {
            starttimes[i]--;
        }
    }

    private void checkLife()
    {
        for(int i = 0;i < harms.length;i++)
        {
            if(starttimes[i] <= 0)
            {
                harms[i].setLife(true);
            }
            if(harms[i].getLifetime() <= 0)
            {
                harms[i].setLife(false);
            }
        }
        if(harms[harms.length-1].getLifetime() <= 0)
        {
            life = false;
        }
    }

    public boolean getLife()
    {
        return life;
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0;i < harms.length;i++)
        {
            if(harms[i].getLife())
            {
                harms[i].draw(g);
            }
        }
    }
}