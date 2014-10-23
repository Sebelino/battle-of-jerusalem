import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

abstract class Sprite extends Objekt3D
{
    protected Animering[][] animationer;
    protected Animering currentAnimation;
    protected BufferedImage shadow;

    protected Vektor2D speedInit;

    protected double speedWalk;
    protected double speedJump;
    protected Tillstand tillstand;
    protected int attacktime;
    protected int attacktimeLevel;
    protected int deathtime;
    protected int hurttime;
    protected int hurttimeLevel;

    public Sprite(int ID,Block3DSpel block,Vektor2D speedInit)
    {
        super(ID,block);
        this.speedInit = new Vektor2D(speedInit);
        attacktime = 0;
        hurttime = 0;
        hurttimeLevel = 4;
    }

    public Tillstand getTillstand()
    {
        return tillstand;
    }

    public void setTillstand(Tillstand tillstand)
    {
        this.tillstand = tillstand;
    }

    public double getSpeedInitWalk()
    {
        return speedInit.getX();
    }

    public double getSpeedWalk()
    {
        return new Vektor3D(speed.getX(),speed.getY(),0).abs();
    }

    public void setSpeedWalk(double value)
    {
        Vektor3D v = new Vektor3D();
        v = Vektor3D.projektion(speed,new Vektor3D(speed.getX(),speed.getY(),0));
        v.normera();
        v.multiplicera(value);
        speed.setX(v.getX());
        speed.setY(v.getY());
        v = null;
    }

    public void addSpeedWalk(double value)
    {
        setSpeedWalk(getSpeedWalk()+value);
    }

    public double getSpeedInitJump()
    {
        return speedInit.getY();
    }

    public boolean getCondition(int condis)
    {
        return tillstand.getCondition()[condis];
    }

    public void setCondition(int condis,boolean value)
    {
        tillstand.setCondition(condis,value);
    }

    public int getDirection()
    {
        return tillstand.getDirection();
    }

    public void setDirection(int direction)
    {
        tillstand.setDirection(direction);
    }

    public Animering[][] getAnimationer()
    {
        return animationer;
    }

    public void setCurrentAnimation(Animering anima)
    {
        currentAnimation = anima;
    }

    public int getCurrentAnimationHighestCondition()
    {
        return currentAnimation.getHighestCondition();
    }

    public int getCurrentAnimationDirection()
    {
        return currentAnimation.getDirection();
    }

    public void setCurrentAnimationHighestCondition(int value)
    {
        currentAnimation.setHighestCondition(value);
    }

    public void setCurrentAnimationDirection(int value)
    {
        currentAnimation.setDirection(value);
    }

    public void springAnimation()
    {
        currentAnimation.spring();
    }

    public int getHighestCondition()
    {
        return tillstand.getHighestCondition();
    }

    public int getDeathtime()
    {
        return attacktime;
    }

    public void decreaseDeathtime()
    {
        attacktime--;
    }

    public int getAttacktime()
    {
        return attacktime;
    }

    public void setAttacktime(int value)
    {
        attacktime = value;
    }

    public int getAttacktimeLevel()
    {
        return attacktime;
    }

    public int getHurttimeLevel()
    {
        return hurttimeLevel;
    }

    public int getHurttime()
    {
        return hurttime;
    }

    public void setHurttime(int value)
    {
        hurttime = value;
    }
}