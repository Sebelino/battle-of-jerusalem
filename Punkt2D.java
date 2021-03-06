class Punkt2D
{
    private double x,y;

    public Punkt2D(double x,double y)
    {
        this.x = x;
        this.y = y;
    }

    public void setX(double nyX)
    {
        x = nyX;
    }

    public void setY(double nyY)
    {
        y = nyY;
    }

    public double abs()
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

    public static Punkt2D add(Punkt2D p1,Punkt2D p2)
    {
        return new Punkt2D((p1.x+p2.x),(p1.y+p2.y));
    }

    public void add(Punkt2D p)
    {
        x += p.x;
        y += p.y;
    }

    public static Punkt2D subtract(Punkt2D p1,Punkt2D p2)
    {
        return new Punkt2D((p1.x-p2.x),(p1.y-p2.y));
    }

    public void subtract(Punkt2D p)
    {
        x -= p.x;
        y -= p.y;
    }

    public void multiplicera(double skalar)
    {
        x *= skalar;
        y *= skalar;
    }

    public Double arg()
    {
        if(argRadians() == null)
        {
            return null;
        }
        return new Double(argRadians());
    }

    public Double argRadians()
    {
        if(x == 0 &&
           y > 0)
        {
            return new Double(Math.PI/2);
        }
        else if(x == 0 &&
                y < 0)
        {
            return new Double(-Math.PI/2);
        }
        else if(x > 0 &&
                y == 0)
        {
            return new Double(0);
        }
        else if(x < 0 &&
                y == 0)
        {
            return new Double(Math.PI);
        }
        else if(x > 0 &&
                y > 0)
        {
            return new Double(Math.atan(y/x));
        }
        else if(x < 0 &&
                y > 0)
        {
            return new Double(Math.PI+Math.atan(y/x));
        }
        else if(x < 0 &&
                y < 0)
        {
            return new Double(-Math.PI+Math.atan(y/x));
        }
        else if(x > 0 &&
                y < 0)
        {
            return new Double(Math.atan(y/x));
        }
        return null;
    }

    public Double argDegrees()
    {
        if(argRadians() == null)
        {
            return null;
        }
        return new Double(180/Math.PI*argRadians());
    }
}