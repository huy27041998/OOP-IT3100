package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import model.unit.Archer;
import model.unit.BalloonBombardier;
import model.unit.Catapult;
import model.unit.Gyrocopter;
import model.unit.Hoplite;
import model.unit.Mortar;
import model.unit.Ram;
import model.unit.Slinger;
import model.unit.Spearman;
import model.unit.SteamGiant;
import model.unit.SulphurCarabineer;
import model.unit.Swordsman;
import model.unit.UnitFighter;
import model.unit.UnitMunition;
import ui.IsLandUI;

public class BattleField {

    private int levelOfHouse;

    public static enum TypeOfBattleField {
        ATTACK, DEFENCE, EDITTING;
    }

    private int numberOfSlotForHI; //Heavy Infantry
    private int numberOfSlotForLRF;//LongRangeFighter
    private int numberOfSlotForLI; //Light Infantry
    private int numberOfSlotForAr; //Artillery
    private int numberOfSlotForBB; //Balloon
    private int numberOfSlotForGy; //Gyrocopter

    private int spacePerSlotForHI;
    private int spacePerSlotForLRF;
    private int spacePerSlotForLI;
    private int spacePerSlotForAr;
    private int spacePerSlotForBB;
    private int spacePerSlotForGy;

    public String attackFieldImg;
    public String defenceFieldImg;
    public Slot[] artillery, longRangeFighter, front, flank, airDefence, bomber;
    public RealArmy reserve; //Quân dự bị
    private TypeOfBattleField typeOfBattleField;
    public int garision_limit;
    
    public void setAttackFieldImg(String attackFieldImg) {
    	this.attackFieldImg = attackFieldImg;
    }
    
    public void setDefenceFieldImg(String defenceFieldImg) {
    	this.defenceFieldImg = defenceFieldImg;
    }
    
    public int getGarisionLimit() {
    	return this.garision_limit;
    }
    
    public int getTotalNumberOfUnits() {
    	int total_number_of_units = 0;
    	for (Slot slot : this.artillery) 
    		total_number_of_units += slot.getUnit().size();
    	for (Slot slot : this.longRangeFighter) 
    		total_number_of_units += slot.getUnit().size();
    	for (Slot slot : this.front) 
    		total_number_of_units += slot.getUnit().size();
    	for (Slot slot : this.airDefence) 
    		total_number_of_units += slot.getUnit().size();
    	for (Slot slot : this.bomber) 
    		total_number_of_units += slot.getUnit().size();
    	total_number_of_units += reserve.getArcher().size();
        total_number_of_units += reserve.getBB().size();
        total_number_of_units += reserve.getCatapult().size();
        total_number_of_units += reserve.getGyrocopter().size();
        total_number_of_units += reserve.getHop().size();
        total_number_of_units += reserve.getMortar().size();
        total_number_of_units += reserve.getRam().size();
        total_number_of_units += reserve.getSC().size();
        total_number_of_units += reserve.getSlinger().size();
        total_number_of_units += reserve.getSpear().size();
        total_number_of_units += reserve.getSteam().size();
        total_number_of_units += reserve.getSword().size();
    	return total_number_of_units;
    }
    
    public int getNumberOfSlotForLRF() {
        return numberOfSlotForLRF;
    }

    public int getNumberOfSlotForAr() {
        return numberOfSlotForAr;
    }

    public int getNumberOfSlotForBB() {
        return numberOfSlotForBB;
    }

    public int getSpacePerSlotForHI() {
        return spacePerSlotForHI;
    }

    public int getSpacePerSlotForLRF() {
        return spacePerSlotForLRF;
    }

    public int getSpacePerSlotForLI() {
        return spacePerSlotForLI;
    }

    public int getSpacePerSlotForAr() {
        return spacePerSlotForAr;
    }

    public int getSpacePerSlotForBB() {
        return spacePerSlotForBB;
    }

    public int getSpacePerSlotForGy() {
        return spacePerSlotForGy;
    }

    public int getNumberOfSlotForGy() {
        return numberOfSlotForGy;
    }

    public void setNumberOfSlotForGy(int numberOfSlotForGy) {
        this.numberOfSlotForGy = numberOfSlotForGy;
    }

    public int getNumberOfSlotForHI() {
        return numberOfSlotForHI;
    }

    public void setNumberOfSlotForHI(int numberOfSlotForHI) {
        this.numberOfSlotForHI = numberOfSlotForHI;
    }

    public void setNumberOfSlotForLRF(int numberOfSlotForLRF) {
        this.numberOfSlotForLRF = numberOfSlotForLRF;
    }

    public int getNumberOfSlotForLI() {
        return numberOfSlotForLI;
    }

    public void setNumberOfSlotForLI(int numberOfSlotForLI) {
        this.numberOfSlotForLI = numberOfSlotForLI;
    }

    public void setNumberOfSlotForAr(int numberOfSlotForAr) {
        this.numberOfSlotForAr = numberOfSlotForAr;
    }

    public void setNumberOfSlotForBB(int numberOfSlotForBB) {
        this.numberOfSlotForBB = numberOfSlotForBB;
    }

    public void setBattleField(House house) {

    }

    public int getLevelOfHouse() {
        return levelOfHouse;
    }

    public void setLevelOfHouse(int levelOfHouse) {
        this.levelOfHouse = levelOfHouse;
    }

    public TypeOfBattleField getTypeOfBattleField() {
        return typeOfBattleField;
    }

    public void setTypeOfBattleField(TypeOfBattleField typeOfBattleField) {
        this.typeOfBattleField = typeOfBattleField;
    }

    public BattleField(int level, TypeOfBattleField typeOfBattleField) {
        levelOfHouse = level;
        reserve = new RealArmy();
        this.typeOfBattleField = typeOfBattleField;
        this.garision_limit += level * 50;
        if (level >= 1 && level <= 4) {
            this.numberOfSlotForHI = 3;
            this.numberOfSlotForLI = 0;
            this.numberOfSlotForAr = 1;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 3;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 10;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 10;

            this.attackFieldImg = "/image/battleField/attackField1-4.png";
            this.defenceFieldImg = "/image/battleField/defenceField1-4.png";
        }
        if (level >= 5 && level <= 9) {
            this.numberOfSlotForHI = 5;
            this.numberOfSlotForLI = 2;
            this.numberOfSlotForAr = 2;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 5;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 20;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 20;

            this.attackFieldImg = "/image/battleField/attackField5-9.png";
            this.defenceFieldImg = "/image/battleField/defenceField5-9.png";
        }
        if (level >= 10 && level <= 16) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 4;
            this.numberOfSlotForAr = 3;
            this.numberOfSlotForBB = 1;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 1;

            this.spacePerSlotForHI = 30;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 30;
            this.spacePerSlotForLRF = 30;
            this.spacePerSlotForGy = 30;

            this.attackFieldImg = "/image/battleField/attackField10-16.png";
            this.defenceFieldImg = "/image/battleField/defenceField10-16.png";
        }
        if (level >= 17 && level <= 24) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 6;
            this.numberOfSlotForAr = 4;
            this.numberOfSlotForBB = 2;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 2;

