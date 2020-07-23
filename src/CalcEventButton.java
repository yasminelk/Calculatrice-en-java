package calculatrice.Controller;

import javax.swing.*;
import java.awt.event.*;
import calculatrice.View.CalculatriceSimple;
import calculatrice.View.Affichage;

public class CalcEventButton implements ActionListener{
	private JTextArea afficheur;
	private Affichage affManagement;

	public CalcEventButton(JFrame fen){
		afficheur=((CalculatriceSimple)fen).getAfficheur();
		affManagement=((CalculatriceSimple)fen).getAfficheurManager();
	}
	

	public void actionPerformed(ActionEvent e){
		
		String ope;
		if(e.getActionCommand()!="^x")
			ope=e.getActionCommand();
		else
			ope="^";
		afficheur.setText(affManagement.addText(afficheur.getText(),ope,false));
		afficheur.requestFocus();
	}
}