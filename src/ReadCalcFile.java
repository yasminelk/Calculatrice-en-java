package calculatrice.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCalcFile{
	private String path;
	private BufferedReader br;

	public ReadCalcFile(String filePath){
		path=filePath;
	}

	public String read(){
		String calculs="";
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));

			while ((sCurrentLine = br.readLine()) != null) {
				calculs+=sCurrentLine+"\n";
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return calculs;
	}
}