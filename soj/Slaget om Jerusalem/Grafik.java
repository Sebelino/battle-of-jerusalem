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

import javax.swing.JFrame;
import javax.swing.*;

class Grafik extends JFrame
                 implements GameInterface,TillstandInterface
{
	
	

    
	int mousex = BoJMouseListener.mousex;
	int mousey = BoJMouseListener.mousey;
	Boolean Button1=false;
	Boolean Button2=false;
	Boolean Button3=true;
	Boolean Button4=false;
	
	Boolean Perks1=false;
	Boolean Perks2=false;
	Boolean Perks3=false;
	Boolean Perks4=false;
	Boolean Perks5=false;
	Boolean Perks6=false;
	Boolean Perks7=false;
	
	Boolean Perk1=false;
	Boolean Perk2=false;
	Boolean Perk3=false;
	Boolean Perk4=false;
	Boolean Perk5=false;
	Boolean Perk6=false;
	Boolean Perk7=false;
	Boolean Perk8=false;
	Boolean Perk9=false;
	Boolean Perk10=false;
	Boolean Perk11=false;
	Boolean Perk12=false;
	Boolean Perk13=false;
	Boolean Perk14=false;
	Boolean Perk15=false;
	Boolean Perk16=false;
	Boolean Perk17=false;
	Boolean Perk18=false;
	
	
	Rektangel mittP;
	
	
	int[]XAB = new int[10];
	int yAB = 800;
	int	xAB = 30;
	int storAB = 75;
	
	int[]XINV = new int[5];
	int[]YINV = new int[5];
	int yINV = 500;
	int xINV = 900;
	int storINV = 50;
	
	int[]XEQ = {900, 980, 993, 1085};
	int[]YEQ = {50, 130, 285};
	int storEQ = 75;
	int storEQ2 = 100;
	
	int[]XButton = new int[5];
	int yButton = 820;
	int xButton = 890;
	int storButton = 55;
	
	int[]XSkills = {50,500,850};
	int[]YSkills = {50,400};
	int storSkills = 350;
	
	int XPerkBox1 = 55;
	int[]YPerkBox1 = {60, 80, 100, 120, 140, 160};
	int XPerkBox2 = 65; 
	int[]YPerkBox2 = {  80, 130, 180, 230,   100, 165,    120, 170,    140, 190,    160, 225, 290,   180, 245, 310, 375,  230};
	int storPerkBox = 10;
	
	int XSkillBox = 855;
	int[]YSkillBox = {410, 455, 500, 545, 590, 635, 680, 725};
	
	int XMenu  = 463;
	int[]YMenu 	= {125,225,325,425,525,625};
	int storMenu = 300; 
	Form[]f = new Form[150];


    BufferedImage buffer;
    Graphics2D bufferg;
    public Grafik()
    {
	for(int i=0;i<10;i++){
			
		f[i] = new Kvadrat(storAB,XAB[i],yAB); 												//ACTION BARS

		if(i<5){
			
			f[i+10] = new Kvadrat(storButton,XButton[i],yButton); 							// knappar för att öppna ryggsäck etc.
			
			f[i+15] = new Kvadrat(storINV,XINV[i],YINV[0]);									// INVENTORY
			f[i+20] = new Kvadrat(storINV,XINV[i],YINV[1]);
			f[i+25] = new Kvadrat(storINV,XINV[i],YINV[2]);	
			f[i+30] = new Kvadrat(storINV,XINV[i],YINV[3]);	
			f[i+35] = new Kvadrat(storINV,XINV[i],YINV[4]);		
		}
	}
		f[40] = new Kvadrat(storEQ,XEQ[2],YEQ[0]);
		f[41] = new Rektangel(storEQ, (storEQ * 2), XEQ[0], YEQ[1]);						//EQUIPMENT
		f[42] = new Rektangel(storEQ2, (storEQ * 2), XEQ[1], YEQ[1]); 
		f[43] = new Rektangel(storEQ, (storEQ * 2), XEQ[3], YEQ[1]);
		f[44] = new Kvadrat(storEQ, XEQ[0], YEQ[2]);
		f[45] = new Kvadrat(storEQ, XEQ[3], YEQ[2]);
		
							
		f[84] = new Rektangel((storSkills + 100),(storSkills*2),XSkills[0],YSkills[0]);		//QUEST LOG
		f[85] = new Rektangel(storSkills,(storSkills*2),XSkills[1],YSkills[0]);
		f[86] = new Rektangel((storSkills*2 + 100),25,XSkills[0], 25);	
							
		f[46] = new Rektangel((storSkills + 100),(storSkills*2),XSkills[0],YSkills[0]); 	// SKILLS/PERKS						
		f[48] = new Kvadrat(storSkills,XSkills[2],YSkills[1]);
		f[83] = new Rektangel((storSkills*3 + 100),25,XSkills[0], 25);	
		f[47] = new Rektangel(storSkills, storSkills/2,XSkills[1],YSkills[0]);
		f[92] = new Rektangel(storSkills, storSkills/2,XSkills[1],YSkills[0]+storSkills/2);
		f[93] = new Rektangel(storSkills, storSkills/2,XSkills[1],YSkills[0]+storSkills);
		f[94] = new Rektangel(storSkills, storSkills/2,XSkills[1],YSkills[0]+storSkills+storSkills/2);
		f[95] = new Rektangel(storSkills, storSkills/2,XSkills[2],YSkills[0]);				//senast
		f[87] = new Rektangel(storSkills, storSkills/2,XSkills[2],YSkills[0]+storSkills/2);	
					
		f[52] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+30);							//knappar för varje nivå på perks
		f[53] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+50);
		f[54] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+70);
		f[55] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+90);					
		f[56] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+100);
		f[57] = new Kvadrat(storPerkBox,XSkills[0]+10,YSkills[0]+120);
		
		f[58] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[0]);						    //gå upp i level 1 perks
		f[59] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[1]);					
		f[60] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[2]);
		f[61] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[3]);
		
		f[62] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[4]);							//gå upp i level 4 perks
		f[63] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[5]);		
		f[88] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[17]);
		
		f[64] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[6]);							//gå upp i level 8 perks
		f[65] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[7]);
		
		f[66] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[8]);							//gå upp i level 12 perks
		f[67] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[9]);
		
		f[68] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[10]);							//gå upp i level 16 perks
		f[69] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[11]);
		f[70] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[12]);
		
		f[71] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[13]);							//gå upp i level 20 perks
		f[72] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[14]);
		f[73] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[15]);
		f[74] = new Kvadrat(storPerkBox,XPerkBox2,YPerkBox2[16]);
		
		f[75] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[0]); 							//rutor för att gå upp i alla skills
		f[76] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[1]); 
		f[77] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[2]); 					
		f[78] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[3]); 
		f[79] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[4]); 
		f[80] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[5]); 
		f[81] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[6]); 
		f[82] = new Kvadrat(storPerkBox,XSkillBox,YSkillBox[7]); 
		
		f[49] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[0]);						//Menu
		f[50] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[1]);		
		f[51] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[2]);
		f[89] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[3]);
		f[90] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[4]);
		f[91] = new Rektangel(storMenu,(storMenu/4),XMenu,YMenu[5]);
			
    }

    public void spring()
    {
        buffer = (BufferedImage)createImage(FRAMESIZEX,FRAMESIZEY);
        while(true)
        {
            rita();

            try
            {
                Thread.sleep((int)(1000/FPS));
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
/*
            fiende.AI0(prot);
            fiende.setGroundlevel(hm[(int)fiende.getV()][(int)fiende.getW()]);
            renderUB(fiende);
*/
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
        Graphics2D bufferg = (Graphics2D)this.getGraphics();
        bufferg.drawImage(buffer,0,0,this);
        bufferg.dispose();
    }

    public void drawStuffs()
    {

	if(f[14].ärIForm(mousex,mousey)&&!Button3){
 			Button1 = !Button1;
 			if(Button2){
 				Button2 = !Button2;
 			}
 		}
		if(f[13].ärIForm(mousex,mousey)&&!Button3){
			Button2 = !Button2;
			Perks7 = !Perks7;
			if(!Button2){
				Perks1 = false;
				Perks2 = false;
				Perks3 = false;
				Perks4 = false;
				Perks5 = false;
				Perks6 = false;
				Perks7 = false;
			}
			else if(Button1&&Button4){
				Button1 = !Button1;
				Button4 = !Button4;
			}
			else{
				Button1 = false;
				Button4 = false;
			}
			}
		if(!Button3){
		if(f[10].ärIForm(mousex,mousey)){
			Button4 = false;
			Button3 = !Button3;
			Button2 = false;;
			Button1 = false;
			}
        }
		if(f[12].ärIForm(mousex,mousey)&&!Button3){
			Button4 = !Button4;
			if(!Button4){
				
			}
			else if(Button2){
				Button2 = !Button2;
			}
			else{
				Button2 = false;
			}		
		}
			
		if(f[52].ärIForm(mousex,mousey)&&!Perks2&&!Perks3&&!Perks4&&!Perks5&&!Perks6){
			Perks1 = !Perks1;
			Perks7 = !Perks7;
		}
			
		if(f[53].ärIForm(mousex,mousey)&&!Perks1&&!Perks3&&!Perks4&&!Perks5&&!Perks6){
			Perks2 = !Perks2;
			Perks7 = !Perks7;
		}
			
		if(f[54].ärIForm(mousex,mousey)&&!Perks1&&!Perks2&&!Perks4&&!Perks5&&!Perks6){
			Perks3 = !Perks3;
			Perks7 = !Perks7;
		}
			
		if(f[55].ärIForm(mousex,mousey)&&!Perks1&&!Perks2&&!Perks3&&!Perks5&&!Perks6){
			Perks4 = !Perks4;
			Perks7 = !Perks7;
		}
			
		if(f[56].ärIForm(mousex,mousey)&&!Perks1&&!Perks2&&!Perks3&&!Perks4&&!Perks6){
			Perks5 = !Perks5;
			Perks7 = !Perks7;
		}
			
		if(f[57].ärIForm(mousex,mousey)&&!Perks1&&!Perks2&&!Perks3&&!Perks4&&!Perks5){
			Perks6 = !Perks6;
			Perks7 = !Perks7;
		}

		
		
			
																											//LEVEL 1
		if(f[58].ärIForm(mousex,mousey)&&Button2&&Perks1&&Fördelar.FastLearner<1&&Stats.PPoints>0){		
			Fördelar.FastLearner++;	
			Perk1 = true;
			Stats.PPoints--;
		}
			if(Perk1&&Button2){
			bufferg.drawString("Fast Learner", (XSkills[1] + 20), (YSkills[0]+40));
			bufferg.drawString(""+Fördelar.FastLearner, (XSkills[1] + storSkills - 30), (YSkills[0]+40));
			}
		
		if(f[59].ärIForm(mousex,mousey)&&Button2&&Perks1&&Fördelar.Sharpener<3&&Stats.PPoints>0){		
			Fördelar.Sharpener++;
			Perk2 = true;
			Stats.PPoints--;	
		}
			if(Perk2&&Button2){
			bufferg.drawString("Sharpener ", (XSkills[1] + 20), (YSkills[0]+55));
			bufferg.drawString(""+Fördelar.Sharpener, (XSkills[1] + storSkills - 30), (YSkills[0]+55));
			}
		
		if(f[60].ärIForm(mousex,mousey)&&Button2&&Perks1&&Fördelar.ObsessedWithWeapons<3&&Stats.PPoints>0){
			Fördelar.ObsessedWithWeapons++;	
			Perk3 = true;
			Stats.PPoints--;
			Skills.MedRange = Skills.MedRange+5;
			Skills.ModRange = Skills.ModRange+5;
			Skills.Melee = Skills.Melee+5;
			Skills.Explosives = Skills.Explosives+5;	
		}
			if(Perk3&&Button2){
			bufferg.drawString("Obsessed With Weapons ", (XSkills[1] + 20), (YSkills[0]+70));
			bufferg.drawString(""+Fördelar.ObsessedWithWeapons, (XSkills[1] + storSkills - 30), (YSkills[0]+70));
			}
			
		if(f[61].ärIForm(mousex,mousey)&&Button2&&Perks1&&Fördelar.Handsome<1&&Stats.PPoints>0){		
			Fördelar.Handsome++;
			Perk4 = true;
			Stats.PPoints--;
			Skills.Charm = Skills.Charm + 10;	
		}
			if(Perk4&&Button2){
			bufferg.drawString("Handsome ", (XSkills[1] + 20), (YSkills[0]+85));
			bufferg.drawString(""+Fördelar.Handsome, (XSkills[1] + storSkills - 30), (YSkills[0]+85));
			}
																												//LEVEL 4
		if(f[62].ärIForm(mousex,mousey)&&Button2&&Perks2&&Fördelar.Haggler<3&&Skills.Charm>49&&Stats.PPoints>0){		
			Fördelar.Haggler++;
			Perk5 = true;
			Stats.PPoints--;
		}
			if(Perk5&&Button2){
			bufferg.drawString("Haggler ", (XSkills[1] + 20), (YSkills[0]+storSkills/2+40));
			bufferg.drawString(""+Fördelar.Haggler, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills/2+40));
			}
		if(f[63].ärIForm(mousex,mousey)&&Button2&&Perks2&&Fördelar.Cleave<1&&Skills.Melee>49&&Stats.PPoints>0){
			Fördelar.Cleave++;
			Perk6 = true;
			Stats.PPoints--;
		}
			if(Perk6&&Button2){
			bufferg.drawString("Cleave ", (XSkills[1] + 20), (YSkills[0]+storSkills/2+55));
			bufferg.drawString(""+Fördelar.Cleave, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills/2+55));
			}
		if(f[88].ärIForm(mousex,mousey)&&Button2&&Perks2&&Fördelar.Bandage<3&&Skills.FirstAid>50&&Stats.PPoints>0){	
			Fördelar.Bandage++;
			Perk18 = true;
			Stats.PPoints--;
		}
			if(Perk18&&Button2){
			bufferg.drawString("Bandage ", (XSkills[1] + 20), (YSkills[0]+storSkills/2+70));
			bufferg.drawString(""+Fördelar.Bandage, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills/2+70));
			}
																												//LEVEL 8
		if(f[64].ärIForm(mousex,mousey)&&Button2&&Perks3&&Fördelar.Grease<3&&Stats.PPoints>0){		
			Fördelar.Grease++;
			Perk7 = true;
			Stats.PPoints--;
		}
			if(Perk7&&Button2){
			bufferg.drawString("Grease ", (XSkills[1] + 20), (YSkills[0]+storSkills+40));
			bufferg.drawString(""+Fördelar.Grease, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills+40));
			}
		if(f[65].ärIForm(mousex,mousey)&&Button2&&Perks3&&Fördelar.Charge<1&&Skills.Melee>79&&Stats.PPoints>0){	
			Fördelar.Charge++;
			Perk8 = true;
			Stats.PPoints--;
		}
			if(Perk8&&Button2){
			bufferg.drawString("Charge ", (XSkills[1] + 20), (YSkills[0]+storSkills+55));
			bufferg.drawString(""+Fördelar.Charge, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills+55));
			}
																												//LEVEL 12
		if(f[66].ärIForm(mousex,mousey)&&Button2&&Perks4&&Fördelar.ToughSkin<3&&Stats.PPoints>0){
			Fördelar.ToughSkin++;
			Perk9 = true;
			Stats.PPoints--;
		}
			if(Perk9&&Button2){
			bufferg.drawString("Tough Skin ", (XSkills[1] + 20), (YSkills[0]+storSkills+storSkills/2+40));
			bufferg.drawString(""+Fördelar.ToughSkin, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills+storSkills/2+40));
			}
		if(f[67].ärIForm(mousex,mousey)&&Button2&&Perks4&&Fördelar.OneStepAhead<3&&Stats.PPoints>0){	
			Fördelar.OneStepAhead++;
			Perk10 = true;
			Stats.PPoints--;
		}
			if(Perk10&&Button2){
			bufferg.drawString("One Step Ahead ", (XSkills[1] + 20), (YSkills[0]+storSkills+storSkills/2+55));
			bufferg.drawString(""+Fördelar.OneStepAhead, (XSkills[1] + storSkills - 30), (YSkills[0]+storSkills+storSkills/2+55));
			}
																												//LEVEL 16
		if(f[68].ärIForm(mousex,mousey)&&Button2&&Perks5&&Fördelar.StrongArms<1&&Skills.Melee>99&&Stats.PPoints>0){	
			Fördelar.StrongArms++;
			Perk11 = true;
			Stats.PPoints--;
		}
			if(Perk11&&Button2){
			bufferg.drawString("Strong Arms ", (XSkills[2] + 20), (YSkills[0]+40));
			bufferg.drawString(""+Fördelar.StrongArms, (XSkills[2] + storSkills - 30), (YSkills[0]+40));
			}
		if(f[69].ärIForm(mousex,mousey)&&Button2&&Perks5&&Fördelar.DEUSVOLT<1/*&&Stats.Faith.equals("very good")*/&&Stats.PPoints>0){	
			Fördelar.DEUSVOLT++;
			Perk12 = true;
			Stats.PPoints--;
		}
			if(Perk12&&Button2){
			bufferg.drawString("DEUS VOLT ", (XSkills[2] + 20), (YSkills[0]+55));
			bufferg.drawString(""+Fördelar.DEUSVOLT, (XSkills[2] + storSkills - 30), (YSkills[0]+55));
			}
		if(f[70].ärIForm(mousex,mousey)&&Button2&&Perks5&&Fördelar.NinjaBoy<4&&Stats.PPoints>0){	
			Fördelar.NinjaBoy++;
			Perk13 = true;
			Stats.PPoints--;
		}
			if(Perk13&&Button2){
			bufferg.drawString("Ninja Boy ", (XSkills[2] + 20), (YSkills[0]+70));
			bufferg.drawString(""+Fördelar.NinjaBoy, (XSkills[2] + storSkills - 30), (YSkills[0]+70));
			}
																												//LEVEL 20
		if(f[71].ärIForm(mousex,mousey)&&Button2&&Perks6&&Fördelar.DualWield<1&&Skills.Melee>69&&Skills.ModRange>69&&Skills.MedRange>69&&Skills.Explosives>69&&Perk11&&Stats.PPoints>0){
			Fördelar.DualWield++;
			Perk14 = true;
			Stats.PPoints--;
		}
			if(Perk14&&Button2){
			bufferg.drawString("Dual Wield ", (XSkills[2] + 20), (YSkills[0]+storSkills/2+40));
			bufferg.drawString(""+Fördelar.DualWield, (XSkills[2] + storSkills - 30), (YSkills[0]+storSkills/2+40));
			}
		if(f[72].ärIForm(mousex,mousey)&&Button2&&Perks6&&Fördelar.NaziZombies<1&&Skills.FirstAid>79&&Skills.Surgery>79/*&&Stats.Faith.equals("very bad")*/&&Stats.PPoints>0){
			Fördelar.NaziZombies++;
			Perk15 = true;
			Stats.PPoints--;
		}
			if(Perk15&&Button2){
			bufferg.drawString("Nazi Zombies ", (XSkills[2] + 20), (YSkills[0]+storSkills/2+55));
			bufferg.drawString(""+Fördelar.NaziZombies, (XSkills[2] + storSkills - 30), (YSkills[0]+storSkills/2+55));
			}
		if(f[73].ärIForm(mousex,mousey)&&Button2&&Perks6&&Fördelar.JackOfAllTrades<1&&Stats.Faith.equals("neutral")&&Stats.PPoints>0){
			Fördelar.JackOfAllTrades++;
			Perk16 = true;
			Stats.PPoints--;
			Skills.Charm = 100;
			Skills.FirstAid = 100;
			Skills.Surgery = 100;
			Skills.Melee = 100;
			Skills.MedRange = 100;
			Skills.ModRange = 100;
			Skills.Explosives = 100;
			Skills.Athletics = 100;
		}
			if(Perk16&&Button2){
			bufferg.drawString("Jack Of All Trades ", (XSkills[2] + 20), (YSkills[0]+storSkills/2+70));
			bufferg.drawString(""+Fördelar.JackOfAllTrades, (XSkills[2] + storSkills - 30), (YSkills[0]+storSkills/2+70));
			}
		if(f[74].ärIForm(mousex,mousey)&&Button2&&Perks6&&Fördelar.TheRunningMan<1&&Skills.Athletics>99&&Stats.PPoints>0){
			Fördelar.TheRunningMan++;
			Perk17 = true;
			Stats.PPoints--;
		}
			if(Perk17&&Button2){
			bufferg.drawString("The Running Man ", (XSkills[2] + 20), (YSkills[0]+storSkills/2+85));
			bufferg.drawString(""+Fördelar.TheRunningMan, (XSkills[2] + storSkills - 30), (YSkills[0]+storSkills/2+85));
			}
			if(!Button3){
			
		for(int i=0;i<15;i++)
		{
			f[i].draw(bufferg);
			
			
		}
		}
		else{
		}
		
		if(!Button3){
		if(Button1)
		{		
			
			
			for(int i=15;i<46;i++)
			{
				
					f[i].draw(bufferg);
						
			}
			}

		
		
		if(Button2)
		{
				
					f[83].draw(bufferg);
					f[46].draw(bufferg);
					f[47].draw(bufferg);
					f[48].draw(bufferg);
					f[75].draw(bufferg);
					f[76].draw(bufferg);
					f[77].draw(bufferg);
					f[78].draw(bufferg);
					f[79].draw(bufferg);
					f[80].draw(bufferg);
					f[81].draw(bufferg);
					f[82].draw(bufferg);
					f[87].draw(bufferg);
					f[92].draw(bufferg);
					f[93].draw(bufferg);
					f[94].draw(bufferg);
					f[95].draw(bufferg);
					bufferg.drawString("Health: " + Stats.Health,(XSkills[0]+20),43);
					bufferg.drawString("Faith: " + Stats.Faith,(XSkills[0]+100),43);
					bufferg.drawString("Experience: " + Stats.Exp,(XSkills[0] + 200),43);
					bufferg.drawString("Level: " + Stats.Level,(XSkills[0] + 300),43);
					bufferg.drawString("Skill Points: " + Stats.SPoints, (XSkills[0] + 365),43);
					bufferg.drawString("Perk Points:  " + Stats.PPoints, (XSkills[0] + 465),43);
					
					bufferg.drawString("Level 1 Perks",(XSkills[1]+storSkills/3+35),YSkills[0]+20);
					bufferg.drawString("Level 4 Perks",(XSkills[1]+storSkills/3+35),YSkills[0]+storSkills/2+20);
					bufferg.drawString("Level 8 Perks",(XSkills[1]+storSkills/3+35),YSkills[1]+20);
					bufferg.drawString("Level 12 Perks",(XSkills[1]+storSkills/3+30),YSkills[1]+storSkills/2+20);
					bufferg.drawString("Level 16 Perks", (XSkills[2]+storSkills/3+30),YSkills[0]+20);
					bufferg.drawString("Level 20 Perks", (XSkills[2]+storSkills/3+30),YSkills[0]+storSkills/2+20);
					
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+20));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+65));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+110));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+155));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+200));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+245));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+290));
					bufferg.drawString("+", (XSkills[2]+7), (YSkills[1]+335));
					
					bufferg.drawString("Medieval ranged weapons ", (XSkills[2] + 20), (YSkills[1]+20));
					bufferg.drawString("Melee ", (XSkills[2] + 20), (YSkills[1]+65));
					bufferg.drawString("First Aid ", (XSkills[2] + 20), (YSkills[1]+110));
					bufferg.drawString("Surgery ", (XSkills[2] + 20), (YSkills[1]+155));
					bufferg.drawString("Modern ranged weapons ", (XSkills[2] + 20), (YSkills[1]+200));
					bufferg.drawString("Athlete ", (XSkills[2] + 20), (YSkills[1]+245));
					bufferg.drawString("Explosives ", (XSkills[2] + 20), (YSkills[1]+290));
					bufferg.drawString("Charm ", (XSkills[2] + 20), (YSkills[1]+335));
					
					if(Perks7){
					
						f[52].draw(bufferg);
						f[53].draw(bufferg);
						f[54].draw(bufferg);
						f[55].draw(bufferg);
						f[56].draw(bufferg);
						f[57].draw(bufferg);
								
						bufferg.drawString("Level 1 ", (XSkills[0] + 20), (YSkills[0]+20));
						bufferg.drawString("Level 4 ", (XSkills[0] + 20), (YSkills[0]+40));
						bufferg.drawString("Level 8 ", (XSkills[0] + 20), (YSkills[0]+60));
						bufferg.drawString("Level 12 ", (XSkills[0] + 20), (YSkills[0]+80));
						bufferg.drawString("Level 16 ", (XSkills[0] + 20), (YSkills[0]+100));
						bufferg.drawString("Level 20 ", (XSkills[0] + 20), (YSkills[0]+120));
					
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+20));
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+40));
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+60));
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+80));
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+100));
						bufferg.drawString("+", (XSkills[0]+7), (YSkills[0]+120));
				
					}
					if(Perks1){
						f[52].draw(bufferg);
						f[58].draw(bufferg);
						f[59].draw(bufferg);
						f[60].draw(bufferg);
						f[61].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+40));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+90));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+140));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+190));
						
						bufferg.drawString("Level 1", (XSkills[0] + 20), (YSkills[0]+20));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+20));
						
						bufferg.drawString("Fast Learner (level "+Fördelar.FastLearner+" of 1)", (XSkills[0] + 30), (YSkills[0]+40));
						bufferg.drawString("Gain 10% more expereience.", (XSkills[0] + 40), (YSkills[0]+55));
						
						bufferg.drawString("Sharpener (level "+Fördelar.Sharpener+" of 3)", (XSkills[0] + 30), (YSkills[0]+90));
						bufferg.drawString("Cause 10% more damage with medieval weapons.", (XSkills[0] + 40), (YSkills[0]+105));
						
						bufferg.drawString("Obsessed With Weapons (level "+Fördelar.ObsessedWithWeapons+" of 3)", (XSkills[0] + 30), (YSkills[0]+140));
						bufferg.drawString("Gain 5 skills with all weapons", (XSkills[0] + 40), (YSkills[0]+155));
						
						bufferg.drawString("Handsome (level "+Fördelar.Handsome+" of 1)", (XSkills[0] + 30), (YSkills[0]+190));
						bufferg.drawString("Gain 10 in charm", (XSkills[0] + 40), (YSkills[0]+205));
						
					}
					if(Perks2){
						f[53].draw(bufferg);
						f[62].draw(bufferg);
						f[63].draw(bufferg);
						f[88].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+60));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+125));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+190));
						
						bufferg.drawString("Level 4", (XSkills[0] + 20), (YSkills[0]+40));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+40));
						
						bufferg.drawString("Haggler (level "+Fördelar.Haggler+" of 3)", (XSkills[0] + 30), (YSkills[0]+60));
						bufferg.drawString("requires 50 in charm", (XSkills[0] + 30), (YSkills[0]+75));
						bufferg.drawString("Buy goods 20% cheaper", (XSkills[0] + 40), (YSkills[0]+90));
						
						bufferg.drawString("Cleave (level "+Fördelar.Cleave+" of 1)", (XSkills[0] + 30), (YSkills[0]+125));
						bufferg.drawString("requires 50 in melee", (XSkills[0] + 30), (YSkills[0]+140));
						bufferg.drawString("Each hit on the enemy damages an additional nearby enemy", (XSkills[0] + 40), (YSkills[0]+155));
						
						bufferg.drawString("Bandage (level "+Fördelar.Bandage+" of 3)", (XSkills[0] + 30), (YSkills[0]+190));
						bufferg.drawString("requires 50 in first aid", (XSkills[0] + 30), (YSkills[0]+205));
						bufferg.drawString("Learn to ability to create bandages", (XSkills[0] + 40), (YSkills[0]+220));
						
					}
					if(Perks3){
						f[54].draw(bufferg);
						f[64].draw(bufferg);
						f[65].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+80));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+130));
						
						bufferg.drawString("Level 8", (XSkills[0] + 20), (YSkills[0]+60));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+60));
						
						
						bufferg.drawString("Grease (level "+Fördelar.Grease+" of 3)", (XSkills[0] + 30), (YSkills[0]+80));
						bufferg.drawString("Attack speed with medieval ranged weapons increased by 10%", (XSkills[0] + 40), (YSkills[0]+95));
						
						bufferg.drawString("Charge (level "+Fördelar.Charge+" of 1)", (XSkills[0] + 30), (YSkills[0]+130));
						bufferg.drawString("requires 80 in melee", (XSkills[0] + 30), (YSkills[0]+145));
						bufferg.drawString("Charge the enemy, damaging them.", (XSkills[0] + 40), (YSkills[0]+160));
					}
					if(Perks4){
						f[55].draw(bufferg);
						f[66].draw(bufferg);
						f[67].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+100));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+150));
						
						bufferg.drawString("Level 12", (XSkills[0] + 20), (YSkills[0]+80));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+80));
						
						bufferg.drawString("Tough Skin (level "+Fördelar.ToughSkin+" of 3)", (XSkills[0] + 30), (YSkills[0]+100));
						bufferg.drawString("Take 15% less damage", (XSkills[0] + 40), (YSkills[0]+115));
						
						bufferg.drawString("One Step Ahead (level "+Fördelar.OneStepAhead+" of 3)", (XSkills[0] + 30), (YSkills[0]+150));
						bufferg.drawString("Gain a 5% chanse to ofoid all attacks except explosives.", (XSkills[0] + 40), (YSkills[0]+165));
						
					}
					if(Perks5){
						f[56].draw(bufferg);
						f[68].draw(bufferg);
						f[69].draw(bufferg);
						f[70].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+120));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+185));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+250));
						
						bufferg.drawString("Level 16", (XSkills[0] + 20), (YSkills[0]+100));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+100));
						
						bufferg.drawString("Strong Arms (level "+Fördelar.StrongArms+" of 1)", (XSkills[0] + 30), (YSkills[0]+120));
						bufferg.drawString("requires 100 skill in melee", (XSkills[0] + 30), (YSkills[0]+135));
						bufferg.drawString("Allows wielding two handed weapons in one hand.", (XSkills[0] + 40), (YSkills[0]+150));
						
						bufferg.drawString("DEUS VOLT (level "+Fördelar.DEUSVOLT+" of 1)", (XSkills[0] + 30), (YSkills[0]+185));
						bufferg.drawString("requires very good faith", (XSkills[0] + 30), (YSkills[0]+200));
						bufferg.drawString("Invulnerable for 10 seconds.", (XSkills[0] + 40), (YSkills[0]+215));
						
						bufferg.drawString("Ninja Boy (level "+Fördelar.NinjaBoy+" of 4)", (XSkills[0] + 30), (YSkills[0]+250));
						bufferg.drawString("Reduces enemy vision by 10%. 50% at level 4.", (XSkills[0] + 40), (YSkills[0]+265));
						
					}
					if(Perks6){
						f[57].draw(bufferg);
						f[71].draw(bufferg);
						f[72].draw(bufferg);
						f[73].draw(bufferg);
						f[74].draw(bufferg);
						
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+140));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+205));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+270));
						bufferg.drawString("+", (XSkills[0]+17), (YSkills[0]+335));
						
						bufferg.drawString("Level 20", (XSkills[0] + 20), (YSkills[0]+120));
						bufferg.drawString("-", (XSkills[0]+9), (YSkills[0]+120));
						
						bufferg.drawString("Dual Wield (level "+Fördelar.DualWield+" of 1)", (XSkills[0] + 30), (YSkills[0]+140));
						bufferg.drawString("Requires 70 skill with all weapons and the perk strong arms.", (XSkills[0] + 30), (YSkills[0]+155));
						bufferg.drawString("Allows use of two weapons at the same time.", (XSkills[0] + 40), (YSkills[0]+170));
						
						bufferg.drawString("Nazi Zombies (level "+Fördelar.NaziZombies+" of 1)", (XSkills[0] + 30), (YSkills[0]+205));
						bufferg.drawString("requires 80 in first aid and surgery and very bad faith.", (XSkills[0] + 30), (YSkills[0]+220));
						bufferg.drawString("Dead nazis become ally zombies.", (XSkills[0] + 40), (YSkills[0]+235));
						
						bufferg.drawString("Jack Of All Trades (level "+Fördelar.JackOfAllTrades+" of 1)", (XSkills[0] + 30), (YSkills[0]+270));
						bufferg.drawString("requires neutral faith.", (XSkills[0] + 30), (YSkills[0]+285));
						bufferg.drawString("Gain 100 in all skills.", (XSkills[0] + 40), (YSkills[0]+300));
						
						bufferg.drawString("The Running Man (level "+Fördelar.TheRunningMan+" of 1)", (XSkills[0] + 30), (YSkills[0]+335));
						bufferg.drawString("requires 100 in athlete.", (XSkills[0] + 30), (YSkills[0]+350));
						bufferg.drawString("Running speed and attack speed with all weapons increased by 50%.", (XSkills[0] + 40), (YSkills[0]+365));
					}
					
					
					
					if(f[75].ärIForm(mousex,mousey)&&Skills.MedRange<100&&Stats.SPoints>0){	
						Skills.MedRange++;
						Stats.SPoints--;
					}	
					if(f[76].ärIForm(mousex,mousey)&&Skills.Melee<100&&Stats.SPoints>0){
						Skills.Melee++;
						Stats.SPoints--;
					}			
					if(f[77].ärIForm(mousex,mousey)&&Skills.FirstAid<100&&Stats.SPoints>0){
						Skills.FirstAid++;
						Stats.SPoints--;
					}		
					if(f[78].ärIForm(mousex,mousey)&&Skills.Surgery<100&&Stats.SPoints>0){	
						Skills.Surgery++;
						Stats.SPoints--;
					}		
					if(f[79].ärIForm(mousex,mousey)&&Skills.ModRange<100&&Stats.SPoints>0){
						Skills.ModRange++;
						Stats.SPoints--;
					}		
					if(f[80].ärIForm(mousex,mousey)&&Skills.Athletics<100&&Stats.SPoints>0){
						Skills.Athletics++;
						Stats.SPoints--;
					}	
					if(f[81].ärIForm(mousex,mousey)&&Skills.Explosives<100&&Stats.SPoints>0){
						Skills.Explosives++;
						Stats.SPoints--;
					}
					if(f[82].ärIForm(mousex,mousey)&&Skills.Charm<100&&Stats.SPoints>0){
						Skills.Charm++;
						Stats.SPoints--;
					}
					bufferg.drawString(""+Skills.MedRange, (XSkills[2] + storSkills - 30), (YSkills[1]+20));
					bufferg.drawString(""+Skills.Melee, (XSkills[2] + storSkills - 30), (YSkills[1]+65));
					bufferg.drawString(""+Skills.FirstAid, (XSkills[2] + storSkills - 30), (YSkills[1]+110));
					bufferg.drawString(""+Skills.Surgery, (XSkills[2] + storSkills - 30), (YSkills[1]+155));
					bufferg.drawString(""+Skills.ModRange, (XSkills[2] + storSkills - 30), (YSkills[1]+200));
					bufferg.drawString(""+Skills.Athletics, (XSkills[2] + storSkills - 30), (YSkills[1]+245));
					bufferg.drawString(""+Skills.Explosives, (XSkills[2] + storSkills - 30), (YSkills[1]+290));
					bufferg.drawString(""+Skills.Charm, (XSkills[2] + storSkills - 30), (YSkills[1]+335));		
					

		}
		if(Button4){
			f[84].draw(bufferg);
			f[85].draw(bufferg);
			f[86].draw(bufferg);
			bufferg.drawString("Quest Log ",(XSkills[0]+20),43);

		}
		else{
		}
		}
		if(Button3)
		{
			f[49].draw(bufferg);
			f[50].draw(bufferg);
			f[51].draw(bufferg);
			f[89].draw(bufferg);
			f[90].draw(bufferg);
			f[91].draw(bufferg);
			Boolean Oks = f[49].ärIForm(mousex,mousey);
			if(f[49].ärIForm(BoJMouseListener.mousex,BoJMouseListener.mousey)){
				System.out.println(mousex +", " + mousey);
				System.out.println("Ojdå!");
				Button3 = !Button3;
				repaint();
			}
			if(f[50].ärIForm(mousex,mousey)){
				
			}
			if(f[51].ärIForm(mousex,mousey)){
				
			}
			if(f[89].ärIForm(mousex,mousey)){
				
			}
			if(f[90].ärIForm(mousex,mousey)){
				
			}
			if(f[91].ärIForm(mousex,mousey)){
				
			}
		}




    }

    public void radera()
    {
    	

        bufferg.setColor(Color.white);
        bufferg.fillRect(0,0,FRAMESIZEX,FRAMESIZEY);
        bufferg.setColor(Color.black);
    }



}