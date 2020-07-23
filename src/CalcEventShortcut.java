package calculatrice.Controller;

import javax.swing.*;
import java.awt.event.*;
import calculatrice.View.CalculatriceSimple;
import calculatrice.View.Affichage;
import calculatrice.Model.ModeleCalcul;

public class CalcEventShortcut extends KeyAdapter{
	private JFrame frame;
	private JTextArea afficheur;
	private String textToShow;
	private Affichage affManagement;
	private ModeleCalcul modele;

	public CalcEventShortcut(JFrame _frame,ModeleCalcul mc){
		frame=_frame;
		afficheur=((CalculatriceSimple)frame).getAfficheur();
		affManagement=((CalculatriceSimple)frame).getAfficheurManager();
		modele=mc;
	}

	public void keyTyped(KeyEvent e) {
		if((e.getKeyChar()+"").equals("c") || (e.getKeyChar()+"").equals("C") || (e.getKeyChar()+"").equals("\b")){
			afficheur.setText(affManagement.clearText(afficheur.getText()));
		}
		else{ 
			if((e.getKeyChar()+"").equals("=") || (e.getKeyChar()+"").equals("\n")){
				afficheur.setText(affManagement.compute(afficheur.getText(),modele));
			}
			else{
				if("1234567890+-*/.".contains(e.getKeyChar()+"")){
					afficheur.setText(affManagement.addText(afficheur.getText(),e.getKeyChar()+"",false));
				}
			}
		}		
	}

}