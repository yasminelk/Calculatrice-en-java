package calculatrice.Controller;

import javax.swing.*;
import java.awt.event.*;
import calculatrice.View.CalculatriceSimple;
import calculatrice.View.Affichage;

public class CalcEventClear implements ActionListener{
	private JTextArea afficheur;
	private Affichage affManagement;

	public CalcEventClear(JFrame fen){
		afficheur=((CalculatriceSimple)fen).getAfficheur();
		affManagement=((CalculatriceSimple)fen).getAfficheurManager();
	}

	public void actionPerformed(ActionEvent e){
		afficheur.setText(affManagement.clearText(afficheur.getText()));
		afficheur.requestFocus();
	}
}