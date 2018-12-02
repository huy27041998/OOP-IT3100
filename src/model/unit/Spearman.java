package model.unit;

public class Spearman extends LightInfantry {

    private String imageUrl = "/image/SpearmanBB.png";

    public Spearman() {
        hitPoint = 13;
        damage = 4;
        armour = 0;
        name = "Spear";
        accuracyNearHit = 0.7f;
        accuracyLongHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
