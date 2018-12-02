package model.unit;

public class Swordsman  extends LightInfantry{
    
    private String imageUrl = "/image/SwordsmanBB.png";


    public Swordsman() {
        hitPoint = 18;
        damage = 10;
        armour = 0;
        name = "Sword";
        accuracyNearHit = 0.9f;
        accuracyLongHit = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }
        
        
        
	
}
