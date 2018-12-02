package model.unit;

public class Catapult extends Artillery {

    public static int nearHit = 4;
    private String imageUrl = "/image/CatapultBB.png";

    public Catapult() {
        munition = 5;
        hitPoint = 54;
        armour = 0;
        damage = 133;
        accuracyNearHit = 0.2f;
        accuracyLongHit = 0.1f;
        name = "Catapult";
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
