/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.PriorityQueue;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
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
import ui.BattleFieldFightingUI;
import ui.IsLandUI;
import ui.WaveAttackUI;

/**
 *
 * @author GBlue
 */
public class BattleFieldFighting {
	public int pnWaveId;
    private BattleField attackBattleField, defenceBattleField;
    private boolean war;
    private int houseID;
    public BattleFieldFighting(int houseID) {
        this.houseID = houseID;
        war = false;
    }

    public void startAttack() {
    	if (war == false) return;
    	for(int j = 0; j < IsLandUI.myHouse.getSentRealArmy().get(houseID).size(); j++) {
    		IsLandUI.myHouse.getSentRealArmy().get(houseID).get(j).setArrivalTime(System.currentTimeMillis() + (long) 15*60*1000/(Integer.parseInt((String)IsLandUI.timeSkip.getSelectedItem())));
    	}
        attackBattleField.makeArtilleryAttack(defenceBattleField); //wall ; Heavy Infantry + Flanks ? Garision Limit
        attackBattleField.makeAirDefenseAttack(defenceBattleField); //Bomber
        attackBattleField.makeBombersAttack(defenceBattleField); // Artillery => Long-range fighter => Close combat => flanks ? Garision Limit 
        attackBattleField.makeFlanksAttack(defenceBattleField); //(Light Infantry) Front => Flanks => Long-range (If no Wall)
        attackBattleField.makeFrontLineAttack(defenceBattleField); // (Heavy Infantry) Front => Flanks => Long-range (If no Wall)
        attackBattleField.makeLongRangeAttack(defenceBattleField); // (No Wall) Front => Flanks => Long-range; (Wall) Long-range ? Garision Limit 
        defenceBattleField.makeArtilleryAttack(attackBattleField); // Heavy Infantry
        defenceBattleField.makeAirDefenseAttack(attackBattleField); //Bomber
        defenceBattleField.makeBombersAttack(attackBattleField); // Artillery => Long-range fighter => Close combat => flanks
        defenceBattleField.makeFlanksAttack(attackBattleField); //(Light Infantry) Front => Flanks => Long-range 
        defenceBattleField.makeFrontLineAttack(attackBattleField); // (Heavy Infantry) Front => Flanks => Long-range
        defenceBattleField.makeLongRangeAttack(attackBattleField); // Front => Flanks => Long-range
        if (IsLandUI.bffUI == null) {
            IsLandUI.bffUI = new BattleFieldFightingUI(this);
        } else {
            IsLandUI.bffUI.resetBattleFieldFightingUI(this);
        }
        int houseID = this.houseID;        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	@Override
        	public void run() {
        		attackBattleField.setUnitsBackToReserve();
        		defenceBattleField.setUnitsBackToReserve();
        		for (int j = 0; j < IsLandUI.house[houseID].getWaitingWaveAttack().size(); j++) {
        			Army army = new Army();
        			RealArmy realArmy = IsLandUI.house[houseID].getWaitingWaveAttack().get(j);
        			for (int i = realArmy.getArcher().size() - 1; i >= 0; i++) {
        				if (attackBattleField.reserve.getArcher().contains(realArmy.getArcher().get(i))) {
		                    Archer archer = realArmy.getArcher().get(i);
		                    attackBattleField.reserve.getArcher().remove(archer);
		                    army.setNumberOfArcher(army.getNumberOfArcher() + 1);
        				}
        			}
        			for (int i = realArmy.getBB().size() - 1; i >= 0 ; i--) {
        				if (attackBattleField.reserve.getBB().contains(realArmy.getBB().get(i))) {
        					BalloonBombardier bb = realArmy.getBB().get(i);
        					attackBattleField.reserve.getBB().remove(bb);
        					army.setNumberOfBB(army.getNumberOfBB() + 1);
	                	}
        			}
		            for (int i = realArmy.getCatapult().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getCatapult().contains(realArmy.getCatapult().get(i))) {
		                    Catapult catapult = realArmy.getCatapult().get(i);
		                    attackBattleField.reserve.getCatapult().remove(catapult);
		                    army.setNumberOfCatapult(army.getNumberOfCatapult() + 1);
		                }
		            }
		            for (int i = realArmy.getGyrocopter().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getGyrocopter().contains(realArmy.getGyrocopter().get(i))) {
		                    Gyrocopter gy = realArmy.getGyrocopter().get(i);
		                    attackBattleField.reserve.getGyrocopter().remove(gy);
		                    army.setNumberOfGyrocopter(army.getNumberOfGyrocopter() + 1);
		                }
		            }
		            for (int i = realArmy.getHop().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getHop().contains(realArmy.getHop().get(i))) {
		                    Hoplite hop = realArmy.getHop().get(i);
		                    attackBattleField.reserve.getHop().remove(hop);
		                    army.setNumberOfHop(army.getNumberOfHop() + 1);
		                }
		            }
		            for (int i = realArmy.getMortar().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getMortar().contains(realArmy.getMortar().get(i))) {
		                    Mortar mortar = realArmy.getMortar().get(i);
		                    attackBattleField.reserve.getMortar().remove(mortar);
		                    army.setNumberOfMotar(army.getNumberOfMotar() + 1);
		                }
		            }
		            for (int i = realArmy.getRam().size() - 1; i >= 0  ; i--) {
		                if (attackBattleField.reserve.getRam().contains(realArmy.getRam().get(i))) {
		                    Ram ram = realArmy.getRam().get(i);
		                    attackBattleField.reserve.getRam().remove(ram);
		                    army.setNumberOfRam(army.getNumberOfRam() + 1);
		                }
		            }
		            for (int i = realArmy.getSC().size() - 1 ; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getSC().contains(realArmy.getSC().get(i))) {
		                    SulphurCarabineer sul = realArmy.getSC().get(i);
		                    attackBattleField.reserve.getSC().remove(sul);
		                    army.setNumberOfSC(army.getNumberOfSC() + 1);
		                }
		            }
		            for (int i = realArmy.getSlinger().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getSlinger().contains(realArmy.getSlinger().get(i))) {
		                    Slinger slinger = realArmy.getSlinger().get(i);
		                    attackBattleField.reserve.getSlinger().remove(slinger);
		                    army.setNumberOfSlinger(army.getNumberOfSlinger() + 1);
		                }
		            }
		            for (int i = realArmy.getSpear().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getSpear().contains(realArmy.getSpear().get(i))) {
		                    Spearman spear = realArmy.getSpear().get(i);
		                    attackBattleField.reserve.getSpear().remove(spear);
		                    army.setNumberOfSpear(army.getNumberOfSpear() + 1);
		                }
		            }
		            for (int i = realArmy.getSteam().size() - 1; i >= 0 ; i--) {
		                if (attackBattleField.reserve.getSteam().contains(realArmy.getSteam().get(i))) {
		                    SteamGiant steam = realArmy.getSteam().get(i);
		                    attackBattleField.reserve.getSteam().remove(steam);
		                    army.setNumberOfSteam(army.getNumberOfSteam() + 1);
		                }
		            }
		            for (int i = realArmy.getSword().size(); i >= 0 ; i--) {
		                if (attackBattleField.reserve.getSword().contains(realArmy.getSword().get(i))) {
		                    Swordsman sword = realArmy.getSword().get(i);
		                    attackBattleField.reserve.getSword().remove(sword);
		                    army.setNumberOfSword(army.getNumberOfSword() + 1);
		                }
		            }
		            Timer timer1 = new Timer();
		            timer1.schedule(new TimerTask() {
		                @Override
		                public void run() {
		                    IsLandUI.myHouse.getArmy().addArmy(army);
		                    JOptionPane.showMessageDialog(null, "Wave Success!");
		                }
		            }, 0); //15s.
		        }
		        IsLandUI.house[houseID].getWaitingWaveAttack().clear();
		        if (attackBattleField.isAllDead()) {
		        	//Toàn bộ quân tấn công chết hết
					war = false;
					IsLandUI.bffUI.setVisible(false);
					IsLandUI.house[houseID].getArmy().addArmy(defenceBattleField.getReserve().toArmy());
					SendingArmy temp = new SendingArmy();
					PriorityQueue<SendingArmy>  tempArrayList = IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId());
					temp.setArmy(attackBattleField.getReserve().toArmy());
					temp.setStartTime(System.currentTimeMillis());
					temp.setFinishTime(temp.getStartTime()+ temp.getArmy().getSpeedTimeForWholeRoute());
					if(tempArrayList == null)
						IsLandUI.myHouse.getSendingBackArmy().put(IsLandUI.currentHouse.getId(), new PriorityQueue<SendingArmy>());
					IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId()).add(temp);
					IsLandUI.myHouse.getSentRealArmy().remove(IsLandUI.currentHouse.getId());
					attackBattleField.getReserve().clear();
					defenceBattleField.getReserve().clear();
        			IsLandUI.waveAttackPanel.dispose();
        			House myHouse = IsLandUI.myHouse;
        			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
        			IsLandUI.waveAttackPanel.setVisible(true);
		            JOptionPane.showMessageDialog(null, "Enemy "+IsLandUI.house[houseID].getName()+" won");
		        } else if (defenceBattleField.isAllDead()) {
		            war = false;
		            IsLandUI.bffUI.setVisible(false);
		            IsLandUI.house[houseID].getArmy().addArmy(defenceBattleField.getReserve().toArmy());
					SendingArmy temp = new SendingArmy();
					PriorityQueue<SendingArmy>  tempArrayList = IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId());
					temp.setArmy(attackBattleField.getReserve().toArmy());
					temp.setStartTime(System.currentTimeMillis());
					temp.setFinishTime(temp.getStartTime()+ temp.getArmy().getSpeedTimeForWholeRoute());
					if(tempArrayList == null)
						IsLandUI.myHouse.getSendingBackArmy().put(IsLandUI.currentHouse.getId(), new PriorityQueue<SendingArmy>());
					IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId()).add(temp);
					IsLandUI.myHouse.getSentRealArmy().remove(IsLandUI.currentHouse.getId());
					attackBattleField.getReserve().clear();
					defenceBattleField.getReserve().clear();
        			IsLandUI.waveAttackPanel.dispose();
        			House myHouse = IsLandUI.myHouse;
        			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
        			IsLandUI.waveAttackPanel.setVisible(true);
		            JOptionPane.showMessageDialog(null, "You won "+IsLandUI.house[houseID].getName());
		        } else {
		            boolean isAllWall = defenceBattleField.isAllWall();
		            attackBattleField.addToField(false);
		            defenceBattleField.addToField(isAllWall);
		            startAttack();
		        }
        	}
        }, (long) 15*60*1000/(Integer.parseInt((String)IsLandUI.timeSkip.getSelectedItem())));
	}
    public void cancelFighting() {
     //canceling fighting
    	Timer timer = new Timer();
    	timer.schedule(new TimerTask() {
    		@Override
    		public void run() {
    			if(!attackBattleField.isAllDead() && !defenceBattleField.isAllDead()) {
	    			war = false;
	    			Army army = attackBattleField.getReserve().toArmy();
	    			IsLandUI.house[houseID].getArmy().addArmy(defenceBattleField.getReserve().toArmy());
	    			if (army.getNumberAll() > 0) {
		    			SendingArmy temp = new SendingArmy();
		    			temp.setArmy(army);
		    			PriorityQueue<SendingArmy>  tempArrayList = IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId());
		    			if(tempArrayList == null)
		    				IsLandUI.myHouse.getSendingBackArmy().put(IsLandUI.currentHouse.getId(), new PriorityQueue<SendingArmy>());
		    			temp.setStartTime(System.currentTimeMillis());
		    			temp.setFinishTime(temp.getStartTime()+ temp.getArmy().getSpeedTimeForWholeRoute());
		    			IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId()).add(temp);
		    			IsLandUI.myHouse.getSentRealArmy().remove(IsLandUI.currentHouse.getId());
		    			attackBattleField.getReserve().clear();
						defenceBattleField.getReserve().clear();
		    			IsLandUI.waveAttackPanel.dispose();
		    			House myHouse = IsLandUI.myHouse;
		    			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
		    			IsLandUI.waveAttackPanel.setVisible(true);
	    			}
    			}
    		}
    	}, IsLandUI.myHouse.getSentRealArmy().get(IsLandUI.currentHouse.getId()).get(0).getArrivalTime() - System.currentTimeMillis() + 5000);
    }
    public BattleField getAttackBattleField() {
        return attackBattleField;
    }

    public void setAttackBattleField(BattleField attackBattleField) {
        this.attackBattleField = attackBattleField;
    }

    public BattleField getDefenceBattleField() {
        return defenceBattleField;
    }

    public void setDefenceBattleField(BattleField defenceBattleField) {
        this.defenceBattleField = defenceBattleField;
    }

    public boolean isWar() {
        return war;
    }

    public void setWar(boolean war) {
        this.war = war;
    }

}
