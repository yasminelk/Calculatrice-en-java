import calculatrice.View.CalculatriceSimple;
import calculatrice.Model.ModeleCalcul;

public class Calculatrice{
	public static void main(String[] args){
		ModeleCalcul mc= new ModeleCalcul();
		new CalculatriceSimple("Calculatrice Swing using MVC",mc);
	}
}