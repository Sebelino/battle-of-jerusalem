import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.*;

class Spel extends JFrame
           implements Runnable
{
    private Protagonist prot;
    private ArrayList<Fiende> fiender;
    private Spelplan plan;
    private ArrayList<Strike> slag;
    private UI ui;
    private Obstakler obstakler;
    private static boolean win;
    private static int kills;
    private int endtimer;

    private BufferedImage buffer;
    private Graphics2D bufferg;

    public Spel()
    {
        win = false;
        plan = new Spelplan();
        prot = new Protagonist(1,new Block3DSpel(new Punkt3D(0,0,-800),10,10,80),new Vektor2D(Consts.SPEEDWALK,Consts.SPEEDJUMP));
        fiender = new ArrayList<Fiende>();
        fiender.add(new Fiende(2,new Block3DSpel(new Punkt3D(200,100,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(3,new Block3DSpel(new Punkt3D(400,300,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(4,new Block3DSpel(new Punkt3D(600,1200,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(5,new Block3DSpel(new Punkt3D(900,700,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(6,new Block3DSpel(new Punkt3D(1300,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(7,new Block3DSpel(new Punkt3D(1600,800,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(8,new Block3DSpel(new Punkt3D(1700,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(9,new Block3DSpel(new Punkt3D(1900,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(10,new Block3DSpel(new Punkt3D(2200,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(11,new Block3DSpel(new Punkt3D(2300,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(12,new Block3DSpel(new Punkt3D(2500,600,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        fiender.add(new Fiende(13,new Block3DSpel(new Punkt3D(2300,1000,-100),10,10,80),new Vektor2D(1,Consts.SPEEDJUMP)));
        slag = new ArrayList<Strike>();
        addMouseListener(new BoJMouseListener());
        ui = new UI();
        obstakler = new Obstakler();
        kills = 0;
        endtimer = 30;
        Vapen.setVapen(Vapen.MELEE);
    }

    public void run()
    {
        buffer = (BufferedImage)createImage(Consts.FRAMESIZEX,Consts.FRAMESIZEY);
        while(true)
        {
            rita();
            try
            {
                Thread.sleep((int)(1000/Consts.FPS));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            updateProt();
            updateFiende();
            updateIntersection();
            for(int i = 0;i < slag.size();i++)
            {
                for(int j = 0;j < slag.get(i).getCurrentHarms().length;j++)
                {
                    slag.get(i).getCurrentHarms()[j].springAnimation();
                }
            }
            if(prot.getCondition(Consts.DEAD))
            {
                win = false;
                if(endtimer <= 0)
                {
                    break;
                }
                endtimer--;
            }
            if(fiender.size() == 0)
            {
                win = true;
                if(endtimer <= 0)
                {
                    break;
                }
                endtimer--;
            }
            kill();
            decompose();
        }
    }

    private void decompose()
    {
        for(int i = 0;i < fiender.size();i++)
        {
            if(fiender.get(i).getCondition(Consts.DEAD))
            {
                fiender.get(i).decreaseDeathtime();
            }
        }
    }

    private void kill()
    {
        for(int i = 0;i < slag.size();i++)
        {
            if(!slag.get(i).getLife())
            {
                slag.remove(i);
            }
        }
        for(int i = 0;i < fiender.size();i++)
        {
            if(fiender.get(i).getCondition(Consts.DEAD) && fiender.get(i).getDeathtime() == 0)
            {
                fiender.remove(i);
            }
        }
    }

    public void updateProt()
    {
        boolean temp;
        ProtUtil.updatePunkt3DPre(prot);
        ProtUtil.updateGroundlevelPre(prot);
        ProtUtil.determineCondition(prot);
        ProtUtil.determineDirection(prot);
        ProtUtil.move(prot,plan);
        if(prot.getAttacktime() == Consts.ATTACKTIME)
        {
            attack();
        }
        if(prot.getAttacktime() > 0)
        {
            prot.setCondition(Consts.ATTACKING,true);
            prot.setAttacktime(prot.getAttacktime()-1);
        }
        else
        {
            prot.setCondition(Consts.ATTACKING,false);
        }
        AnimationUtil.determineAnimation(prot);
    }

    public void updateFiende()
    {
        for(int i = 0;i < fiender.size();i++)
        {
            FiendeUtil.updatePunkt3DPre(fiender.get(i));
            FiendeUtil.updateGroundlevelPre(fiender.get(i));
            FiendeUtil.determineCondition(fiender.get(i));
            FiendeUtil.determineDirection(fiender.get(i),prot);
            if(!fiender.get(i).getCondition(Consts.DEAD))
            {
                FiendeUtil.move(fiender.get(i),plan,prot);
            }
            AnimationUtil.determineAnimation(fiender.get(i));
        }
    }

    public void updateIntersection()
    {
        for(int i = 0;i < fiender.size();i++)
        {
            if(Block3DSpel.intersects(prot.getBlock3D(),fiender.get(i).getBlock3D()))
            {
                StatsProt.setHealth(StatsProt.getHealth()-1);
                prot.setHurttime(prot.getHurttimeLevel());
                prot.setCondition(Consts.HURT,true);
            }
        }
        if(StatsProt.getHealth() <= 0)
            prot.setCondition(Consts.DEAD,true);
        if(prot.getHurttime() <= 0)
        {
            prot.setCondition(Consts.HURT,false);
        }
        for(int i = 0;i < slag.size();i++)
        {
            Harm[] harmar = slag.get(i).getCurrentHarms();
            for(int j = 0;j < harmar.length;j++)
            {
                for(int k = 0;k < fiender.size();k++)
                {
                    if(Block3DSpel.intersects(fiender.get(k).getBlock3D(),harmar[j].getBlock3D()))
                    {
//                        fiender.get(k).setU(-2000);
                        fiender.get(k).setCondition(Consts.DEAD,true);
                        kills++;
                    }
                }
            }
        }
        if(prot.getCondition(Consts.HURT))
        {
            prot.setHurttime(prot.getHurttime()-1);
        }
    }

    public void attack()
    {
        if(Vapen.getVapen() == Vapen.MELEE)
            slag.add(StrikeUtil.meleeStrike(prot));
        else if(Vapen.getVapen() == Vapen.CROSS)
            slag.add(StrikeUtil.crossStrike(prot));
        else if(Vapen.getVapen() == Vapen.WHIRL)
            slag.add(StrikeUtil.whirlStrike(prot));
    }

    public static boolean getWin()
    {
        return win;
    }

    public void drawFiender(Graphics2D g)
    {
        for(int i = 0;i < fiender.size();i++)
        {
            fiender.get(i).draw(g);
        }
    }

    public void rita()
    {
        if(bufferg == null)
        {
            bufferg = (Graphics2D)buffer.getGraphics();
        }
        radera();
        drawStuffs();
        Graphics2D g = (Graphics2D)this.getGraphics();
        g.drawImage(buffer,0,0,this);
        g.dispose();
    }

    public void drawStuffs()
    {
        plan.drawVisible(bufferg,prot.getPunkt3D());
        obstakler.draw(bufferg);
        prot.draw(bufferg);
        drawFiender(bufferg);
        for(int i = 0;i < slag.size();i++)
        {
            if(slag.get(i) != null)
            {
                slag.get(i).draw(bufferg);
            }
        }
        ui.draw(bufferg);
    }

    public void radera()
    {
        bufferg.setColor(Color.BLACK);
        bufferg.fillRect(0,0,Consts.FRAMESIZEX,Consts.FRAMESIZEY);
    }
}