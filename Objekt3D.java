import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

abstract class Objekt3D
{
    protected Block3DSpel block;
    protected Block3DSpel blockPre;
    protected Vektor3D speed;
    protected int ID;

    public Objekt3D(int ID)
    {
        this.ID = ID;
        speed = new Vektor3D(0,0,0);
        block = new Block3DSpel(new Punkt3D(0,0,0),0,0,0);
        blockPre = new Block3DSpel(new Punkt3D(0,0,0),0,0,0);
    }

    public Objekt3D(int ID,Block3DSpel block)
    {
        this.ID = ID;
        speed = new Vektor3D(0,0,0);
        this.block = new Block3DSpel(block);
        blockPre = new Block3DSpel(block);
    }

    public void move()
    {
        addPunkt3D(speed);
    }

    public Block3DSpel getBlock3D()
    {
        return block;
    }

    public Block3DSpel getBlock3DPre()
    {
        return blockPre;
    }

    public Punkt3D getPunkt3D()
    {
        return block.getPunkt3D();
    }

    public double getV()
    {
        return block.getV();
    }

    public double getW()
    {
        return block.getW();
    }

    public double getU()
    {
        return block.getU();
    }

    public Punkt3D getPunkt3DPre()
    {
        return blockPre.getPunkt3D();
    }

    public double getLength()
    {
        return block.getLength();
    }

    public double getWidth()
    {
        return block.getWidth();
    }

    public double getHeight()
    {
        return block.getHeight();
    }

    public void setPunkt3D(Punkt3D value)
    {
        block.setPunkt3D(value);
    }

    public void setPunkt3D(Vektor3D value)
    {
        block.setPunkt3D(new Punkt3D(value.getX(),value.getY(),value.getX()));
    }

    public void setV(double value)
    {
        block.setV(value);
    }

    public void setW(double value)
    {
        block.setW(value);
    }

    public void setU(double value)
    {
        block.setU(value);
    }

    public void setPunkt3DPre(Punkt3D value)
    {
        blockPre.setPunkt3D(value);
    }

    public void addPunkt3D(Punkt3D value)
    {
        block.addPunkt3D(new Punkt3D(value.getX(),value.getY(),value.getZ()));
    }

    public void addPunkt3D(Vektor3D value)
    {
        block.addPunkt3D(new Punkt3D(value.getX(),value.getY(),value.getZ()));
    }

    public void addV(double value)
    {
        setV(getV()+value);
    }

    public void addW(double value)
    {
        setW(getW()+value);
    }

    public void addU(double value)
    {
        setU(getU()+value);
    }

    public Vektor3D getSpeed()
    {
        return speed;
    }

    public double getSpeedV()
    {
        return speed.getX();
    }

    public void setSpeedV(double value)
    {
        speed.setX(value);
    }

    public void addSpeedV(double value)
    {
        speed.setX(speed.getX()+value);
    }

    public double getSpeedW()
    {
        return speed.getY();
    }

    public void setSpeedW(double value)
    {
        speed.setY(value);
    }

    public void addSpeedW(double value)
    {
        speed.setY(speed.getY()+value);
    }

    public double getSpeedU()
    {
        return speed.getZ();
    }

    public void setSpeedU(double value)
    {
        speed.setZ(value);
    }

    public void addSpeedU(double value)
    {
        speed.setZ(speed.getZ()+value);
    }

    public void setLength(double value)
    {
        block.setLength(value);
    }

    public void setWidth(double value)
    {
        block.setWidth(value);
    }

    public void setHeight(double value)
    {
        block.setHeight(value);
    }

    public int getID()
    {
        return ID;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public double getGroundlevel()
    {
        return block.getGroundlevel();
    }

    public double getGroundlevelPre()
    {
        return blockPre.getGroundlevel();
    }

    public void setGroundlevel(double value)
    {
        block.setGroundlevel(value);
    }

    public void setGroundlevelPre(double value)
    {
        blockPre.setGroundlevel(value);
    }
}