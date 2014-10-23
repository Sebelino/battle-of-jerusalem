import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Spelplan
{
    protected Karta[][] plan;
    protected static int kartskala;
    protected static int planskala;
    protected int visuellGrad;

    public Spelplan()
    {
        kartskala = 128;
        planskala = 40;
        int[][] hm = setHeightmap();
        int[][] hm01 = setHeightmap01();
        int[][] hm10 = setHeightmap10();
        plan = new Karta[planskala][planskala];
        for(int i = 0;i < planskala;i++)
        {
            for(int j = 0;j < planskala;j++)
            {
                plan[i][j] = new Karta(i,j,hm,Bilder.area11);
            }
        }
        plan[0][0] = new Karta(0,0,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[0][1] = new Karta(0,1,hm01,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area01.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[0][2] = new Karta(0,2,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[0][3] = new Karta(0,3,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[1][0] = new Karta(1,0,hm10,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area10.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[1][1] = new Karta(1,1,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[1][2] = new Karta(1,2,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[1][3] = new Karta(1,3,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[2][0] = new Karta(2,0,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[2][1] = new Karta(2,1,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[2][2] = new Karta(2,2,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[2][3] = new Karta(2,3,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[3][0] = new Karta(3,0,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area00.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[3][1] = new Karta(3,1,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area10.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[3][2] = new Karta(3,2,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        plan[3][3] = new Karta(3,3,hm,ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),kartskala*6,kartskala*4));
        visuellGrad = 3;
    }

    private int[][] setHeightmap()
    {
        int hm[][] = new int[kartskala][kartskala];
        for(int i = 0;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length;j++)
            {
                hm[i][j] = 0;
            }
        }
        return hm;
    }

    private int[][] setHeightmap01()
    {
        int hm[][] = new int[kartskala][kartskala];
        for(int i = 0;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length;j++)
            {
                hm[i][j] = 0;
            }
        }
        for(int i = (int)(0.2*hm.length);i < (int)(0.6*hm.length);i++)
        {
            for(int j = (int)(0.1*hm.length);j < (int)(0.5*hm.length);j++)
            {
                hm[i][j] = -(int)(3*Math.sqrt((int)(0.2*hm.length)*(int)(0.2*hm.length)-(i-(int)(0.4*hm.length))*(i-(int)(0.4*hm.length))-(j-(int)(0.3*hm.length))*(j-(int)(0.3*hm.length))));
            }
        }
        return hm;
    }

    private int[][] setHeightmap10()
    {
        int hm[][] = new int[kartskala][kartskala];
        for(int i = 0;i < hm.length;i++)
        {
            for(int j = 0;j < hm[0].length;j++)
            {
                hm[i][j] = 0;
            }
        }
        for(int i = (int)(0.4*hm.length);i < (int)(0.6*hm.length);i++)
        {
            for(int j = (int)(0.4*hm.length);j < (int)(0.6*hm.length);j++)
            {
                hm[i][j] = -100;
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
        Punkt2D prot = new Punkt2D((int)(p.getX()/kartskala),(int)(p.getY()/kartskala));
        for(int i = (int)prot.getX()-visuellGrad+1;i <= (int)prot.getX()+visuellGrad-1;i++)
        {
            for(int j = (int)prot.getY()-visuellGrad+1;j <= (int)prot.getY()+visuellGrad-1;j++)
            {
                if(i >= 0 &&
                   i < plan.length &&
                   j >= 0 &&
                   j < plan[0].length)
                {
                    plan[i][j].draw(g);
                }
            }
        }
        g.setColor(Color.black);
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0;i < plan.length;i++)
        {
            for(int j = 0;j < plan[0].length;j++)
            {
                plan[i][j].draw(g);
            }
        }
    }
}