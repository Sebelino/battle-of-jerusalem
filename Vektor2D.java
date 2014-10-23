class Vektor2D
{
    private double x,y;

    public Vektor2D(){}

    public Vektor2D(double x,double y)
    {
        this.x = x;
        this.y = y;
    }

    public Vektor2D(double skalar,double x,double y)
    {
        this.x = x;
        this.y = y;
        normera();
        multiplicera(skalar);
    }

    public Vektor2D(Punkt2D p)
    {
        this.x = p.getX();
        this.y = p.getY();
    }

    public Vektor2D(double skalar,Punkt2D p)
    {
        this.x = p.getX();
        this.y = p.getY();
        normera();
        multiplicera(skalar);
    }

    public Vektor2D(Vektor2D vekt)
    {
        this.x = vekt.getX();
        this.y = vekt.getY();
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setX(double v)
    {
        x = v;
    }

    public void setY(double v)
    {
        y = v;
    }

    public void addX(double v)
    {
        x += v;
    }

    public void addY(double v)
    {
        y += v;
    }

    public double abs()
    {
        return Math.sqrt(x*x+y*y);
    }

    public static Vektor2D add(Vektor2D v1,Vektor2D v2)
    {
        return new Vektor2D((v1.getX()+v2.getX()),(v1.getY()+v2.getY()));
    }

    public void add(Vektor2D v)
    {
        x += v.getX();
        y += v.getY();
    }

    public void multiplicera(double skalar)
    {
        x *= skalar;
        y *= skalar;
    }

    public void normera()
    {
        if(abs() != 0)
        {
            multiplicera(1/abs());
        }
    }

    public static double skalarprodukt(Vektor2D v1,Vektor2D v2)
    {
        return v1.getX()*v2.getX()+v1.getY()*v2.getY();
    }

    public static Vektor2D projektion(Vektor2D v,Vektor2D riktning)
    {
        riktning.normera();
        return new Vektor2D(skalarprodukt(v,riktning),riktning.getX(),riktning.getY());
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