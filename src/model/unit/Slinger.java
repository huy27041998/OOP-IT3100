package model.unit;

public class Slinger extends LongRangeFighter {

    public static final int size = 1;
    public static int nearHit = 2;

    private String imageUrl = "/image/SlingerBB.png";

    public Slinger() {
        hitPoint = 8;
        munition = 5;
        damage = 3;
        armour = 0;
        name = "Slinger";
        accuracyNearHit = 0.6f;
        accuracyLongHit = 0.2f;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
