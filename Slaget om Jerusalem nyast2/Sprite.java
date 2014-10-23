import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

abstract class Sprite
{
    protected Animation[] animationer;
    protected Animation currentAnimation;
    protected BufferedImage shadow;
    protected Block3D block;
    protected Block3D blockPre;

    protected double speedWalk;                     //*
    protected double speedU;                     //*
    protected Tillstand tillstand;
    protected static double gravity = -4;                     //*

    public Block3D getBlock3D()
    {
        return block;
    }

    public Block3D getBlock3DPre()
    {
        return blockPre;
    }

    public Tillstand getTillstand()
    {
        return tillstand;
    }

    public void setTillstand(Tillstand tillstand)
    {
        this.tillstand = tillstand;
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

    public double getSpeedWalk()
    {
        return speedWalk;
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

    public void setSpeedWalk(double value)
    {
        speedWalk = value;
    }

    public void addSpeedWalk(double value)
    {
        speedWalk += value;
    }

    public double getSpeedU()
    {
        return speedU;
    }

    public void setSpeedU(double value)
    {
        speedU = value;
    }

    public void addSpeedU(double value)
    {
        speedU += value;
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

    public double getGroundlevel()
    {
        return block.getGroundlevel();
    }

    public void setGroundlevel(double value)
    {
        block.setGroundlevel(value);
    }

    public double getGroundlevelPre()
    {
        return blockPre.getGroundlevel();
    }

    public void setGroundlevelPre(double value)
    {
        blockPre.setGroundlevel(value);
    }

    public boolean getCondition(int condis)
    {
        return tillstand.getCondition()[condis];
    }

    public void setCondition(int condis,boolean value)
    {
        tillstand.setCondition(condis,value);
    }

    public int getDirection()
    {
        return tillstand.getDirection();
    }

    public void setDirection(int direction)
    {
        tillstand.setDirection(direction);
    }
}