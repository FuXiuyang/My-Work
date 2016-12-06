package classifier.file.pretreatment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SaveFile {
	private FileOutputStream fos;
	private OutputStreamWriter osw;
	private BufferedWriter bw;
	private String fileString;
	
	
	public SaveFile(File file,String fileString){
		try {
			this.fileString = fileString;
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void saveFile(){
		try {
			bw.write(fileString);
			bw.close();
			osw.close();
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		File file = new File("./Data/test.txt");
		String fileString = "hello world!";
		SaveFile sf = new SaveFile(file, fileString);
		sf.saveFile();
	}
}
