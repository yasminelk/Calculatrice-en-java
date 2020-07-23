package calculatrice.Model;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.Observable;
import java.lang.Math.*;
import java.lang.Double;

public class ModeleCalcul extends Observable{
	private String expression,res;

	public void setExpression(String _expression){
		expression=_expression;
	}

	public void compute(){
		try{
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			expression=getOperation(expression,engine);
			res=engine.eval(expression).toString();
	        setChanged();
			notifyObservers(res);
		}
		catch(NullPointerException pe){
			setChanged();
			notifyObservers("Syntax error");
		}
		catch(ScriptException se){
			setChanged();
			notifyObservers("Syntax error");
		}
	}

	private String getOperation(String expression, ScriptEngine engine){
		try{
			if(expression.contains("π"))
				expression=expression.replaceAll("π",Math.PI+"");
			if(expression.contains("\u0435"))
				expression=expression.replaceAll("\u0435",Math.E+"");

			if(expression.contains("x!")){
				expression=expression.replaceAll("x!","");
				expression=factorielle(engine.eval(expression).toString())+"";
			}

			if(expression.contains("%")){
				expression=expression.replaceAll("%","");
				String operations=expression.replaceAll("[0-9.\\(\\)]",""); //Récupération de l'ensemble des termes d'opération de la chaine de caractère
				String dernOp=operations.substring(operations.length()-1);//Récupère la dernière opération
				int dernop=expression.lastIndexOf(dernOp); 
				String pourcentage=expression.substring(dernop+1).replaceAll("\\)","");//Terme de pourcentage

				if("*/".contains(dernOp)){
					String operandeGauche=engine.eval(expression.substring(0,dernop)+")").toString();
					String operandeDroite=engine.eval(pourcentage+"/100").toString();
					expression=operandeGauche+dernOp+operandeDroite;
				}
				else{
					String operandeGauche=engine.eval(expression.substring(0,dernop)+")").toString();
					String operandeDroite=engine.eval(pourcentage+"/100").toString();
					expression=operandeGauche+dernOp+operandeGauche+"*"+operandeDroite;
				}
			}

			if(expression.contains("^")){
				String[] operandes = expression.split("\\^");
				if(operandes.length>2){
					expression="**"; //On génère une erreur pour ne pas calculer une puissance contenue dans une autre
				}
				else
					expression=engine.eval("Math.pow("+operandes[0]+","+operandes[1]+")").toString();
			}

			if(expression.contains(new String("\u221a"))){
				expression=expression.replaceAll(new String("\u221a"),"");
				expression=Math.sqrt(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("≡")){
				expression=expression.replaceAll("≡","%");
			}

			if(expression.contains("ln")){
				expression=expression.replaceAll("ln","");
				expression=Math.log(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("log")){
				expression=expression.replaceAll("log","");
				expression=Math.log10(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("cos")){
				expression=expression.replaceAll("cos","");
				expression=Math.cos(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("sin")){
				expression=expression.replaceAll("sin","");
				expression=Math.sin(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("tan")){
				expression=expression.replaceAll("tan","");
				expression=Math.tan(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("abs")){
				expression=expression.replaceAll("abs","");
				expression=Math.abs(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("C→F")){
				expression=expression.replaceAll("C→F","");
				Double c=Double.parseDouble(engine.eval(expression).toString());
				Double f=c*1.8+32;
				expression=f+"";
			}

			if(expression.contains("F→C")){
				expression=expression.replaceAll("F→C","");
				Double f=Double.parseDouble(engine.eval(expression).toString());
				Double c=(f-32)/1.8;
				expression=c+"";
			}

			if(expression.contains("rad\u2192")){
				expression=expression.replaceAll("rad\\→deg","");
				expression=Math.toDegrees(Double.parseDouble(engine.eval(expression).toString()))+"";
			}

			if(expression.contains("deg\u2192")){
				expression=expression.replaceAll("deg\\→rad","");
				expression=Math.toRadians(Double.parseDouble(engine.eval(expression).toString()))+"";
			}
			return expression;
		}
		catch(ScriptException se){
			return "";
		}
	}

	private double factorielle(String exp){
		double x= Double.parseDouble(exp);
		if(x==0)
			return 1;

		double fact=1;

		for(double i=1;i<=x;i++)
			fact*=i;
		return fact;
	}
}