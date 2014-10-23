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

public class AnimationUtil
{
    private static BufferedImage[] createImagesCross()
    {
        BufferedImage[] imgs = {Bilder.cross0,Bilder.cross1,Bilder.cross2,Bilder.cross3};
        return imgs;
    }

    private static BufferedImage[] createImagesHarm()
    {
        BufferedImage[] imgs = {Bilder.harm};
        return imgs;
    }

    private static BufferedImage[][][] createImagesProt()
    {
        BufferedImage[][][] bilder = null;

        BufferedImage[] imgs0 = Bilder.protN;
        BufferedImage[] imgs1 = Bilder.protE;
        BufferedImage[] imgs2 = Bilder.protS;
        BufferedImage[] imgs3 = Bilder.protW;
        BufferedImage[] imgs4 = Bilder.protNW;
        BufferedImage[] imgs5 = Bilder.protNE;
        BufferedImage[] imgs6 = Bilder.protSE;
        BufferedImage[] imgs7 = Bilder.protSW;

        BufferedImage[][] imgses = new BufferedImage[][]{imgs0,imgs1,imgs2,imgs3,imgs4,imgs5,imgs6,imgs7};

        imgs0 = null;
        imgs1 = null;
        imgs2 = null;
        imgs3 = null;
        imgs4 = null;
        imgs5 = null;
        imgs6 = null;
        imgs7 = null;

        int[] dead = {13,14,15,16};
        int[] hurt = {9,10,11,12};
        int[] attacking = {5,6,7,8};
        int[] jumping = {4};
        int[] airborne = {4};
        int[] walking = {2,1,3,1};
        int[] standby = {0};

        int[][] ordning = {dead,hurt,attacking,jumping,airborne,walking,standby};
        int[][][] revisor = new int[8][][];
        for(int i = 0;i < 8;i++)
        {
            revisor[i] = ordning;
        }
        bilder = new BufferedImage[revisor.length][][];
        for(int i = 0;i < 8;i++)
        {
            bilder[i] = new BufferedImage[revisor[0].length][];
            for(int j = 0;j < revisor[0].length;j++)
            {
                bilder[i][j] = new BufferedImage[revisor[0][j].length];
            }
        }

        for(int i = 0;i < revisor.length;i++)
        {
            for(int j = 0;j < revisor[0].length;j++)
            {
                for(int k = 0;k < revisor[0][j].length;k++)
                {
                    bilder[i][j][k] = imgses[i][revisor[0][j][k]];
                }
            }
        }
        return bilder;
    }

    private static BufferedImage[][][] createImagesFiende()
    {
        BufferedImage[][][] bilder = null;

        BufferedImage[] imgs0 = Bilder.naziN;
        BufferedImage[] imgs1 = Bilder.naziE;
        BufferedImage[] imgs2 = Bilder.naziS;
        BufferedImage[] imgs3 = Bilder.naziW;
        BufferedImage[] imgs4 = Bilder.naziNW;
        BufferedImage[] imgs5 = Bilder.naziNE;
        BufferedImage[] imgs6 = Bilder.naziSE;
        BufferedImage[] imgs7 = Bilder.naziSW;

        BufferedImage[][] imgses = new BufferedImage[][]{imgs0,imgs1,imgs2,imgs3,imgs4,imgs5,imgs6,imgs7};

        imgs0 = null;
        imgs1 = null;
        imgs2 = null;
        imgs3 = null;
        imgs4 = null;
        imgs5 = null;
        imgs6 = null;
        imgs7 = null;

        int[] dead = {7,8,9,10,11,12,13,14};
        int[] hurt = {5,6};
        int[] attacking = {4};
        int[] jumping = {0};
        int[] airborne = {0};
        int[] walking = {2,1,3,1};
        int[] standby = {0};

        int[][] ordning = {dead,hurt,attacking,jumping,airborne,walking,standby};
        int[][][] revisor = new int[8][][];
        for(int i = 0;i < 8;i++)
        {
            revisor[i] = ordning;
        }
        bilder = new BufferedImage[revisor.length][][];
        for(int i = 0;i < 8;i++)
        {
            bilder[i] = new BufferedImage[revisor[0].length][];
            for(int j = 0;j < revisor[0].length;j++)
            {
                bilder[i][j] = new BufferedImage[revisor[0][j].length];
            }
        }

        for(int i = 0;i < revisor.length;i++)
        {
            for(int j = 0;j < revisor[0].length;j++)
            {
                for(int k = 0;k < revisor[0][j].length;k++)
                {
                    bilder[i][j][k] = imgses[i][revisor[0][j][k]];
                }
            }
        }
        return bilder;
    }

    public static Animation makeAnimationsCross()
    {
        BufferedImage[] bilder = createImagesCross();
        return new Animation(bilder,1,true);
    }

    public static Animation makeAnimationsHarm()
    {
        BufferedImage[] bilder = createImagesHarm();
        return new Animation(bilder,1000,true);
    }

    public static Animation[][] makeAnimationsProt()
    {
        BufferedImage[][][] bilder = createImagesProt();
        Animation[][] animationer = new Animation[bilder.length][20];
        for(int i = 0;i < bilder.length;i++)
        {
            for(int j = 0;j < bilder[i].length;j++)
            {
                animationer[i][j] = new Animation(bilder[i][j],2,true);
            }
//            for(int j = 0;j < bilder[i].length;j++)
//            {
//                if(j == Consts.ATTACKING)
//                    animationer[i][j].setRepeat(false);
//            }
        }
        bilder = null;
        return animationer;
    }

    public static Animation[][] makeAnimationsFiende()
    {
        BufferedImage[][][] bilder = createImagesFiende();
        Animation[][] animationer = new Animation[bilder.length][20];
        for(int i = 0;i < bilder.length;i++)
        {
            for(int j = 0;j < bilder[i].length;j++)
            {
                animationer[i][j] = new Animation(bilder[i][j],2,true);
            }
        }
        bilder = null;
        return animationer;
    }

    public static Animering[][] createAnimationsProt()
    {
        Animation[][] animationer = makeAnimationsProt();
        Animering[][] animeringar = new Animering[8][20];
        for(int i = 0;i < animationer.length;i++)
        {
            for(int j = 0;j < animationer[i].length;j++)
            {
                animeringar[i][j] = new Animering(animationer[i][j],i,j);
            }
        }
        animationer = null;
        return animeringar;
    }

    public static Animering[][] createAnimationsFiende()
    {
        Animation[][] animationer = makeAnimationsFiende();
        Animering[][] animeringar = new Animering[8][20];
        for(int i = 0;i < animationer.length;i++)
        {
            for(int j = 0;j < animationer[i].length;j++)
            {
                animeringar[i][j] = new Animering(animationer[i][j],i,j);
            }
        }
        animationer = null;
        return animeringar;
    }

    public static void determineAnimation(Sprite sp)
    {
        if(sp.getCurrentAnimationHighestCondition() == sp.getHighestCondition() &&
           sp.getCurrentAnimationDirection() == sp.getDirection())
        {
            sp.springAnimation();
        }
        else
        {
            sp.setCurrentAnimation(sp.getAnimationer()[sp.getDirection()][sp.getHighestCondition()]);
            sp.setCurrentAnimationDirection(sp.getDirection());
            sp.setCurrentAnimationHighestCondition(sp.getHighestCondition());
        }
    }

    public static void clear(BufferedImage img)
    {
        img.flush();
        img = null;
    }
}