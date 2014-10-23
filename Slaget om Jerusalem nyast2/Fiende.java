import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;

class Fiende// extends Sprite
                   // implements ImageObserver
{
/*
    protected double speedJump;
    protected Bild shadow;

    public Fiende(Punkt3D p,
                  double length,
                  double width,
                  double height,
                  double speedWalk,
                  int direction)
    {
        this.p = p;
        this.length = length;
        this.width = width;
        this.height = height;
        this.speedWalk = speedWalk;
        this.speedJump = speedJump;
        condition = new boolean[3];
        condition[standby] = true;
        condition[walking] = false;
        condition[jumping] = false;
        this.direction = direction;
        bilder = new Bild[3][8];
        bilder[0][0] = new Bild("ProtagonistN.png");
        bilder[0][1] = new Bild("ProtagonistE.png");
        bilder[0][2] = new Bild("ProtagonistS.png");
        bilder[0][3] = new Bild("ProtagonistW.png");
        bilder[0][4] = new Bild("ProtagonistNW.png");
        bilder[0][5] = new Bild("ProtagonistNE.png");
        bilder[0][6] = new Bild("ProtagonistSE.png");
        bilder[0][7] = new Bild("ProtagonistSW.png");
        bilder[1][0] = new Bild("ProtagonistN.png");
        bilder[1][1] = new Bild("ProtagonistE.png");
        bilder[1][2] = new Bild("ProtagonistS.png");
        bilder[1][3] = new Bild("ProtagonistW.png");
        bilder[1][4] = new Bild("ProtagonistNW.png");
        bilder[1][5] = new Bild("ProtagonistNE.png");
        bilder[1][6] = new Bild("ProtagonistSE.png");
        bilder[1][7] = new Bild("ProtagonistSW.png");
        bilder[2][0] = new Bild("ProtagonistN.png");
        bilder[2][1] = new Bild("ProtagonistE.png");
        bilder[2][2] = new Bild("ProtagonistS.png");
        bilder[2][3] = new Bild("ProtagonistW.png");
        bilder[2][4] = new Bild("ProtagonistNW.png");
        bilder[2][5] = new Bild("ProtagonistNE.png");
        bilder[2][6] = new Bild("ProtagonistSE.png");
        bilder[2][7] = new Bild("ProtagonistSW.png");
        shadow = new Bild("Skugga.png");
        pPre = new Punkt3D(p.getX(),p.getY(),p.getZ());
        this.mapX = mapX;
        this.mapY = mapY;
    }

    public double getSpeedJump()
    {
        return speedJump;
    }

    public void setSpeedJump(double value)
    {
        speedJump = value;
    }

    public void addSpeedJump(double value)
    {
        speedJump += value;
    }

    public void moveForward()
    {
        if(direction == north)
        {
            p.addX(speedWalk/Math.sqrt(2));
            p.addY(speedWalk/Math.sqrt(2));
        }
        else if(direction == east)
        {
            p.addX(-speedWalk/Math.sqrt(2));
            p.addY(speedWalk/Math.sqrt(2));
        }
        else if(direction == south)
        {
            p.addX(-speedWalk/Math.sqrt(2));
            p.addY(-speedWalk/Math.sqrt(2));
        }
        else if(direction == west)
        {
            p.addX(speedWalk/Math.sqrt(2));
            p.addY(-speedWalk/Math.sqrt(2));
        }
        else if(direction == northwest)
        {
            p.addX(speedWalk);
        }
        else if(direction == northeast)
        {
            p.addY(speedWalk);
        }
        else if(direction == southeast)
        {
            p.addX(-speedWalk);
        }
        else if(direction == southwest)
        {
            p.addY(-speedWalk);
        }
    }

    public Bild getShadow()
    {
        return shadow;
    }

    public void AI0(Protagonist prot)
    {
        if(p.getX() < prot.getV())
        {
            p.addX(speedWalk);
        }
        else if(p.getX() > prot.getV())
        {
            p.addX(-speedWalk);
        }
        if(p.getY() < prot.getW())
        {
            p.addY(speedWalk);
        }
        else if(p.getY() > prot.getW())
        {
            p.addY(-speedWalk);
        }
    }

    public boolean imageUpdate(Image img,
                               int infoflags,
                               int x,
                               int y,
                               int width,
                               int height)
    {
        return true;
    }

    private void drawGrid(Graphics g,double x,double y,double deltaX,double deltaY,double height)
    {
        g.drawLine((int)x-1,(int)y,(int)x+1,(int)y);
        g.drawLine((int)x-1,(int)y-1,(int)x+1,(int)y-1);
        g.drawLine((int)x-1,(int)y+1,(int)x+1,(int)y+1);
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y-deltaY/2+height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)x,(int)(y+deltaY/2+height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)x,(int)(y-deltaY/2+height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y-height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y-height/2),(int)x,(int)(y-deltaY/2-height/2));
        g.drawLine((int)(x-deltaX/2),(int)(y+height/2),(int)(x-deltaX/2),(int)(y-height/2));
        g.drawLine((int)(x+deltaX/2),(int)(y+height/2),(int)(x+deltaX/2),(int)(y-height/2));
        g.drawLine((int)x,(int)(y+deltaY/2+height/2),(int)x,(int)(y+deltaY/2-height/2));
        g.drawLine((int)x,(int)(y-deltaY/2+height/2),(int)x,(int)(y-deltaY/2-height/2));
    }

    public void draw(Graphics g,Image fiendeImg,Image skuggaImg)
    {
        double x = mapX+3*(getW()-getV());
        double xNW = x-3*(length+width)/2;
        double deltaX = 3*(length+width);
        double y = mapY-2*(getV()+getW())-groundlevel;
        double yNW = y-2*(length+width)/2;
        double deltaY = 2*(length+width);
        g.drawImage(skuggaImg,
                    (int)xNW,
                    (int)yNW,
                    (int)deltaX,
                    (int)deltaY,
                    this);
        g.drawImage(fiendeImg,
                    (int)xNW,
                    (int)(yNW-getU()+groundlevel-height/2),
                    (int)deltaX,
                    (int)(deltaY+height),
                    this);
        drawGrid(g,x,y-getU()+groundlevel,deltaX,deltaY,height);
    }
*/
}