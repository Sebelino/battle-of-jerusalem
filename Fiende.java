import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class Fiende extends Sprite
{
    protected Vektor3D[] riktning;
    protected StatsFiende stats;

    public Fiende(int ID,
                  Block3DSpel block,
                  Vektor2D speedInit)
    {
        super(ID,block,speedInit);
        tillstand = new Tillstand(Consts.SOUTH,new boolean[]{false,false,false,false,false,false,true});
        attacktime = 50;
        deathtime = 50;
        animationer = AnimationUtil.createAnimationsFiende();
        currentAnimation = animationer[Consts.SOUTH][Consts.STANDBY];
        BufferedImage shadow = ImageUtil.makeColorTransparent("Pics/Skugga.png",new Color(255,128,128));
        this.shadow = shadow;
        stats = new StatsFiende();
    }

    public int getHealth()
    {
        return stats.getHealth();
    }

    public int getHealthMax()
    {
        return stats.getHealthMax();
    }

    public int getHighestCondition()
    {
        return tillstand.getHighestCondition();
    }

    public void draw(Graphics2D g)
    {
        double x = Consts.MAPX+3*(block.getW()-block.getV());
        double deltaX = 3*(block.getLength()+block.getWidth())+1;
        double y = Consts.MAPY-2*(block.getV()+block.getW())+block.getU();
        double deltaY = 2*(block.getLength()+block.getWidth())+1;

        BufferedImage skuggbild = ImageUtil.resize(shadow,(int)deltaX,(int)deltaY);
        BufferedImage bild = ImageUtil.resize(currentAnimation.getCurrentImg(),(int)(Consts.IMAGEWIDTHRATIO*deltaX),(int)(Consts.IMAGEHEIGHTRATIO*(deltaY+block.getHeight())));
        g.drawImage(skuggbild,
                    null,
                    (int)(-Kontroller.absoluteX+x-deltaX/2),
                    (int)(-Kontroller.absoluteY+y-block.getU()+block.getGroundlevel()-deltaY/2));

        g.drawImage(bild,
                    null,
                    GameUtil.avrunda(-Kontroller.absoluteX+x-Consts.IMAGEWIDTHRATIO*deltaX/2),
                    GameUtil.avrunda(-Kontroller.absoluteY+y-Consts.IMAGEHEIGHTRATIO*(deltaY/2+block.getHeight()/2)));
//        ritaGrid(g);
    }

    private void ritaGrid(Graphics2D g)
    {
        block.drawGrid(g,-Kontroller.absoluteX,-Kontroller.absoluteY);
    }
}