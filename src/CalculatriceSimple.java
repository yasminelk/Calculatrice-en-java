package calculatrice.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import calculatrice.Controller.*;
import calculatrice.Model.ModeleCalcul;



public class CalculatriceSimple extends JFrame{
	private JTextArea aff=new JTextArea();
	private Affichage affManag = new Affichage();
	private ModeleCalcul model;
	private JButton _0 = new JButton("0");
	private JButton _1 = new JButton("1");
	private JButton _2 = new JButton("2");
	private JButton _3 = new JButton("3");
	private JButton _4 = new JButton("4");
	private JButton _5 = new JButton("5");
	private JButton _6 = new JButton("6");
	private JButton _7 = new JButton("7");
	private JButton _8 = new JButton("8");
	private JButton _9 = new JButton("9");
	private JButton _coma = new JButton(".");
	private JButton _res = new JButton("=");
	private JButton _add = new JButton("+");
	private JButton _sou = new JButton("-");
	private JButton _mul = new JButton("*");
	private JButton _div = new JButton("/");
	private JButton _cl = new JButton("C");
	private JPanel pane = new JPanel(new GridBagLayout());
	private JMenuBar menu = new JMenuBar();
	private JMenu menuEdit = new JMenu("Édition");
	private JMenuItem menuRest = new JMenuItem("Importer");
	private JMenuItem menuExp = new JMenuItem("Exporter");
	private JMenu menuMode = new JMenu("Mode");
	private JMenuItem menuISimple = new JMenuItem("Simple");
	private JMenuItem menuISc = new JMenuItem("Scientifique");
	private JMenu menuAbout = new JMenu("?");
	private JMenuItem menuIAbout = new JMenuItem("À propos");

	public CalculatriceSimple(String titre,ModeleCalcul mc){
		super(titre);
		model=mc;
		setJMenuBar(menu);
        setMinimumSize(new Dimension(300,200));
        setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		menu.add(menuEdit);
		menuEdit.add(menuRest);
		menuRest.addActionListener(new CalcEventImport(CalculatriceSimple.this,"1",aff));
		menuEdit.add(menuExp);
		menuExp.addActionListener(new CalcEventImport(CalculatriceSimple.this,"0",aff));
		menu.add(menuMode);
		menuMode.add(menuISimple);
		menuISimple.addActionListener(new CalcEventMode(CalculatriceSimple.this));
		menuMode.add(menuISc);
		menuISc.addActionListener(new CalcEventMode(CalculatriceSimple.this));
		menu.add(menuAbout);
		menuAbout.add(menuIAbout);
		menuIAbout.addActionListener(new CalcEventAbout(CalculatriceSimple.this));

		aff.setEditable(false);
		aff.setColumns(50);
		aff.setRows(3);

		add(new JScrollPane(aff,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.PAGE_START);
		aff.requestFocusInWindow();
		aff.addKeyListener(new CalcEventShortcut(CalculatriceSimple.this,mc));
		
		add(pane,BorderLayout.CENTER);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.fill = GridBagConstraints.BOTH;
		pane.add(_7,c);
		_7.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=1;
		pane.add(_8,c);
		_8.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=2;
		pane.add(_9,c);
		_9.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=3;
		pane.add(_div,c);
		_div.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=0;
		c.gridy=1;
		pane.add(_4,c);
		_4.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=1;
		pane.add(_5,c);
		_5.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=2;
		pane.add(_6,c);
		_6.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=3;
		pane.add(_mul,c);
		_mul.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=0;
		c.gridy=2;
		pane.add(_1,c);
		_1.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=1;
		pane.add(_2,c);
		_2.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=2;
		pane.add(_3,c);
		_3.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=3;
		pane.add(_sou,c);
		_sou.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=0;
		c.gridy=3;
		pane.add(_0,c);
		_0.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=1;
		pane.add(_coma,c);
		_coma.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=2;
		pane.add(_res,c);
		_res.addActionListener(new CalcEventRes(CalculatriceSimple.this,mc));

		c.gridx=3;
		pane.add(_add,c);
		_add.addActionListener(new CalcEventButton(CalculatriceSimple.this));

		c.gridx=0;
		c.gridy=4;
		c.gridwidth=4;
		pane.add(_cl,c);
		_cl.addActionListener(new CalcEventClear(CalculatriceSimple.this));

		pack();
		setVisible(true);
	}

	public CalculatriceSimple(String titre,int x,int y,String contenu,ModeleCalcul mc){
		this(titre,mc);
		setBounds(x,y,getWidth(),getHeight());
		aff.setText(contenu);
	}

	public JTextArea getAfficheur(){
		return aff;
	}

	public Affichage getAfficheurManager(){
		return affManag;
	}

	public ModeleCalcul getModel(){
		return model;
	}

	public JPanel getCalcPane(){
		return pane;
	}
}