public class StatsProt extends Stats
{
    private static int exp;
    private static int level;
    private static int sPoints;
    private static int pPoints;

    public static int getExp()
    {
        return exp;
    }

    public static int getLevel()
    {
        return level;
    }

    public static int getSPoints()
    {
        return sPoints;
    }

    public static int getPPoints()
    {
        return pPoints;
    }

    public static void setSPoints(int value)
    {
        sPoints = value;
    }

    public static void setPPoints(int value)
    {
        pPoints = value;
    }
}