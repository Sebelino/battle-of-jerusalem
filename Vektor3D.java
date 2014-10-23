class Vektor3D
{
    private double x,y,z;

    public Vektor3D(){}

    public Vektor3D(double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vektor3D(double skalar,double x,double y,double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        normera();
        multiplicera(skalar);
    }

    public Vektor3D(Punkt3D p)
    {
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
    }

    public Vektor3D(double skalar,Punkt3D p)
    {
        this.x = p.getX();
        this.y = p.getY();
        this.z = p.getZ();
        normera();
        multiplicera(skalar);
    }

    public Vektor3D(Vektor3D vekt)
    {
        this.x = vekt.getX();
        this.y = vekt.getY();
        this.z = vekt.getZ();
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

    public static Vektor3D add(Vektor3D v1,Vektor3D v2)
    {
        return new Vektor3D((v1.getX()+v2.getX()),(v1.getY()+v2.getY()),(v1.getZ()+v2.getZ()));
    }

    public void add(Vektor3D v)
    {
        x += v.getX();
        y += v.getY();
        z += v.getZ();
    }

    public void multiplicera(double skalar)
    {
        x *= skalar;
        y *= skalar;
        z *= skalar;
    }

    public void normera()
    {
        if(abs() != 0)
        {
            multiplicera(1/abs());
        }
    }

    public static double skalarprodukt(Vektor3D v1,Vektor3D v2)
    {
        return v1.getX()*v2.getX()+v1.getY()*v2.getY()+v1.getZ()*v2.getZ();
    }

    public static Vektor3D projektion(Vektor3D v,Vektor3D riktning)
    {
        riktning.normera();
        return new Vektor3D(skalarprodukt(v,riktning),riktning.getX(),riktning.getY(),riktning.getZ());
    }

    public void rotate(Vektor3D vekt,double angle)
    {
        double tempX = x;
        double tempY = y;
        double tempZ = z;
        if(vekt.getX() == 0 && vekt.getY() == 0 && vekt.getZ() > 0)
        {
            x = Math.cos(angle)*x-Math.sin(angle)*y;
            y = Math.sin(angle)*x+Math.cos(angle)*y;
        }
        else if(vekt.getX() == 0 && vekt.getY() > 0 && vekt.getZ() == 0)
        {
            x = Math.cos(angle)*x+Math.sin(angle)*z;
            z = -Math.sin(angle)*x+Math.cos(angle)*z;
        }
        else if(vekt.getX() > 0 && vekt.getY() == 0 && vekt.getZ() == 0)
        {
            y = Math.cos(angle)*y-Math.sin(angle)*z;
            z = Math.sin(angle)*y+Math.cos(angle)*z;
        }
    }
}