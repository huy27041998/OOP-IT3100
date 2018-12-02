/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.BattleField;
import model.RealArmy;
import model.Wall;
import ui.BattleFieldUI;

/**
 *
 * @author admin
 */
public class HouseInfoUI extends JDialog {

    JPanel pnMain, pnTitle, pnLvHou, pnLvWall, pnTypeOfHou, pnButtonm, pnNameHou;
    JLabel lblLvHou, lblLvWall, lblTypeOfHou, lblNameHou;
    JLabel lblImg, lblTitle, lblImgTitle;
    JSlider sldLevelHouse;
	JSlider sldLevelWall;
    JTextField txtLevelHouse, txtLevelWall, txtNameHou;
    JComboBox<String> cbo;
    JButton btnDispose, btnPillage, btnBarrack, btnOK, btnBattleFighting, btnUpgradeUnit;

    public HouseInfoUI() throws HeadlessException {
        addControls();
        addEvents();
    }

    public void addControls() {
        Container con = getContentPane();
        con.setLayout(null);
        lblImgTitle = new JLabel(new ImageIcon(getClass().getResource("/image/lblHouTitle.png")));
        lblImgTitle.setBounds(20, 0, 60, 60);
        
        pnMain = new JPanel(null);
        pnMain.setBounds(0, 30, 800, 700);
        pnMain.setBackground(new Color(253, 247, 221));
        pnTitle = new JPanel(null);
        pnTitle.setBounds(0, 0, 800, 20);
        pnTitle.setBackground(new Color(215, 172, 116));
        pnMain.add(pnTitle);
        lblTitle = new JLabel("House's Information");
        lblTitle.setBounds(312, 0, 247, 15);
        pnTitle.add(lblTitle);
        btnDispose = new JButton(new ImageIcon(getClass().getResource("/image/xButton.png")));
        btnDispose.setBounds(778, 0, 20, 20);
        pnTitle.add(btnDispose);

        pnNameHou = new JPanel(null);
        pnNameHou.setBounds(10, 41, 788, 50);
        pnNameHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnNameHou);
        lblNameHou = new JLabel("Name of House");
        lblNameHou.setBounds(25, 14, 129, 20);
        pnNameHou.add(lblNameHou);
        txtNameHou = new JTextField(40);
        txtNameHou.setBounds(169, 12, 586, 26);
        pnNameHou.add(txtNameHou);
        
