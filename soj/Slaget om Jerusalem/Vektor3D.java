class Vektor3D
{
/*
    private double x,y,z;

    public Vektor3D(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
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

    public double avstandOrigo()
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

    public static Punkt3D adder(Punkt3D p1,Punkt3D p2)
    {
        return new Punkt3D((p1.x+p2.x),(p1.y+p2.y),(p1.z+p2.z));
    }

    public void adder(Punkt3D p)
    {
        x += p.x;
        y += p.y;
        z += p.z;
    }

    public static Punkt3D subtracter(Punkt3D p1, Punkt3D p2)
    {
        return new Punkt3D((p1.x-p2.x),(p1.y-p2.y),(p1.z-p2.z));
    }

    public void subtracter(Punkt3D p)
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
*/
}