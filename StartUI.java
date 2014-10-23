import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class StartUI implements Runnable
{
    private Ruta[] rutor;
    private Thread trad;
    private boolean life;
    public boolean start;

    public StartUI()
    {
    	start = false;
        life = true;          
        rutor = new Ruta[5];

        rutor[0] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/MenyStart.png");
        rutor[1] = new Ruta(RutConsts.MENYLOAD,true,true,"Pics/UI/MenyLoad.png");
        rutor[2] = new Ruta(RutConsts.MENYCREDITS,true,true,"Pics/UI/MenyCredits.png");
        rutor[3] = new Ruta(RutConsts.MENYEXIT,true,true,"Pics/UI/MenyExit.png");
        rutor[4] = new Ruta(RutConsts.CREDITS,false,false,"Pics/Credits.png");
/*
        rutor[0].setSynlig(true);
        rutor[0].setAccessibel(true);
        rutor[1].setSynlig(true);
        rutor[1].setAccessibel(true);
        rutor[2].setSynlig(true);
        rutor[2].setAccessibel(true);
        rutor[3].setSynlig(true);
        rutor[3].setAccessibel(true);
        rutor[4].setSynlig(false);
        rutor[4].setAccessibel(false);
*/
        trad = new Thread(this);
        start();
    }

    public void start()
    {
        trad.start();
    }

    public void run()
    {
        while(life)
        {
            try
            {
                trad.sleep(10);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            checkRutor();
        }
    }

    public void checkRutor()
    {
        for(int i = 0;i < rutor.length && rutor[i] != null;i++)
        {
            if(rutor[i].inside(BoJMouseListener.getX(),BoJMouseListener.getY()))
            {
                rutor[i].increaseAntalTryck();
            }
        }
        if(BoJMouseListener.getX() != BoJMouseListener.DEAD && BoJMouseListener.getY() != BoJMouseListener.DEAD)
        {
            actRutor();
            BoJMouseListener.setX(BoJMouseListener.DEAD);
            BoJMouseListener.setY(BoJMouseListener.DEAD);
        }
    }

    public void actRutor()
    {
        ruta0();
        ruta1();
        ruta3();
        ruta4();
        ruta2();
    }

    private void ruta0()
    {
        if(rutaPressed(rutor[0]))
        {
            start = true;
            life = false;
        }
    }

    private void ruta1()
    {
        if(rutaPressed(rutor[1]))
        {
            int[] temp = new int[GameUtil.fillasare("Save.boj").length];
            for(int i = 0;i < temp.length;i++)
                temp[i] = Integer.parseInt(GameUtil.fillasare("Save.boj")[i]);
            if(temp.length > 0)
                StatsProt.healthMax = temp[0];
            if(temp.length > 1)
                StatsProt.health = temp[1];
            start = true;
            life = false;
        }
    }

    private void ruta2()
    {
        if(rutaPressed(rutor[2]))
        {
            rutor[4].setSynlig(true);
            rutor[4].setAccessibel(true);
        }
    }

    private void ruta3()
    {
        if(rutaPressed(rutor[3]))
        {
            life = false;
        }
    }

    private void ruta4()
    {
        if(rutaPressed(rutor[4]))
        {
            rutor[4].setSynlig(false);
            rutor[4].setAccessibel(false);
        }
    }

    public boolean getStart()
    {
    	return start;
    }

    private boolean rutaPressed(Ruta ruta)
    {
        return (ruta.getAccessibel() && ruta.inside(BoJMouseListener.getX(),BoJMouseListener.getY()));
    }

    public boolean getLife()
    {
        return life;
    }

    public void draw(Graphics2D g)
    {
        for(int i = 0;i < rutor.length && rutor[i] != null;i++)
        {
                rutor[i].rita(g);
        }
    }
}