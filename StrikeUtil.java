class StrikeUtil
{
    static Block3DSpel[] whirlstrike;

    public static void init()
    {
        whirlstrike = new Block3DSpel[32];

        whirlstrike[0] = new Block3DSpel(new Punkt3D(0,30,0),5,5,2);
        whirlstrike[1] = new Block3DSpel(new Punkt3D(21,21,0),5,5,2);
        whirlstrike[2] = new Block3DSpel(new Punkt3D(30,0,0),5,5,2);
        whirlstrike[3] = new Block3DSpel(new Punkt3D(21,-21,0),5,5,2);
        whirlstrike[4] = new Block3DSpel(new Punkt3D(0,-30,0),5,5,2);
        whirlstrike[5] = new Block3DSpel(new Punkt3D(-21,-21,0),5,5,2);
        whirlstrike[6] = new Block3DSpel(new Punkt3D(-30,0,0),5,5,2);
        whirlstrike[7] = new Block3DSpel(new Punkt3D(-21,21,0),5,5,2);

        whirlstrike[8] = new Block3DSpel(new Punkt3D(0,40,0),7,7,2);
        whirlstrike[9] = new Block3DSpel(new Punkt3D(28,28,0),7,7,2);
        whirlstrike[10] = new Block3DSpel(new Punkt3D(40,0,0),7,7,2);
        whirlstrike[11] = new Block3DSpel(new Punkt3D(28,-28,0),7,7,2);
        whirlstrike[12] = new Block3DSpel(new Punkt3D(0,-40,0),7,7,2);
        whirlstrike[13] = new Block3DSpel(new Punkt3D(-28,-28,0),7,7,2);
        whirlstrike[14] = new Block3DSpel(new Punkt3D(-40,0,0),7,7,2);
        whirlstrike[15] = new Block3DSpel(new Punkt3D(-28,28,0),7,7,2);

        whirlstrike[16] = new Block3DSpel(new Punkt3D(0,50,0),9,9,2);
        whirlstrike[17] = new Block3DSpel(new Punkt3D(35,35,0),9,9,2);
        whirlstrike[18] = new Block3DSpel(new Punkt3D(50,0,0),9,9,2);
        whirlstrike[19] = new Block3DSpel(new Punkt3D(35,-35,0),9,9,2);
        whirlstrike[20] = new Block3DSpel(new Punkt3D(0,-50,0),9,9,2);
        whirlstrike[21] = new Block3DSpel(new Punkt3D(-35,-35,0),9,9,2);
        whirlstrike[22] = new Block3DSpel(new Punkt3D(-50,0,0),9,9,2);
        whirlstrike[23] = new Block3DSpel(new Punkt3D(-35,35,0),9,9,2);

        whirlstrike[24] = new Block3DSpel(new Punkt3D(0,60,0),11,11,2);
        whirlstrike[25] = new Block3DSpel(new Punkt3D(42,42,0),11,11,2);
        whirlstrike[26] = new Block3DSpel(new Punkt3D(60,0,0),11,11,2);
        whirlstrike[27] = new Block3DSpel(new Punkt3D(42,-42,0),11,11,2);
        whirlstrike[28] = new Block3DSpel(new Punkt3D(0,-60,0),11,11,2);
        whirlstrike[29] = new Block3DSpel(new Punkt3D(-42,-42,0),11,11,2);
        whirlstrike[30] = new Block3DSpel(new Punkt3D(-60,0,0),11,11,2);
        whirlstrike[31] = new Block3DSpel(new Punkt3D(-42,42,0),11,11,2);
    }

    public static Strike meleeStrike(Sprite sp)
    {
        Block3DSpel[] temp = {new Block3DSpel(new Punkt3D(-12.5,5,0),2.5,2.5,2),
                              new Block3DSpel(new Punkt3D(-9.5,7.5,0),5,5,2),
                              new Block3DSpel(new Punkt3D(-7,17.5,0),5,5,2),
                              new Block3DSpel(new Punkt3D(-3.5,27.5,0),2.5,2.5,2),
                              new Block3DSpel(new Punkt3D(0,32.5,0),2.5,2.5,2),
                              new Block3DSpel(new Punkt3D(3.5,27.5,0),2.5,2.5,2),
                              new Block3DSpel(new Punkt3D(7,17.5,0),5,5,2),
                              new Block3DSpel(new Punkt3D(9.5,7.5,0),5,5,2),
                              new Block3DSpel(new Punkt3D(12.5,5,0),2.5,2.5,2)};
        return createStrike(sp.getID(),true,temp,new Punkt3D(sp.getV(),sp.getW(),sp.getU()),new Vektor2D(0,0,0),sp.getDirection(),4,2,AnimationUtil.makeAnimationsHarm());
    }

    public static Strike crossStrike(Sprite sp)
    {
        Block3DSpel[] temp = {new Block3DSpel(new Punkt3D(0,5,0),8,8,16)};
        return createStrike(sp.getID(),true,temp,new Punkt3D(sp.getV(),sp.getW(),sp.getU()),new Vektor2D(Consts.SPEEDCROSS,0,1),sp.getDirection(),50,1,AnimationUtil.makeAnimationsCross());
    }

    public static Strike whirlStrike(Sprite sp)
    {
        if(whirlstrike == null)
        {
            init();
        }
        return createStrike(sp.getID(),true,whirlstrike,new Punkt3D(sp.getV(),sp.getW(),sp.getU()),new Vektor2D(0,0,0),sp.getDirection(),4,3,AnimationUtil.makeAnimationsHarm());
    }

    public static Strike createStrike(int spriteID,boolean relative,Block3DSpel[] block,Punkt3D pSprite,Vektor2D direction,int directionSprite,int lifetime,int damage,Animation animation)
    {
        if(relative)
        {
            Vektor2D rikt = GameUtil.directionToVektor2D(directionSprite);
            Vektor2D ny;
            if(direction.argRadians() == null)
            {
                ny = new Vektor2D(Math.sin(rikt.argRadians()),-Math.cos(rikt.argRadians()));
            }
            else
            {
                ny = new Vektor2D(Math.sin(rikt.argRadians()+direction.argRadians()),-Math.cos(rikt.argRadians()+direction.argRadians()));
            }
            Harm[] harmar = new Harm[block.length];
            int[] starttider = new int[block.length];
            ny.multiplicera(direction.abs());
            for(int i = 0;i < harmar.length;i++)
            {
                Punkt2D dummy = new Punkt2D(block[i].getV(),block[i].getW());
                Punkt2D delta = new Punkt2D(Math.sin(dummy.argRadians()+rikt.argRadians()),-Math.cos(dummy.argRadians()+rikt.argRadians()));
                delta.multiplicera(dummy.abs());
                Punkt3D p = new Punkt3D(ny.getX()+pSprite.getX()+delta.getX(),ny.getY()+pSprite.getY()+delta.getY(),pSprite.getZ());

                harmar[i] = new Harm(spriteID,new Block3DSpel(p,block[i].getLength(),block[i].getWidth(),block[i].getHeight()),10,new Vektor3D(ny.getX(),ny.getY(),0),lifetime,damage,animation);
                starttider[i] = i*1;
            }
            return new Strike(harmar,starttider);
        }
        return null;
    }
}