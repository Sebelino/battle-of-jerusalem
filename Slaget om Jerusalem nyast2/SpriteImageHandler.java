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

public class SpriteImageHandler
{
    public static BufferedImage[][][] getProtagonistImages()
    {
        BufferedImage[][][] bilder;
        bilder = new BufferedImage[8][5][16]; //direktion,tillstånd,antalbilderförlängstaanimationen

        BufferedImage img0 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistN.png",new Color(255,128,128));
        BufferedImage img1 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistE.png",new Color(255,128,128));
        BufferedImage img2 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistS.png",new Color(255,128,128));
        BufferedImage img3 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistW.png",new Color(255,128,128));
        BufferedImage img4 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistNW.png",new Color(255,128,128));
        BufferedImage img5 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistNE.png",new Color(255,128,128));
        BufferedImage img6 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistSE.png",new Color(255,128,128));
        BufferedImage img7 = ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistSW.png",new Color(255,128,128));

        BufferedImage[] imgs0 = ImageUtil.splitImage(img0,10,2);
        BufferedImage[] imgs1 = ImageUtil.splitImage(img1,10,2);
        BufferedImage[] imgs2 = ImageUtil.splitImage(img2,10,2);
        BufferedImage[] imgs3 = ImageUtil.splitImage(img3,10,2);
        BufferedImage[] imgs4 = ImageUtil.splitImage(img4,10,2);
        BufferedImage[] imgs5 = ImageUtil.splitImage(img5,10,2);
        BufferedImage[] imgs6 = ImageUtil.splitImage(img6,10,2);
        BufferedImage[] imgs7 = ImageUtil.splitImage(img7,10,2);

        BufferedImage[][] imgses = new BufferedImage[][]{imgs0,imgs1,imgs2,imgs3,imgs4,imgs5,imgs6,imgs7};

        int[][] ordning = new int[][]{{0},{1,0,2},{3},{3},{4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}};

        for(int i = 0;i < 8;i++)
        {
            for(int j = 0;j < ordning.length;j++)
            {
                for(int k = 0;k < ordning[j].length;k++)
                {
                    bilder[i][j][k] = imgses[i][ordning[j][k]];
                }
            }
        }
        return bilder;
    }
/*
    public static Animationer[] createAnimationsProt()
    {
        Animation[][] animationer = new Animation[8][5];
        animationer[0][0] = new Animation(bilder[0][0],Tillstand.NORTH,new int[]{1,0,0,0,0},100);
        animationer[1] = new Animation(standbyEast,Tillstand.EAST,new int[]{1,0,0,0,0},100);
        animationer[2] = new Animation(standbySouth,Tillstand.SOUTH,new int[]{1,0,0,0,0},100);
        animationer[3] = new Animation(standbyWest,Tillstand.WEST,new int[]{1,0,0,0,0},100);
        animationer[4] = new Animation(standbyNorthwest,Tillstand.NORTHWEST,new int[]{1,0,0,0,0},100);
        animationer[5] = new Animation(standbyNortheast,Tillstand.NORTHEAST,new int[]{1,0,0,0,0},100);
        animationer[6] = new Animation(standbySoutheast,Tillstand.SOUTHEAST,new int[]{1,0,0,0,0},100);
        animationer[7] = new Animation(standbySouthwest,Tillstand.SOUTHWEST,new int[]{1,0,0,0,0},100);
        animationer[8] = new Animation(standbyNorth,Tillstand.NORTH,new int[]{0,1,0,0,0},100);
        animationer[9] = new Animation(standbyEast,Tillstand.EAST,new int[]{0,1,0,0,0},100);
        animationer[10] = new Animation(standbySouth,Tillstand.SOUTH,new int[]{0,1,0,0,0},100);
        animationer[11] = new Animation(standbyWest,Tillstand.WEST,new int[]{0,1,0,0,0},100);
        animationer[12] = new Animation(standbyNorthwest,Tillstand.NORTHWEST,new int[]{0,1,0,0,0},100);
        animationer[13] = new Animation(standbyNortheast,Tillstand.NORTHEAST,new int[]{0,1,0,0,0},100);
        animationer[14] = new Animation(standbySoutheast,Tillstand.SOUTHEAST,new int[]{0,1,0,0,0},100);
        animationer[15] = new Animation(standbySouthwest,Tillstand.SOUTHWEST,new int[]{0,1,0,0,0},100);
        return animationer;
    }
*/
}