import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Strike
{
/*
    protected Punkt3D p;
    protected Punkt3D pPre;
    protected double length;
    protected double width;
    protected double height;
    protected Bild[][] bilder;
    protected boolean[] condition;
    protected int direction;
    protected int sort;
    protected boolean activated;
    protected int lifetime;

    public static final int standby = 0;
    public static final int walking = 1;
    public static final int airborne = 2;
    public static final int jumping = 3;

    public static final int north = 0;
    public static final int east = 1;
    public static final int south = 2;
    public static final int west = 3;
    public static final int northwest = 4;
    public static final int northeast = 5;
    public static final int southeast = 6;
    public static final int southwest = 7;

    public Strike(Punkt3D distance,
                  double length,
                  double width,
                  double height)
    {
        this.p = new Punkt3D(p.getX(),p.getY(),p.getZ());
        this.length = length;
        this.width = width;
        this.height = height;
        bilder = new Bild[3][8];
        bilder[0][0] = new Bild("Strike.png");
        bilder[0][1] = new Bild("Strike.png");
        bilder[0][2] = new Bild("Strike.png");
        bilder[0][3] = new Bild("Strike.png");
        bilder[0][4] = new Bild("Strike.png");
        bilder[0][5] = new Bild("Strike.png");
        bilder[0][6] = new Bild("Strike.png");
        bilder[0][7] = new Bild("Strike.png");
        bilder[1][0] = new Bild("Strike.png");
        bilder[1][1] = new Bild("Strike.png");
        bilder[1][2] = new Bild("Strike.png");
        bilder[1][3] = new Bild("Strike.png");
        bilder[1][4] = new Bild("Strike.png");
        bilder[1][5] = new Bild("Strike.png");
        bilder[1][6] = new Bild("Strike.png");
        bilder[1][7] = new Bild("Strike.png");
        bilder[2][0] = new Bild("Strike.png");
        bilder[2][1] = new Bild("Strike.png");
        bilder[2][2] = new Bild("Strike.png");
        bilder[2][3] = new Bild("Strike.png");
        bilder[2][4] = new Bild("Strike.png");
        bilder[2][5] = new Bild("Strike.png");
        bilder[2][6] = new Bild("Strike.png");
        bilder[2][7] = new Bild("Strike.png");
        pPre = new Punkt3D(p.getX(),p.getY(),p.getZ());
    }

    public Punkt3D getPunkt3D()
    {
        return p;
    }

    public double getV()
    {
        return p.getX();
    }

    public double getW()
    {
        return p.getY();
    }

    public double getU()
    {
        return p.getZ();
    }

    public Punkt3D getPunkt3DPre()
    {
        return pPre;
    }

    public double getLength()
    {
        return length;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setPunkt3D(Punkt3D value)
    {
        p = new Punkt3D(value.getX(),value.getY(),value.getZ());
    }

    public void setV(double value)
    {
        p.setX(value);
    }

    public void setW(double value)
    {
        p.setY(value);
    }

    public void setU(double value)
    {
        p.setZ(value);
    }

    public void setPunkt3DPre(Punkt3D value)
    {
        pPre = new Punkt3D(value.getX(),value.getY(),value.getZ());
    }

    public void addV(double value)
    {
        p.setX(p.getX()+value);
    }

    public void addW(double value)
    {
        p.setY(p.getY()+value);
    }

    public void addU(double value)
    {
        p.setZ(p.getZ()+value);
    }

    public void setLength(double value)
    {
        length = value;
    }

    public void setWidth(double value)
    {
        width = value;
    }

    public void setHeight(double value)
    {
        height = value;
    }

    public boolean getCondition(int condis)
    {
        return condition[condis];
    }

    public void setCondition(int condis,boolean value)
    {
        condition[condis] = value;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
    }

    public boolean getActivated()
    {
        return activated;
    }

    public void activate(int lifetime)
    {
        activated = true;
        this.lifetime = lifetime;
    }
*/
}