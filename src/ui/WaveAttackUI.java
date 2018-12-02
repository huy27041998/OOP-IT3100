/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import model.Army;
import model.House;
import model.RealArmy;
import model.SendingArmy;
import model.SentArmy;

/**
 *
 * @author Dat Ngo
 */
public class WaveAttackUI extends JDialog {
	public boolean is_open = true;
    int size = 0;
    int wei = 0;
    public JPanel pnMain;
    JLabel[] lblTitle;
    public PnWaveAttack[] pnWave;
    HashMap<Integer, ArrayList<SentArmy>> sentRealArmy;
    HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy;
    HashMap<Integer, PriorityQueue<SendingArmy>> sendingBackArmy;
    int count = 0;
    
    public WaveAttackUI(String title, HashMap<Integer, ArrayList<SentArmy>> sentRealArmy, HashMap<Integer, PriorityQueue<SendingArmy>> sendingArmy, HashMap<Integer, PriorityQueue<SendingArmy>> sendingBackArmy) {
        setTitle(title);
        setSize(820, 500);
        setLocationRelativeTo(null);
        pnMain = new JPanel();
        lblTitle = new JLabel[7];
        sentRealArmy.forEach((key, arrList) -> {
            size += arrList.size();
        }
        );
        sendingArmy.forEach((key, queue) -> {
            wei += queue.size();
        });
        sendingBackArmy.forEach((key, queue) -> {
        	wei += queue.size();
        });
        pnWave = new PnWaveAttack[size + wei];
        this.sentRealArmy = sentRealArmy;
        this.sendingArmy = sendingArmy;
        this.sendingBackArmy = sendingBackArmy;
        addControls();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void removePn() {
    	this.getParent().remove(this);
    }
    void addControls() {
        Container con = getContentPane();
        JScrollPane sc = new JScrollPane(pnMain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        con.add(sc);
        pnMain.setLayout(null);
        pnMain.setBackground(new Color(221, 176, 109));
        for (int i = 0; i < 7; i++) {
            lblTitle[i] = new JLabel();
            lblTitle[i].setBounds(30 + 110 * i, 20, 100, 50);
            pnMain.add(lblTitle[i]);
        }
        lblTitle[0].setText("Mission");
        lblTitle[1].setText("Arrival time");
        lblTitle[2].setText("Munition");
        lblTitle[3].setText("Unit");
        lblTitle[4].setText("Origin");
        lblTitle[5].setText("Target");
        lblTitle[6].setText("Action");

        sentRealArmy.forEach((key, arrList) -> {
            for (int j = 0; j < arrList.size(); j++) {
                int numberOfUnit = 0;
                SentArmy sentArmy = arrList.get(arrList.size() - j - 1);
                for (int k = 0; k < sentArmy.getRealArmy().getArcher().size(); k++) {
                    if (sentArmy.getRealArmy().getArcher().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getBB().size(); k++) {
                    if (sentArmy.getRealArmy().getBB().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getCatapult().size(); k++) {
                    if (sentArmy.getRealArmy().getCatapult().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getHop().size(); k++) {
                    if (sentArmy.getRealArmy().getHop().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getMortar().size(); k++) {
                    if (sentArmy.getRealArmy().getMortar().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getRam().size(); k++) {
                    if (sentArmy.getRealArmy().getRam().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSC().size(); k++) {
                    if (sentArmy.getRealArmy().getSC().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSlinger().size(); k++) {
                    if (sentArmy.getRealArmy().getSlinger().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSpear().size(); k++) {
                    if (sentArmy.getRealArmy().getSpear().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSteam().size(); k++) {
                    if (sentArmy.getRealArmy().getSteam().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getSword().size(); k++) {
                    if (sentArmy.getRealArmy().getSword().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                for (int k = 0; k < sentArmy.getRealArmy().getGyrocopter().size(); k++) {
                    if (sentArmy.getRealArmy().getGyrocopter().get(k).getHitPoint() != 0) {
                        numberOfUnit++;
                    }
                }
                int temp = count;
                if (numberOfUnit != 0) {
                    pnWave[count] = new PnWaveAttack(sentArmy, key);
                    pnWave[count].getLblOrigin().setText(IsLandUI.myHouse.getName());
                    pnWave[count].getLblTarget().setText(IsLandUI.house[key].getName());
                    pnWave[count].getLblUnit().setText(numberOfUnit + "");
                    pnWave[count].getbtnMission().setIcon(new ImageIcon(getClass().getResource("/image/Pillage_Enabled.PNG")));
                    pnWave[count].getbtnMission().addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) 
	                    		IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.house[key].getBattleFieldFighting());
	                            IsLandUI.bffUI.showWindow();
                    	}
                    });
                    pnWave[count].getBtnAction().addActionListener(new ActionListener() {
                    	@Override
                    	public void actionPerformed (ActionEvent e) {
                    		int dialogButton = JOptionPane.YES_NO_OPTION;
                		    JOptionPane.showConfirmDialog (null, "Retreat?", "Warning", dialogButton);
                		    if (dialogButton == JOptionPane.YES_OPTION) {
	                    		IsLandUI.house[key].getBattleFieldFighting().cancelFighting();
                		    }
                    	}
                    });
                    SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
                    Timer dongho = new Timer(0, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            pnWave[temp].getLblArrivalTime().setText("<html>" + ft.format(new Date(-System.currentTimeMillis() + sentArmy.getArrivalTime())) + "<br>(Ground Fight)</html>");//cần sủa lại thời gian
                        }
                    });
                    dongho.start();

                    pnWave[count].setBounds(20, 60 * count + 75, 820, 50);
                    pnMain.add(pnWave[count]);
                    count++;
                }

            }

        }
        );

        sendingArmy.forEach((key, queue) -> {
            Iterator<SendingArmy> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int numberOfUnit = 0;
                SendingArmy sendingArmy = iterator.next();

                Army army = sendingArmy.getArmy();

                for (Army.Unit unit : Army.Unit.values()) {
                    numberOfUnit += army.getNumberOf(unit);
                }
                int temp = count;
                if (numberOfUnit != 0) {
                    pnWave[count] = new PnWaveAttack(sendingArmy, key, this.sendingArmy.get(key));
                    pnWave[count].getLblOrigin().setText(IsLandUI.myHouse.getName());
                    pnWave[count].getLblTarget().setText(IsLandUI.house[key].getName());
                    pnWave[count].getLblUnit().setText(numberOfUnit + "");
                    pnWave[count].getbtnMission().setIcon(new ImageIcon(getClass().getResource("/image/Pillage_Enabled.PNG")));
                    pnWave[count].getBtnAction().addActionListener(new ActionListener() {
                    	@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "Can't retreat while sending!");
						}
                    });
                    pnWave[count].getbtnMission().addActionListener(new ActionListener() {
                    	public void actionPerformed(ActionEvent e) {
                    		JOptionPane.showMessageDialog(null, "War haven't happened");
                    	}
                    });
                    SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
                    Timer dongho = new Timer(0, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        		pnWave[temp].getLblArrivalTime().setText("<html>" + ft.format(new Date(-System.currentTimeMillis() + sendingArmy.getFinishTime())) + "<br>(underway)</html>"); //da sua
	                    		if (System.currentTimeMillis() > sendingArmy.getFinishTime()) {
	                    			pnWave[temp].getLblArrivalTime().setText("<html>---<br>(underway)</html>");
	                    			IsLandUI.myHouse.getSendingArmy().remove(key);
	                    			IsLandUI.waveAttackPanel.dispose();
	                    			House myHouse = IsLandUI.myHouse;
	                    			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
	                    			IsLandUI.waveAttackPanel.setVisible(true);
	                    			((Timer)e.getSource()).stop();
	                    		}
                        }
                    });
                    dongho.start();

                    pnWave[count].setBounds(20, 60 * (count) + 75, 820, 50);
                    pnMain.add(pnWave[count]);
                    count++;
                }
            }

        });
        sendingBackArmy.forEach((key, queue) -> {
            Iterator<SendingArmy> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int numberOfUnit = 0;
                SendingArmy sendingArmy = iterator.next();

                Army army = sendingArmy.getArmy();

                for (Army.Unit unit : Army.Unit.values()) {
                    numberOfUnit += army.getNumberOf(unit);
                }
                int temp = count;
                if (numberOfUnit != 0) {
                    pnWave[count] = new PnWaveAttack(sendingArmy, key, this.sendingArmy.get(key));
                    pnWave[count].getLblOrigin().setText(IsLandUI.myHouse.getName());
                    pnWave[count].getLblTarget().setText(IsLandUI.house[key].getName());
                    pnWave[count].getLblUnit().setText(numberOfUnit + "");
                    pnWave[count].getbtnMission().setIcon(new ImageIcon(getClass().getResource("/image/Pillage_Disabled.PNG")));
                    pnWave[count].getBtnAction().addActionListener(new ActionListener() {
                    	@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "Can't retreat while sending!");
						}
                    });
                    SimpleDateFormat ft = new SimpleDateFormat("mm:ss");
                    Timer dongho = new Timer(0, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                        		pnWave[temp].getLblArrivalTime().setText("<html>" + ft.format(new Date(-System.currentTimeMillis() + sendingArmy.getFinishTime())) + "<br>(going back)</html>"); //da sua
	                    		if (System.currentTimeMillis() > sendingArmy.getFinishTime()) {
	                    			pnWave[temp].getLblArrivalTime().setText("<html>---<br>(going back)</html>");
	                    			IsLandUI.myHouse.getSendingBackArmy().remove(key);
	                    			IsLandUI.myHouse.getArmy().addArmy(sendingArmy.getArmy());
	                    			if(is_open == true) {
		                    			IsLandUI.waveAttackPanel.dispose();
		                    			House myHouse = IsLandUI.myHouse;
		                    			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
		                    			IsLandUI.waveAttackPanel.setVisible(true);
		                    			is_open = true;
	                    			}
	                    			else {
	                    				IsLandUI.waveAttackPanel.dispose();
		                    			House myHouse = IsLandUI.myHouse;
		                    			IsLandUI.waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
	                    			}
	                    			JOptionPane.showMessageDialog(null, "Success, Units come back home");
	                    			((Timer)e.getSource()).stop();
	                    		}
                        }
                    });
                    dongho.start();

                    pnWave[count].setBounds(20, 60 * (count) + 75, 820, 50);
                    pnMain.add(pnWave[count]);
                    count++;
                }
            }

        });

    }
}
