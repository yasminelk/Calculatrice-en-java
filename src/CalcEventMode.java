package calculatrice.Controller;

import java.awt.event.*;
import javax.swing.*;
import calculatrice.View.CalculatriceSimple;
import calculatrice.View.CalculatriceScientifique;

public class CalcEventMode implements ActionListener {
	private JFrame fen;

	public CalcEventMode(JFrame fene){
		fen=fene;
	}
	
	public void actionPerformed(ActionEvent e){
		
		if(fen instanceof CalculatriceScientifique && e.getActionCommand().equals("Simple")){
			fen.dispose();
			new CalculatriceSimple(fen.getTitle(),fen.getX(),fen.getY(),((CalculatriceScientifique)fen).getAfficheur().getText(),((CalculatriceScientifique)fen).getModel());
		}
		if(fen instanceof CalculatriceSimple && !(fen instanceof CalculatriceScientifique) && e.getActionCommand().equals("Scientifique")){
			fen.dispose();
			new CalculatriceScientifique(fen.getTitle(),fen.getX(),fen.getY(),((CalculatriceSimple)fen).getAfficheur().getText(),((CalculatriceSimple)fen).getModel());
		}
	}
}