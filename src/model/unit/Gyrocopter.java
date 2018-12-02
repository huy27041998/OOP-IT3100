package model.unit;

public class Gyrocopter extends AirDefence {

    public static final int speed = 80;
    public static final int size = 1;
    
    private String imageUrl = "/image/GyrocopterBB.png";

    public Gyrocopter() {
        hitPoint = 29;
        munition = 4;
        armour = 0;
        damage = 17;
        name = "Gyrocopter";
        accuracyLongHit = 0.8f;
        accuracyNearHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
