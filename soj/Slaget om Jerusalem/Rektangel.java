import java.awt.*;
public class Rektangel extends Form{
protected int bas, h�jd;
  public Rektangel(int bas, int h�jd, int x, int y){
    this.bas=bas;
    this.h�jd=h�jd;
    this.x = x;
    this.y = y;
      }

public void draw(Graphics2D g){
    int nP = 4;
    int[] x = new int[nP];
    int[] y = new int[nP];
    x[0]=this.x;
    x[1]=bas+this.x;
    x[2]=bas+this.x;
    x[3]=this.x;
    y[0]=this.y;
    y[1]=this.y;
    y[2]=h�jd+this.y;
    y[3]=h�jd+this.y;
    g.drawPolygon(x,y,nP);
  }
     public boolean �rIForm(int x, int y){
  	return(this.x<x&&x<this.x+bas&&this.y<y&&y<this.y+h�jd);
  }
}
