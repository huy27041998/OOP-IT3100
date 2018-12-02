package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import ui.IsLandUI;
import ui.WaveAttackUI;

public class House {

    private int id;
    private int levelOfHouse;
    private int levelOfWall;
    private Wall wall;
    private int typeOfHouse = 3; //0: của mình, 1: của đồng minh, 2: của địch, 3: Moor
    private Army army;
    public HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy;
    public HashMap<Integer, ArrayList<SentArmy>> sentRealArmy;
    public HashMap<Integer, PriorityQueue<SendingArmy>> sendingBackArmy;
    private ArrayList<RealArmy> waitingWaveAttack;
    private BattleFieldFighting battleFieldFighting;
    private String name;
    
    public House() {
        army = new Army();
        wall = new Wall(0);
        sendingArmy = new HashMap<Integer, PriorityQueue<SendingArmy>>();
        sendingBackArmy = new HashMap<Integer, PriorityQueue<SendingArmy>>();
        battleFieldFighting = new BattleFieldFighting(id);
        waitingWaveAttack = new ArrayList<RealArmy>();
        sentRealArmy = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        battleFieldFighting = new BattleFieldFighting(id);
    }

    public House(int id) {
        this.id = id;
    }

    public HashMap<Integer, ArrayList<SentArmy>> getSentRealArmy() {
        return sentRealArmy;
    }

    public void setSentRealArmy(HashMap<Integer, ArrayList<SentArmy>> sentRealArmy) {
        this.sentRealArmy = sentRealArmy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wall getWall() {
        return wall;
    }

    public void setWall(Wall wall) {
        this.wall = wall;
    }

    public int getLevelOfWall() {
        return levelOfWall;
    }

    public int getLevelOfHouse() {
        return levelOfHouse;
    }

    public void setLevelOfHouse(int levelOfHouse) {
        this.levelOfHouse = levelOfHouse;
    }

    public void setLevelOfWall(int levelOfWall) {
        this.levelOfWall = levelOfWall;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public int getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(int typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }

    public HashMap<Integer, PriorityQueue<SendingArmy>> getSendingArmy() {
        return sendingArmy;
    }

    public void setSendingArmy(HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy) {
        this.sendingArmy = sendingArmy;
    }

    public BattleFieldFighting getBattleFieldFighting() {
        return battleFieldFighting;
    }

    public void setBattleFieldFighting(BattleFieldFighting battleFieldFighting) {
        this.battleFieldFighting = battleFieldFighting;
    }

    public ArrayList<RealArmy> getWaitingWaveAttack() {
        return waitingWaveAttack;
    }

    public void setWaitingWaveAttack(ArrayList<RealArmy> waitingWaveAttack) {
        this.waitingWaveAttack = waitingWaveAttack;
    }
    
    private boolean checkRow12(Army attackArmy, BattleField attackBattleField) {
    	if (attackArmy.getNumberOfHop() == 0 &&
			attackArmy.getNumberOfSteam() == 0 &&
			attackArmy.getNumberOfSpear() == 0 && 
			attackArmy.getNumberOfSword() == 0 && 
			attackArmy.getNumberOfSlinger() == 0 &&
			attackArmy.getNumberOfArcher() == 0 &&
			attackArmy.getNumberOfSC() == 0 &&
    		attackBattleField.getReserve().getHop().size() == 0 &&
			attackBattleField.getReserve().getSteam().size() == 0 &&
			attackBattleField.getReserve().getSpear().size() == 0 &&
			attackBattleField.getReserve().getSword().size() == 0 &&
			attackBattleField.getReserve().getSlinger().size() == 0 &&
			attackBattleField.getReserve().getSC().size() == 0 &&
			attackBattleField.getReserve().getArcher().size() == 0)
			return false;
    	return true; 
    	}
    
    
    
    public void addArmyToBattleField(Army attackArmy, SendingArmy sendingArmy) {
        Timer timer = new Timer();
        Army defenceArmy = this.army;
        int houseID = this.getId();
        sendingArmy.setTimer(timer);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
            	if(checkRow12(attackArmy, battleFieldFighting.getAttackBattleField())) {
	                battleFieldFighting.getAttackBattleField().addToReserve(battleFieldFighting.getAttackBattleField().getReserve(), attackArmy, houseID);
	                if (!battleFieldFighting.isWar()) {
	                    battleFieldFighting.getDefenceBattleField().addToReserve(battleFieldFighting.getDefenceBattleField().getReserve(), defenceArmy, houseID);
	                    army.clear();
	                    battleFieldFighting.setWar(true);
		                Stack<Wall> walls = new Stack<>();
	                    for (int i = 0; i < battleFieldFighting.getDefenceBattleField().getNumberOfSlotForHI(); i++) {
	                        walls.add(new Wall(levelOfWall));
	                    }
	                    int garisionLimit = walls.get(0).getGarisionLimit();
	                    battleFieldFighting.getDefenceBattleField().setGarisionLimit(garisionLimit);
	                    battleFieldFighting.getAttackBattleField().setGarisionLimit(0);
	                    battleFieldFighting.getDefenceBattleField().getReserve().setWall(walls);
	                    
	                }
	                boolean isAllWall = battleFieldFighting.getDefenceBattleField().isAllWall();
	                battleFieldFighting.getDefenceBattleField().addToField(isAllWall);
	                battleFieldFighting.getAttackBattleField().addToField(false);
	                battleFieldFighting.startAttack();
	                JOptionPane.showMessageDialog(null, "Success, Units Arrived");
            	}
            	else {
            		//Mat tich
            		SendingArmy temp = new SendingArmy();
					PriorityQueue<SendingArmy>  tempArrayList = IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId());
					temp.setArmy(sendingArmy.getArmy());
					temp.setStartTime(System.currentTimeMillis());
					temp.setFinishTime(temp.getStartTime()+ temp.getArmy().getSpeedTimeForWholeRoute() +(long) 3600*1000/(Integer.parseInt((String)IsLandUI.timeSkip.getSelectedItem())));
					if(tempArrayList == null)
						IsLandUI.myHouse.getSendingBackArmy().put(IsLandUI.currentHouse.getId(), new PriorityQueue<SendingArmy>());
					IsLandUI.myHouse.getSendingBackArmy().get(IsLandUI.currentHouse.getId()).add(temp);
					IsLandUI.waveAttackPanel.dispose();
        			House myHouse = IsLandUI.myHouse;
        			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
        			IsLandUI.waveAttackPanel.setVisible(true);
					JOptionPane.showMessageDialog(null, "Units Lost");
            	}
            }
        }, attackArmy.getSpeedTimeForWholeRoute());
    }

	public HashMap<Integer, PriorityQueue<SendingArmy>> getSendingBackArmy() {
		return sendingBackArmy;
	}

	public void setSendingBackArmy(HashMap<Integer, PriorityQueue<SendingArmy>> sendingBackArmy) {
		this.sendingBackArmy = sendingBackArmy;
	}

}
