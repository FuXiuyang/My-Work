package classifier.file.pretreatment;
/**
 * 
 * @作者：付修杨
 * @时间：2016年6月1日09:03:11
 * @功能：将文件转化成字符串
 */
import java.io.*;

public class TestFile {
	private File file;
	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader br;
	private StringBuffer fileString;
	public TestFile(String path){
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			fileString = new StringBuffer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("文件读取失败！");
			e.printStackTrace();
		}
		
	}
	public String LoadFile(){
		String temp;
		try {
			while((temp = br.readLine()) != null){
				fileString.append(temp);
			}
			br.close();
			isr.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileString.toString();
	}
	public static void main(String[] args) {
		TestFile tf = new TestFile("./Data/out.txt");
		System.out.println(tf.LoadFile());
	}
	
}
