package model.unit;

public class Archer extends LongRangeFighter {

    public static final int size = 1;
    public static int nearHit = 5;    
    public static String imageUrl = "/image/ArcherBB.png";

    public Archer() {
        hitPoint = 16;
        munition = 3;
        damage = 5;
        armour = 0;
        name = "Archer";
        accuracyNearHit = 0.6f;
        accuracyLongHit = 0.4f;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
