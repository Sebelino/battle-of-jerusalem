class Tillstand implements TillstandInterface
{
    protected boolean[] condition;
    protected int direction;

    public Tillstand(int direction,boolean[] condition)
    {
        this.direction = direction;
        this.condition = condition;
    }

    public boolean[] getCondition()
    {
        return condition;
    }

    public boolean getCondition(int condis)
    {
        return condition[condis];
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
    }
}