class Punkt2D
{
    private double x,y;

    public Punkt2D(double x,double y)
    {
        this.x = x;
        this.y = y;
    }

    public void andraX(double nyX)
    {
        x = nyX;
    }

    public void andraY(double nyY)
    {
        y = nyY;
    }

    public double avstandOrigo()
    {
        double avstand = Math.sqrt(x*x+y*y);
        return avstand;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double avstand(Punkt2D p)
    {
        return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
    }

    public static double avstand(Punkt2D p1,Punkt2D p2)
    {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }

    public static Punkt2D adder(Punkt2D p1,Punkt2D p2)
    {
        return new Punkt2D((p1.x+p2.x),(p1.y+p2.y));
    }

    public void adder(Punkt2D p)
    {
        x += p.x;
        y += p.y;
    }

    public static Punkt2D subtracter(Punkt2D p1,Punkt2D p2)
    {
        return new Punkt2D((p1.x-p2.x),(p1.y-p2.y));
    }

    public void subtracter(Punkt2D p)
    {
        x -= p.x;
        y -= p.y;
    }

    public void multiplicera(double skalar)
    {
        x *= skalar;
        y *= skalar;
    }

    double vinkel()
    {
        if(x == 0 &&
           y > 0)
        {
            return 90;
        }
        else if(x < 0 &&
                y == 0)
        {
            return 180;
        }
        else if(x == 0 &&
                y < 0)
        {
            return 270;
        }
        else if(x < 0 &&
                y > 0)
        {
            return 180+Math.toDegrees(Math.atan(y/x));
        }
        else if(x < 0 &&
                y < 0)
        {
            return 180+Math.toDegrees(Math.atan(y/x));
        }
        else if(x > 0 &&
                y < 0)
        {
            return 360+Math.toDegrees(Math.atan(y/x));
        }
        return Math.toDegrees(Math.atan(y/x));
    }
}