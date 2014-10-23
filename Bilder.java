import java.awt.image.BufferedImage;
import java.awt.Color;

class Bilder
{
    public static final BufferedImage harm = ImageUtil.makeColorTransparent("Pics/Harm.png",new Color(255,128,128));

    public static final BufferedImage cross0 = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Cross.png",new Color(255,128,128)),4,1)[0];
    public static final BufferedImage cross1 = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Cross.png",new Color(255,128,128)),4,1)[1];
    public static final BufferedImage cross2 = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Cross.png",new Color(255,128,128)),4,1)[2];
    public static final BufferedImage cross3 = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Cross.png",new Color(255,128,128)),4,1)[3];

    public static final BufferedImage area11 = ImageUtil.resize(ImageUtil.makeColorTransparent("Pics/Areor/Area11.png",new Color(255,128,128)),128*6,128*4);

    public static final BufferedImage[] protN = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistN.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protS = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistS.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistW.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protNW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistNW.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protNE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistNE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protSE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistSE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] protSW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Protagonist/ProtagonistSW.png",new Color(255,128,128)),10,2);

    public static final BufferedImage[] naziN = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziN.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziS = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziS.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziW.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziNW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziNW.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziNE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziNE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziSE = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziSE.png",new Color(255,128,128)),10,2);
    public static final BufferedImage[] naziSW = ImageUtil.splitImage(ImageUtil.makeColorTransparent("Pics/Nazi/NaziSW.png",new Color(255,128,128)),10,2);
}