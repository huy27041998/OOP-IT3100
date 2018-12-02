package model.unit;

public class BalloonBombardier extends AirDefence {

    public static final int speed = 20;
    public static final int size = 2;
    
    private String imageUrl = "/image/Balloon-BombardierBB.png";

    public BalloonBombardier() {
        hitPoint = 40;
        munition = 2;
        damage = 48;
        armour = 0;
        name = "Balloon";
        accuracyLongHit = 0.2f;
        accuracyNearHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
