import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ruta extends RektangelProp
{
    private int antalTryck;
    private boolean accessibel;
    private boolean synlig;
    private BufferedImage[] bild;
    private BufferedImage currentBild;

    public Ruta(double x,double y,double width,double height,boolean synlig,boolean accessibel,String fil)
    {
        super(true,x,y,width,height);
        this.antalTryck = 0;
        this.accessibel = accessibel;
        this.synlig = synlig;
        bild = new BufferedImage[1];
	bild[0] = ImageUtil.makeColorTransparent(fil,new Color(255,128,128));
        bild[0] = ImageUtil.resize(bild[0],GameUtil.avrunda(width),GameUtil.avrunda(height));
        currentBild = bild[0];
    }

    public Ruta(RektangelProp rekt,boolean synlig,boolean accessibel,String fil)
    {
        super(true,rekt.getX(),rekt.getY(),rekt.getWidth(),rekt.getHeight());
        this.antalTryck = 0;
        this.accessibel = accessibel;
        this.synlig = synlig;
        bild = new BufferedImage[1];
	bild[0] = ImageUtil.makeColorTransparent(fil,new Color(255,128,128));
        bild[0] = ImageUtil.resize(bild[0],GameUtil.avrunda(width),GameUtil.avrunda(height));
        currentBild = bild[0];
    }

    public Ruta(double x,double y,double width,double height,boolean synlig,boolean accessibel,String[] fil)
    {
        super(true,x,y,width,height);
        this.antalTryck = 0;
        this.accessibel = accessibel;
        this.synlig = synlig;
        bild = new BufferedImage[fil.length];
        for(int i = 0;i < fil.length;i++)
        {
	    bild[i] = ImageUtil.makeColorTransparent(fil[i],new Color(255,128,128));
            bild[i] = ImageUtil.resize(bild[i],GameUtil.avrunda(width),GameUtil.avrunda(height));
        }
        currentBild = bild[0];
    }

    public Ruta(RektangelProp rekt,boolean synlig,boolean accessibel,String[] fil)
    {
        super(true,rekt.getX(),rekt.getY(),rekt.getWidth(),rekt.getHeight());
        this.antalTryck = 0;
        this.accessibel = accessibel;
        this.synlig = synlig;
        bild = new BufferedImage[fil.length];
        for(int i = 0;i < fil.length;i++)
        {
	    bild[i] = ImageUtil.makeColorTransparent(fil[i],new Color(255,128,128));
            bild[i] = ImageUtil.resize(bild[i],GameUtil.avrunda(width),GameUtil.avrunda(height));
        }
        currentBild = bild[0];
    }

    public int getAntalTryck()
    {
        return antalTryck;
    }

    public boolean getAccessibel()
    {
        return accessibel;
    }

    public void invertAccessibel()
    {
        accessibel = !accessibel;
    }

    public boolean getSynlig()
    {
        return synlig;
    }

    public void invertSynlig()
    {
        synlig = !synlig;
    }

    public void increaseAntalTryck()
    {
        antalTryck++;
    }

    public void setAccessibel(boolean value)
    {
        accessibel = value;
    }

    public void setSynlig(boolean value)
    {
        synlig = value;
    }

    public void draw(Graphics2D g)
    {
        g.drawImage(currentBild,
                    null,
                    GameUtil.avrunda(x-width/2),
                    GameUtil.avrunda(y-height/2));
    }

    public void rita(Graphics2D g)
    {
        if(synlig)
        {
            draw(g);
        }
    }
}