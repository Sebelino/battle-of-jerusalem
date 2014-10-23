public class ProtUtil
{
    public static void renderV(Sprite sp)
    {
        sp.addV(sp.getSpeedV());
    }

    public static void renderW(Sprite sp)
    {
        sp.addW(sp.getSpeedW());
    }

    public static void renderU(Sprite sp)
    {
        sp.addU(sp.getSpeedU());
    }

    public static void setSpeedV(Sprite sp)
    {
        if(sp.getCondition(Consts.WALKING))
        {
            sp.setSpeedV(determineSpeedVW(sp).getX());
        }
        else
        {
            sp.setSpeedV(0);
        }
    }
    public static void setSpeedW(Sprite sp)
    {
        if(sp.getCondition(Consts.WALKING))
        {
            sp.setSpeedW(determineSpeedVW(sp).getY());
        }
        else
        {
            sp.setSpeedW(0);
        }
    }

    public static void setSpeedU(Sprite sp)
    {
        if(sp.getCondition(Consts.AIRBORNE))
        {
            sp.addSpeedU(Consts.GRAVITY);
        }
        if(sp.getCondition(Consts.JUMPING))
        {
            sp.setSpeedU(sp.getSpeedInitJump());
        }
    }

    public static Vektor3D determineSpeedVW(Sprite sp)
    {
        Vektor3D vekt = new Vektor3D();
        if(sp.getDirection() == Consts.NORTH)
        {
            vekt.setX(sp.getSpeedInitWalk()/Math.sqrt(2));
            vekt.setY(sp.getSpeedInitWalk()/Math.sqrt(2));
        }
        else if(sp.getDirection() == Consts.EAST)
        {
            vekt.setX(-sp.getSpeedInitWalk()/Math.sqrt(2));
            vekt.setY(sp.getSpeedInitWalk()/Math.sqrt(2));
        }
        else if(sp.getDirection() == Consts.SOUTH)
        {
            vekt.setX(-sp.getSpeedInitWalk()/Math.sqrt(2));
            vekt.setY(-sp.getSpeedInitWalk()/Math.sqrt(2));
        }
        else if(sp.getDirection() == Consts.WEST)
        {
            vekt.setX(sp.getSpeedInitWalk()/Math.sqrt(2));
            vekt.setY(-sp.getSpeedInitWalk()/Math.sqrt(2));
        }
        else if(sp.getDirection() == Consts.NORTHWEST)
        {
            vekt.setX(sp.getSpeedInitWalk());
            vekt.setY(0);
        }
        else if(sp.getDirection() == Consts.NORTHEAST)
        {
            vekt.setX(0);
            vekt.setY(sp.getSpeedInitWalk());
        }
        else if(sp.getDirection() == Consts.SOUTHEAST)
        {
            vekt.setX(-sp.getSpeedInitWalk());
            vekt.setY(0);
        }
        else if(sp.getDirection() == Consts.SOUTHWEST)
        {
            vekt.setX(0);
            vekt.setY(-sp.getSpeedInitWalk());
        }
        return vekt;
    }

    public static boolean coordsVFine(Sprite sp)
    {
        return (sp.getV()+sp.getSpeed().getX() >= 0 &&
                sp.getV()+sp.getSpeed().getX() <= Spelplan.getKartskala()*Spelplan.getPlanskala()-1);
    }

    public static boolean coordsWFine(Sprite sp)
    {
        return (sp.getW()+sp.getSpeed().getY() >= 0 &&
                sp.getW()+sp.getSpeed().getY() <= Spelplan.getKartskala()*Spelplan.getPlanskala()-1);
    }

    public static boolean coordsUFine(Sprite sp)
    {
        return (sp.getU()+sp.getHeight()/2 <= sp.getGroundlevel());
    }

    public static boolean coordsVFine(Sprite sp,double dv)
    {
        return (sp.getV()+dv >= 0 &&
                sp.getV()+dv <= Spelplan.getKartskala()*Spelplan.getPlanskala()-1);
    }

    public static boolean coordsWFine(Sprite sp,double dw)
    {
        return (sp.getW()+dw >= 0 &&
                sp.getW()+dw <= Spelplan.getKartskala()*Spelplan.getPlanskala()-1);
    }

    public static boolean coordsUFine(Sprite sp,double du,double groundlevelNy)
    {
        return (sp.getU()+sp.getHeight()/2+du <= groundlevelNy);
    }

    public static boolean trappa(Sprite sp,double du)
    {
        return (du <= sp.getHeight()/2);
    }

    public static void updatePunkt3DPre(Sprite sp)
    {
        sp.setPunkt3DPre(sp.getPunkt3D());
    }

    public static void updateGroundlevelPre(Sprite sp)
    {
        sp.setGroundlevelPre(sp.getGroundlevel());
    }

    public static void determineDirection(Sprite sp)
    {
        if(Kontroller.left && Kontroller.up)
        {
            sp.setDirection(Consts.NORTHWEST);
        }
        else if(Kontroller.right && Kontroller.up)
        {
            sp.setDirection(Consts.NORTHEAST);
        }
        else if(Kontroller.right && Kontroller.down)
        {
            sp.setDirection(Consts.SOUTHEAST);
        }
        else if(Kontroller.left && Kontroller.down)
        {
            sp.setDirection(Consts.SOUTHWEST);
        }
        else if(Kontroller.up)
        {
            sp.setDirection(Consts.NORTH);
        }
        else if(Kontroller.right)
        {
            sp.setDirection(Consts.EAST);
        }
        else if(Kontroller.down)
        {
            sp.setDirection(Consts.SOUTH);
        }
        else if(Kontroller.left)
        {
            sp.setDirection(Consts.WEST);
        }
    }

    public static void determineCondition(Sprite sp)
    {
        if(Kontroller.up || Kontroller.right || Kontroller.left || Kontroller.down)
        {
            sp.setCondition(Consts.WALKING,true);
            sp.setCondition(Consts.STANDBY,false);
        }
        else
        {
            sp.setCondition(Consts.STANDBY,true);
            sp.setCondition(Consts.WALKING,false);
        }
        if(sp.getU()+sp.getHeight()/2 < sp.getGroundlevel())
        {
            sp.setCondition(Consts.AIRBORNE,true);
        }
        else
        {
            sp.setCondition(Consts.AIRBORNE,false);
        }
        if(Kontroller.c && !sp.getCondition(Consts.JUMPING))
        {
            if(!sp.getCondition(Consts.AIRBORNE))
                sp.setCondition(Consts.JUMPING,true);
        }
        else
        {
            sp.setCondition(Consts.JUMPING,false);
        }
        if(Kontroller.x && !sp.getCondition(Consts.ATTACKING))
        {
            sp.setCondition(Consts.ATTACKING,true);
            sp.setAttacktime(Consts.ATTACKTIME);
        }
    }

    public static void move(Sprite sp,Spelplan plan)
    {
        setSpeedV(sp);
        setSpeedW(sp);
        setSpeedU(sp);
        double v = sp.getV();
        double w = sp.getW();
        double u = sp.getU();
        double dv = sp.getSpeedV();
        double dw = sp.getSpeedW();
        double du = sp.getSpeedU();
        double groundlevel = plan.getKartaSprite(sp.getPunkt3D()).getHeight((int)sp.getV(),(int)sp.getW());
        boolean flyttV;
        boolean flyttW;
        boolean flyttU;
        if(coordsVFine(sp,dv)){}
        else
        {
            sp.setSpeedV(0);
            dv = 0;
        }
        if(coordsWFine(sp,dw)){}
        else
        {
            sp.setSpeedW(0);
            dw = 0;
        }
        Punkt3D temp = new Punkt3D(sp.getPunkt3D());
        temp.addX(dv);
        temp.addY(dw);
        double groundlevelNy = plan.getKartaSprite(temp).getHeight((int)(sp.getV()+dv),(int)(sp.getW()+dw));
        if(coordsUFine(sp,du,groundlevelNy))
        {
            renderU(sp);
        }
        else
        {
            if(trappa(sp,sp.getU()+sp.getHeight()/2-groundlevelNy))
            {
                sp.setU(groundlevelNy-sp.getHeight()/2);
                du = 0;
            }
            else
            {
                dv = 0;
                dw = 0;
                sp.setSpeedU(0);
                groundlevelNy = groundlevel;
            }
        }
        sp.setSpeedV(dv);
        sp.setSpeedW(dw);
        sp.setSpeedU(du);
        renderV(sp);
        renderW(sp);
        sp.setGroundlevel(groundlevelNy);
    }
}