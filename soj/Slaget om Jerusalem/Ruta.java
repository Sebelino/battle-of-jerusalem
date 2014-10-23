import java.applet.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

class Ruta
                  //implements SpelplanInterface
{
/*
    protected Animation[] animationer;
    protected Animation currentAnimation;
    protected BufferedImage shadow;
    protected Block3D block;
    protected Block3D blockPre;

    public Ruta(Animation[] animationer,BufferedImage shadow,Block3D block)
    {
        this.block = new Block3D(new Punkt3D(block.getV(),block.getW(),block.getU()),block.getLength(),block.getWidth(),block.getHeight());
        this.blockPre = new Block3D(new Punkt3D(block.getV(),block.getW(),block.getU()),block.getLength(),block.getWidth(),block.getHeight());
        this.animationer = animationer;
        if(animationer.length >= 2)
            currentAnimation = animationer[2];
        else
            currentAnimation = animationer[0];
        this.shadow = shadow;
    }

    public Block3D getBlock3D()
    {
        return block;
    }

    public Block3D getBlock3DPre()
    {
        return blockPre;
    }

    public void setPunkt3D(Punkt3D value)
    {
        block.setPunkt3D(new Punkt3D(value.getX(),value.getY(),value.getZ()));
    }

    public void setPunkt3DPre(Punkt3D value)
    {
        blockPre.setPunkt3D(new Punkt3D(value.getX(),value.getY(),value.getZ()));
    }

    public void setV(double value)
    {
        block.setV(value);
    }

    public void setW(double value)
    {
        block.setW(value);
    }

    public void setU(double value) 
    {
        block.setU(value);
    }

    public void setLength(double value)
    {
        block.setLength(value);
    }

    public void setWidth(double value)
    {
        block.setWidth(value);
    }

    public void setHeight(double value)
    {
        block.setHeight(value);
    }

    public void setGroundlevel(double value)
    {
        block.setGroundlevel(value);
    }

    public void setGroundlevelPre(double value)
    {
        blockPre.setGroundlevel(value);
    }

    public void draw()
    {
        Graphics g = this.getGraphics();
        paintComponent(g);
        rita((Graphics2D)g);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
    }

    private void rita(Graphics2D g)
    {
        double x = MAPX+3*(block.getW()-block.getV());
        double deltaX = 3*(block.getLength()+block.getWidth())+1;
        double y = MAPY-2*(block.getV()+block.getW())-block.getU();
        double deltaY = 2*(block.getLength()+block.getWidth())+1;

        BufferedImage skuggbild = ImageUtil.resize(shadow,(int)deltaX,(int)deltaY);
        BufferedImage bild = ImageUtil.resize(currentAnimation.getCurrentImg(),(int)deltaX,(int)(deltaY+block.getHeight()));

        g.drawImage(skuggbild,
                    null,
                    (int)(x-deltaX/2),
                    (int)(y+block.getU()-block.getGroundlevel()-deltaY/2));

        g.drawImage(bild,
                    null,
                    (int)(x-deltaX/2),
                    (int)(y-deltaY/2-block.getHeight()/2));
        ritaGrid(g);
    }

    private void ritaGrid(Graphics2D g)
    {
        block.drawGrid(g);
    }
*/
}