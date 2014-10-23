import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Obstakler
{
    private BufferedImage rock;
    private BufferedImage hus1;
    private BufferedImage hus2;
    private BufferedImage hus3;
    private BufferedImage mur3;
    private BufferedImage mur4;

    public Obstakler()
    {
        rock = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Rock.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*150),(int)(Consts.FRAMESIZEY/1000.0*200));
        hus1 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Hus1.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*500),(int)(Consts.FRAMESIZEY/1000.0*500));
        hus2 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Hus2.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*500),(int)(Consts.FRAMESIZEY/1000.0*500));
        hus3 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Hus3.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*500),(int)(Consts.FRAMESIZEY/1000.0*500));
        mur3 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Mur3.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*500),(int)(Consts.FRAMESIZEY/1000.0*500));
        mur4 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Mur4.png",new Color(255,128,128)),(int)(Consts.FRAMESIZEX/1290.0*500),(int)(Consts.FRAMESIZEY/1000.0*500));
    }

    public void draw(Graphics2D g)
    {
        g.drawImage(rock,null,GameUtil.avrunda((-Kontroller.absoluteX+180)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-150)*(Consts.FRAMESIZEX/1000.0)));
        g.drawImage(hus1,null,GameUtil.avrunda((-Kontroller.absoluteX+500)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-1000)*(Consts.FRAMESIZEX/1000.0)));
        g.drawImage(hus2,null,GameUtil.avrunda((-Kontroller.absoluteX+180)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-1500)*(Consts.FRAMESIZEX/1000.0)));
        g.drawImage(hus3,null,GameUtil.avrunda((-Kontroller.absoluteX+180)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-2000)*(Consts.FRAMESIZEX/1000.0)));
        g.drawImage(mur3,null,GameUtil.avrunda((-Kontroller.absoluteX+180)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-2500)*(Consts.FRAMESIZEX/1000.0)));
        g.drawImage(mur4,null,GameUtil.avrunda((-Kontroller.absoluteX+180)*(Consts.FRAMESIZEX/1290.0)),GameUtil.avrunda((-Kontroller.absoluteY-3000)*(Consts.FRAMESIZEX/1000.0)));
    }
}