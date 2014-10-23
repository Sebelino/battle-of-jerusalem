import java.awt.*;
public class Kvadrat extends Rektangel{
  public Kvadrat(double bas, double x, double y){
    super(bas,bas,x,y);
  }
    public void draw(Graphics2D g){
    g.drawRect((int)x,(int)y,(int)bas,(int)höjd);
    
  }
    public boolean ärIForm(double x, double y){
  	return(this.x<x&&x<this.x+bas&&this.y<y&&y<this.y+bas);
  }
  
  }
