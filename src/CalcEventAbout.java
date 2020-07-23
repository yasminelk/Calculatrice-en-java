package calculatrice.Controller;

import javax.swing.*;
import java.awt.event.*;

public class CalcEventAbout implements ActionListener{
	private JFrame frame;

	public CalcEventAbout(JFrame calc){
		frame=calc;
	}
	public void actionPerformed(ActionEvent e){
        JOptionPane.showMessageDialog(frame, "Travail réalisé par Michaël Favel-Guidet. \nMaster 2 STIM\n© 2015","À propos de ce logiciel",JOptionPane.INFORMATION_MESSAGE);
      }
}