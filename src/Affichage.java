package calculatrice.View;

import calculatrice.Model.ModeleCalcul;
import java.util.Observable;
import java.util.Observer;

public class Affichage implements Observer{
	private String res="";
	
	public String clearText(String text){
		String[] lines = text.split("\\n");
		if(lines.length%2!=0)
			if(lines[lines.length-1].length()>=1)
				lines[lines.length-1]=lines[lines.length-1].substring(0,lines[lines.length-1].length()-1);

		String textOut="";
		for(int i=0;i<lines.length;i++){
			if(lines.length==1 || (lines.length%2!=0 && i==lines.length-1))
				textOut+=lines[i];
			else
				textOut+=lines[i]+"\n";
		}

		return textOut;
	}

	public String addText(String text, String textToAdd,boolean operation){
		String[] lines = text.split("\\n");
		String textOut="";

		if(operation){
			if(lines.length%2!=0){
				lines[lines.length-1]=textToAdd+"("+lines[lines.length-1]+")";
			}

			
			for(int i=0;i<lines.length;i++){
				if(lines.length==1 || (lines.length%2!=0 && i==lines.length-1))
					textOut+=lines[i];
				else
					textOut+=lines[i]+"\n";
			}

		}else{
			if(lines.length%2!=0){
				lines[lines.length-1]+=textToAdd;
			}
			else{
				String[] temp = new String [lines.length+1];
				for(int i=0;i<temp.length;i++)
					if(i<lines.length)
						temp[i]=lines[i];
					else
						temp[i]="";
				lines=temp;
				lines[lines.length-1]+=textToAdd;
			}
			
			for(int i=0;i<lines.length;i++){
				if(lines.length==1 || (lines.length%2!=0 && i==lines.length-1))
					textOut+=lines[i];
				else
					textOut+=lines[i]+"\n";
			}
			
		}
		return textOut;
	}

	private String getOperation(String text){
		String[] lines = text.split("\\n");
		if(lines.length%2!=0)
			return lines[lines.length-1];
		else
			return "";
	}

	public String compute(String text,ModeleCalcul mc){
		if(text.length()>=1){
			String exp=getOperation(text);
			if(exp.length()>=1){
				mc.setExpression(exp);
				mc.addObserver(this);
				mc.compute();
				return text+"\n= "+res+"\n";
			}
		}
		return text;
	}

	public void update(Observable o, Object arg){
		res=arg.toString();
	}
}