import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Spelplan implements SpelplanInterface
{
    protected Karta[][] plan;
    protected static int kartskala;
    protected static int planskala;
    protected int visuellGrad;

    public Spelplan()
    {
        kartskala = 128;
        planskala = 1;
        int[][] hm = setHeightmap();
        plan = new Karta[planskala][planskala];
        plan[0][0] = new Karta(0,0,hm,ImageUtil.makeColorTransparent("Pics/Karta.png",new Color(255,128,128)));
        visuellGrad = 2;
    }

    private int[][] setHeightmap()
    {
        int hm[][] = new int[kartskala][kartskala];
        for(int i = 0;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length;j++)
            {
                hm[i][j] = 20;
            }
        }
        for(int i = hm.length/2;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length/2;j++)
            {
                hm[i][j] = (int)(3*Math.sqrt(100*100-(i-100)*(i-100)-(j-100)*(j-100)));
            }
        }

        for(int i = 0;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length;j++)
            {
                hm[i][j] = 0;
            }
        }

        return hm;
    }

    public static int getKartskala()
    {
        return kartskala;
    }

    public static int getPlanskala()
    {
        return planskala;
    }

    public Karta getKarta(int v,int w)
    {
        return plan[v][w];
    }

    public Karta getKartaSprite(Punkt3D p)
    {
        return plan[(int)(p.getX()/kartskala)][(int)(p.getY()/kartskala)];
    }

    public void drawVisible(Graphics2D g,Punkt3D p)
    {
        for(int i = -visuellGrad+1;i < visuellGrad-1;i++)
        {
            for(int j = -visuellGrad+1;j < visuellGrad-1;j++)
            {
                if((int)(p.getX()/kartskala+i) >= 0 && (int)(p.getY()/kartskala+j) >= 0)
                {
                    plan[(int)(p.getX()/kartskala+i)][(int)(p.getY()/kartskala+j)].draw(g);
                }
            }
        }
        g.setColor(Color.black);
    }
}