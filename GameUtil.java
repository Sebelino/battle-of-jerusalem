import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

import javax.imageio.ImageIO;

class GameUtil
{
    public static int avrunda(double value)
    {
        if((int)(2*value) > 2*(int)value)
        {
            return (int)value+1;
        }
        else
        {
            return (int)value;
        }
    }

    public static Harm[] kompresseraHarm(Harm[] falt)
    {
        int langd = 0;
        for(int i = 0;i < falt.length;i++)
        {
            if(falt[i] != null)
            {
                langd++;
            }
        }
        Harm[] nytt = new Harm[langd];
        int temp = 0;
        for(int i = 0;i < langd;i++)
        {
            if(falt[i] != null)
            {
                nytt[temp] = falt[i];
                temp++;
            }
        }
        return nytt;
    }

    public static Vektor2D directionToVektor2D(int direction)
    {
        if(direction >= 0 &&
           direction <= 7)
        {
            if(direction == Consts.NORTH)
            {
                return new Vektor2D(1,1);
            }
            else if(direction == Consts.EAST)
            {
                return new Vektor2D(-1,1);
            }
            else if(direction == Consts.SOUTH)
            {
                return new Vektor2D(-1,-1);
            }
            else if(direction == Consts.WEST)
            {
                return new Vektor2D(1,-1);
            }
            else if(direction == Consts.NORTHWEST)
            {
                return new Vektor2D(1,0);
            }
            else if(direction == Consts.NORTHEAST)
            {
                return new Vektor2D(0,1);
            }
            else if(direction == Consts.SOUTHEAST)
            {
                return new Vektor2D(-1,0);
            }
            else if(direction == Consts.SOUTHWEST)
            {
                return new Vektor2D(0,-1);
            }
        }
        return new Vektor2D(0,0);
    }

    public static Punkt3D relativeToAbsolutePunkt3D(Punkt3D punkt,int direction)
    {
        Punkt3D p = new Punkt3D(punkt);
        if(direction == Consts.NORTH)
        {
            p.setX(p.abs()/Math.sqrt(2));
            p.setY(p.abs()/Math.sqrt(2));
        }
        else if(direction == Consts.EAST)
        {
            p.setX(-p.abs()/Math.sqrt(2));
            p.setY(p.abs()/Math.sqrt(2));
        }
        else if(direction == Consts.SOUTH)
        {
            p.setX(-p.abs()/Math.sqrt(2));
            p.setY(-p.abs()/Math.sqrt(2));
        }
        else if(direction == Consts.WEST)
        {
            p.setX(p.abs()/Math.sqrt(2));
            p.setY(-p.abs()/Math.sqrt(2));
        }
        else if(direction == Consts.NORTHWEST)
        {
            p.setX(p.abs());
            p.setY(0);
        }
        else if(direction == Consts.NORTHEAST)
        {
            p.setX(0);
            p.setY(p.abs());
        }
        else if(direction == Consts.SOUTHEAST)
        {
            p.setX(-p.abs());
            p.setY(0);
        }
        else if(direction == Consts.SOUTHWEST)
        {
            p.setX(0);
            p.setY(-p.abs());
        }
        return p;
    }

    public static String[] fillasare(String fil)
    {
        String pro = "Data/";
        ArrayList<String> rader = new ArrayList<String>();
        try
        {
            FileReader fr = new FileReader(pro+fil);
            BufferedReader input = new BufferedReader(fr);
            String rad = input.readLine();
            int i = 0;
            while(rad != null)
            {
                rader.add(rad);
                rad = input.readLine();
                i++;
            }
            input.close();
        }
        catch(FileNotFoundException e1)
        {
            System.out.println("Filen hittades inte.");
        }
        catch(IOException e2)
        {
            System.out.println("Foljande fel: "+ e2);
        }
        String[] raders = new String[rader.size()];
        raders = rader.toArray(raders);
        return raders;
    }

    public static void filskrivare(String[] info,String fil,boolean editera)
    {
        String pro = "Data/";
        try
        {
            FileWriter fW = new FileWriter(pro+fil,editera);
            BufferedWriter bW = new BufferedWriter(fW);
            PrintWriter pW = new PrintWriter(bW);
            for(int i = 0;i < info.length;i++)
            {
                pW.println(info[i]);
            }
            pW.close();
        }
        catch(FileNotFoundException e1)
        {
            System.out.println("Filen hittades inte.");
        }
        catch(IOException e2)
        {
            System.out.println(e2);
        }
    }
}