import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Block3D implements SpelplanInterface
{
    protected Punkt3D p;
    protected int kartaV;
    protected int kartaW;
    protected double length;
    protected double width;
    protected double height;
    protected double groundlevel;

    Block3D(Punkt3D p,
                   double length,
                   double width,
                   double height)
    {
        this.p = new Punkt3D(p.getX(),p.getY(),p.getZ());
        this.length = length;
        this.width = width;
        this.height = height;
        groundlevel = 0;
    }

    Punkt3D getPunkt3D()
    {
        return p;
    }

    double getV()
    {
        return p.getX();
    }

    double getW()
    {
        return p.getY();
    }

    double getU()
    {
        return p.getZ();
    }

    double getLength()
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

    private void updateCoords()
    {
        kartaV = (int)(getV()/Spelplan.getKartskala());
        kartaW = (int)(getW()/Spelplan.getKartskala());
    }

    public void setPunkt3D(Punkt3D value)
    {
        p = new Punkt3D(value.getX(),value.getY(),value.getZ());
        updateCoords();
    }

    public void setV(double value)
    {
        p.setX(value);
        updateCoords();
    }

    public void setW(double value)
    {
        p.setY(value);
        updateCoords();
    }

    public void setU(double value)
    {
        p.setZ(value);
        updateCoords();
    }

    public void addV(double value)
    {
        setV(p.getX()+value);
    }

    public void addW(double value)
    {
        setW(p.getY()+value);
    }

    public void addU(double value)
    {
        setU(p.getZ()+value);
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

    public int getKartaV()
    {
        return kartaV;
    }

    public int getKartaW()
    {
        return kartaW;
    }

    public double getGroundlevel()
    {
        return groundlevel;
    }

    public void setGroundlevel(double value)
    {
        groundlevel = value;
    }

    public static boolean intersects(Block3D blockA,Block3D blockB)
    {
        boolean v = (Math.abs(blockA.getV()-blockB.getV()) < blockA.getLength()/2+blockB.getLength()/2);
        boolean w = (Math.abs(blockA.getW()-blockB.getW()) < blockA.getWidth()/2+blockB.getWidth()/2);
        boolean u = (Math.abs(blockA.getU()-blockB.getU()) < blockA.getHeight()/2+blockB.getHeight()/2);
        return (v && w && u);
    }

    public void drawGrid(Graphics g)
    {
        double x = MAPX+3*(getW()-getV());
        double deltaX = 3*(getLength()+getWidth());
        double y = MAPY-2*(getV()+getW())-getU();
        double deltaY = 2*(getLength()+getWidth());

//        g.drawLine((int)x-1,(int)y,(int)x+1,(int)y);
//        g.drawLine((int)x-1,(int)y-1,(int)x+1,(int)y-1);
//        g.drawLine((int)x-1,(int)y+1,(int)x+1,(int)y+1);

        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));         //Botten
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
//        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y-deltaY/2+height/2));
//        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y-deltaY/2+height/2));

        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));         //Topp
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));

        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)(x-deltaX/2),(int)(y-height/2));         //Stolpar
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)(x+deltaX/2),(int)(y-height/2));
        g.drawLine((int)x,(int)(y+deltaY/2+height/2),(int)x,(int)(y+deltaY/2-height/2));
//        g.drawLine((int)x,(int)(y-deltaY/2+height/2),(int)x,(int)(y-deltaY/2-height/2));
    }
}