import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Block3DSpel extends Block3D
{
    protected int kartaV;
    protected int kartaW;
    protected double groundlevel;

    Block3DSpel(Punkt3D p,
                double length,
                double width,
                double height)
    {
        super(p,length,width,height);
        groundlevel = 0;
        kartaV = 0;
        kartaW = 0;
    }

    Block3DSpel(Block3DSpel block)
    {
        super(block);
        groundlevel = 0;
        kartaV = 0;
        kartaW = 0;
    }

    private void updateCoords()
    {
        kartaV = (int)(getV()/Spelplan.getKartskala());
        kartaW = (int)(getW()/Spelplan.getKartskala());
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

    public void setPunkt3D(Punkt3D value)
    {
        super.setPunkt3D(value);
        updateCoords();
    }

    public void setV(double value)
    {
        super.setV(value);
        updateCoords();
    }

    public void setW(double value)
    {
        super.setW(value);
        updateCoords();
    }

    public void setU(double value)
    {
        super.setU(value);
        updateCoords();
    }
}