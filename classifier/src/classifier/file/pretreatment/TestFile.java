package classifier.file.pretreatment;
/**
 * 
 * @���ߣ�������
 * @ʱ�䣺2016��6��1��09:03:11
 * @���ܣ����ļ�ת�����ַ���
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
			System.out.println("�ļ���ȡʧ�ܣ�");
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
