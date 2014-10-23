import java.awt.*;

public class Block
{
/*
    protected double xPos;
    protected double yPos;
    protected double width;
    protected double height;

    public Block(double xPos,
                 double yPos,
                 double width,
                 double height)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }

    public double getXPos()
    {
        return xPos;
    }

    public double getYPos()
    {
        return yPos;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public void setXPos(double xPos)
    {
        this.xPos = xPos;
    }

    public void setYPos(double yPos)
    {
        this.yPos = yPos;
    }

    public void barrier(Protagonist prot)
    {
        double k = (prot.getYPos()-prot.yPosPre)/(prot.getXPos()-prot.xPosPre);
        double theta = angle((prot.getXPos()-prot.xPosPre),
                             (prot.getYPos()-prot.yPosPre));
        if(inside(prot))
        {
            prot.setXSpeed(0);
            prot.setYSpeed(0);
            while(inside(prot))
            {
                if(theta == 0)
                {
                    prot.addXPos(-1);
                }
                else if(theta == 90)
                {
                    prot.addYPos(1);
                }
                else if(theta == 180)
                {
                    prot.addXPos(1);
                }
                else if(theta == 270)
                {
                    prot.addYPos(-1);
                }
                else if(theta > 0 &&
                        theta < 90)
                {
                    prot.addXPos(-1);
                    prot.addYPos(-k);
                }
                else if(theta > 90 &&
                        theta < 180)
                {
                    prot.addXPos(1);
                    prot.addYPos(k);
                }
                else if(theta > 180 &&
                        theta < 270)
                {
                    prot.addXPos(1);
                    prot.addYPos(k);
                }
                else if(theta > 270 &&
                        theta < 360)
                {
                    prot.addXPos(-1);
                    prot.addYPos(-k);
                }
            }
        }
    }

    public boolean inside(Protagonist prot)
    {
        return (prot.getXPos()+prot.getWidth()/2 >= xPos &&
                prot.getYPos()+prot.getHeight()/2-yPos >= 0 &&
                prot.getXPos()-prot.getWidth()/2-(xPos+width) < 0 &&
                prot.getYPos()-prot.getHeight()/2-(yPos+height) < 0);
    }

    public void friction(Protagonist prot)
    {
        if(prot.getXSpeed() > 0)
        {
            prot.setXSpeed(prot.getXSpeed()-Protagonist.friction);
            if(prot.getXSpeed() < 0)
            {
                prot.setXSpeed(0);
            }
        }
        else if(prot.getXSpeed() < 0)
        {
            prot.setXSpeed(prot.getXSpeed()+Protagonist.friction);
            if(prot.getXSpeed() > 0)
            {
                prot.setXSpeed(0);
            }
        }
    }

    public static double angle(double deltaX,
                               double deltaY)
    {
        double a = 0;
        if(deltaX == 0 &&
           deltaY < 0)
        {
            a = Math.PI/2;
        }
        else if(deltaX == 0 &&
                deltaY > 0)
        {
            a = 3*Math.PI/2;
        }
        else if(deltaX < 0 &&
                deltaY == 0)
        {
            a = Math.PI;
        }
        else if(deltaX > 0 &&
                deltaY == 0)
        {
            a = 0;
        }
        else
        {
            double k = deltaY/deltaX;
            if(deltaX < 0 &&
               deltaY < 0)
            {
                a = Math.PI-Math.atan(k);
            }
            else if(deltaX < 0 &&
                    deltaY > 0)
            {
                a = Math.PI-Math.atan(k);
            }
            else if(deltaX > 0 &&
                    deltaY < 0)
            {
                a = Math.atan(-k);
            }
            else if(deltaX > 0 &&
                    deltaY > 0)
            {
                a = Math.atan(-k)+2*Math.PI;
            }
        }
        return Math.toDegrees(a);
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect((int)xPos,
                   (int)yPos,
                   (int)width,
                   (int)height);
        g.setColor(Color.black);
    }
*/
}