            this.spacePerSlotForHI = 40;
            this.spacePerSlotForLI = 30;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 20;
            this.spacePerSlotForLRF = 40;
            this.spacePerSlotForGy = 20;

            this.attackFieldImg = "/image/battleField/attackField17-24.png";
            this.defenceFieldImg = "/image/battleField/defenceField17-24.png";
        }
        if (level >= 25) {
            this.numberOfSlotForHI = 7;
            this.numberOfSlotForLI = 6;
            this.numberOfSlotForAr = 5;
            this.numberOfSlotForBB = 2;
            this.numberOfSlotForLRF = 7;
            this.numberOfSlotForGy = 2;

            this.spacePerSlotForHI = 50;
            this.spacePerSlotForLI = 40;
            this.spacePerSlotForAr = 30;
            this.spacePerSlotForBB = 30;
            this.spacePerSlotForLRF = 50;
            this.spacePerSlotForGy = 30;

            this.attackFieldImg = "/image/battleField/attackField25.png";
            this.defenceFieldImg = "/image/battleField/defenceField25.png";
        }

        resetAll(level);
    }

    public void resetAll(int level) { //Khởi động lại battle field về rỗng
        artillery = new Slot[this.numberOfSlotForAr];
        for (int i = 0; i < this.numberOfSlotForAr; i++) {
            artillery[i] = new Slot();
            artillery[i].setSize(this.spacePerSlotForAr);
        }

        longRangeFighter = new Slot[this.numberOfSlotForLRF];
        for (int i = 0; i < this.numberOfSlotForLRF; i++) {
            longRangeFighter[i] = new Slot();
            longRangeFighter[i].setSize(this.spacePerSlotForLRF);
        }

        front = new Slot[this.numberOfSlotForHI];
        for (int i = 0; i < this.numberOfSlotForHI; i++) {
            front[i] = new Slot();
            front[i].setSize(this.spacePerSlotForHI);
        }

        flank = new Slot[this.numberOfSlotForLI];
        flank = new Slot[this.numberOfSlotForLI];
        for (int i = 0; i < this.numberOfSlotForLI; i++) {
            flank[i] = new Slot();
            flank[i].setSize(this.numberOfSlotForLI);
        }

        airDefence = new Slot[this.numberOfSlotForGy];
        for (int i = 0; i < this.numberOfSlotForGy; i++) {
            airDefence[i] = new Slot();
            airDefence[i].setSize(this.numberOfSlotForGy);
        }

        bomber = new Slot[this.numberOfSlotForBB];
        for (int i = 0; i < this.numberOfSlotForBB; i++) {
            bomber[i] = new Slot();
            bomber[i].setSize(this.numberOfSlotForBB);
        }
    }

    public String getAttackFieldImg() {
        return attackFieldImg;
    }

    public String getDefenceFieldImg() {
        return defenceFieldImg;
    }

    public void setArtilleryClass() {
        int index = countByType(artillery, Army.Unit.Mortar);
        int slotForMortar = (int) Math.ceil((reserve.getMortar().size() * Mortar.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForMortar; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForMortar) {
                    List<Mortar> units = reserve.getMortar().subList(reserve.getMortar().size() - 1 -this.spacePerSlotForAr / Mortar.size, reserve.getMortar().size() - 1);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Mortar);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Mortar> units = reserve.getMortar();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Mortar);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    reserve.getMortar().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(artillery, Army.Unit.Catapult);
        int slotForCatapult = (int) Math.ceil((reserve.getCatapult().size() * Catapult.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForCatapult; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForCatapult) {
                    List<Catapult> units = reserve.getCatapult().subList(reserve.getCatapult().size() - 1 -this.spacePerSlotForAr / Catapult.size, reserve.getCatapult().size() - 1);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Catapult);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Catapult> units = reserve.getCatapult();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Catapult);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    reserve.getCatapult().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(artillery, Army.Unit.Ram);
        int slotForRam = (int) Math.ceil((reserve.getRam().size() * Ram.size) / (float) this.spacePerSlotForAr);
        for (int i = 1; i <= slotForRam; i++) {
            if (index < this.numberOfSlotForAr) {
                if (i < slotForRam) {
                    List<Ram> units = reserve.getRam().subList(reserve.getRam().size() - 1 -this.spacePerSlotForGy / Ram.size, reserve.getRam().size() - 1);
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Ram);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Ram> units = reserve.getRam();
                    artillery[index].getUnit().addAll(units);
                    artillery[index].setImageUrl(units.get(0).getImageUrl());
                    artillery[index].setUnitType(Army.Unit.Ram);
                    artillery[index].setInitNumUnit(artillery[index].getUnit().size());
                    artillery[index].setInitHitpointUnit((int)artillery[index].getUnit().get(0).getHitPoint());
                    artillery[index].setInitMunition(((model.unit.UnitMunition)artillery[index].getUnit().get(0)).getMunition());
                    reserve.getRam().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setAirDefence() {
        int index = countByType(airDefence, Army.Unit.Gyrocopter);
        int slotForGyr = (int) Math.ceil((reserve.getGyrocopter().size() * Gyrocopter.size) / (float) this.spacePerSlotForGy);
        for (int i = 1; i <= slotForGyr; i++) {
            if (index < this.numberOfSlotForGy) {
                if (i < slotForGyr) {
                    List<Gyrocopter> units = reserve.getGyrocopter().subList(reserve.getGyrocopter().size() - 1 -this.spacePerSlotForGy / Gyrocopter.size, reserve.getGyrocopter().size() - 1);
                    airDefence[index].getUnit().addAll(units);
                    airDefence[index].setImageUrl(units.get(0).getImageUrl());
                    airDefence[index].setUnitType(Army.Unit.Gyrocopter);
                    airDefence[index].setInitNumUnit(airDefence[index].getUnit().size());
                    airDefence[index].setInitHitpointUnit((int)airDefence[index].getUnit().get(0).getHitPoint());
                    airDefence[index].setInitMunition(((model.unit.UnitMunition)airDefence[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Gyrocopter> units = reserve.getGyrocopter();
                    airDefence[index].getUnit().addAll(units);
                    airDefence[index].setImageUrl(units.get(0).getImageUrl());
                    airDefence[index].setUnitType(Army.Unit.Gyrocopter);
                    airDefence[index].setInitNumUnit(airDefence[index].getUnit().size());
                    airDefence[index].setInitHitpointUnit((int)airDefence[index].getUnit().get(0).getHitPoint());
                    airDefence[index].setInitMunition(((model.unit.UnitMunition)airDefence[index].getUnit().get(0)).getMunition());
                    reserve.getGyrocopter().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setBB() {
        int index = countByType(bomber, Army.Unit.Balloon);
        int slotForBB = (int) Math.ceil((reserve.getBB().size() * BalloonBombardier.size) / (float) this.spacePerSlotForBB);
        for (int i = 1; i <= slotForBB; i++) {
            if (index < this.numberOfSlotForBB) {
                if (i < slotForBB) {
                    List<BalloonBombardier> units = reserve.getBB().subList(reserve.getBB().size() - 1 -this.spacePerSlotForBB / BalloonBombardier.size, reserve.getBB().size() - 1);
                    bomber[index].getUnit().addAll(units);
                    bomber[index].setImageUrl(units.get(0).getImageUrl());
                    bomber[index].setUnitType(Army.Unit.Balloon);
                    bomber[index].setInitNumUnit(bomber[index].getUnit().size());
                    bomber[index].setInitHitpointUnit((int)bomber[index].getUnit().get(0).getHitPoint());
                    bomber[index].setInitMunition(((model.unit.UnitMunition)bomber[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<BalloonBombardier> units = reserve.getBB();
                    bomber[index].getUnit().addAll(units);
                    bomber[index].setImageUrl(units.get(0).getImageUrl());
                    bomber[index].setUnitType(Army.Unit.Balloon);
                    bomber[index].setInitNumUnit(bomber[index].getUnit().size());
                    bomber[index].setInitHitpointUnit((int)bomber[index].getUnit().get(0).getHitPoint());
                    bomber[index].setInitMunition(((model.unit.UnitMunition)bomber[index].getUnit().get(0)).getMunition());
                    reserve.getBB().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setFlankToSlot(boolean isAllWall, int x) {
    	if(isAllWall) return;
    	int index = countByType(front, Army.Unit.Swordsman); //Tìm slot bắt đầu có thẻ điền
    	index += x;
        int slotForSword = (int) Math.ceil((reserve.getSword().size() * Swordsman.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForSword; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForSword) {
                    List<Swordsman> units = reserve.getSword().subList(reserve.getSword().size() - 1 -this.spacePerSlotForHI / Swordsman.size, reserve.getSword().size() - 1);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Swordsman);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Swordsman> units = reserve.getSword();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Swordsman);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    reserve.getSword().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(front, Army.Unit.Spearman);
        int slotForSpear = (int) Math.ceil((reserve.getSpear().size() * Spearman.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForSpear; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForSpear) {
                    List<Spearman> units = reserve.getSpear().subList(reserve.getSpear().size() - 1 -this.spacePerSlotForHI / Spearman.size, reserve.getSpear().size() - 1);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Spearman);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Spearman> units = reserve.getSpear();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Spearman);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    reserve.getSpear().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index = countByType(flank, Army.Unit.Swordsman);
        slotForSword = (int) Math.ceil((reserve.getSword().size() * Swordsman.size) / (float) this.spacePerSlotForLI);
        for (int i = 1; i <= slotForSword; i++) {
            if (index < this.numberOfSlotForLI) {
                if (i < slotForSword) {
                    List<Swordsman> units = reserve.getSword().subList(reserve.getSword().size() - 1 -this.spacePerSlotForLI / Swordsman.size, reserve.getSword().size() - 1);
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Swordsman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit((int)flank[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Swordsman> units = reserve.getSword();
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Swordsman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit((int)flank[index].getUnit().get(0).getHitPoint());
                    reserve.getSword().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(flank, Army.Unit.Spearman);
        slotForSpear = (int) Math.ceil((reserve.getSpear().size() * Spearman.size) / (float) this.spacePerSlotForLI);
        for (int i = 1; i <= slotForSpear; i++) {
            if (index < this.numberOfSlotForLI) {
                if (i < slotForSpear) {
                    List<Spearman> units = reserve.getSpear().subList(reserve.getSpear().size() - 1 -this.spacePerSlotForLI / Spearman.size, reserve.getSpear().size() - 1);
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Spearman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit((int)flank[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Spearman> units = reserve.getSpear();
                    flank[index].getUnit().addAll(units);
                    flank[index].setImageUrl(units.get(0).getImageUrl());
                    flank[index].setUnitType(Army.Unit.Spearman);
                    flank[index].setInitNumUnit(flank[index].getUnit().size());
                    flank[index].setInitHitpointUnit((int)flank[index].getUnit().get(0).getHitPoint());
                    reserve.getSpear().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public void setLongRange() {
        int index = countByType(longRangeFighter, Army.Unit.Sulfur);
        int slotForSC = (int) Math.ceil((reserve.getSC().size() * SulphurCarabineer.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForSC; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForSC) {
                    List<SulphurCarabineer> units = reserve.getSC().subList(reserve.getSC().size() - 1 -this.spacePerSlotForLRF / SulphurCarabineer.size, reserve.getSC().size() - 1);
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Sulfur);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<SulphurCarabineer> units = reserve.getSC();
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Sulfur);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    reserve.getSC().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(longRangeFighter, Army.Unit.Archer);
        int slotForArcher = (int) Math.ceil((reserve.getArcher().size() * Archer.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForArcher; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForArcher) {
                    List<Archer> units = reserve.getArcher().subList(reserve.getArcher().size() - 1 -this.spacePerSlotForLRF / Archer.size, reserve.getArcher().size() - 1);//Khởi tạo 1 mảng slot chứa quân
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(Archer.imageUrl);
                    longRangeFighter[index].setUnitType(Army.Unit.Archer);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Archer> units = reserve.getArcher();
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(Archer.imageUrl);
                    longRangeFighter[index].setUnitType(Army.Unit.Archer);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    reserve.getArcher().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(longRangeFighter, Army.Unit.Slinger);
        int slotForSlinger = (int) Math.ceil((reserve.getSlinger().size() * Slinger.size) / (float) this.spacePerSlotForLRF);
        for (int i = 1; i <= slotForSlinger; i++) {
            if (index < this.numberOfSlotForLRF) {
                if (i < slotForSlinger) {
                    List<Slinger> units = reserve.getSlinger().subList(reserve.getSlinger().size() - 1 -this.spacePerSlotForLRF / Slinger.size, reserve.getSlinger().size() - 1);
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Slinger);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    units.clear();
                } else {
                    List<Slinger> units = reserve.getSlinger();
                    longRangeFighter[index].getUnit().addAll(units);
                    longRangeFighter[index].setImageUrl(units.get(0).getImageUrl());
                    longRangeFighter[index].setUnitType(Army.Unit.Slinger);
                    longRangeFighter[index].setInitNumUnit(longRangeFighter[index].getUnit().size());
                    longRangeFighter[index].setInitHitpointUnit((int)longRangeFighter[index].getUnit().get(0).getHitPoint());
                    longRangeFighter[index].setInitMunition(((model.unit.UnitMunition)longRangeFighter[index].getUnit().get(0)).getMunition());
                    reserve.getSlinger().clear();
                }
                index++;
            } else {
                break;
            }
        }
    }

    public int setFrontLine() {
        int numberOfWall = 0;
        Stack<Wall> walls = reserve.getWall();
        numberOfWall = walls.size();
        for (int i = 0; i < numberOfWall; i++) {
            Wall wall = walls.pop();
            front[i].getUnit().add(wall);
            front[i].setImageUrl(wall.getImageUrl());
            front[i].setUnitType(Army.Unit.Wall);
            front[i].setInitNumUnit(1);
            front[i].setInitHitpointUnit((int)wall.getHitPoint());
        }

        int index = countByType(front, Army.Unit.Hoplite) + numberOfWall;
        int slotForHop = (int) Math.ceil((reserve.getHop().size() * Hoplite.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForHop; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForHop) {
                    List<Hoplite> units = reserve.getHop().subList(reserve.getHop().size() - 1 -this.spacePerSlotForHI / Hoplite.size, reserve.getHop().size() - 1);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Hoplite);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<Hoplite> units = reserve.getHop();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.Hoplite);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    reserve.getHop().clear();
                }
                index++;
            } else {
                break;
            }
        }
        index += countByType(front, Army.Unit.SteamGiant);
        int slotForSteam = (int) Math.ceil((reserve.getSteam().size() * SteamGiant.size) / (float) this.spacePerSlotForHI);
        for (int i = 1; i <= slotForSteam; i++) {
            if (index < this.numberOfSlotForHI) {
                if (i < slotForSteam) {
                    List<SteamGiant> units = reserve.getSteam().subList(reserve.getSteam().size() - 1 -this.spacePerSlotForHI / SteamGiant.size, reserve.getSteam().size() - 1);
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.SteamGiant);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    units.clear();
                } else {
                    List<SteamGiant> units = reserve.getSteam();
                    front[index].getUnit().addAll(units);
                    front[index].setImageUrl(units.get(0).getImageUrl());
                    front[index].setUnitType(Army.Unit.SteamGiant);
                    front[index].setInitNumUnit(front[index].getUnit().size());
                    front[index].setInitHitpointUnit((int)front[index].getUnit().get(0).getHitPoint());
                    reserve.getSteam().clear();
                }
                index++;
            } else {
                break;
            }
        }
        return index; //Lưu lại chỉ số để set Flank vào hàng front
    }

    public void addToReserve(RealArmy reserve, Army sentArmy, int houseID) {
        RealArmy realArmy = new RealArmy();
        for (int i = 0; i < sentArmy.getNumberOfArcher(); i++) {
            Archer archer = new Archer();
            archer.setArmour(archer.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Archer.ordinal()]);
            archer.setDamage(archer.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Archer.ordinal()]);
            reserve.getArcher().add(archer);
            realArmy.getArcher().add(archer);
        }
        for (int i = 0; i < sentArmy.getNumberOfBB(); i++) {
            BalloonBombardier ballon = new BalloonBombardier();
            ballon.setArmour(ballon.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Balloon.ordinal()]);
            ballon.setDamage(ballon.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Balloon.ordinal()]);
            reserve.getBB().add(ballon);
            realArmy.getBB().add(ballon);
        }
        for (int i = 0; i < sentArmy.getNumberOfCatapult(); i++) {
            Catapult catapult = new Catapult();
            catapult.setArmour(catapult.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Catapult.ordinal()]);
            catapult.setDamage(catapult.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Catapult.ordinal()]);
            reserve.getCatapult().add(catapult);
            realArmy.getCatapult().add(catapult);
        }
        for (int i = 0; i < sentArmy.getNumberOfGyrocopter(); i++) {
            Gyrocopter gy = new Gyrocopter();
            gy.setArmour(gy.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Gyrocopter.ordinal()]);
            gy.setDamage(gy.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Gyrocopter.ordinal()]);
            reserve.getGyrocopter().add(gy);
            realArmy.getGyrocopter().add(gy);
        }
        for (int i = 0; i < sentArmy.getNumberOfHop(); i++) {
            Hoplite hop = new Hoplite();
            hop.setArmour(hop.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Hoplite.ordinal()]);
            hop.setDamage(hop.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Hoplite.ordinal()]);
            reserve.getHop().add(hop);
            realArmy.getHop().add(hop);
        }
        for (int i = 0; i < sentArmy.getNumberOfMotar(); i++) {
            Mortar mortar = new Mortar();
            mortar.setArmour(mortar.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Mortar.ordinal()]);
            mortar.setDamage(mortar.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Mortar.ordinal()]);
            reserve.getMortar().add(mortar);
            realArmy.getMortar().add(mortar);
        }
        for (int i = 0; i < sentArmy.getNumberOfRam(); i++) {
            Ram ram = new Ram();
            ram.setArmour(ram.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Ram.ordinal()]);
            ram.setDamage(ram.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Ram.ordinal()]);
            reserve.getRam().add(ram);
            realArmy.getRam().add(ram);
        }
        for (int i = 0; i < sentArmy.getNumberOfSC(); i++) {
            SulphurCarabineer sc = new SulphurCarabineer();
            sc.setArmour(sc.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Sulfur.ordinal()]);
            sc.setDamage(sc.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Sulfur.ordinal()]);
            reserve.getSC().add(sc);
            realArmy.getSC().add(sc);
        }
        for (int i = 0; i < sentArmy.getNumberOfSlinger(); i++) {
            Slinger slinger = new Slinger();
            slinger.setArmour(slinger.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Slinger.ordinal()]);
            slinger.setDamage(slinger.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Slinger.ordinal()]);
            reserve.getSlinger().add(slinger);
            realArmy.getSlinger().add(slinger);
        }
        for (int i = 0; i < sentArmy.getNumberOfSpear(); i++) {
            Spearman spear = new Spearman();
            spear.setArmour(spear.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Spearman.ordinal()]);
            spear.setDamage(spear.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Spearman.ordinal()]);
            reserve.getSpear().add(spear);
            realArmy.getSpear().add(spear);
        }
        for (int i = 0; i < sentArmy.getNumberOfSteam(); i++) {
            SteamGiant steam = new SteamGiant();
            steam.setArmour(steam.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.SteamGiant.ordinal()]);
            steam.setDamage(steam.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.SteamGiant.ordinal()]);
            reserve.getSteam().add(steam);
            realArmy.getSteam().add(steam);
        }
        for (int i = 0; i < sentArmy.getNumberOfSword(); i++) {
            Swordsman sword = new Swordsman();
            sword.setArmour(sword.getArmour() + sentArmy.getArmourUpgrade()[Army.Unit.Swordsman.ordinal()]);
            sword.setDamage(sword.getDamage() + sentArmy.getDamageUpgrade()[Army.Unit.Swordsman.ordinal()]);
            reserve.getSword().add(sword);
            realArmy.getSword().add(sword);
        }
        if (IsLandUI.myHouse.getSentRealArmy().get(houseID) == null) {
            IsLandUI.myHouse.getSentRealArmy().put(houseID, new ArrayList<>());
        }

        if (BattleField.TypeOfBattleField.ATTACK == this.typeOfBattleField) {
            IsLandUI.myHouse.getSentRealArmy().get(houseID).add(new SentArmy(realArmy,System.currentTimeMillis()));
        }
    }

    public void setUnitsBackToReserve() {
        for (Slot slot : artillery) {
            if (slot.getUnitType() == Army.Unit.Mortar) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getMortar().push((Mortar) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Ram) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getRam().push((Ram) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Catapult) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getCatapult().push((Catapult) unit);
                    }
                }
            }
        }
        for (Slot slot : front) {
            if (slot.getUnitType() == Army.Unit.Wall) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getWall().push((Wall) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.Hoplite) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getHop().push((Hoplite) unit);
                    }
                }
            } else if (slot.getUnitType() == Army.Unit.SteamGiant) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSteam().push((SteamGiant) unit);
                    }
                }
            }
            else if (slot.getUnitType() == Army.Unit.Swordsman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSword().push((Swordsman) unit);
                    }
                }

            }
            else if (slot.getUnitType() == Army.Unit.Spearman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSpear().push((Spearman) unit);
                    }
                }

            }

        }
        for (Slot slot : airDefence) {
            if (slot.getUnitType() == Army.Unit.Gyrocopter) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getGyrocopter().push((Gyrocopter) unit);
                    }
                }
            }
        }
        for (Slot slot : bomber) {
            if (slot.getUnitType() == Army.Unit.Balloon) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getBB().push((BalloonBombardier) unit);
                    }
                }
            }
        }
        for (Slot slot : longRangeFighter) {
            if (slot.getUnitType() == Army.Unit.Sulfur) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSC().push((SulphurCarabineer) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Archer) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getArcher().push((Archer) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Slinger) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSlinger().push((Slinger) unit);
                    }
                }

            }

        }
        for (Slot slot : flank) {
            if (slot.getUnitType() == Army.Unit.Swordsman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSword().push((Swordsman) unit);
                    }
                }

            }
            if (slot.getUnitType() == Army.Unit.Spearman) {
                for (UnitFighter unit : slot.getUnit()) {
                    if (unit.getHitPoint() != 0) {
                        reserve.getSpear().push((Spearman) unit);
                    }
                }

            }

        }
        resetAll(levelOfHouse);
    }

    public Slot[] getMyClassUnit(Army.ClassUnit classUnit) {
        switch (classUnit) {
            case Front:
                return getFront();
            case LRF:
                return getlongRangeFighter();
            case Artillery:
                return getArtillery();
            case Bomber:
                return getBomber();
            case Airdefence:
                return getAirDefence();
            case Flank:
                return getFlank();

            default:
                return null;
        }
    }

    public void resetUnitSlot(BattleField battleFields, Slot[] slots, Army.Unit unitType) {
        for (Slot slot : slots) {
            if (slot.getUnitType() == null) {
                continue;
            }
            else if (slot.getUnitType().ordinal() != unitType.ordinal()) {
                for (int i = 0; i < slot.getUnit().size(); i++) {
                    battleFields.reserve.push(slot.getUnitType());
                }
                slot.setImageUrl("");
                slot.setSize(0);
                slot.setTotalHitpoint(0);
                slot.setUnit(new ArrayList<>());
                slot.setTotalMunition(0);
                slot.setUnitType(null);
                slot.setInitHitpointUnit(0);
            }
            else  {
                slot.setImageUrl("");
                slot.setSize(0);
                slot.setTotalHitpoint(0);
                slot.setUnit(new ArrayList<>());
                slot.setTotalMunition(0);
                slot.setUnitType(null);
                slot.setInitHitpointUnit(0);
            }
        }

    }

    public int countByType(Slot[] slots, Army.Unit unitType) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.getUnitType() == null) {
                continue;
            }
            if (slot.getUnitType().ordinal() == unitType.ordinal()) {
                count++;
            }
        }
        return count;
    }
    
	public void artilleryAttack(BattleField enemy, Slot[] a, Slot[] b) {
		int dam, AM, i = 0, j = 0, munition = 0;  //i: Chỉ số quân tấn công, j: Chỉ số quân bị tấn công
		double HP;
		float accuracyLongHit, accuracyNearHit;
    	for (Slot slot : a) {
        	i = 0;
        	ArrayList<UnitMunition> myA = new ArrayList<>();
            for (UnitFighter unit : slot.getUnit()) {
                myA.add((UnitMunition)unit); //thêm quân vào mảng a.
            }
        	for (Slot slot1 : b ) {
        		ArrayList<UnitFighter> target = new ArrayList<>();
        		for (UnitFighter unit : slot1.getUnit())
        			target.add(unit); //UnitFighterhêm quân vào mảng Front
	        	while (i < myA.size() && !isAllDeadInArrayList(target)) {
	            	j = 0;
	            	while (target.get(j).getHitPoint() == 0)
	                    j++; //Tìm quân có máu # 0
            		dam = (target.get(j) instanceof Wall) ? myA.get(i).getDamage() : 80;
	                HP = target.get(j).getHitPoint();
	                AM = target.get(j).getArmour();
                	munition = myA.get(i).getMunition();
	                if (munition > 0 && myA.get(i).getHitPoint() > 0) {
		            	accuracyLongHit = myA.get(i).getAccuracyLongHit();
		                target.get(j).setHitPoint((AM > dam * accuracyLongHit) ? HP : (HP + AM > (dam * accuracyLongHit) ? (HP + AM - dam * accuracyLongHit) : 0));//Quân trúng nhận (dam * accuracyLongHit) damamge
		                target.get(j).setArmour((int) ((AM > dam * accuracyLongHit) ? AM - dam * accuracyLongHit : 0));
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j) {
			                	target.get(j1).setHitPoint((AM > dam * accuracyLongHit * 0.005) ? HP :(HP + AM > (dam * accuracyLongHit * 0.005) ? (HP + AM - dam * accuracyLongHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyLongHit
			                	target.get(j1).setArmour((int) ((AM > dam * accuracyLongHit * 0.005) ? AM - dam * accuracyLongHit * 0.005 : 0));
		                	}
		                }
		                myA.get(i).setMunition(munition - 1);
	                }
	                else {
		            	accuracyNearHit = myA.get(i).getAccuracyNearHit();
		            	target.get(j).setArmour((int) ((AM > dam * accuracyNearHit * 0.005) ? AM - dam * accuracyNearHit : 0));
		            	target.get(j).setHitPoint((AM > dam * accuracyNearHit) ? HP : (HP + AM > (dam * accuracyNearHit) ? (HP + AM - dam * accuracyNearHit) : 0));//Quân trúng nhận (dam * accuracyNearHit) damamge 
	                }
	                i++; // Chuyển đến quân tấn công tiếp theo
	        	}
        	}
        }
    }
	
	public void longRangeAttack(BattleField enemy, Slot[] a, Slot[] b) {
		int dam, AM, i = 0, j = 0, munition = 0;  //i: Chỉ số quân tấn công, j: Chỉ số quân bị tấn công
		double HP;
		float accuracyLongHit, accuracyNearHit;
    	for (Slot slot : a) {
        	i = 0;
        	ArrayList<UnitMunition> myA = new ArrayList<>();
            for (UnitFighter unit : slot.getUnit()) {
                myA.add((UnitMunition)unit); //thêm quân vào mảng a.
            }
        	for (Slot slot1 : b ) {
        		ArrayList<UnitFighter> target = new ArrayList<>();
        		for (UnitFighter unit : slot1.getUnit())
        			target.add(unit); //UnitFighterhêm quân vào mảng Front
	        	while (i < myA.size() && !isAllDeadInArrayList(target)) {
	            	j = 0;
	            	while (target.get(j).getHitPoint() == 0)
	                    j++; //Tìm quân có máu # 0
	            	if (target.get(j) instanceof Wall)
	            		return;
            		dam = myA.get(i).getDamage();
	                HP = target.get(j).getHitPoint();
	                AM = target.get(j).getArmour();
                	munition = myA.get(i).getMunition();
	                if (munition > 0 && myA.get(i).getHitPoint() > 0) {
		            	accuracyLongHit = myA.get(i).getAccuracyLongHit();
		                target.get(j).setHitPoint((AM > dam * accuracyLongHit) ? HP : (HP + AM > (dam * accuracyLongHit) ? (HP + AM - dam * accuracyLongHit) : 0));//Quân trúng nhận (dam * accuracyLongHit) damamge
		                target.get(j).setArmour((int) ((AM > dam * accuracyLongHit) ? AM - dam * accuracyLongHit : 0));
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j) {
			                	target.get(j1).setHitPoint((AM > dam * accuracyLongHit * 0.005) ? HP :(HP + AM > (dam * accuracyLongHit * 0.005) ? (HP + AM - dam * accuracyLongHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyLongHit
			                	target.get(j1).setArmour((int) ((AM > dam * accuracyLongHit * 0.005) ? AM - dam * accuracyLongHit * 0.005 : 0));
		                	}
		                }
		                myA.get(i).setMunition(munition - 1);
	                }
	                else {
		            	accuracyNearHit = myA.get(i).getAccuracyNearHit();
		            	target.get(j).setHitPoint((AM > dam * accuracyNearHit) ? HP : (HP + AM > (dam * accuracyNearHit) ? (HP + AM - dam * accuracyNearHit) : 0));//Quân trúng nhận (dam * accuracyNearHit) damamge
		            	target.get(j).setArmour((int) ((AM > dam * accuracyNearHit) ? AM - dam * accuracyNearHit : 0));
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j) {
		                		target.get(j1).setHitPoint((AM > dam * accuracyNearHit * 0.005) ? HP :(HP + AM > (dam * accuracyNearHit * 0.005) ? (HP + AM - dam * accuracyNearHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyNearHit
		                		target.get(j1).setArmour((int) ((AM > dam * accuracyNearHit * 0.005) ? AM - dam * accuracyNearHit * 0.005 : 0));
		                	}
		                }
	                }
	                i++; // Chuyển đến quân tấn công tiếp theo
	        	}
        	}
        }
    }
    
	public void front_or_flank_attack(BattleField enemy, Slot[] a, Slot[] b) {
		int dam, AM, i = 0, j = 0;  //i: Chỉ số quân tấn công, j: Chỉ số quân bị tấn công
		double HP;
		float accuracyNearHit;
    	for (Slot slot : a) {
        	i = 0;
        	ArrayList<UnitFighter> myA = new ArrayList<>();
            for (UnitFighter unit : slot.getUnit()) {
                myA.add(unit); //thêm quân vào mảng a.
            }
        	for (Slot slot1 : b ) {
        		ArrayList<UnitFighter> target = new ArrayList<>();
        		for (UnitFighter unit : slot1.getUnit())
        			target.add(unit); //UnitFighterhêm quân vào mảng Front
	        	while (i < myA.size() && !isAllDeadInArrayList(target)) {
	            	j = 0;
	            	while (target.get(j).getHitPoint() == 0)
	                    j++; //Tìm quân có máu # 0
	            	if (target.get(j) instanceof Wall)
	            		return;
            		dam = myA.get(i).getDamage();
	                HP = target.get(j).getHitPoint();
	                AM = target.get(j).getArmour();
	                if (myA.get(i).getHitPoint() > 0) {
		            	accuracyNearHit = myA.get(i).getAccuracyNearHit();
		            	target.get(j).setHitPoint((AM > dam * accuracyNearHit) ? HP : (HP + AM > (dam * accuracyNearHit) ? (HP + AM - dam * accuracyNearHit) : 0));//Quân trúng nhận (dam * accuracyNearHit) damamge
		            	target.get(j).setArmour((int) ((AM > dam * accuracyNearHit) ? AM - dam * accuracyNearHit : 0));
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j) {
		                		target.get(j1).setHitPoint((AM > dam * accuracyNearHit * 0.005) ? HP :(HP + AM > (dam * accuracyNearHit * 0.005) ? (HP + AM - dam * accuracyNearHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyNearHit
		                		target.get(j1).setArmour((int) ((AM > dam * accuracyNearHit * 0.005) ? AM - dam * accuracyNearHit * 0.005 : 0));
		                	}
		                }
	                }
	                i++; // Chuyển đến quân tấn công tiếp theo
	        	}
        	}
        }
    }
    
	public void bomberAttack(BattleField enemy, Slot[] a, Slot[] b) {
		int dam, AM, i = 0, j = 0, munition = 0;  //i: Chỉ số quân tấn công, j: Chỉ số quân bị tấn công
		double HP;
		float accuracyLongHit;
    	for (Slot slot : a) {
        	i = 0;
        	ArrayList<UnitMunition> myA = new ArrayList<>();
            for (UnitFighter unit : slot.getUnit()) {
                myA.add((UnitMunition)unit); //thêm quân vào mảng a.
            }
        	for (Slot slot1 : b ) {
        		ArrayList<UnitFighter> target = new ArrayList<>();
        		for (UnitFighter unit : slot1.getUnit())
        			target.add(unit);
	        	while (i < myA.size() && !isAllDeadInArrayList(target)) {
	            	j = 0;
	            	while (target.get(j).getHitPoint() == 0)
	                    j++; //Tìm quân có máu # 0
	            	if (target.get(j) instanceof Wall)
	            		return;
            		dam = myA.get(i).getDamage();
	                HP = target.get(j).getHitPoint();
	                AM = target.get(j).getArmour();
                	munition = myA.get(i).getMunition();
	                if (munition > 0 && myA.get(i).getHitPoint() > 0) {
		            	accuracyLongHit = myA.get(i).getAccuracyLongHit();
		                target.get(j).setHitPoint((AM > dam * accuracyLongHit) ? HP : (HP + AM > (dam * accuracyLongHit) ? (HP + AM - dam * accuracyLongHit) : 0));//Quân trúng nhận (dam * accuracyLongHit) damamge
		                target.get(j).setArmour((int) ((AM > dam * accuracyLongHit) ? AM - dam * accuracyLongHit : 0));
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j)
		                		target.get(j1).setArmour((int) ((AM > dam * accuracyLongHit * 0.005) ? AM - dam * accuracyLongHit * 0.005 : 0));
			                	target.get(j1).setHitPoint((AM > dam * accuracyLongHit * 0.005) ? HP :(HP + AM > (dam * accuracyLongHit * 0.005) ? (HP + AM - dam * accuracyLongHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyLongHit
		                }
		                //
		                myA.get(i).setMunition(munition - 1);
	                }
	                i++; // Chuyển đến quân tấn công tiếp theo
	        	}
        	}
        }
    }
	
	public void gyrocopterAttack(BattleField enemy, Slot[] a, Slot[] b) {
		int dam, AM, i = 0, j = 0, munition = 0;  //i: Chỉ số quân tấn công, j: Chỉ số quân bị tấn công
		double HP;
		float accuracyLongHit;
    	for (Slot slot : a) {
        	i = 0;
        	ArrayList<UnitMunition> myA = new ArrayList<>();
            for (UnitFighter unit : slot.getUnit()) {
                myA.add((UnitMunition)unit); //thêm quân vào mảng a.
            }
        	for (Slot slot1 : b ) {
        		ArrayList<UnitFighter> target = new ArrayList<>();
        		for (UnitFighter unit : slot1.getUnit())
        			target.add(unit);
	        	while (i < myA.size() && !isAllDeadInArrayList(target)) {
	            	j = 0;
	            	while (target.get(j).getHitPoint() == 0)
	                    j++; //Tìm quân có máu # 0
            		dam = myA.get(i).getDamage();
	                HP = target.get(j).getHitPoint();
	                AM = target.get(j).getArmour();
                	munition = myA.get(i).getMunition();
	                if (munition > 0 && myA.get(i).getHitPoint() > 0) {
		            	accuracyLongHit = myA.get(i).getAccuracyLongHit();
		            	target.get(j).setArmour((int) ((AM > dam * accuracyLongHit * 0.005) ? AM - dam * accuracyLongHit : 0));
		                target.get(j).setHitPoint((AM > dam * accuracyLongHit) ? HP : (HP + AM > (dam * accuracyLongHit) ? (HP + AM - dam * accuracyLongHit) : 0));//Quân trúng nhận (dam * accuracyLongHit) damamge 
		                for (int j1 = 0; j1 < target.size(); j1++) {
		                	if (j1 != j)
		                		target.get(j1).setArmour((int) ((AM > dam * accuracyLongHit * 0.005) ? AM - dam * accuracyLongHit * 0.005 : 0));
			                	target.get(j1).setHitPoint((AM > dam * accuracyLongHit * 0.005) ? HP :(HP + AM > (dam * accuracyLongHit * 0.005) ? (HP + AM - dam * accuracyLongHit * 0.05) : 0)); //Các quân còn lại trong ô mỗi quân nhận 5% * dam * accuracyLongHit
		                }
		                myA.get(i).setMunition(munition - 1);
	                }
	                i++; // Chuyển đến quân tấn công tiếp theo
	        	}
        	}
        }
    }
	
	public void makeArtilleryAttack(BattleField enemy) {
        ArrayList<UnitFighter> allEnemyFront = new ArrayList<>(); //All Front
        for (Slot temp: enemy.getFront())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFront.add(unit);
        ArrayList<UnitFighter> allEnemyFlank = new ArrayList<>(); //All Flanks
        for (Slot temp: enemy.getFlank())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFlank.add(unit);
        ArrayList<UnitFighter> allEnemyLongRange = new ArrayList<>(); //All Long Range
        for (Slot temp: enemy.getlongRangeFighter())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyLongRange.add(unit);
        ArrayList<UnitFighter> allEnemyArtillery = new ArrayList<>(); //All Artillery
        for (Slot temp: enemy.getArtillery()) 
        	for (UnitFighter unit : temp.getUnit())
        		allEnemyArtillery.add(unit);
        if (!isAllDeadInArrayList(allEnemyFront)) {
        	if (isAllWallInArray(allEnemyFront) && enemy.getTotalNumberOfUnits() > enemy.getGarisionLimit())
        		return;
        	else
        		artilleryAttack(enemy, this.artillery, enemy.getFront());
        }
        else if (!isAllDeadInArrayList(allEnemyFlank)) { //Attack Flanks
        	artilleryAttack(enemy, this.artillery, enemy.getFlank());
        }
        else if (!isAllDeadInArrayList(allEnemyLongRange)) {
        	//Tan cong Long Range
    		artilleryAttack(enemy, this.artillery, enemy.getlongRangeFighter());
        }
        else if (!isAllDeadInArrayList(allEnemyArtillery)) {
        	//Tan cong Artillery
        	artilleryAttack(enemy, this.artillery, enemy.getArtillery());
        }
    }
    
    public void makeLongRangeAttack(BattleField enemy) {
        ArrayList<UnitFighter> allEnemyFront = new ArrayList<>(); //All Front
        for (Slot temp: enemy.getFront())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFront.add(unit);
        ArrayList<UnitFighter> allEnemyFlank = new ArrayList<>(); //All Flanks
        for (Slot temp: enemy.getFlank())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFlank.add(unit);
        ArrayList<UnitFighter> allEnemyLongRange = new ArrayList<>(); //All Long Range
        for (Slot temp: enemy.getlongRangeFighter())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyLongRange.add(unit);
        ArrayList<UnitFighter> allEnemyArtillery = new ArrayList<>(); //All Artillery
        for (Slot temp: enemy.getArtillery()) 
        	for (UnitFighter unit : temp.getUnit())
        		allEnemyArtillery.add(unit);
        if (!isAllDeadInArrayList(allEnemyFront)) { 
	        if (isAllWallInArray(allEnemyFront) && enemy.getTotalNumberOfUnits() > enemy.getGarisionLimit()) 
	        	//Neu co tuong, so quan > garision limit : khong tan cong
	        	return;
	        else if(isAllWallInArray(allEnemyFront) && enemy.getTotalHitpoint() <= enemy.getGarisionLimit()) {
	        	//Neu co tuong, so quan <= garision limit : tan cong long range
	        	if (!isAllDeadInArrayList(allEnemyLongRange))
	        		longRangeAttack(enemy, longRangeFighter, enemy.getlongRangeFighter());
	        }
	        else {
	        	//Tan cong Front
	        	longRangeAttack(enemy, longRangeFighter, enemy.getFront());
	        }
        }
        else if (!isAllDeadInArrayList(allEnemyFlank)){
        	//Tan cong quan Flanks
        	longRangeAttack(enemy, longRangeFighter, enemy.getFlank());
        }
        else if (!isAllDeadInArrayList(allEnemyLongRange)) {
        	//Tan cong Long Range
    		longRangeAttack(enemy, longRangeFighter, enemy.getlongRangeFighter());
        }
        else if (!isAllDeadInArrayList(allEnemyArtillery)) {
        	//Tan cong Artillery
        	longRangeAttack(enemy, longRangeFighter, enemy.getArtillery());
        }
    }

    public void makeFrontLineAttack(BattleField enemy) {
    	ArrayList<UnitFighter> allEnemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyFront.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyFlank.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyLongRange = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyLongRange.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyArtillery = new ArrayList<>();
        for (Slot slot : enemy.getArtillery()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyArtillery.add(unit);
            }
        }
        if(!isAllDeadInArrayList(allEnemyFront)) {
        	//attack Front
        	if (!isAllWallInArray(allEnemyFront)) 
        		front_or_flank_attack(enemy, front, enemy.getFront());

        }
        else if(!isAllDeadInArrayList(allEnemyFlank)) { 
        	//attack Flank
        	front_or_flank_attack(enemy, front, enemy.getFlank());
        }
        else if(!isAllDeadInArrayList(allEnemyLongRange)) {
        	//attack Long Range
        	front_or_flank_attack(enemy, front, enemy.getlongRangeFighter());
        }
        else if(!isAllDeadInArrayList(allEnemyArtillery)){ 
        	//attack Artillery
        	front_or_flank_attack(enemy, front, enemy.getArtillery());
        }
    }
    
    public void makeBombersAttack(BattleField enemy) {
    	//BB công pháo, long range fighter
        ArrayList<UnitFighter> allEnemyFront = new ArrayList<>(); //All Front
        for (Slot temp: enemy.getFront())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFront.add(unit);
        ArrayList<UnitFighter> allEnemyFlank = new ArrayList<>(); //All Flanks
        for (Slot temp: enemy.getFlank())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyFlank.add(unit);
        ArrayList<UnitFighter> allEnemyLongRange = new ArrayList<>(); //All Long Range
        for (Slot temp: enemy.getlongRangeFighter())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyLongRange.add(unit);
        ArrayList<UnitFighter> allEnemyArtillery = new ArrayList<>(); //All Artillery
        for (Slot temp: enemy.getArtillery())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyLongRange.add(unit);
        if(!isAllDeadInArrayList(allEnemyArtillery)) {
        	//attack Artillery
        	bomberAttack(enemy, bomber, enemy.getArtillery());
        }
        else if(!isAllDeadInArrayList(allEnemyLongRange)) {
        	//attack Long Range
        	bomberAttack(enemy, bomber, enemy.getlongRangeFighter());
        }
        else if(!isAllDeadInArrayList(allEnemyFront)) {
        	//attack Front
        	if (!isAllWallInArray(allEnemyFront)) 
        		bomberAttack(enemy, bomber, enemy.getFront());
        }
        else if(!isAllDeadInArrayList(allEnemyFlank)) {
        	//attack Flank
        	bomberAttack(enemy, bomber, enemy.getFlank());
        }
    }
    
    public void makeAirDefenseAttack(BattleField enemy) {
    	ArrayList<UnitFighter> allEnemyBomber = new ArrayList<>(); //All Front
        for (Slot temp: enemy.getBomber())
        	for (UnitFighter unit : temp.getUnit()) 
        		allEnemyBomber.add(unit);
        if(!isAllDeadInArrayList(allEnemyBomber)) {
        	gyrocopterAttack(enemy, airDefence, enemy.getBomber());
        }
    }
    
    public void makeFlanksAttack(BattleField enemy) {
    	ArrayList<UnitFighter> allEnemyFront = new ArrayList<>();
        for (Slot slot : enemy.getFront()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyFront.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyFlank = new ArrayList<>();
        for (Slot slot : enemy.getFlank()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyFlank.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyLongRange = new ArrayList<>();
        for (Slot slot : enemy.getlongRangeFighter()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyLongRange.add(unit);
            }
        }
        ArrayList<UnitFighter> allEnemyArtillery = new ArrayList<>();
        for (Slot slot : enemy.getArtillery()) {
            for (UnitFighter unit : slot.getUnit()) {
            		allEnemyArtillery.add(unit);
            }
        }
        if(!isAllDeadInArrayList(allEnemyFront)) {
        	//attack Front
        	if (!isAllWallInArray(allEnemyFront)) 
        		front_or_flank_attack(enemy, front, enemy.getFront());

        }
        else if(!isAllDeadInArrayList(allEnemyFlank)) { 
        	//attack Flank
        	front_or_flank_attack(enemy, front, enemy.getFlank());
        }
        else if(!isAllDeadInArrayList(allEnemyArtillery)){ 
        	//attack Long Range
        	front_or_flank_attack(enemy, front, enemy.getArtillery());
        }
    }

    
    private boolean isAllDeadInArrayList(ArrayList<UnitFighter> units) {
        for (UnitFighter unit : units) {
            if (unit.getHitPoint() != 0) {
                return false;
            }
        }
        return true;
    }

    
    public void addToField(boolean isAllWall) {
        setLongRange();
        setAirDefence();
        setArtilleryClass();
        int x = setFrontLine();
        setFlankToSlot(isAllWall, x);
        setBB();
    }

    
    public boolean isAllDead() {
        if (!reserve.getArcher().empty()) {
            return false;
        }
        if (!reserve.getCatapult().empty()) {
            return false;
        }
        if (!reserve.getHop().empty()) {
            return false;
        }
        if (!reserve.getMortar().empty()) {
            return false;
        }
        if (!reserve.getRam().empty()) {
            return false;
        }
        if (!reserve.getSC().empty()) {
            return false;
        }
        if (!reserve.getSlinger().empty()) {
            return false;
        }
        if (!reserve.getSpear().empty()) {
            return false;
        }
        if (!reserve.getSteam().empty()) {
            return false;
        }
        if (!reserve.getSword().empty()) {
            return false;
        }
        if (!reserve.getWall().empty()) {
            return false;
        }
        return true;
    }
    
     
    public boolean isAllWall(){ 
    	//true : Còn tường trên sàn đấu
    	if (this.typeOfBattleField == TypeOfBattleField.ATTACK)
    		return false;
    	else
    		return this.getReserve().getWall().size()==this.getNumberOfSlotForHI();
    }


    public RealArmy getReserve() {
        return reserve;
    }

    
    public void setReserve(RealArmy reserve) {
        this.reserve = reserve;
    }

    
    public Slot[] getArtillery() {
        return artillery;
    }
    

    public void setArtillery(Slot[] artillery) {
        this.artillery = artillery;
    }
    

    public Slot[] getlongRangeFighter() {
        return longRangeFighter;
    }

    
    public void setlongRangeFighter(Slot[] longRangeFighter) {
        this.longRangeFighter = longRangeFighter;
    }
    

    public Slot[] getFront() {
        return front;
    }

    
    public void setFront(Slot[] front) {
        this.front = front;
    }

    
    public Slot[] getFlank() {
        return flank;
    }

    
    public void setFlank(Slot[] flank) {
        this.flank = flank;
    }

    
    public Slot[] getAirDefence() {
        return airDefence;
    }
    

    public void setAirDefence(Slot[] airDefence) {
        this.airDefence = airDefence;
    }

    
    public Slot[] getBomber() {
        return bomber;
    }

    public void setBomber(Slot[] bomber) {
        this.bomber = bomber;
    }
    
//Lấy toàn bộ máu của tất cả các quân trong các slot để kiểm tra chiến trường có thay đổi hay không
   
    public int getTotalHitpoint()  {
        int totalHitpoint = 0;
        for (Army.ClassUnit classUnit : Army.ClassUnit.values()) {
            for (Slot slot : getMyClassUnit(classUnit)) {
                    totalHitpoint += slot.getTotalHitpointNotPercent();
            }
        }
        return totalHitpoint;
    }
	public boolean isAllWallInArray(ArrayList <UnitFighter> a) {
		for (UnitFighter unit : a ) {
			if (!(unit instanceof Wall))
				return false;
		}
		return true;
	}
	public void setGarisionLimit(int garisionLimit) {
		this.garision_limit = garisionLimit;
	}
}
