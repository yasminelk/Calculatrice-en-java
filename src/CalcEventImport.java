package calculatrice.Controller;

import javax.swing.filechooser.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import calculatrice.Model.ReadCalcFile;
import calculatrice.Model.WriteCalcFile;

public class CalcEventImport implements ActionListener{
	private JFrame frame;
	private String opt;
	private JTextArea afficheur;

	public CalcEventImport(JFrame _frame,String _opt,JTextArea aff){
		frame=_frame;
		opt=_opt;
		afficheur=aff;
	}

	public void actionPerformed(ActionEvent e){
		JFileChooser fco = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "Fichiers calc (*.calc)", "calc");
        fco.setFileFilter(filter);
        fco.setAcceptAllFileFilterUsed(false);
        fco.setFileSelectionMode(JFileChooser.FILES_ONLY);

		if(opt.equals("1")){
			fco.showOpenDialog(frame);
			if(fco.getSelectedFile()!=null){
				File fichierSelect = fco.getSelectedFile();
				if(fichierSelect.exists() && fichierSelect.canRead()){
					ReadCalcFile rf=new ReadCalcFile(fichierSelect.getAbsolutePath());
					afficheur.setText(rf.read());
					fco.setSelectedFile(null);
				}
			}
		}
		else{
			fco.showSaveDialog(frame);
			if(fco.getSelectedFile()!=null){
				WriteCalcFile wf;
				if(fco.getSelectedFile().getAbsolutePath().contains(".calc")){
					wf = new WriteCalcFile(fco.getSelectedFile().getAbsolutePath());
				}
				else{
					wf = new WriteCalcFile(fco.getSelectedFile().getAbsolutePath()+".calc");
				}
				wf.write(afficheur.getText());
				fco.setSelectedFile(null);
			}
		}
	}
}