package model.unit;

public class UnitFighter {

    protected double hitPoint;
    protected int damage;
    protected int armour;
    protected float accuracyNearHit;
    protected float accuracyLongHit;
    public String name;
    public String getName() {
    	return this.name;
    }
    public UnitFighter() {
    }

    public double getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(double hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }
    public float getAccuracyNearHit() {
    	return this.accuracyNearHit;
    }
    public float getAccuracyLongHit() {
    	return this.accuracyLongHit;
    }
}
