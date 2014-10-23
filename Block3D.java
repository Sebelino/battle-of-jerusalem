import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Block3D
{
    protected Punkt3D p;
    protected double length;
    protected double width;
    protected double height;

    Block3D(Punkt3D p,
            double length,
            double width,
            double height)
    {
        this.p = new Punkt3D(p.getX(),p.getY(),p.getZ());
        this.length = length;
        this.width = width;
        this.height = height;
    }

    Block3D(Block3D block)
    {
        this.p = new Punkt3D(block.getV(),block.getW(),block.getU());
        this.length = block.getLength();
        this.width = block.getWidth();
        this.height = block.getHeight();
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

    public void addPunkt3D(Punkt3D value)
    {
        p.add(new Punkt3D(value.getX(),value.getY(),value.getZ()));
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

    public static boolean intersects(Block3D blockA,Block3D blockB)
    {
        boolean v = (Math.abs(blockA.getV()-blockB.getV()) < blockA.getLength()/2+blockB.getLength()/2);
        boolean w = (Math.abs(blockA.getW()-blockB.getW()) < blockA.getWidth()/2+blockB.getWidth()/2);
        boolean u = (Math.abs(blockA.getU()-blockB.getU()) < blockA.getHeight()/2+blockB.getHeight()/2);
        return (v && w && u);
    }

    public void drawGrid(Graphics g)
    {
        double x = Consts.MAPX+3*(getW()-getV());
        double deltaX = 3*(getLength()+getWidth());
        double y = Consts.MAPY-2*(getV()+getW())+getU();
        double deltaY = 2*(getLength()+getWidth());

        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));

        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)(x-deltaX/2),(int)(y-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)(x+deltaX/2),(int)(y-height/2));
        g.drawLine((int)x,(int)(y+deltaY/2+height/2),(int)x,(int)(y+deltaY/2-height/2));
    }

    public void drawGrid(Graphics g,double addX,double addY)
    {
        double x = addX+Consts.MAPX+3*(getW()-getV());
        double deltaX = 3*(getLength()+getWidth());
        double y = addY+Consts.MAPY-2*(getV()+getW())+getU();
        double deltaY = 2*(getLength()+getWidth());

        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));

        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)(x-deltaX/2),(int)(y-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)(x+deltaX/2),(int)(y-height/2));
        g.drawLine((int)x,(int)(y+deltaY/2+height/2),(int)x,(int)(y+deltaY/2-height/2));
    }
}