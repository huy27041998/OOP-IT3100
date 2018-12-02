package model.unit;

public class Hoplite extends HeavyInfantry {

    public static final int speed = 60;
    public static final int size = 1;
    public String imageUrl = "/image/HopliteBB.png";

    public Hoplite() {
        hitPoint = 56;
        armour = 1;
        damage = 18;
        name = "Hoplite";
        accuracyNearHit = 0.9f;
        accuracyLongHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
