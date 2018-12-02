/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.unit.UnitFighter;

/**
 *
 * @author maidoanh
 * Lớp slot chứa quân đang đứng trên sàn đấu 
 */

public class Slot {
    private ArrayList<UnitFighter> unit;
    private int totalHitpoint;
    private int totalMunition;
    private String imageUrl;
    private int size;
    private Army.Unit unitType;
    private int initNumUnit;
    private int initHitpointUnit; // máu ban đầu 
    private int initMunition; //đạn ban đầu

    public Slot() {
    	//tỏng máu đạn ban đầu ?
        initNumUnit = 0;
        totalHitpoint = 0;
        totalMunition = 0;
        imageUrl = "";
        initHitpointUnit = 0;
        unit = new ArrayList<UnitFighter>();
        size = 0;
    }

    public ArrayList<UnitFighter> getUnit() {
        return unit;
    }

    public void setUnit(ArrayList unit) {
        this.unit = unit;
    }

    public void setTotalHitpoint(int totalHitpoint) {
        this.totalHitpoint = totalHitpoint;
    }

    public void setTotalMunition(int totalMunition) {
        this.totalMunition = totalMunition;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Army.Unit getUnitType() {
        return unitType;
    }

    public void setUnitType(Army.Unit unitType) {
        this.unitType = unitType;
    }

    public int getInitNumUnit() {
        return initNumUnit;
    }

    public void setInitNumUnit(int initNumUnit) {
        this.initNumUnit = initNumUnit;
    }

    public int getInitHitpointUnit() {
        return initHitpointUnit;
    }
    public void setInitMunition(int munition) {
    	this.initMunition = munition;
    }
    public void setInitHitpointUnit(int initHitpointUnit) {
        this.initHitpointUnit = initHitpointUnit;
    }
    
    
    public int getTotalHitpoint() {
    	//Tỏng lượng máu tính theo %
        int totalHitpoint = 0;
        for (UnitFighter unitFighter : unit) {                
            totalHitpoint += unitFighter.getHitPoint();
        }
        if (getUnitAlive() == 0 || initHitpointUnit == 0) {
        	System.out.println("Total HP of " + this.unit.get(0).getName() + "s are 0");
            return 0;
        }
        else {
        	int a = totalHitpoint * 100/(getInitNumUnit() * initHitpointUnit);
        	System.out.println("Total HP of " + this.unit.get(0).getName() + "s are " + a);
            return a;
        }
    }
    public int getTotalMunition() {
     	//Tỏng lượng đạn tính theo %
        int totalMunition = 0;
        for (UnitFighter unitFighter : unit) {
        	if (unitFighter instanceof model.unit.UnitMunition && unitFighter.getHitPoint() > 0) {
        		model.unit.UnitMunition unit1 = (model.unit.UnitMunition) unitFighter;
        		totalMunition += unit1.getMunition();
        	}
        }
        if (getUnitAlive() == 0 || initMunition == 0) {
        	if (this.unit.get(0) instanceof model.unit.UnitMunition)
        		System.out.println("Total Munition of " + this.unit.get(0).getName() + "s are 0");
            return 0;
        }
        else {
        	int a = totalMunition * 100/(getInitNumUnit() * initMunition);
        	if (this.unit.get(0) instanceof model.unit.UnitMunition)
        		System.out.println("Total Munition of " + this.unit.get(0).getName() + "s are " + a);
            return a;
        }
    }
    public int getTotalHitpointNotPercent() {
    	//Tổng lượng máu 
        int totalHitpoint = 0;
        for (UnitFighter unitFighter : unit) {                
            totalHitpoint += unitFighter.getHitPoint();
       
        }
         return totalHitpoint;
    }
     public int getUnitAlive() {
    	//Số lượng quân còn sống
        int count = 0;
        for (UnitFighter unitFighter : unit) {
            if (unitFighter.getHitPoint() > 0) 
                count++;
        }
        return count;
    }
}
