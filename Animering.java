import java.awt.image.BufferedImage;

class Animering
{
    private Animation animation;
    private int direction;
    private int highestCondition;

    public Animering(Animation animation,int direction,int highestCondition)
    {
        this.animation = new Animation();
        this.animation = animation;
        this.direction = direction;
        this.highestCondition = highestCondition;
    }

    public Animation getAnimation()
    {
        return animation;
    }

    public int getHighestCondition()
    {
        return highestCondition;
    }

    public int getDirection()
    {
        return direction;
    }

    public void setHighestCondition(int value)
    {
        highestCondition = value;
    }

    public void setDirection(int value)
    {
        direction = value;
    }

    public BufferedImage getCurrentImg()
    {
        return animation.getCurrentImg();
    }

    public int getCurrentImgID()
    {
        return animation.getCurrentImgID();
    }

    public boolean getAktiverad()
    {
        return animation.getAktiverad();
    }

    public void spring()
    {
        animation.spring();
    }
}