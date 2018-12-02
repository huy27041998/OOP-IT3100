package model.unit;

public class BatteringRam extends Artillery{
	
    public static final int size = 5;
    public static int nearHit = 12;
    public static int longHit = 80;
 
    private String imageUrl = "/image/RamBB.png";

    public BatteringRam() {
        hitPoint = 88;
        munition = 999;
        accuracyLongHit = 0.1f;
        accuracyNearHit = 0.7f;
    }

}
