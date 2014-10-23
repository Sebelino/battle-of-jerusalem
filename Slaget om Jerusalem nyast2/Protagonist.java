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
                         implements SpelplanInterface,TillstandInterface
{
    protected double speedJump;
//    protected Strike slash;

    public Protagonist(Block3D block,
                       double speedWalk,
                       double speedJump)
    {
        this.block = new Block3D(new Punkt3D(block.getV(),block.getW(),block.getU()),block.getLength(),block.getWidth(),block.getHeight());
        this.blockPre = new Block3D(new Punkt3D(block.getV(),block.getW(),block.getU()),block.getLength(),block.getWidth(),block.getHeight());

        this.speedWalk = speedWalk;
        this.speedJump = speedJump;

        tillstand = new Tillstand(Tillstand.SOUTH,new boolean[]{true,false,false,false,false});

        BufferedImage shadow = ImageUtil.makeColorTransparent("Pics/Skugga.png",new Color(255,128,128));

//        slash = new Strike(new Punkt3D(5,0,0),3,3,3);

    /*    this.animationer = animationer;
        if(animationer.length >= 2)
            currentAnimation = animationer[2];
        else
            currentAnimation = animationer[0];
        this.shadow = shadow;*/
    }

    public double getSpeedJump()
    {
        return speedJump;
    }

    public void setSpeedJump(double value)
    {
        speedJump = value;
    }

    public void moveForward()
    {
        if(getDirection() == NORTH)
        {
            addV(speedWalk/Math.sqrt(2));
            addW(speedWalk/Math.sqrt(2));
        }
        else if(getDirection() == EAST)
        {
            addV(-speedWalk/Math.sqrt(2));
            addW(speedWalk/Math.sqrt(2));
        }
        else if(getDirection() == SOUTH)
        {
            addV(-speedWalk/Math.sqrt(2));
            addW(-speedWalk/Math.sqrt(2));
        }
        else if(getDirection() == WEST)
        {
            addV(speedWalk/Math.sqrt(2));
            addW(-speedWalk/Math.sqrt(2));
        }
        else if(getDirection() == NORTHWEST)
        {
            addV(speedWalk);
        }
        else if(getDirection() == NORTHEAST)
        {
            addW(speedWalk);
        }
        else if(getDirection() == SOUTHEAST)
        {
            addV(-speedWalk);
        }
        else if(getDirection() == SOUTHWEST)
        {
            addW(-speedWalk);
        }
    }
/*
    public void meleeStrike()
    {
        slash.activate(100);
    }
*/

   /* public void animera()
    {
        animation.flyt();
    }*/

    public void draw(Graphics2D g)
    {
        double x = MAPX+3*(block.getW()-block.getV());
        double deltaX = 3*(block.getLength()+block.getWidth())+1;
        double y = MAPY-2*(block.getV()+block.getW())-block.getU();
        double deltaY = 2*(block.getLength()+block.getWidth())+1;

 //     BufferedImage skuggbild = ImageUtil.resize(shadow,(int)deltaX,(int)deltaY);
        //BufferedImage bild = ImageUtil.resize(currentAnimation.getCurrentImg(),(int)deltaX,(int)(deltaY+block.getHeight()));
        g.drawImage(shadow,
                    null,
                    (int)(x-deltaX/2),
                    (int)(y+block.getU()-block.getGroundlevel()-deltaY/2));

        //g.drawImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistS.png", new Color(255,128,128)),
          //          null,
            //        GameUtil.avrunda(x-deltaX/2),
              //      GameUtil.avrunda(y-deltaY/2-block.getHeight()/2));
        ritaGrid(g);
    }

    private void ritaGrid(Graphics2D g)
    {
        block.drawGrid(g);
    }
}