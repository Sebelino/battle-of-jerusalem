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

class Protagonist extends Sprite
{
    public Protagonist(int ID,
                       Block3DSpel block,
                       Vektor2D speedInit)
    {
        super(ID,block,speedInit);
        tillstand = new Tillstand(Consts.SOUTH,new boolean[]{false,false,false,false,false,false,true});
        deathtime = 50;
        animationer = AnimationUtil.createAnimationsProt();
        currentAnimation = animationer[Consts.SOUTH][Consts.STANDBY];
        BufferedImage shadow = ImageUtil.makeColorTransparent("Pics/Skugga.png",new Color(255,128,128));
        this.shadow = shadow;
        StatsProt.healthMax = 50;
        StatsProt.health = 50;
    }

    public void draw(Graphics2D g)
    {
        double x = 3*(block.getW()-block.getV());
        double deltaX = 3*(block.getLength()+block.getWidth())+1;
        double y = -2*(block.getV()+block.getW())+block.getU();
        double deltaY = 2*(block.getLength()+block.getWidth())+1;

        Kontroller.absoluteX = GameUtil.avrunda(x);
        Kontroller.absoluteY = GameUtil.avrunda(y);

        BufferedImage skuggbild = ImageUtil.resize(shadow,(int)deltaX,(int)deltaY);
        BufferedImage bild = ImageUtil.resize(currentAnimation.getCurrentImg(),(int)(Consts.IMAGEWIDTHRATIO*deltaX),(int)(Consts.IMAGEHEIGHTRATIO*(deltaY+block.getHeight())));
        g.drawImage(skuggbild,
                    null,
                    (int)(Consts.MAPX-Kontroller.absoluteX+x-deltaX/2),
                    (int)(Consts.MAPY+deltaY/2-block.getU()-block.getHeight()/2+getSpeedU()+getGroundlevel()));

        g.drawImage(bild,
                    null,
                    (int)(Consts.MAPX-Consts.IMAGEWIDTHRATIO*deltaX/2),
                    (int)(Consts.MAPY-Consts.IMAGEHEIGHTRATIO*(block.getHeight()-deltaY/2)));
//        ritaGrid(g);
    }

    private void ritaGrid(Graphics2D g)
    {
        block.drawGrid(g,-Kontroller.absoluteX,-Kontroller.absoluteY);
    }
}