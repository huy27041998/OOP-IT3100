/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;
import ui.MyJButtonFlag;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.House;
import javax.swing.JScrollPane;

/**
 *
 * @author Dat Ngo
 */
public class IsLandUI extends JFrame{
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btnWaveAttack;
    JTextField txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17;
    JLabel lblIsLand;
    public static JComboBox timeSkip;
    public static WaveAttackUI waveAttackPanel;
    public static JButton currentButton;
    public static House currentHouse;
    public static JTextField currentTextField;
    public HouseInfoUI houseInfoUI;
    public static House[] house;
    public static House myHouse;
    public static BattleFieldFightingUI bffUI;
    public IsLandUI(String title){
    	
        super(title);
        setBounds(0, 100, 1400, 900);
        house = new House[18];
        currentHouse = new House();
        currentButton = new JButton();
        for(int i=1; i<18; i++){
            house[i] = new House();
            house[i].setName("Ikariam"+i);
            house[i].setId(i);
        }
            
        houseInfoUI = new HouseInfoUI();
        addControls();
        addEvents();
    }
    
    public void addControls(){
        Container con = getContentPane();
        JPanel pnMain = new JPanel();
        pnMain.setLayout(null);
        con.add(pnMain);
        btn1 = new MyJButtonFlag();
        btn1.setBounds(241, 266, 60, 60);
	    txt1 = new JTextField();
	    txt1.setBounds(235, 338, 60, 17);
	    txt1.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt1.setEditable(false);
	    txt1.setVisible(false);
	    txt1.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(btn1);
	    pnMain.add(txt1);
	    btn2 = new MyJButtonFlag();
	    btn2.setBounds(386, 287, 60, 60);
	    txt2 = new JTextField();
	    txt2.setBounds(386, 359, 60, 17);
	    txt2.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt2.setEditable(false);
	    txt2.setVisible(false);
	    txt2.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt2);
	    pnMain.add(btn2);
	    btn3 = new MyJButtonFlag();
	    btn3.setBounds(497, 220, 60, 60);
	    txt3 = new JTextField();
	    txt3.setBounds(497, 292, 60, 17);
	    txt3.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt3.setEditable(false);
	    txt3.setVisible(false);
	    txt3.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt3);
	    pnMain.add(btn3);
	    btn4 = new MyJButtonFlag();
	    btn4.setBounds(659, 137, 60, 60);
	    txt4 = new JTextField();
	    txt4.setBounds(659, 212, 60, 17);
	    txt4.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt4.setEditable(false);
	    txt4.setVisible(false);
	    txt4.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt4);
	    pnMain.add(btn4);
	    btn5 = new MyJButtonFlag();
	    btn5.setBounds(1059, 185, 60, 60);
	    txt5 = new JTextField();
	    txt5.setBounds(1059, 266, 60, 17);
	    txt5.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt5.setEditable(false);
	    txt5.setVisible(false);
	    txt5.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt5);
	    pnMain.add(btn5);
	    btn6 = new MyJButtonFlag();
	    btn6.setBounds(900, 123, 60, 60);
	    txt6 = new JTextField();
	    txt6.setBounds(900, 198, 60, 17);
	    txt6.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt6.setEditable(false);
	    txt6.setVisible(false);
	    txt6.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt6);
	    pnMain.add(btn6);
	    btn7 = new MyJButtonFlag();
	    btn7.setBounds(188, 370, 60, 60);
	    txt7 = new JTextField();
	    txt7.setBounds(188, 443, 60, 17);
	    txt7.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt7.setEditable(false);
	    txt7.setVisible(false);
	    txt7.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt7);
	    pnMain.add(btn7);
	    btn8 = new MyJButtonFlag();
	    btn8.setBounds(153, 557, 60, 60);
	    txt8 = new JTextField();
	    txt8.setBounds(153, 639, 60, 17);
	    txt8.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt8.setEditable(false);
	    txt8.setVisible(false);
	    txt8.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt8);
	    pnMain.add(btn8);
	    btn9 = new MyJButtonFlag();
	    btn9.setBounds(465, 592, 60, 60);
	    txt9 = new JTextField();
	    txt9.setBounds(465, 664, 60, 17);
	    txt9.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt9.setEditable(false);
	    txt9.setVisible(false);
	    txt9.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt9);
	    pnMain.add(btn9);
	    btn10 = new MyJButtonFlag();
	    btn10.setBounds(310, 624, 60, 60);
	    txt10 = new JTextField();
	    txt10.setBounds(310, 698, 60, 17);
	    txt10.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt10.setEditable(false);
	    txt10.setVisible(false);
	    txt10.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt10);
	    pnMain.add(btn10);
	    btn11 = new MyJButtonFlag();
	    btn11.setBounds(527, 716, 60, 60);
	    txt11 = new JTextField();
	    txt11.setBounds(527, 788, 60, 17);
	    txt11.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt11.setEditable(false);
	    txt11.setVisible(false);
	    txt11.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt11);
	    pnMain.add(btn11);
	    btn12 = new MyJButtonFlag();
	    btn12.setBounds(835, 664, 60, 60);
	    txt12 = new JTextField();
	    txt12.setBounds(835, 736, 60, 17);
	    txt12.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt12.setEditable(false);
	    txt12.setVisible(false);
	    txt12.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt12);
	    pnMain.add(btn12);
	    btn13 = new MyJButtonFlag();
	    btn13.setBounds(992, 592, 60, 60);
	    txt13 = new JTextField();
	    txt13.setBounds(992, 680, 60, 17);
	    txt13.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt13.setEditable(false);
	    txt13.setVisible(false);
	    txt13.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt13);
	    pnMain.add(btn13);
	    btn14 = new MyJButtonFlag();
	    btn14.setBounds(1154, 557, 60, 60);
	    txt14 = new JTextField();
	    txt14.setBounds(1143, 647, 60, 17);
	    txt14.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt14.setEditable(false);
	    txt14.setVisible(false);
	    txt14.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt14);
	    pnMain.add(btn14);
	    btn15 = new MyJButtonFlag();
	    btn15.setBounds(1143, 443, 60, 60);
	    txt15 = new JTextField();
	    txt15.setBounds(1143, 515, 60, 17);
	    txt15.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt15.setVisible(false);
	    txt15.setVisible(false);
	    txt15.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt15);
	    pnMain.add(btn15);
	    btn16 = new MyJButtonFlag();
	    btn16.setBounds(1118, 329, 60, 60);
	    txt16 = new JTextField();
	    txt16.setBounds(1118, 401, 60, 17);
	    txt16.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt16.setEditable(false);
	    txt16.setVisible(false);
	    txt16.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt16);
	    pnMain.add(btn16);
	    btn17 = new MyJButtonFlag();
	    btn17.setBounds(935, 329, 60, 60);
	    txt17 = new JTextField();
	    txt17.setBounds(935, 411, 60, 17);
	    txt17.setFont(new Font(Font.SERIF, Font.BOLD, 11));
	    txt17.setEditable(false);
	    txt17.setVisible(false);
	    txt17.setHorizontalAlignment(JTextField.CENTER);
	    pnMain.add(txt17);
	    pnMain.add(btn17);
	    btnWaveAttack = new JButton("");
	    btnWaveAttack.setBounds(1094, 12, 70, 100);
	    btnWaveAttack.setOpaque(false);
	    btnWaveAttack.setContentAreaFilled(false);
	    btnWaveAttack.setBorder(null);
	    pnMain.add(btnWaveAttack);
        timeSkip = new JComboBox();
        timeSkip.setFont(new Font("Tahoma", Font.PLAIN, 14));
        timeSkip.setModel(new DefaultComboBoxModel(new String[] {"1", "3", "5", "10", "15", "25", "30", "50"}));
        timeSkip.setSelectedIndex(0);
        timeSkip.setSize(107, 26);
        pnMain.add(timeSkip);
        lblIsLand = new JLabel();
        lblIsLand.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/island1.jpg")));
        pnMain.add(lblIsLand);
        lblIsLand.setBounds(0, 0, 1400, 900);
        
    }
    
    public void addEvents(){
        btnWaveAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(myHouse!=null) {
                    waveAttackPanel = new WaveAttackUI("WaveAttack", myHouse.getSentRealArmy(), myHouse.getSendingArmy(), myHouse.getSendingBackArmy());
                	waveAttackPanel.setVisible(true);
                }
                	
            }
        });
        
        
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[1];
                currentButton = btn1;
                currentTextField = txt1;
                houseInfoUI.showWindow();
            }
        });
        
        
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[2];
                currentButton = btn2;
                currentTextField = txt2;
                houseInfoUI.showWindow();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[3];
                currentButton = btn3;
                currentTextField = txt3;
                houseInfoUI.showWindow();
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[4];
                currentButton = btn4;
                currentTextField = txt4;
                houseInfoUI.showWindow();
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[5];
                currentButton = btn5;
                currentTextField = txt5;
                houseInfoUI.showWindow();
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[6];
                currentButton = btn6;
                currentTextField = txt6;
                houseInfoUI.showWindow();
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[7];
                currentButton = btn7;
                currentTextField = txt7;
                houseInfoUI.showWindow();
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[8];
                currentButton = btn8;
                currentTextField = txt8;
                houseInfoUI.showWindow();
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[9];
                currentButton = btn9;
                currentTextField = txt9;
                houseInfoUI.showWindow();
            }
        });
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[10];
                currentButton = btn10;
                currentTextField = txt10;
                houseInfoUI.showWindow();
            }
        });
        btn11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[11];
                currentButton = btn11;
                currentTextField = txt11;
                houseInfoUI.showWindow();
            }
        });
        btn12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[12];
                currentButton = btn12;
                currentTextField = txt12;
                houseInfoUI.showWindow();
            }
        });
        btn13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[13];
                currentButton = btn13;
                currentTextField = txt13;
                houseInfoUI.showWindow();
            }
        });
        btn14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[14];
                currentButton = btn14;
                currentTextField = txt14;
                houseInfoUI.showWindow();
            }
        });
        btn15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[15];
                currentButton = btn15;
                currentTextField = txt15;
                houseInfoUI.showWindow();
            }
        });
        btn16.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[16];
                currentButton = btn16;
                currentTextField = txt16;
                houseInfoUI.showWindow();
            }
        });
        btn17.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentHouse = house[17];
                currentButton = btn17;
                currentTextField = txt17;
                houseInfoUI.showWindow();
            }
        });
    }
    
    public void showWindow(){
        setSize(1400, 900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }          
}
