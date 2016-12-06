package classifier.file.pretreatment;


import java.util.HashMap;

import classifier.word.dictionary.Dictionary;

public class ReadFileSentence {
	private TestFile file;
	private String fileString;
	private String path;
	//flag用于标记已经读取到文件的位子
	private int flag = 0;
	private int length = 0;
	private StringBuffer sentence;
	private Dictionary sentenceDic;
	private HashMap<String, String> dic;
	private String temp = "0";
	public ReadFileSentence(){
		init();
	}
	public ReadFileSentence(String path){
		this.path = path;
		file = new TestFile(path);
		fileString = file.LoadFile();
		length = fileString.length();
		init();
	}
	public void init(){
		sentence = new StringBuffer();
		sentenceDic = new Dictionary("./Data/punctuation.txt");
		dic = sentenceDic.LoadDictionary();
	}
	
	public void setFileString(String fileString) {
		this.fileString = fileString;
//		System.out.println(fileString+"READ");
		length = fileString.length();
		flag = 0;
	}
	public boolean SenOrNull(){
		if(dic.containsKey(temp)||temp == null){
			return true;
		}else{
			return false;
		}
	}
	public String getSentence(){
		if(flag < length){
			sentence.setLength(0);
			temp = fileString.substring(flag,flag+1);
			sentence.append(temp);
			flag ++;
			while(!SenOrNull()){
				if(flag < length){
					temp = fileString.substring(flag,flag+1);
					sentence.append(temp);
					flag ++;
				}else{
					break;
				}
			}
			return sentence.toString();
		}else{
			return null;
		}
	}
	public static void main(String[] args) {
//		ReadFileSentence rfs = new ReadFileSentence("./Data/text.txt");
		ReadFileSentence rfs = new ReadFileSentence();
		rfs.setFileString("你好啊，我是测试。");
		String str;
		while((str = rfs.getSentence()) != null){
			System.out.println(str);
		}
		
	}
}
