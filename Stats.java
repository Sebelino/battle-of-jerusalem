public class Stats
{
    public static final int NEUTRAL = 0;
    public static final int GOOD = 1;

    protected static int health;
    protected static int healthMax;
    protected static int faith;

    public static int getHealth()
    {
        return health;
    }

    public static void setHealth(int value)
    {
        health = value;
    }

    public static int getHealthMax()
    {
        return healthMax;
    }

    public static int getFaith()
    {
        return faith;
    }
}