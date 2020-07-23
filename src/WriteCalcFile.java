package calculatrice.Model;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.io.IOException;

public class WriteCalcFile{
	private String path;
	
	public WriteCalcFile(String filePath){
		path=filePath;
	}

	public void write(String text){
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path),Charset.forName("UTF-8"))) {
		    writer.write(text, 0, text.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
}