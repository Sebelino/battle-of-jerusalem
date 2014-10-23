class Tillstand
{
    protected boolean[] condition;
    protected int direction;
    protected Vektor2D rikt;

    public Tillstand(int direction,boolean[] condition)
    {
        this.direction = direction;
        this.condition = condition;
        rikt = GameUtil.directionToVektor2D(direction);
    }

    public Tillstand(){}

    public boolean[] getCondition()
    {
        return condition;
    }

    public boolean getCondition(int condis)
    {
        return condition[condis];
    }

    public int getHighestCondition()
    {
        for(int i = 0;true;i++)
        {
            if(condition[i])
            {
                return i;
            }
        }
    }

    public int getDirection()
    {
        return direction;
    }

    public void setCondition(int condis,boolean value)
    {
        condition[condis] = value;
    }

    public void setDirection(int direction)
    {
        this.direction = direction;
        rikt = GameUtil.directionToVektor2D(direction);
    }

    public void setDirection(Vektor2D rikt)
    {
        this.rikt = new Vektor2D(rikt);
    }
}