package calculatrice.Controller;

import javax.swing.*;
import java.awt.event.*;
import calculatrice.View.CalculatriceSimple;
import calculatrice.View.Affichage;
import calculatrice.Model.ModeleCalcul;

public class CalcEventRes implements ActionListener{
	private JTextArea afficheur;
	private Affichage affManagement;
	private ModeleCalcul modele;

	public CalcEventRes(JFrame fen,ModeleCalcul mc){
		afficheur=((CalculatriceSimple)fen).getAfficheur();
		affManagement=((CalculatriceSimple)fen).getAfficheurManager();
		modele=mc;
	}

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("="))
			afficheur.setText(affManagement.compute(afficheur.getText(),modele));
		else{
			if(!affManagement.compute(afficheur.getText(),modele).equals("")){
				afficheur.setText(affManagement.addText(afficheur.getText(),e.getActionCommand(),true));
				afficheur.setText(affManagement.compute(afficheur.getText(),modele));
			}
		}
		afficheur.requestFocus();
	}
}