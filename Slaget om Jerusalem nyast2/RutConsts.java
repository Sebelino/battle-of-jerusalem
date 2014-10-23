import java.awt.Color;
import java.awt.image.BufferedImage;

public class RutConsts
{
    public static final RektangelProp MENYSTART = new RektangelProp(0.5,0.15,0.4,0.1);
    public static final RektangelProp MENY2 = new RektangelProp(0.5,0.27,0.4,0.1);
    public static final RektangelProp MENY3 = new RektangelProp(0.5,0.39,0.4,0.1);
    public static final RektangelProp MENY4 = new RektangelProp(0.5,0.51,0.4,0.1);
    public static final RektangelProp MENY5 = new RektangelProp(0.5,0.63,0.4,0.1);
    public static final RektangelProp MENYEXIT = new RektangelProp(0.5,0.75,0.4,0.1);

    public static final RektangelProp BARHP = new RektangelProp(0.05,0.015,0.1,0.03);
    public static final RektangelProp BARXP = new RektangelProp(0.25,0.015,0.1,0.03);
	
	public static final RektangelProp INVENTORY = new RektangelProp(0.94,0.94,0.05,0.05*1.3);
	public static final RektangelProp SNP = new RektangelProp(0.885,0.94,0.05,0.05*1.3);
	public static final RektangelProp BOA = new RektangelProp(0.83,0.94,0.05,0.05*1.3);
	public static final RektangelProp QUESTLOG = new RektangelProp(0.775,0.94,0.05,0.05*1.3);
    public static final RektangelProp MENYBAREXIT = new RektangelProp(0.72,0.94,0.05,0.05*1.3);
    
    public static final RektangelProp INV1 = new RektangelProp(0.75,0.55,0.045,0.045*1.3);
    public static final RektangelProp INV2 = new RektangelProp(0.75,0.615,0.045,0.045*1.3);
    public static final RektangelProp INV3 = new RektangelProp(0.75,0.68,0.045,0.045*1.3);
    public static final RektangelProp INV4 = new RektangelProp(0.75,0.745,0.045,0.045*1.3);
    public static final RektangelProp INV5 = new RektangelProp(0.75,0.81,0.045,0.045*1.3);
    public static final RektangelProp INV6 = new RektangelProp(0.80,0.55,0.045,0.045*1.3);
    public static final RektangelProp INV7 = new RektangelProp(0.80,0.615,0.045,0.045*1.3);
    public static final RektangelProp INV8 = new RektangelProp(0.80,0.68,0.045,0.045*1.3);
    public static final RektangelProp INV9 = new RektangelProp(0.80,0.745,0.045,0.045*1.3);
    public static final RektangelProp INV10 = new RektangelProp(0.80,0.81,0.045,0.045*1.3);
    public static final RektangelProp INV11 = new RektangelProp(0.85,0.55,0.045,0.045*1.3);
    public static final RektangelProp INV12 = new RektangelProp(0.85,0.615,0.045,0.045*1.3);
    public static final RektangelProp INV13 = new RektangelProp(0.85,0.68,0.045,0.045*1.3);
    public static final RektangelProp INV14 = new RektangelProp(0.85,0.745,0.045,0.045*1.3);
    public static final RektangelProp INV15 = new RektangelProp(0.85,0.81,0.045,0.045*1.3);
    public static final RektangelProp INV16 = new RektangelProp(0.90,0.55,0.045,0.045*1.3);
    public static final RektangelProp INV17 = new RektangelProp(0.90,0.615,0.045,0.045*1.3);
    public static final RektangelProp INV18 = new RektangelProp(0.90,0.68,0.045,0.045*1.3);
    public static final RektangelProp INV19 = new RektangelProp(0.90,0.745,0.045,0.045*1.3);
    public static final RektangelProp INV20 = new RektangelProp(0.90,0.81,0.045,0.045*1.3);
    public static final RektangelProp INV21 = new RektangelProp(0.95,0.55,0.045,0.045*1.3);
    public static final RektangelProp INV22 = new RektangelProp(0.95,0.615,0.045,0.045*1.3);
    public static final RektangelProp INV23 = new RektangelProp(0.95,0.68,0.045,0.045*1.3);
    public static final RektangelProp INV24 = new RektangelProp(0.95,0.745,0.045,0.045*1.3);
    public static final RektangelProp INV25 = new RektangelProp(0.95,0.81,0.045,0.045*1.3);
    public static final RektangelProp GLOVES = new RektangelProp(0.77,0.37,0.07,0.07*1.3);
    public static final RektangelProp ARMOR = new RektangelProp(0.85,0.23,0.08,0.14*1.3);
    public static final RektangelProp HEAD = new RektangelProp(0.85,0.091,0.07,0.07*1.3);
    public static final RektangelProp BOOTS = new RektangelProp(0.929,0.37,0.07,0.07*1.3);
    public static final RektangelProp WEAPON = new RektangelProp(0.77,0.23,0.07,0.14*1.3);
    public static final RektangelProp SHIELD = new RektangelProp(0.929,0.23,0.07,0.14*1.3);
    
