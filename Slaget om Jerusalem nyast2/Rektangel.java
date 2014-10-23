import java.awt.Graphics2D;

class Rektangel
{
    protected double x;
    protected double y;
    protected double width;
    protected double height;

    public Rektangel(){}

    public Rektangel(double x,double y,double width,double height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rektangel(double width,double height)
    {
        x = 0;
        y = 0;
        this.width = width;
        this.height = height;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setX(double value)
    {
        x = value;
    }

    public void setY(double value)
    {
        y = value;
    }

    public void setWidth(double value)
    {
        width = value;
    }

    public void setHeight(double value)
    {
        height = value;
    }

    public boolean inside(double xP,double yP)
    {
        return(xP > x-width/2 &&
               xP < x+width/2 &&
               yP > y-height/2 &&
               yP < y+height/2);
    }

    public void draw(Graphics2D g)
    {
        g.drawRect(GameUtil.avrunda(x-width/2),
                   GameUtil.avrunda(y-height/2),
                   GameUtil.avrunda(width),
                   GameUtil.avrunda(height));
    }
}