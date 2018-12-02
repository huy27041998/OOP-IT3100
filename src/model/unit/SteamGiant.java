package model.unit;

public class SteamGiant extends HeavyInfantry {

    public static final int speed = 40;
    public static final int size = 3;
    private String imageUrl = "/image/SteamGiantBB.png";

    public SteamGiant() {
        hitPoint = 184;
        armour = 3;
        damage = 42;
        name = "Steam Giant";
        accuracyNearHit = 0.8f;
        accuracyLongHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
