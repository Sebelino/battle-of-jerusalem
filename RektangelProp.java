import java.awt.Graphics2D;

class RektangelProp extends Rektangel
{
    public RektangelProp(double x,double y,double width,double height)
    {
        super(x,y,width,height);
    }

    public RektangelProp(boolean prop,double x,double y,double width,double height)
    {
        if(prop)
        {
            this.x = x*Consts.FRAMESIZEX;
            this.y = y*Consts.FRAMESIZEY;
            this.width = width*Consts.FRAMESIZEX;
            this.height = height*Consts.FRAMESIZEY;
        }
        else
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    public double getXProp()
    {
        return x/Consts.FRAMESIZEX;
    }

    public double getYProp()
    {
        return y/Consts.FRAMESIZEY;
    }

    public double getWidthProp()
    {
        return width/Consts.FRAMESIZEX;
    }

    public double getHeightProp()
    {
        return height/Consts.FRAMESIZEY;
    }

    public void setXProp(double value)
    {
        x = value*Consts.FRAMESIZEX;
    }

    public void setYProp(double value)
    {
        y = value*Consts.FRAMESIZEY;
    }

    public void setWidthProp(double value)
    {
        width = value*Consts.FRAMESIZEX;
    }

    public void setHeightProp(double value)
    {
        height = value*Consts.FRAMESIZEY;
    }
}