        pnLvHou = new JPanel(null);
        pnLvHou.setBounds(10, 127, 788, 50);
        pnLvHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvHou);
        lblLvHou = new JLabel("Level of House");
        lblLvHou.setBounds(29, 15, 110, 20);
        pnLvHou.add(lblLvHou);
        sldLevelHouse = new JSlider(0, 40);
        sldLevelHouse.setBounds(169, 15, 564, 20);
        sldLevelHouse.setBackground(new Color(251, 232, 193));
        pnLvHou.add(sldLevelHouse);
        txtLevelHouse = new JTextField(40);
        txtLevelHouse.setBounds(742, 16, 20, 20);
        pnLvHou.add(txtLevelHouse);

        pnLvWall = new JPanel(null);
        pnLvWall.setBounds(12, 225, 788, 50);
        pnLvWall.setBackground(new Color(251, 232, 193));
        pnMain.add(pnLvWall);
        lblLvWall = new JLabel("Level of Wall");
        lblLvWall.setBounds(30, 15, 90, 20);
        pnLvWall.add(lblLvWall);
        sldLevelWall = new JSlider(0, 42);
        sldLevelWall.setBounds(169, 15, 564, 20);
        sldLevelWall.setBackground(new Color(251, 232, 193));
        pnLvWall.add(sldLevelWall);
        txtLevelWall = new JTextField(40);
        txtLevelWall.setBounds(745, 16, 20, 20);
        pnLvWall.add(txtLevelWall);

        pnTypeOfHou = new JPanel(null);
        pnTypeOfHou.setBounds(12, 320, 788, 50);
        pnTypeOfHou.setBackground(new Color(251, 232, 193));
        pnMain.add(pnTypeOfHou);
        lblTypeOfHou = new JLabel("Type of House");
        lblTypeOfHou.setBounds(31, 15, 118, 20);
        pnTypeOfHou.add(lblTypeOfHou);
        cbo = new JComboBox<>();
        cbo.setBounds(169, 15, 266, 20);
        cbo.addItem("My House");
        cbo.addItem("My Ally");
        cbo.addItem("Enemy");
        cbo.addItem("Moor");
        pnTypeOfHou.add(cbo);

        btnPillage = new JButton();
        btnPillage.setBounds(33, 396, 50, 35);
        btnPillage.setIcon(new ImageIcon(getClass().getResource("/image/Pillage_Enabled.PNG")));
        pnMain.add(btnPillage);

        btnBarrack = new JButton("Set Barrack");
        btnBarrack.setBounds(33, 456, 110, 30);
        btnBarrack.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBarrack);

        btnBattleFighting = new JButton("Fighting");
        btnBattleFighting.setBounds(33, 498, 110, 30);
        btnBattleFighting.setBackground(new Color(248, 222, 164));
        pnMain.add(btnBattleFighting);

        btnUpgradeUnit = new JButton("Upgrade Unit");
        btnUpgradeUnit.setBounds(33, 540, 110, 30);
        btnUpgradeUnit.setBackground(new Color(248, 222, 164));
        pnMain.add(btnUpgradeUnit);

        lblImg = new JLabel(new ImageIcon(getClass().getResource("/image/HouseInfo.png")));
        lblImg.setBounds(561, 383, 200, 200);
        pnMain.add(lblImg);

        btnOK = new JButton("OK");
        btnOK.setBounds(343, 619, 110, 30);
        btnOK.setBackground(new Color(248, 222, 164));
        pnMain.add(btnOK);

        con.add(pnMain);

    }

    public void addEvents() {
        this.addComponentListener(new ComponentAdapter() {

            public void componentShown(ComponentEvent evt) {
            	txtNameHou.setText(IsLandUI.currentHouse.getName());
                sldLevelHouse.setValue(IsLandUI.currentHouse.getLevelOfHouse());
                sldLevelWall.setValue(IsLandUI.currentHouse.getLevelOfWall());
                cbo.setSelectedIndex(IsLandUI.currentHouse.getTypeOfHouse());
                if (IsLandUI.currentHouse.getTypeOfHouse() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Enabled.PNG")));
                } else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Disabled.PNG")));
                }
                if (IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    sldLevelHouse.setEnabled(false);
                    sldLevelWall.setEnabled(false);
                } else {
                    sldLevelHouse.setEnabled(true);
                    sldLevelWall.setEnabled(true);
                }

            }
        });

        btnDispose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        sldLevelHouse.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelHouse.setText(String.valueOf(sldLevelHouse.getValue()));
            }
        });
        txtLevelHouse.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelHouse.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelHouse.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelHouse.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelHouse.setText("40");
                }
                sldLevelHouse.setValue(Integer.valueOf(txtLevelHouse.getText()));
            }
        });
        

        sldLevelWall.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent evt) {
                txtLevelWall.setText(String.valueOf(sldLevelWall.getValue()));
            }
        });

        txtLevelWall.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                String StringVal = txtLevelWall.getText();
                Integer IntVal = 0;
                try {
                    IntVal = Integer.valueOf(StringVal);
                } catch (NumberFormatException e) {
                    txtLevelWall.setText("0");
                }
                if (IntVal < 0) {
                    txtLevelWall.setText("0");
                } else if (IntVal >= 40) {
                    txtLevelWall.setText("42");
                }
                sldLevelWall.setValue(Integer.valueOf(txtLevelWall.getText()));
            }
        });

        cbo.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (cbo.getSelectedIndex() == 3) {
                    sldLevelHouse.setValue(0);
                    sldLevelWall.setEnabled(false);
                    sldLevelHouse.setEnabled(false);
                    txtLevelHouse.setEnabled(false);
                    txtLevelWall.setEnabled(false);
                    btnBarrack.setEnabled(false);
                    
                } else {
                    sldLevelHouse.setMinimum(1);
                    sldLevelWall.setMinimum(0);
                    sldLevelWall.setEnabled(true);
                    sldLevelHouse.setEnabled(true);
                    txtLevelHouse.setEnabled(true);
                    txtLevelWall.setEnabled(true);
                    btnBarrack.setEnabled(true);
                }
                if (cbo.getSelectedIndex() == 2) {
                    btnPillage.setEnabled(true);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Enabled.PNG")));
                }
                else {
                    btnPillage.setEnabled(false);
                    btnPillage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Pillage_Disabled.PNG")));
                }
            }
        });
        btnOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
            }
        });
        btnPillage.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                btnPillage.setBorder(new BevelBorder(BevelBorder.RAISED));
            }

            public void mouseExited(MouseEvent evt) {
                btnPillage.setBorder(null);
            }

            public void mouseClicked(MouseEvent evt) {
                if (IsLandUI.myHouse == null) {
                    JOptionPane.showMessageDialog(null, "Chưa có các thông số của My house");
                } else {
                    setHouseInfo();
                    BattleFieldUI ui = new BattleFieldUI();
                    ui.showWindow();

                }
            }
        });
        btnBarrack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                setBarrackInfo();
            }
        });
        btnBattleFighting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
                    JOptionPane.showMessageDialog(null, "War haven't happened");
                } else {
//                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    //System.out.println("" + IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().reserve.getArcher().size());
                    IsLandUI.bffUI = new BattleFieldFightingUI(IsLandUI.currentHouse.getBattleFieldFighting());
                    IsLandUI.bffUI.showWindow();

                }
            }
        });

        btnUpgradeUnit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setHouseInfo();
                UpgradeUnitUI upgradeUnit = new UpgradeUnitUI();
                upgradeUnit.showWindow();
            }
        });

        cbo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (cbo.getSelectedItem().equals("My House")) {
                    IsLandUI.currentHouse.setTypeOfHouse(0);
                }
                if (cbo.getSelectedItem().equals("My Ally")) {
                    IsLandUI.currentHouse.setTypeOfHouse(1);
                }
                if (cbo.getSelectedItem().equals("Enemy")) {
                    IsLandUI.currentHouse.setTypeOfHouse(2);
                }
                if (cbo.getSelectedItem().equals("Moor")) {
                    IsLandUI.currentHouse.setTypeOfHouse(3);
                }
            }
        });

    }

    protected void setBarrackInfo() {
        SetUnitJDialog ui = new SetUnitJDialog();
        ui.showWindows();
    }
    private boolean checkNameHouse(String nnn) { 
    	String x; 
    	if (nnn.length() > 20) 
    		return false; 
    	for(int i=0; i< nnn.length(); i++) { 
    		x = "" + nnn.charAt(i); 
    		if (x.matches("\\W")) 
    			return false; 
    	} 
    	return true; 
    }
    //Set house's attributes
    protected void setHouseInfo() {
    	if (checkNameHouse(txtNameHou.getText()))
    		IsLandUI.currentHouse.setName(txtNameHou.getText());
    	else 
    		JOptionPane.showMessageDialog(null, "Invalid name of house");
        IsLandUI.currentHouse.setLevelOfHouse(Integer.parseInt(txtLevelHouse.getText()));
        IsLandUI.currentHouse.setLevelOfWall(Integer.parseInt(txtLevelWall.getText()));
        if (!IsLandUI.currentHouse.getBattleFieldFighting().isWar()) {
            if (IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setAttackBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.ATTACK));
            } else {
            	BattleField attack = new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.ATTACK);
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().getReserve();
                IsLandUI.currentHouse.getBattleFieldFighting().setAttackBattleField(attack);
                IsLandUI.currentHouse.getBattleFieldFighting().getAttackBattleField().setReserve(realArmy);
            }
            if (IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField() == null) {
                IsLandUI.currentHouse.getBattleFieldFighting().setDefenceBattleField(
                        new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.DEFENCE));
            } else {
                BattleField defence = new BattleField(IsLandUI.currentHouse.getLevelOfHouse(), BattleField.TypeOfBattleField.DEFENCE);
                RealArmy realArmy = IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().getReserve();
                Stack<Wall> walls = new Stack<>();
                for (int i = 0; i < IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().getNumberOfSlotForHI(); i++) {
                    walls.add(new Wall(IsLandUI.currentHouse.getLevelOfWall()));
                }
                realArmy.setWall(walls);
                IsLandUI.currentHouse.getBattleFieldFighting().setDefenceBattleField(defence);
                IsLandUI.currentHouse.getBattleFieldFighting().getDefenceBattleField().setReserve(realArmy); 
            }

        }

        String type = cbo.getSelectedItem().toString();
        if (type.equals("My House")) {
            IsLandUI.currentHouse.setTypeOfHouse(0);
            setIconHouse();
            IsLandUI.myHouse = IsLandUI.currentHouse;
        } else if (type.equals("My Ally")) {
            IsLandUI.currentHouse.setTypeOfHouse(1);
            setIconHouse();
        } else if (type.equals("Enemy")) {
            IsLandUI.currentHouse.setTypeOfHouse(2);
            setIconHouse();
        } else {
            IsLandUI.currentHouse.setTypeOfHouse(3);
            setIconHouse();
        }
        IsLandUI.currentTextField.setText(IsLandUI.currentHouse.getName());
        IsLandUI.currentTextField.setVisible(true);
        this.dispose();

    }

    private void setIconHouse() {
    	if (IsLandUI.currentHouse.getTypeOfHouse() == 3) 
    		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/moorHouse/houseLv7.png")));
    	String temp0 = "/image/";
        if (IsLandUI.currentHouse.getLevelOfHouse() < 2) {
        	String temp1 = "/houseLv1.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 2 && IsLandUI.currentHouse.getLevelOfHouse() <= 3) {
        	String temp1 = "/houseLv2.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 4 && IsLandUI.currentHouse.getLevelOfHouse() <= 6) {
        	String temp1 = "/houseLv4.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 7 && IsLandUI.currentHouse.getLevelOfHouse() <= 9) {
        	String temp1 = "/houseLv7.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 10 && IsLandUI.currentHouse.getLevelOfHouse() <= 12) {
        	String temp1 = "/houseLv10.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 13 && IsLandUI.currentHouse.getLevelOfHouse() <= 15) {
        	String temp1 = "/houseLv13.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() == 16 || IsLandUI.currentHouse.getLevelOfHouse() == 17) {
        	String temp1 = "/houseLv16.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
        if (IsLandUI.currentHouse.getLevelOfHouse() >= 18) {
        	String temp1 = "/houseLv18+.png";
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 0) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "myHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 1) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "allyHouse" + temp1)));
        	if (IsLandUI.currentHouse.getTypeOfHouse() == 2) 
        		IsLandUI.currentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource(temp0 + "enemyHouse" + temp1)));
        }
		IsLandUI.currentButton.setVisible(true);
    }
    

    //Show the HouseInfoUI dialog
    public void showWindow() {
        this.setSize(800, 700);
        setUndecorated(true);
        this.setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //pnTranparent.setOpaque(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setVisible(true);
    }
}
