import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public class UI implements Runnable
{
    private Ruta[] rutor;
    private Thread trad;
    private boolean life;
	private boolean pressed = true;
	private boolean open = true;
    public UI()
    {
        life = true;
        rutor = new Ruta[200];

        rutor[0] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/UIMenyKnapp.png");
        rutor[1] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/UIMenyKnapp.png");
        rutor[2] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/UIMenyKnapp.png");
        rutor[3] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/UIMenyKnapp.png");
        rutor[4] = new Ruta(RutConsts.MENYSTART,true,true,"Pics/UI/UIMenyKnapp.png");
        rutor[5] = new Ruta(RutConsts.MENYEXIT,true,true,"Pics/UI/UIMenyKnapp.png");

        rutor[6] = new Ruta(RutConsts.BARHP,false,false,"Pics/HPXPBAR/HPXPBARtom.png");
        rutor[7] = new Ruta(RutConsts.BARXP,false,false,"Pics/HPXPBAR/HPXPBARtom.png");
        
        rutor[8] = new Ruta(RutConsts.INVENTORY,false,false,"Pics/UI/UIInventory.png");
		rutor[9] = new Ruta(RutConsts.SNP,false,false,"Pics/UI/UISnP.png");
		rutor[10] = new Ruta(RutConsts.BOA,false,false,"Pics/UI/UIBoA.png");
		rutor[11] = new Ruta(RutConsts.QUESTLOG,false,false,"Pics/UI/UIQuest.png");
        rutor[12] = new Ruta(RutConsts.MENYBAREXIT,false,false,"Pics/UI/UIQuit.png");
        
        rutor[13] = new Ruta(RutConsts.INV1,false,false,"Pics/UI/InventoryRuta.png");
        rutor[14] = new Ruta(RutConsts.INV2,false,false,"Pics/UI/InventoryRuta.png");
        rutor[15] = new Ruta(RutConsts.INV3,false,false,"Pics/UI/InventoryRuta.png");
        rutor[16] = new Ruta(RutConsts.INV4,false,false,"Pics/UI/InventoryRuta.png");
		rutor[17] = new Ruta(RutConsts.INV5,false,false,"Pics/UI/InventoryRuta.png");
		rutor[18] = new Ruta(RutConsts.INV6,false,false,"Pics/UI/InventoryRuta.png");
		rutor[19] = new Ruta(RutConsts.INV7,false,false,"Pics/UI/InventoryRuta.png");
		rutor[20] = new Ruta(RutConsts.INV8,false,false,"Pics/UI/InventoryRuta.png");
		rutor[21] = new Ruta(RutConsts.INV9,false,false,"Pics/UI/InventoryRuta.png");
		rutor[22] = new Ruta(RutConsts.INV10,false,false,"Pics/UI/InventoryRuta.png");
		rutor[23] = new Ruta(RutConsts.INV11,false,false,"Pics/UI/InventoryRuta.png");
		rutor[24] = new Ruta(RutConsts.INV12,false,false,"Pics/UI/InventoryRuta.png");
		rutor[25] = new Ruta(RutConsts.INV13,false,false,"Pics/UI/InventoryRuta.png");
		rutor[26] = new Ruta(RutConsts.INV14,false,false,"Pics/UI/InventoryRuta.png");
		rutor[27] = new Ruta(RutConsts.INV15,false,false,"Pics/UI/InventoryRuta.png");
		rutor[28] = new Ruta(RutConsts.INV16,false,false,"Pics/UI/InventoryRuta.png");
		rutor[29] = new Ruta(RutConsts.INV17,false,false,"Pics/UI/InventoryRuta.png");
		rutor[30] = new Ruta(RutConsts.INV18,false,false,"Pics/UI/InventoryRuta.png");
		rutor[31] = new Ruta(RutConsts.INV19,false,false,"Pics/UI/InventoryRuta.png");
		rutor[32] = new Ruta(RutConsts.INV20,false,false,"Pics/UI/InventoryRuta.png");
		rutor[33] = new Ruta(RutConsts.INV21,false,false,"Pics/UI/InventoryRuta.png");
		rutor[34] = new Ruta(RutConsts.INV22,false,false,"Pics/UI/InventoryRuta.png");
		rutor[35] = new Ruta(RutConsts.INV23,false,false,"Pics/UI/InventoryRuta.png");
		rutor[36] = new Ruta(RutConsts.INV24,false,false,"Pics/UI/InventoryRuta.png");
		rutor[37] = new Ruta(RutConsts.INV25,false,false,"Pics/UI/InventoryRuta.png");
		rutor[38] = new Ruta(RutConsts.HEAD,false,false,"Pics/UI/HjälmHandskarSkor.png");
		rutor[39] = new Ruta(RutConsts.WEAPON,false,false,"Pics/UI/VapenSköldInventory.png");
		rutor[40] = new Ruta(RutConsts.ARMOR,false,false,"Pics/UI/ArmorInventory.png");
		rutor[41] = new Ruta(RutConsts.SHIELD,false,false,"Pics/UI/VapenSköldInventory.png");
		rutor[42] = new Ruta(RutConsts.GLOVES,false,false,"Pics/UI/HjälmHandskarSkor.png");
		rutor[43] = new Ruta(RutConsts.BOOTS,false,false,"Pics/UI/HjälmHandskarSkor.png");
	
		rutor[44] = new Ruta(RutConsts.AB1,false,false,"Pics/UI/UIMelee.png");
		rutor[45] = new Ruta(RutConsts.AB2,false,false,"Pics/UI/UICross.png");
		rutor[46] = new Ruta(RutConsts.AB3,false,false,"Pics/UI/UIWhirl.png");
		rutor[47] = new Ruta(RutConsts.AB4,false,false,"Pics/UI/UIHowl.png");
		rutor[48] = new Ruta(RutConsts.AB5,false,false,"Pics/UI/UIPowerStrike.png");
		rutor[49] = new Ruta(RutConsts.AB6,false,false,"Pics/UI/UISplitTheRedSea.png");
		rutor[50] = new Ruta(RutConsts.AB7,false,false,"Pics/UI/UISurgery.png");
		rutor[51] = new Ruta(RutConsts.AB8,false,false,"Pics/UI/UICharge.png");
		rutor[52] = new Ruta(RutConsts.AB9,false,false,"Pics/UI/UICripple.png");
		rutor[53] = new Ruta(RutConsts.AB0,false,false,"Pics/UI/UIDeusVult.png");

		rutor[90] = new Ruta(RutConsts.SnPRubrik,false,false,"Pics/UI/SnPRubrik.png");
		
		rutor[91] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[92] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[93] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[94] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[95] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[96] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png"); 
		
		rutor[54] = new Ruta(RutConsts.SnP1,false,false,"Pics/UI/SnPRuta.png");
		rutor[55] = new Ruta(RutConsts.SnP4,false,false,"Pics/UI/SnPRuta.png");
		rutor[56] = new Ruta(RutConsts.SnP8,false,false,"Pics/UI/SnPRuta.png");
		rutor[57] = new Ruta(RutConsts.SnP12,false,false,"Pics/UI/SnPRuta.png");
		rutor[58] = new Ruta(RutConsts.SnP16,false,false,"Pics/UI/SnPRuta.png");
		rutor[59] = new Ruta(RutConsts.SnP20,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[60] = new Ruta(RutConsts.SnP1n1,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[61] = new Ruta(RutConsts.SnP1n2,false,false,"Pics/UI/SnPRuta.png");
		rutor[62] = new Ruta(RutConsts.SnP1n3,false,false,"Pics/UI/SnPRuta.png");
		rutor[63] = new Ruta(RutConsts.SnP1n4,false,false,"Pics/UI/SnPRuta.png");
		rutor[64] = new Ruta(RutConsts.SnP1n5,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[65] = new Ruta(RutConsts.SnP4n1,false,false,"Pics/UI/SnPRuta.png");
		rutor[66] = new Ruta(RutConsts.SnP4n2,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[67] = new Ruta(RutConsts.SnP4n3,false,false,"Pics/UI/SnPRuta.png");
		rutor[68] = new Ruta(RutConsts.SnP4n4,false,false,"Pics/UI/SnPRuta.png");
		rutor[69] = new Ruta(RutConsts.SnP4n5,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[70] = new Ruta(RutConsts.SnP8n1,false,false,"Pics/UI/SnPRuta.png");
		rutor[71] = new Ruta(RutConsts.SnP8n2,false,false,"Pics/UI/SnPRuta.png");
		rutor[72] = new Ruta(RutConsts.SnP8n3,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[73] = new Ruta(RutConsts.SnP8n4,false,false,"Pics/UI/SnPRuta.png");
		rutor[74] = new Ruta(RutConsts.SnP8n5,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[75] = new Ruta(RutConsts.SnP12n1,false,false,"Pics/UI/SnPRuta.png");
		rutor[76] = new Ruta(RutConsts.SnP12n2,false,false,"Pics/UI/SnPRuta.png");
		rutor[77] = new Ruta(RutConsts.SnP12n3,false,false,"Pics/UI/SnPRuta.png");
		rutor[78] = new Ruta(RutConsts.SnP12n4,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[79] = new Ruta(RutConsts.SnP12n5,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[80] = new Ruta(RutConsts.SnP16n1,false,false,"Pics/UI/SnPRuta.png");
		rutor[81] = new Ruta(RutConsts.SnP16n2,false,false,"Pics/UI/SnPRuta.png");
		rutor[82] = new Ruta(RutConsts.SnP16n3,false,false,"Pics/UI/SnPRuta.png");
		rutor[83] = new Ruta(RutConsts.SnP16n4,false,false,"Pics/UI/SnPRuta.png");
		rutor[84] = new Ruta(RutConsts.SnP16n5,false,false,"Pics/UI/UIMenyKnapp.png");
		
		rutor[85] = new Ruta(RutConsts.SnP20n1,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[86] = new Ruta(RutConsts.SnP20n2,false,false,"Pics/UI/UIMenyKnapp.png");
		rutor[87] = new Ruta(RutConsts.SnP20n3,false,false,"Pics/UI/SnPRuta.png");
		rutor[88] = new Ruta(RutConsts.SnP20n4,false,false,"Pics/UI/SnPRuta.png");
		rutor[89] = new Ruta(RutConsts.SnP20n5,false,false,"Pics/UI/SnPRuta.png");
		
		rutor[96] = new Ruta(RutConsts.l1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[97] = new Ruta(RutConsts.l1p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[98] = new Ruta(RutConsts.l1p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[99] = new Ruta(RutConsts.l1p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[100] = new Ruta(RutConsts.l1p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[101] = new Ruta(RutConsts.l1p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[102] = new Ruta(RutConsts.l4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[103] = new Ruta(RutConsts.l4p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[104] = new Ruta(RutConsts.l4p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[105] = new Ruta(RutConsts.l4p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[106] = new Ruta(RutConsts.l4p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[107] = new Ruta(RutConsts.l4p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[108] = new Ruta(RutConsts.l8,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[109] = new Ruta(RutConsts.l8p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[110] = new Ruta(RutConsts.l8p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[111] = new Ruta(RutConsts.l8p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[112] = new Ruta(RutConsts.l8p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[113] = new Ruta(RutConsts.l8p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[114] = new Ruta(RutConsts.l12,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[115] = new Ruta(RutConsts.l12p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[116] = new Ruta(RutConsts.l12p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[117] = new Ruta(RutConsts.l12p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[118] = new Ruta(RutConsts.l12p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[119] = new Ruta(RutConsts.l12p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[120] = new Ruta(RutConsts.l16,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[121] = new Ruta(RutConsts.l16p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[122] = new Ruta(RutConsts.l16p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[123] = new Ruta(RutConsts.l16p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[124] = new Ruta(RutConsts.l16p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[125] = new Ruta(RutConsts.l16p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[126] = new Ruta(RutConsts.l20,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[127] = new Ruta(RutConsts.l20p1,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[128] = new Ruta(RutConsts.l20p2,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[129] = new Ruta(RutConsts.l20p3,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[130] = new Ruta(RutConsts.l20p4,false,false,"Pics/UI/SnPPerkRuta.png");
		rutor[131] = new Ruta(RutConsts.l20p5,false,false,"Pics/UI/SnPPerkRuta.png");
		
		rutor[132] = new Ruta(RutConsts.Athlete,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[133] = new Ruta(RutConsts.Ranged,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[134] = new Ruta(RutConsts.Melee,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[135] = new Ruta(RutConsts.Strength,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[136] = new Ruta(RutConsts.Technology,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[137] = new Ruta(RutConsts.Charm,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[138] = new Ruta(RutConsts.FirstAid,false,false,"Pics/UI/SnPStatsRuta.png");
		rutor[139] = new Ruta(RutConsts.Surgery,false,false,"Pics/UI/SnPStatsRuta.png");
		
		rutor[140] = new Ruta(RutConsts.BoARubrik,false,false,"Pics/UI/BoARubrik.png");
		rutor[141] = new Ruta(RutConsts.BoAMelee,false,false,"Pics/UI/BoARuta.png");
		rutor[142] = new Ruta(RutConsts.BoARanged,false,false,"Pics/UI/BoARuta.png");
		rutor[143] = new Ruta(RutConsts.BoACharm,false,false,"Pics/UI/BoARuta.png");
		rutor[144] = new Ruta(RutConsts.BoATech,false,false,"Pics/UI/BoARuta.png");
		rutor[145] = new Ruta(RutConsts.BoAHealing,false,false,"Pics/UI/BoARuta.png");
		rutor[146] = new Ruta(RutConsts.BoABigBox,false,false,"Pics/UI/BoAStorRuta.png");
		
		rutor[147] = new Ruta(RutConsts.QuestLogRubrik,false,false,"Pics/UI/QuestLogRubrik.png");
		rutor[148] = new Ruta(RutConsts.QuestLogQuest,false,false,"Pics/UI/BoAStorRuta.png");
		rutor[149] = new Ruta(RutConsts.QuestLogQRubrik,false,false,"Pics/UI/BoARuta.png");
		rutor[150] = new Ruta(RutConsts.QuestLogProgress,false,false,"Pics/UI/BoARuta.png");
		rutor[151] = new Ruta(RutConsts.QuestLogDescription,false,false,"Pics/UI/BoARuta.png");
		rutor[152] = new Ruta(RutConsts.QuestLogReward,false,false,"Pics/UI/BoARuta.png");//senast

        invertSpelmeny();

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
                trad.sleep((int)(1000/Consts.FPS));
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
        ruta5();
        ruta8();
        ruta9();
        ruta10();
        ruta11();
        ruta12();
        ruta44();
        ruta45();
        ruta46();
        ruta54();
        ruta55();
        ruta56();
        ruta57();
        ruta58();
        ruta59();
        ruta60();
        ruta61();
        ruta62();
        ruta63();
        ruta64();
        ruta65();
        ruta66();
        ruta67();
        ruta68();
        ruta69();
        ruta70();
        ruta71();
        ruta72();
        ruta73();
        ruta74();
        ruta75();
        ruta76();
        ruta77();
        ruta78();
        ruta79();
        ruta80();
        ruta81();
        ruta82();
        ruta83();
        ruta84();
        ruta85();
        ruta86();
        ruta87();
        ruta88();
        ruta89();
        ruta132();
        ruta133();
        ruta134();
        ruta135();
        ruta136();
        ruta137();
        ruta138();
        ruta139();
        ruta141();
        ruta142();
        ruta143();
        ruta144();
        ruta145();
    }

    private void ruta0()
    {
/*
        if(rutaPressed(rutor[0]))
        {
            invertSpelmeny();
            invertMeny();
        }
*/
    }

    private void ruta5()
    {
/*
        if(rutaPressed(rutor[5]))
        {
            life = false;
        }
*/
    }

    private void ruta8()
    {	
    	if(rutaPressed(rutor[8]))
    	{
    		invertInventory();
    		closeSnP();
    		closeSnP1();
            closeSnP2();
            closeSnP3();
            closeSnP4();
            closeSnP5();
            closeSnP6();
    		open=true;
    	}
    }
    private void ruta9()
    {
    	if(rutaPressed(rutor[9])&&open)
    	{	
    		openSnP();
    		closeBoA();
    		closeInventory();
    		closeQuestLog();
			open = false;
			pressed = true;
    	}
    	else if(rutaPressed(rutor[9])&&!open)
    	{
    		closeSnP();
    		closeSnP1();
    		closeSnP2();
    		closeSnP3();
    		closeSnP4();
    		closeSnP5();
    		closeSnP6();
    		open = true;
    		pressed = true;
    	}
    }
    private void ruta10()
    {
    	if(rutaPressed(rutor[10]))
    	{
    		invertBoA();
    		closeSnP();
    		closeQuestLog();
    		closeSnP1();
            closeSnP2();
            closeSnP3();
            closeSnP4();
            closeSnP5();
            closeSnP6();
    		open=true;
    		pressed = true;
    	}
    }
    private void ruta11()
    {
    	if(rutaPressed(rutor[11]))
    	{
    		invertQuestLog();
    		closeSnP();
    		closeBoA();
    		closeSnP1();
            closeSnP2();
            closeSnP3();
            closeSnP4();
            closeSnP5();
            closeSnP6();
    		open=true;
    		pressed = true;
    	}
    }
    private void ruta12()
    {
/*
    	if(rutaPressed(rutor[12]))
        {
            invertSpelmeny();
            invertMeny();
            closeInventory();
            closeBoA();
            closeSnP();
            closeQuestLog();
            closeSnP1();
            closeSnP2();
            closeSnP3();
            closeSnP4();
            closeSnP5();
            closeSnP6();
            open=true;
            pressed = true;
        }
*/
    }

    private void ruta44()
    {
    	if(rutaPressed(rutor[44])){
            Vapen.setVapen(Vapen.MELEE);
    		pressed = false;
    	}
    	else if(rutaPressed(rutor[44])&&!pressed){
            Vapen.setVapen(Vapen.MELEE);
    		pressed = true;
    	}
    }

    private void ruta45()
    {
    	if(rutaPressed(rutor[45])){
            Vapen.setVapen(Vapen.CROSS);
    		pressed = false;
    	}
    	else if(rutaPressed(rutor[45])&&!pressed){
            Vapen.setVapen(Vapen.CROSS);
    		pressed = true;
    	}
    }

    private void ruta46()
    {
    	if(rutaPressed(rutor[46])){
            Vapen.setVapen(Vapen.WHIRL);
    		pressed = false;
    	}
    	else if(rutaPressed(rutor[46])&&!pressed){
            Vapen.setVapen(Vapen.WHIRL);
    		pressed = true;
    	}
    }

    private void ruta54()
    {
    	if(rutaPressed(rutor[54])&&pressed){
    		openSnP1();
    		pressed = false;
    	}
    	else if(rutaPressed(rutor[54])&&!pressed){
    		closeSnP1();
    		openSnP();
    		pressed = true;
    	}
    }
    private void ruta55()
    {
    	if(rutaPressed(rutor[55])){
    		openSnP2();
    	}
    	else if(rutaPressed(rutor[91]))
    	{
    		closeSnP2();
    		openSnP();
    	}
    }
    private void ruta56()
    {
    	if(rutaPressed(rutor[56])){
    		openSnP3();
    	}
    	else if(rutaPressed(rutor[92]))
    	{
    		closeSnP3();
    		openSnP();

    	}
    }
    private void ruta57()
    {
    	if(rutaPressed(rutor[57])){
    		openSnP4();
    	}
    	else if(rutaPressed(rutor[93]))
    	{
    		closeSnP4();
    		openSnP();
    	}
    }
    private void ruta58()
    {
    	if(rutaPressed(rutor[58])){
    		openSnP5();
    	}
    	else if(rutaPressed(rutor[94]))
    	{
    		closeSnP5();
    		openSnP();
    	}
    }
    private void ruta59()
    {
    	if(rutaPressed(rutor[59])){
    		openSnP6();
    	}
    	else if(rutaPressed(rutor[95]))
    	{
    		closeSnP6();
    		openSnP();
    	}
    }
    private void ruta60(){
    	if(rutaPressed(rutor[60])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[60])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta61(){
    	if(rutaPressed(rutor[61])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[61])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta62(){
    	if(rutaPressed(rutor[62])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[62])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta63(){
    	if(rutaPressed(rutor[63])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[63])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta64(){
    	if(rutaPressed(rutor[64])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[64])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta65(){
    	if(rutaPressed(rutor[65])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[65])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta66(){
    	if(rutaPressed(rutor[66])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[66])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta67(){
    	if(rutaPressed(rutor[67])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[67])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta68(){
    	if(rutaPressed(rutor[68])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[68])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta69(){
    	if(rutaPressed(rutor[69])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[69])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta70(){
    	if(rutaPressed(rutor[70])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[70])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta71(){
    	if(rutaPressed(rutor[71])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[71])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta72(){
    	if(rutaPressed(rutor[72])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[72])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta73(){
    	if(rutaPressed(rutor[73])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[73])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }

    private void ruta74(){
    	if(rutaPressed(rutor[74])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[74])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta75(){
    	if(rutaPressed(rutor[75])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[75])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta76(){
    	if(rutaPressed(rutor[76])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[76])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta77(){
    	if(rutaPressed(rutor[77])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[77])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta78(){
    	if(rutaPressed(rutor[78])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[78])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta79(){
    	if(rutaPressed(rutor[79])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[79])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta80(){
    	if(rutaPressed(rutor[80])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[80])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta81(){
    	if(rutaPressed(rutor[81])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[81])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta82(){
    	if(rutaPressed(rutor[82])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[82])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta83(){
    	if(rutaPressed(rutor[83])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[83])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta84(){
    	if(rutaPressed(rutor[84])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[84])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta85(){
    	if(rutaPressed(rutor[85])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[85])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta86(){
    	if(rutaPressed(rutor[86])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[86])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta87(){
    	if(rutaPressed(rutor[87])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[87])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta88(){
    	if(rutaPressed(rutor[88])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[88])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }
    private void ruta89(){
    	if(rutaPressed(rutor[89])&&StatsProt.getPPoints()>0)
    	{
    		StatsProt.setPPoints(StatsProt.getPPoints()-1);
    	}
    	else if(rutaPressed(rutor[89])&&!(StatsProt.getPPoints()>0))
    	{
    	}
    }

    private void ruta132()
    {
    	if(rutaPressed(rutor[132])&&StatsProt.getSPoints()>0){
    		Skills.Athletics++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[132])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta133()
    {
    	if(rutaPressed(rutor[133])&&StatsProt.getSPoints()>0){
    		Skills.Ranged++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[133])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta134()
    {
    	if(rutaPressed(rutor[134])&&StatsProt.getSPoints()>0){
    		Skills.Melee++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[134])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta135()
    {
    	if(rutaPressed(rutor[135])&&StatsProt.getSPoints()>0){
    		Skills.Strength++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[135])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta136()
    {
    	if(rutaPressed(rutor[136])&&StatsProt.getSPoints()>0){
    		Skills.Technology++;
    	}
    	else if(rutaPressed(rutor[136])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta137()
    {
    	if(rutaPressed(rutor[137])&&StatsProt.getSPoints()>0){
    		Skills.Charm++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[137])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta138()
    {
    	if(rutaPressed(rutor[138])&&StatsProt.getSPoints()>0){
    		Skills.FirstAid++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[138])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta139()
    {
    	if(rutaPressed(rutor[139])&&StatsProt.getSPoints()>0){
    		Skills.Surgery++;
    		StatsProt.setSPoints(StatsProt.getSPoints()-1);
    	}
    	else if(rutaPressed(rutor[139])&&!(StatsProt.getSPoints()>0)){
    		
    	} 
    }
    private void ruta141()
    {
    	if((rutaPressed(rutor[141])))
    	{
    	}
    }
    private void ruta142()
    {
    	if((rutaPressed(rutor[142])))
    	{
    	}
    }
    private void ruta143()
    {
    	if((rutaPressed(rutor[143])))
    	{
    	}
    }
    private void ruta144()
    {
    	if((rutaPressed(rutor[144])))
    	{
    	}
    }
    private void ruta145()
	{
    	if((rutaPressed(rutor[145])))
    	{
    	}
    }	
    private void invertMeny()
    {
        rutor[0].invertAccessibel();
        rutor[0].invertSynlig();
        rutor[1].invertAccessibel();
        rutor[1].invertSynlig();
        rutor[2].invertAccessibel();
        rutor[2].invertSynlig();
        rutor[3].invertAccessibel();
        rutor[3].invertSynlig();
        rutor[4].invertAccessibel();
        rutor[4].invertSynlig();
        rutor[5].invertAccessibel();
        rutor[5].invertSynlig();
        
        
    }

    private void invertSpelmeny()
    {
        rutor[6].invertAccessibel();
        rutor[6].invertSynlig();
        rutor[7].invertAccessibel();
        rutor[7].invertSynlig();
        rutor[8].invertAccessibel();
        rutor[8].invertSynlig();
        rutor[9].invertAccessibel();
        rutor[9].invertSynlig();
        rutor[10].invertAccessibel();
        rutor[10].invertSynlig();
        rutor[11].invertAccessibel();
        rutor[11].invertSynlig();
        rutor[12].invertAccessibel();
        rutor[12].invertSynlig();
        rutor[44].invertSynlig();
        rutor[44].invertAccessibel();
        rutor[45].invertSynlig();
        rutor[45].invertAccessibel();
        rutor[46].invertSynlig();
        rutor[46].invertAccessibel();
        rutor[47].invertSynlig();
        rutor[47].invertAccessibel();
        rutor[48].invertSynlig();
        rutor[48].invertAccessibel();
        rutor[49].invertSynlig();
        rutor[49].invertAccessibel();
        rutor[50].invertSynlig();
        rutor[50].invertAccessibel();
        rutor[51].invertSynlig();
        rutor[51].invertAccessibel();
        rutor[52].invertSynlig();
        rutor[52].invertAccessibel();
        rutor[53].invertSynlig();
        rutor[53].invertAccessibel();
      
    }
    
    private void invertInventory()
    {
    	
        
    	rutor[13].invertSynlig();
    	rutor[14].invertSynlig();
    	rutor[15].invertSynlig();
    	rutor[16].invertSynlig();
    	rutor[17].invertSynlig();
    	rutor[18].invertSynlig();
    	rutor[19].invertSynlig();
    	rutor[20].invertSynlig();
    	rutor[21].invertSynlig();
    	rutor[22].invertSynlig();
    	rutor[23].invertSynlig();
    	rutor[24].invertSynlig();
    	rutor[25].invertSynlig();
    	rutor[26].invertSynlig();
    	rutor[27].invertSynlig();
    	rutor[28].invertSynlig();
    	rutor[29].invertSynlig();
    	rutor[30].invertSynlig();
    	rutor[31].invertSynlig();
    	rutor[32].invertSynlig();
    	rutor[33].invertSynlig();
    	rutor[34].invertSynlig();
    	rutor[35].invertSynlig();
    	rutor[36].invertSynlig();
    	rutor[37].invertSynlig();
    	rutor[38].invertSynlig();
    	rutor[39].invertSynlig();
    	rutor[40].invertSynlig();
    	rutor[41].invertSynlig();
    	rutor[42].invertSynlig();
    	rutor[43].invertSynlig();
    	rutor[13].invertAccessibel();
    	rutor[14].invertAccessibel();
    	rutor[15].invertAccessibel();
    	rutor[16].invertAccessibel();
    	rutor[17].invertAccessibel();
    	rutor[18].invertAccessibel();
    	rutor[19].invertAccessibel();
    	rutor[20].invertAccessibel();
    	rutor[21].invertAccessibel();
    	rutor[22].invertAccessibel();
    	rutor[23].invertAccessibel();
    	rutor[24].invertAccessibel();
    	rutor[25].invertAccessibel();
    	rutor[26].invertAccessibel();
    	rutor[27].invertAccessibel();
    	rutor[28].invertAccessibel();
    	rutor[29].invertAccessibel();
    	rutor[30].invertAccessibel();
    	rutor[31].invertAccessibel();
    	rutor[32].invertAccessibel();
    	rutor[33].invertAccessibel();
    	rutor[34].invertAccessibel();
    	rutor[35].invertAccessibel();
    	rutor[36].invertAccessibel();
    	rutor[37].invertAccessibel();
    	rutor[38].invertAccessibel();
    	rutor[39].invertAccessibel();
    	rutor[40].invertAccessibel();
    	rutor[41].invertAccessibel();
    	rutor[42].invertAccessibel();
    	rutor[43].invertAccessibel();
    }
    
    public void openSnP(){
    	rutor[54].setAccessibel(true);
    	rutor[54].setSynlig(true);
    	rutor[55].setAccessibel(true);
    	rutor[55].setSynlig(true);
    	rutor[56].setAccessibel(true);
    	rutor[56].setSynlig(true);
    	rutor[57].setAccessibel(true);
    	rutor[57].setSynlig(true);
    	rutor[58].setAccessibel(true);
    	rutor[58].setSynlig(true);
    	rutor[59].setAccessibel(true);
    	rutor[59].setSynlig(true);
    	rutor[90].setSynlig(true);
    	rutor[90].setAccessibel(true);
    	
    	rutor[96].setSynlig(true);
    	rutor[97].setSynlig(true);
    	rutor[98].setSynlig(true);
    	rutor[99].setSynlig(true);
    	rutor[100].setSynlig(true);
    	rutor[101].setSynlig(true);
    	rutor[102].setSynlig(true);
    	rutor[103].setSynlig(true);
    	rutor[104].setSynlig(true);
    	rutor[105].setSynlig(true);
    	rutor[106].setSynlig(true);
    	rutor[107].setSynlig(true);
    	rutor[108].setSynlig(true);
    	rutor[109].setSynlig(true);
    	rutor[110].setSynlig(true);
    	rutor[111].setSynlig(true);
    	rutor[112].setSynlig(true);
    	rutor[113].setSynlig(true);
    	rutor[114].setSynlig(true);
    	rutor[115].setSynlig(true);
    	rutor[116].setSynlig(true);
    	rutor[117].setSynlig(true);
    	rutor[118].setSynlig(true);
    	rutor[119].setSynlig(true);
    	rutor[120].setSynlig(true);
    	rutor[121].setSynlig(true);
    	rutor[122].setSynlig(true);
    	rutor[123].setSynlig(true);
    	rutor[124].setSynlig(true);
    	rutor[125].setSynlig(true);
    	rutor[126].setSynlig(true);
    	rutor[127].setSynlig(true);
    	rutor[128].setSynlig(true);
    	rutor[129].setSynlig(true);
    	rutor[130].setSynlig(true);
    	rutor[131].setSynlig(true);
		
		rutor[132].setSynlig(true);
		rutor[133].setSynlig(true);
		rutor[134].setSynlig(true);
		rutor[135].setSynlig(true);
		rutor[136].setSynlig(true);
		rutor[137].setSynlig(true);
		rutor[138].setSynlig(true);
		rutor[139].setSynlig(true);
		rutor[132].setAccessibel(true);
		rutor[133].setAccessibel(true);
		rutor[134].setAccessibel(true);
		rutor[135].setAccessibel(true);
		rutor[136].setAccessibel(true);
		rutor[137].setAccessibel(true);
		rutor[138].setAccessibel(true);
		rutor[139].setAccessibel(true);
    }
    
    public void closeSnP(){
    	rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
    	rutor[59].setAccessibel(false);
    	rutor[59].setSynlig(false);
    	rutor[90].setSynlig(false);
    	rutor[90].setAccessibel(false);
		
		rutor[96].setSynlig(false);
    	rutor[97].setSynlig(false);
    	rutor[98].setSynlig(false);
    	rutor[99].setSynlig(false);
    	rutor[100].setSynlig(false);
    	rutor[101].setSynlig(false);
    	rutor[102].setSynlig(false);
    	rutor[103].setSynlig(false);
    	rutor[104].setSynlig(false);
    	rutor[105].setSynlig(false);
    	rutor[106].setSynlig(false);
    	rutor[107].setSynlig(false);
    	rutor[108].setSynlig(false);
    	rutor[109].setSynlig(false);
    	rutor[110].setSynlig(false);
    	rutor[111].setSynlig(false);
    	rutor[112].setSynlig(false);
    	rutor[113].setSynlig(false);
    	rutor[114].setSynlig(false);
    	rutor[115].setSynlig(false);
    	rutor[116].setSynlig(false);
    	rutor[117].setSynlig(false);
    	rutor[118].setSynlig(false);
    	rutor[119].setSynlig(false);
    	rutor[120].setSynlig(false);
    	rutor[121].setSynlig(false);
    	rutor[122].setSynlig(false);
    	rutor[123].setSynlig(false);
    	rutor[124].setSynlig(false);
    	rutor[125].setSynlig(false);
    	rutor[126].setSynlig(false);
    	rutor[127].setSynlig(false);
    	rutor[128].setSynlig(false);
    	rutor[129].setSynlig(false);
    	rutor[130].setSynlig(false);
    	rutor[131].setSynlig(false);
    	
		rutor[132].setSynlig(false);
		rutor[133].setSynlig(false);
		rutor[134].setSynlig(false);
		rutor[135].setSynlig(false);
		rutor[136].setSynlig(false);
		rutor[137].setSynlig(false);
		rutor[138].setSynlig(false);
		rutor[139].setSynlig(false);
		rutor[132].setAccessibel(false);
		rutor[133].setAccessibel(false);
		rutor[134].setAccessibel(false);
		rutor[135].setAccessibel(false);
		rutor[136].setAccessibel(false);
		rutor[137].setAccessibel(false);
		rutor[138].setAccessibel(false);
		rutor[139].setAccessibel(false);
    }
    
    	
    
    public void openSnP1(){
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
    	rutor[59].setAccessibel(false);
    	rutor[59].setSynlig(false);	
    	rutor[60].setAccessibel(true);
    	rutor[60].setSynlig(true);
    	rutor[61].setAccessibel(true);
    	rutor[61].setSynlig(true);
    	rutor[62].setAccessibel(true);
    	rutor[62].setSynlig(true);
    	rutor[63].setAccessibel(true);
    	rutor[63].setSynlig(true);
    	rutor[64].setAccessibel(true);
    	rutor[64].setSynlig(true);
    }
    public void closeSnP1(){
    	rutor[60].setAccessibel(false);
    	rutor[60].setSynlig(false);
    	rutor[61].setAccessibel(false);
    	rutor[61].setSynlig(false);
    	rutor[62].setAccessibel(false);
    	rutor[62].setSynlig(false);
    	rutor[63].setAccessibel(false);
    	rutor[63].setSynlig(false);
    	rutor[64].setAccessibel(false);
    	rutor[64].setSynlig(false);
    }
   	public void openSnP2(){
		
   		rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
    	rutor[59].setAccessibel(false);	
    	rutor[59].setSynlig(false);	
    	
    	rutor[91].setAccessibel(true);
    	rutor[91].setSynlig(true);
    	rutor[55].setAccessibel(true);
    	rutor[55].setSynlig(true);
    	rutor[65].setAccessibel(true);
    	rutor[65].setSynlig(true);
    	rutor[66].setAccessibel(true);
    	rutor[66].setSynlig(true);
    	rutor[67].setAccessibel(true);
    	rutor[67].setSynlig(true);
    	rutor[68].setAccessibel(true);
    	rutor[68].setSynlig(true);
    	rutor[69].setAccessibel(true);
    	rutor[69].setSynlig(true);
    }
    public void closeSnP2(){
		rutor[91].setAccessibel(false);
		rutor[91].setSynlig(false);
    	rutor[65].setAccessibel(false);
    	rutor[65].setSynlig(false);
    	rutor[66].setAccessibel(false);
    	rutor[66].setSynlig(false);
    	rutor[67].setAccessibel(false);
    	rutor[67].setSynlig(false);
    	rutor[68].setAccessibel(false);
    	rutor[68].setSynlig(false);
    	rutor[69].setAccessibel(false);
    	rutor[69].setSynlig(false);
    }
    public void openSnP3(){
    	
		rutor[92].setAccessibel(true);
    	rutor[92].setSynlig(true);
    	rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
    	rutor[59].setAccessibel(false);
    	rutor[59].setSynlig(false);	
    	rutor[56].setAccessibel(true);
    	rutor[56].setSynlig(true);
    	rutor[70].setAccessibel(true);
    	rutor[70].setSynlig(true);
    	rutor[71].setAccessibel(true);
    	rutor[71].setSynlig(true);
    	rutor[72].setAccessibel(true);
    	rutor[72].setSynlig(true);
    	rutor[73].setAccessibel(true);
    	rutor[73].setSynlig(true);
    	rutor[74].setAccessibel(true);
    	rutor[74].setSynlig(true);
    }
    public void closeSnP3(){
		rutor[92].setAccessibel(false);
		rutor[92].setSynlig(false);
    	rutor[70].setAccessibel(false);
    	rutor[70].setSynlig(false);
    	rutor[71].setAccessibel(false);
    	rutor[71].setSynlig(false);
    	rutor[72].setAccessibel(false);
    	rutor[72].setSynlig(false);
    	rutor[73].setAccessibel(false);
    	rutor[73].setSynlig(false);
    	rutor[74].setAccessibel(false);
    	rutor[74].setSynlig(false);
    }
   	public void openSnP4(){
 		rutor[93].setAccessibel(true);
    	rutor[93].setSynlig(true);
    	rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
    	rutor[59].setAccessibel(false);
    	rutor[59].setSynlig(false);	
    	rutor[57].setAccessibel(true);
    	rutor[57].setSynlig(true);
    	rutor[75].setAccessibel(true);
    	rutor[75].setSynlig(true);
    	rutor[76].setAccessibel(true);
    	rutor[76].setSynlig(true);
    	rutor[77].setAccessibel(true);
    	rutor[77].setSynlig(true);
    	rutor[78].setAccessibel(true);
    	rutor[78].setSynlig(true);
    	rutor[79].setAccessibel(true);
    	rutor[79].setSynlig(true);
   	}
   	public void closeSnP4(){
		rutor[93].setAccessibel(false);
		rutor[93].setSynlig(false);
    	rutor[75].setAccessibel(false);
    	rutor[75].setSynlig(false);
    	rutor[76].setAccessibel(false);
    	rutor[76].setSynlig(false);
    	rutor[77].setAccessibel(false);
    	rutor[77].setSynlig(false);
    	rutor[78].setAccessibel(false);
    	rutor[78].setSynlig(false);
    	rutor[79].setAccessibel(false);
    	rutor[79].setSynlig(false);
    }
   	public void openSnP5(){
   		rutor[94].setAccessibel(true);
    	rutor[94].setSynlig(true);
    	rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[59].setAccessibel(false);
    	rutor[59].setSynlig(false);	
    	rutor[58].setAccessibel(true);
    	rutor[58].setSynlig(true);
    	rutor[80].setAccessibel(true);
    	rutor[80].setSynlig(true);
    	rutor[81].setAccessibel(true);
    	rutor[81].setSynlig(true);
    	rutor[82].setAccessibel(true);
    	rutor[82].setSynlig(true);
    	rutor[83].setAccessibel(true);
    	rutor[83].setSynlig(true);
    	rutor[84].setAccessibel(true);
    	rutor[84].setSynlig(true);
    }
    public void closeSnP5(){
		rutor[94].setAccessibel(false);
		rutor[94].setSynlig(false);
    	rutor[80].setAccessibel(false);
    	rutor[80].setSynlig(false);
    	rutor[81].setAccessibel(false);
    	rutor[81].setSynlig(false);
    	rutor[82].setAccessibel(false);
    	rutor[82].setSynlig(false);
    	rutor[83].setAccessibel(false);
    	rutor[83].setSynlig(false);
    	rutor[84].setAccessibel(false);
    	rutor[84].setSynlig(false);
    }
    public void openSnP6(){
		rutor[95].setAccessibel(true);
    	rutor[95].setSynlig(true);
    	rutor[54].setAccessibel(false);
    	rutor[54].setSynlig(false);
    	rutor[55].setAccessibel(false);
    	rutor[55].setSynlig(false);
    	rutor[56].setAccessibel(false);
    	rutor[56].setSynlig(false);
    	rutor[57].setAccessibel(false);
    	rutor[57].setSynlig(false);
    	rutor[58].setAccessibel(false);
    	rutor[58].setSynlig(false);
		rutor[59].setAccessibel(true);
    	rutor[59].setSynlig(true);
    	rutor[85].setAccessibel(true);
    	rutor[85].setSynlig(true);
    	rutor[86].setAccessibel(true);
    	rutor[86].setSynlig(true);
    	rutor[87].setAccessibel(true);
    	rutor[87].setSynlig(true);
    	rutor[88].setAccessibel(true);
    	rutor[88].setSynlig(true);
    	rutor[89].setAccessibel(true);
    	rutor[89].setSynlig(true);
    	}
    public void closeSnP6(){
    	rutor[95].setAccessibel(false);
		rutor[95].setSynlig(false);
    	rutor[85].setAccessibel(false);
    	rutor[85].setSynlig(false);
    	rutor[86].setAccessibel(false);
    	rutor[86].setSynlig(false);
    	rutor[87].setAccessibel(false);
    	rutor[87].setSynlig(false);
    	rutor[88].setAccessibel(false);
    	rutor[88].setSynlig(false);
    	rutor[89].setAccessibel(false);
    	rutor[89].setSynlig(false);
    }
    	
	public void invertBoA()
	{
		rutor[140].invertSynlig();
		rutor[141].invertSynlig();
		rutor[142].invertSynlig();
		rutor[143].invertSynlig();
		rutor[144].invertSynlig();
		rutor[145].invertSynlig();
		rutor[146].invertSynlig();
		rutor[141].invertAccessibel();
		rutor[142].invertAccessibel();
		rutor[143].invertAccessibel();
		rutor[144].invertAccessibel();
		rutor[145].invertAccessibel();
	}
	public void closeBoA()
	{
		rutor[140].setSynlig(false);
		rutor[141].setSynlig(false);
		rutor[142].setSynlig(false);
		rutor[143].setSynlig(false);
		rutor[144].setSynlig(false);
		rutor[145].setSynlig(false);
		rutor[146].setSynlig(false);
		rutor[141].setAccessibel(false);
		rutor[142].setAccessibel(false);
		rutor[143].setAccessibel(false);
		rutor[144].setAccessibel(false);
		rutor[145].setAccessibel(false);
	}
	public void invertQuestLog()
	{
		rutor[147].invertSynlig();
		rutor[148].invertSynlig();
		rutor[149].invertSynlig();
		rutor[150].invertSynlig();
		rutor[151].invertSynlig();
		rutor[152].invertSynlig();	
	}
	public void closeQuestLog()
	{
		rutor[147].setSynlig(false);
		rutor[148].setSynlig(false);
		rutor[149].setSynlig(false);
		rutor[150].setSynlig(false);
		rutor[151].setSynlig(false);
		rutor[152].setSynlig(false);
	}
	public void closeInventory()
    {
    	rutor[13].setSynlig(false);
    	rutor[14].setSynlig(false);
    	rutor[15].setSynlig(false);
    	rutor[16].setSynlig(false);
    	rutor[17].setSynlig(false);
    	rutor[18].setSynlig(false);
    	rutor[19].setSynlig(false);
    	rutor[20].setSynlig(false);
    	rutor[21].setSynlig(false);
    	rutor[22].setSynlig(false);
    	rutor[23].setSynlig(false);
    	rutor[24].setSynlig(false);
    	rutor[25].setSynlig(false);
    	rutor[26].setSynlig(false);
    	rutor[27].setSynlig(false);
    	rutor[28].setSynlig(false);
    	rutor[29].setSynlig(false);
    	rutor[30].setSynlig(false);
    	rutor[31].setSynlig(false);
    	rutor[32].setSynlig(false);
    	rutor[33].setSynlig(false);
    	rutor[34].setSynlig(false);
    	rutor[35].setSynlig(false);
    	rutor[36].setSynlig(false);
    	rutor[37].setSynlig(false);
    	rutor[38].setSynlig(false);
    	rutor[39].setSynlig(false);
    	rutor[40].setSynlig(false);
    	rutor[41].setSynlig(false);
    	rutor[42].setSynlig(false);
    	rutor[43].setSynlig(false);
    	rutor[13].setAccessibel(false);
    	rutor[14].setAccessibel(false);
    	rutor[15].setAccessibel(false);
    	rutor[16].setAccessibel(false);
    	rutor[17].setAccessibel(false);
    	rutor[18].setAccessibel(false);
    	rutor[19].setAccessibel(false);
    	rutor[20].setAccessibel(false);
    	rutor[21].setAccessibel(false);
    	rutor[22].setAccessibel(false);
    	rutor[23].setAccessibel(false);
    	rutor[24].setAccessibel(false);
    	rutor[25].setAccessibel(false);
    	rutor[26].setAccessibel(false);
    	rutor[27].setAccessibel(false);
    	rutor[28].setAccessibel(false);
    	rutor[29].setAccessibel(false);
    	rutor[30].setAccessibel(false);
    	rutor[31].setAccessibel(false);
    	rutor[32].setAccessibel(false);
    	rutor[33].setAccessibel(false);
    	rutor[34].setAccessibel(false);
    	rutor[35].setAccessibel(false);
    	rutor[36].setAccessibel(false);
    	rutor[37].setAccessibel(false);
    	rutor[38].setAccessibel(false);
    	rutor[39].setAccessibel(false);
    	rutor[40].setAccessibel(false);
    	rutor[41].setAccessibel(false);
    	rutor[42].setAccessibel(false);
    	rutor[43].setAccessibel(false);
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
            if(i >= 6)
                rutor[i].rita(g);
        }
        g.setColor(Color.RED);
        g.fillRect((int)(rutor[6].getX()-rutor[6].getWidth()/2+5),(int)(rutor[6].getY()-rutor[6].getHeight()/2+5),(int)((rutor[6].getWidth()-10)*StatsProt.health/StatsProt.healthMax),(int)(rutor[6].getHeight()-10));
        g.setColor(Color.BLACK);
    }
}