    public static final RektangelProp AB1 = new RektangelProp(0.05,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB2 = new RektangelProp(0.115,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB3 = new RektangelProp(0.18,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB4 = new RektangelProp(0.245,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB5 = new RektangelProp(0.31,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB6 = new RektangelProp(0.375,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB7 = new RektangelProp(0.44,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB8 = new RektangelProp(0.505,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB9 = new RektangelProp(0.57,0.935,0.06,0.06*1.3);
    public static final RektangelProp AB0 = new RektangelProp(0.635,0.935,0.06,0.06*1.3);
    
    public static final RektangelProp SnPRubrik = new RektangelProp(0.5,0.101,0.93,0.03);
    
    public static final RektangelProp SnP1 = new RektangelProp(0.15,0.175,0.23,0.12);
    public static final RektangelProp SnP4 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP8 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP12 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP16 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP20 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp SnP1n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP1n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP1n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP1n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP1n5 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp SnP4n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP4n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP4n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP4n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP4n5 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp SnP8n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP8n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP8n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP8n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP8n5 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp SnP12n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP12n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP12n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP12n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP12n5 = new RektangelProp(0.15,0.775,0.23,0.12);
     
    public static final RektangelProp SnP16n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP16n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP16n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP16n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP16n5 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp SnP20n1 = new RektangelProp(0.15,0.295,0.23,0.12);
    public static final RektangelProp SnP20n2 = new RektangelProp(0.15,0.415,0.23,0.12);
    public static final RektangelProp SnP20n3 = new RektangelProp(0.15,0.535,0.23,0.12);
    public static final RektangelProp SnP20n4 = new RektangelProp(0.15,0.655,0.23,0.12);
    public static final RektangelProp SnP20n5 = new RektangelProp(0.15,0.775,0.23,0.12);
    
    public static final RektangelProp l1  = new RektangelProp(0.38,0.135,0.23,0.04);
    public static final RektangelProp l1p1 = new RektangelProp(0.38,0.175,0.23,0.04);
    public static final RektangelProp l1p2 = new RektangelProp(0.38,0.215,0.23,0.04);
    public static final RektangelProp l1p3 = new RektangelProp(0.38,0.255,0.23,0.04);
    public static final RektangelProp l1p4 = new RektangelProp(0.38,0.295,0.23,0.04);
    public static final RektangelProp l1p5 = new RektangelProp(0.38,0.335,0.23,0.04);
    
    public static final RektangelProp l4 = new RektangelProp(0.38,0.375,0.23,0.04);
    public static final RektangelProp l4p1 = new RektangelProp(0.38,0.415,0.23,0.04);
    public static final RektangelProp l4p2 = new RektangelProp(0.38,0.455,0.23,0.04);
    public static final RektangelProp l4p3 = new RektangelProp(0.38,0.495,0.23,0.04);
    public static final RektangelProp l4p4 = new RektangelProp(0.38,0.535,0.23,0.04);
    public static final RektangelProp l4p5 = new RektangelProp(0.38,0.575,0.23,0.04);
    
    public static final RektangelProp l8 = new RektangelProp(0.38,0.615,0.23,0.04);
    public static final RektangelProp l8p1 = new RektangelProp(0.38,0.655,0.23,0.04);
    public static final RektangelProp l8p2 = new RektangelProp(0.38,0.695,0.23,0.04);
    public static final RektangelProp l8p3 = new RektangelProp(0.38,0.735,0.23,0.04);
    public static final RektangelProp l8p4 = new RektangelProp(0.38,0.775,0.23,0.04);
    public static final RektangelProp l8p5 = new RektangelProp(0.38,0.815,0.23,0.04);
    
    public static final RektangelProp l12 = new RektangelProp(0.61,0.135,0.23,0.04);
    public static final RektangelProp l12p1 = new RektangelProp(0.61,0.175,0.23,0.04);
    public static final RektangelProp l12p2 = new RektangelProp(0.61,0.215,0.23,0.04);
    public static final RektangelProp l12p3 = new RektangelProp(0.61,0.255,0.23,0.04);
    public static final RektangelProp l12p4 = new RektangelProp(0.61,0.295,0.23,0.04);
    public static final RektangelProp l12p5 = new RektangelProp(0.61,0.335,0.23,0.04);
    
    public static final RektangelProp l16 = new RektangelProp(0.61,0.375,0.23,0.04);
    public static final RektangelProp l16p1 = new RektangelProp(0.61,0.415,0.23,0.04);
    public static final RektangelProp l16p2 = new RektangelProp(0.61,0.455,0.23,0.04);
    public static final RektangelProp l16p3 = new RektangelProp(0.61,0.495,0.23,0.04);
    public static final RektangelProp l16p4 = new RektangelProp(0.61,0.535,0.23,0.04);
    public static final RektangelProp l16p5 = new RektangelProp(0.61,0.575,0.23,0.04);
    
    public static final RektangelProp l20 = new RektangelProp(0.61,0.615,0.23,0.04);
    public static final RektangelProp l20p1 = new RektangelProp(0.61,0.655,0.23,0.04);
    public static final RektangelProp l20p2 = new RektangelProp(0.61,0.695,0.23,0.04);
    public static final RektangelProp l20p3 = new RektangelProp(0.61,0.735,0.23,0.04);
    public static final RektangelProp l20p4 = new RektangelProp(0.61,0.775,0.23,0.04);
    public static final RektangelProp l20p5 = new RektangelProp(0.61,0.815,0.23,0.04);
    
    public static final RektangelProp Athlete = new RektangelProp(0.845,0.16,0.24,0.09);
    public static final RektangelProp Ranged = new RektangelProp(0.845,0.25,0.24,0.09);
    public static final RektangelProp Melee = new RektangelProp(0.845,0.34,0.24,0.09);
    public static final RektangelProp Strength = new RektangelProp(0.845,0.43,0.24,0.09);
    public static final RektangelProp Technology = new RektangelProp(0.845,0.52,0.24,0.09);
    public static final RektangelProp Charm = new RektangelProp(0.845,0.61,0.24,0.09);
    public static final RektangelProp FirstAid = new RektangelProp(0.845,0.70,0.24,0.09);
    public static final RektangelProp Surgery = new RektangelProp(0.845,0.79,0.24,0.09);
    
    public static final RektangelProp BoARubrik = new RektangelProp(0.345,0.101,0.58,0.03);
    public static final RektangelProp BoAMelee = new RektangelProp(0.17,0.188,0.23,0.144);
    public static final RektangelProp BoARanged = new RektangelProp(0.17,0.332,0.23,0.144);
    public static final RektangelProp BoACharm = new RektangelProp(0.17,0.476,0.23,0.144);
    public static final RektangelProp BoATech = new RektangelProp(0.17,0.62,0.23,0.144);
    public static final RektangelProp BoAHealing = new RektangelProp(0.17,0.764,0.23,0.144);
    public static final RektangelProp BoABigBox = new RektangelProp(0.46,0.476,0.35,0.72);
    
    public static final RektangelProp QuestLogRubrik = new RektangelProp(0.325,0.101,0.54,0.03);
    public static final RektangelProp QuestLogQuest = new RektangelProp(0.19,0.476,0.27,0.72);
    public static final RektangelProp QuestLogQRubrik = new RektangelProp(0.46,0.188,0.27,0.144);
    public static final RektangelProp QuestLogProgress = new RektangelProp(0.46,0.332,0.27,0.144);
    public static final RektangelProp QuestLogDescription = new RektangelProp(0.46,0.548,0.27,0.288);
    public static final RektangelProp QuestLogReward = new RektangelProp(0.46,0.764,0.27,0.144);
}