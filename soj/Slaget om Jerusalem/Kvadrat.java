import java.awt.*;
public class Kvadrat extends Rektangel{
  public Kvadrat(int bas, int x, int y){
    super(bas,bas,x,y);
  }
    public void draw(Graphics2D g){
    g.drawRect(x,y,bas,höjd);
    
  }
    public boolean ärIForm(int x, int y){
  return(this.x<x&&x<this.x+bas&&this.y<y&&y<this.y+bas);
  }
  
  }
