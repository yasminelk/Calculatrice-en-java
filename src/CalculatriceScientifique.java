package calculatrice.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import calculatrice.Controller.*;
import calculatrice.Model.ModeleCalcul;



public class CalculatriceScientifique extends CalculatriceSimple{
	private JTextArea aff;
	private ModeleCalcul model;
	private JLabel _blank = new JLabel(" ");
	private JButton _pi = new JButton("π");
	private JButton _euler = new JButton("\u0435");
	private JButton _fact = new JButton("x!");
	private JButton _expos = new JButton("^x");
	private JButton _sqrt = new JButton(new String("\u221a"));
	private JButton _ln = new JButton("ln");
	private JButton _log = new JButton("log");
	private JButton _cos = new JButton("cos");
	private JButton _sin = new JButton("sin");
	private JButton _tan = new JButton("tan");
	private JButton _mod = new JButton("≡");
	private JButton _abs = new JButton("abs");
	private JButton _convRD = new JButton("rad→deg");
	private JButton _convDR = new JButton("deg→rad");
	private JButton _convCF = new JButton("C→F");
	private JButton _convFC = new JButton("F→C");
	private JButton _pourc = new JButton("%");

	private JPanel pane;

	public CalculatriceScientifique(String titre,ModeleCalcul mc){
		super(titre,mc);
		pane=getCalcPane();
		model=getModel();
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;

		c.gridwidth=1;
		c.gridx=4;
		c.gridy=0;
		pane.add(_blank,c);

		c.gridwidth=1;
		c.gridx=5;
		c.gridy=0;
		pane.add(_pi,c);
		_pi.addActionListener(new CalcEventButton(CalculatriceScientifique.this));

		c.gridy=1;
		pane.add(_euler,c);
		_euler.addActionListener(new CalcEventButton(CalculatriceScientifique.this));

		c.gridy=2;
		pane.add(_fact,c);
		_fact.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=3;
		pane.add(_expos,c);
		_expos.addActionListener(new CalcEventButton(CalculatriceScientifique.this));

		c.gridy=4;
		pane.add(_mod,c);
		_mod.addActionListener(new CalcEventButton(CalculatriceScientifique.this));

		c.gridx=6;
		c.gridy=0;
		pane.add(_sqrt,c);
		_sqrt.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=1;
		pane.add(_ln,c);
		_ln.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=2;
		pane.add(_log,c);
		_log.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=3;
		pane.add(_pourc,c);
		_pourc.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridx=7;
		c.gridy=0;
		pane.add(_cos,c);
		_cos.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=1;
		pane.add(_sin,c);
		_sin.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=2;
		pane.add(_tan,c);
		_tan.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=3;
		pane.add(_abs,c);
		_abs.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridx=8;
		c.gridy=0;
		pane.add(_convRD,c);
		_convRD.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=1;
		pane.add(_convDR,c);
		_convDR.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=2;
		pane.add(_convCF,c);
		_convCF.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		c.gridy=3;
		pane.add(_convFC,c);
		_convFC.addActionListener(new CalcEventRes(CalculatriceScientifique.this,model));

		pack();
		setVisible(true);
	}

	public CalculatriceScientifique(String titre,int x, int y,String contenu,ModeleCalcul mc){
		this(titre,mc);
		setBounds(x,y,getWidth(),getHeight());
		getAfficheur().setText(contenu);
	}
}