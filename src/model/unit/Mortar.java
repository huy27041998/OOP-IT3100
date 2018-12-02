package model.unit;

public class Mortar extends Artillery {

    public static int nearHit = 10;
 
    private String imageUrl = "/image/MortarBB.png";

    public Mortar() {
        hitPoint = 32;
        munition = 3;
        armour = 0;
        damage = 270;
        accuracyNearHit = 0.2f;
        accuracyLongHit = 0.1f;
        name = "Mortar";
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
