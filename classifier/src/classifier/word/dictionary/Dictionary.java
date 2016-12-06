package classifier.word.dictionary;
/**
 * 
 * @���ߣ�������
 * @ʱ�䣺2016��5��30��22:01:17
 * @���ܣ��������Ͽ��ֵ䡣
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class Dictionary {
//	private String path = "./Data/out.txt";
	private String path = "./Data/dict02.txt";
	private File file;
	private FileInputStream fis;
	private InputStreamReader isr;
	private BufferedReader br;
	private HashMap<String, String> dic;
	public Dictionary(){
		init();
		
	}
	public Dictionary(String path){
		this.path = path;
		init();
	}
	public void init(){
		try {
			file = new File(path);
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			dic = new HashMap<String, String>();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�ֵ�װ��ʧ�ܣ�");
			e.printStackTrace();
		}
	}
	public HashMap<String, String> LoadDictionary(){
		String temp;
//		int n[] = new int[5];
		try {
			while((temp = br.readLine()) != null){
			
				String str[] = temp.split(" ");
					dic.put(str[0],str[1]);
//					System.out.println(str[0].charAt(0)%5);
/*					if(0 == str[0].charAt(0)%5){
						n[0]++;
					}else if(1 == str[0].charAt(0)%5){
						n[1]++;
					}else if(2 == str[0].charAt(0)%5){
						n[2]++;
					}else if(3 == str[0].charAt(0)%5){
						n[3]++;
					}else if(4 == str[0].charAt(0)%5){
						n[4]++;
					}*/
//				System.out.println(temp);
			}
			br.close();
			isr.close();
			fis.close();
	/*		for(int i = 0; i < 5; i++){
				System.out.println(i+"���ֵĴ���"+n[i]);
			}*/
			System.out.println("�ʵ�װ����ϣ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("��ȡ�ļ�����");
			e.printStackTrace();
		}
		return dic;
	}
	
	public static void main(String[] args) {
		Dictionary dic = new Dictionary();
		dic.LoadDictionary();
	}
}
