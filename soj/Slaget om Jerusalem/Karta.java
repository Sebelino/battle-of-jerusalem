import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class Karta implements SpelplanInterface
{
    protected int v;
    protected int w;
    protected int[][] heightmap;
    protected BufferedImage img;

    public Karta(int v,
                 int w,
                 int[][] heightmap,
                 BufferedImage img)
    {
        this.v = v;
        this.w = w;
        this.heightmap = heightmap;
        this.img = img;
    }

    public int[][] getHeightmap()
    {
        return heightmap;
    }

    public int getHeight(int v,int w)
    {
        return heightmap[v][w];
    }

    private int lesser(int a,int b)
    {
        if(b < a)
        {
            return b;
        }
        else
        {
            return a;
        }
    }

    private void drawGrid(Graphics2D g)
    {
        drawGridPhaseA(g);
        drawGridPhaseB(g);
        drawGridPhaseC(g);
    }

    private void drawGridPhaseA(Graphics2D g)
    {
        int vl = heightmap.length;
        int wl = heightmap[0].length;
        int shortside = lesser(vl,wl);
        for(int i = 0;i < shortside;i++)
        {
            for(int j = 0;j < i+1;j++)
            {
                drawUnit(g,
                         vl-1-j,
                         wl-1-i+j);
            }
        }
    }

    private void drawGridPhaseB(Graphics2D g)
    {
        int vl = heightmap.length;
        int wl = heightmap[0].length;
        int shortside = lesser(vl,wl);
        for(int i = 0;i < Math.abs(vl-wl);i++)
        {
            for(int j = 0;j < shortside;j++)
            {
                drawUnit(g,
                         vl-2-i-j,
                         j);
            }
        }

    }

    private void drawGridPhaseC(Graphics2D g)
    {
        int vl = heightmap.length;
        int wl = heightmap[0].length;
        int shortside = lesser(vl,wl);
        for(int i = 0;i < shortside-1;i++)
        {
            for(int j = 0;j < shortside-1-i;j++)
            {
                drawUnit(g,
                         shortside-2-i-j,
                         j);
            }
        }

    }

    private void drawUnit(Graphics2D g,int v,int w)
    {
        double x = MAPX;
        double y = MAPY;
        int h = heightmap[v][w];
        x -= 3*v;
        y -= 2*v;
        x += 3*w;
        y -= 2*w;
        if(h != 0)
        {
            drawPoles(g,(int)x,(int)y,h);
        }
        drawSquare(g,(int)x,(int)y,h);
    }

    private void drawSquare(Graphics2D g,int x,int y,int h)
    {
        g.drawLine(x-3,y-h,x,y-2-h);
        g.drawLine(x,y-2-h,x+3,y-h);
        g.drawLine(x+3,y-h,x,y+2-h);
        g.drawLine(x,y+2-h,x-3,y-h);
        g.setColor(Color.green);
        g.drawLine(x-2,y-h,x+2,y-h);
        g.drawLine(x,y-h-1,x,y-h+1);
        g.setColor(Color.black);
    }

    private void drawPoles(Graphics2D g,int x,int y,int h)
    {
        g.drawLine(x-3,y,x-3,y-h);
        g.drawLine(x+3,y,x+3,y-h);
        g.drawLine(x,y+2,x,y+2-h);
        g.setColor(Color.red);
        g.drawLine(x-2,y,x-2,y-h);
        g.drawLine(x-1,y,x-1,y-h);
        g.drawLine(x+1,y,x+1,y-h);
        g.drawLine(x+2,y,x+2,y-h);
        g.setColor(Color.black);
    }

    public void draw(Graphics2D g)
    {
//        drawGrid(g);
        g.setColor(Color.orange);
        g.drawLine(MAPX,MAPY,MAPX,MAPY);
        g.setColor(Color.black);
        g.drawImage(img,
                    null,
                    (int)(MAPX-3*heightmap.length),
                    (int)(MAPY-4*heightmap[0].length)+2);
    }
}