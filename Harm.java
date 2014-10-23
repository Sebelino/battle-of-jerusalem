import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Harm extends Objekt3D
{
    protected double speedInitVW;
    protected boolean life;
    protected int lifetime;
    protected int damage;
    protected Animation animation;

    public Harm(int spriteID,Block3DSpel block,double speedInitVW,Vektor3D speed,int lifetime,int damage,Animation animation)
    {
        super(spriteID,block);
        this.speedInitVW = speedInitVW;
        this.speed = new Vektor3D(speed);
        this.lifetime = lifetime;
        life = false;
        this.damage = damage;
        this.animation = animation;
    }

    public void flyt()
    {
        move();
        lifetime--;
    }

    public void springAnimation()
    {
        animation.spring();
    }

    public boolean getLife()
    {
        return life;
    }

    public void setLife(boolean value)
    {
        life = value;
    }

    public int getLifetime()
    {
        return lifetime;
    }

    public void setLifetime(int value)
    {
        lifetime = value;
    }

    public void decrease()
    {
        lifetime--;
    }

    public void shrink(double x,double y,double z)
    {
        block.setLength(block.getLength()-x);
        block.setWidth(block.getWidth()-y);
        block.setHeight(block.getHeight()-z);
    }

    public void draw(Graphics2D g)
    {
        double x = Consts.MAPX+3*(block.getW()-block.getV());
        double deltaX = 3*(block.getLength()+block.getWidth())+1;
        double y = Consts.MAPY-2*(block.getV()+block.getW())+block.getU();
        double deltaY = 2*(block.getLength()+block.getWidth())+1;

        g.drawImage(ImageUtil.resize(animation.getCurrentImg(),(int)deltaX,(int)(deltaY+block.getHeight())),
                    null,
                    GameUtil.avrunda(-Kontroller.absoluteX+x-deltaX/2),
                    GameUtil.avrunda(-Kontroller.absoluteY+y-(deltaY/2+block.getHeight()/2)));
//        ritaGrid(g);
    }

    private void ritaGrid(Graphics2D g)
    {
        block.drawGrid(g,-Kontroller.absoluteX,-Kontroller.absoluteY);
    }
}