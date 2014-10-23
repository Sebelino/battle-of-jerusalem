public class StatsFiende
{
    public static final int NEUTRAL = 0;
    public static final int GOOD = 1;

    private int health;
    private int healthMax;
    private int faith;

    public StatsFiende()
    {
        healthMax = 10;
        health = 10;
    }

    public int getHealth()
    {
        return health;
    }

    public int getHealthMax()
    {
        return healthMax;
    }

    public int getFaith()
    {
        return faith;
    }

    public void setHealth(int value)
    {
        health = value;
    }
}