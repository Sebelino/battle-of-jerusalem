class Punkt3D
{
    private double x,y,z;

    public Punkt3D(){}

    public Punkt3D(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Punkt3D(Punkt3D p)
    {
        x = p.getX();
        y = p.getY();
        z = p.getZ();
    }

    public Punkt3D(Punkt3D p1,Punkt3D p2)
    {
        x = add(p1,p2).getX();
        y = add(p1,p2).getY();
        z = add(p1,p2).getZ();
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    public void setX(double v)
    {
        x = v;
    }

    public void setY(double v)
    {
        y = v;
    }

    public void setZ(double v)
    {
        z = v;
    }

    public void addX(double v)
    {
        x += v;
    }

    public void addY(double v)
    {
        y += v;
    }

    public void addZ(double v)
    {
        z += v;
    }

    public double abs()
    {
        return Math.sqrt(x*x+y*y+z*z);
    }

    public double avstand(Punkt3D p)
    {
        return Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y)+(p.z-z)*(p.z-z));
    }

    public static double avstand(Punkt3D p1,Punkt3D p2)
    {
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y)+(p1.z-p2.z)*(p1.z-p2.z));
    }

    public static Punkt3D add(Punkt3D p1,Punkt3D p2)
    {
        return new Punkt3D((p1.x+p2.x),(p1.y+p2.y),(p1.z+p2.z));
    }

    public void add(Punkt3D p)
    {
        x += p.x;
        y += p.y;
        z += p.z;
    }

    public static Punkt3D subtract(Punkt3D p1,Punkt3D p2)
    {
        return new Punkt3D((p1.x-p2.x),(p1.y-p2.y),(p1.z-p2.z));
    }

    public void subtract(Punkt3D p)
    {
        x -= p.x;
        y -= p.y;
        z -= p.z;
    }

    public void multiplicera(double skalar)
    {
        x *= skalar;
        y *= skalar;
        z *= skalar;
    }

    public static Double arg(Punkt3D p)
    {
        if(argRadians(p) == null)
        {
            return null;
        }
        return new Double(argRadians(p));
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

    public static Double argRadians(Punkt3D p)
    {
        if(p.getX() == 0 &&
           p.getY() > 0)
        {
            return new Double(Math.PI/2);
        }
        else if(p.getX() == 0 &&
                p.getY() < 0)
        {
            return new Double(-Math.PI/2);
        }
        else if(p.getX() > 0 &&
                p.getY() == 0)
        {
            return new Double(0);
        }
        else if(p.getX() < 0 &&
                p.getY() == 0)
        {
            return new Double(Math.PI);
        }
        else if(p.getX() > 0 &&
                p.getY() > 0)
        {
            return new Double(Math.atan(p.getY()/p.getX()));
        }
        else if(p.getX() < 0 &&
                p.getY() > 0)
        {
            return new Double(Math.PI+Math.atan(p.getY()/p.getX()));
        }
        else if(p.getX() < 0 &&
                p.getY() < 0)
        {
            return new Double(-Math.PI+Math.atan(p.getY()/p.getX()));
        }
        else if(p.getX() > 0 &&
                p.getY() < 0)
        {
            return new Double(Math.atan(p.getY()/p.getX()));
        }
        return null;
    }

    public static Double argDegrees(Punkt3D p)
    {
        if(argRadians(p) == null)
        {
            return null;
        }
        return new Double(180/Math.PI*argRadians(p));
    }
}