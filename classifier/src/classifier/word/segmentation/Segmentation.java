package classifier.word.segmentation;

import java.util.Date;
import java.util.Vector;

import classifier.file.pretreatment.*;
import classifier.word.dictionary.Dictionary;

public class Segmentation {
	private FB2MM fb;
	private Vector<String> list;
	private Vector<String> tempList;
	private Dictionary dic;
	private ReadFileSentence sentence;
	
	public Segmentation(){
		init();
	}
	public void init(){
		sentence = new ReadFileSentence();
		list = new Vector<>();
		tempList = new Vector<>();
		fb = new FB2MM();
		dic = new Dictionary();
		fb.setDic(dic.LoadDictionary());
	}
	public void resetDic(Dictionary dic){
		this.dic = dic;
		fb.setDic(dic.LoadDictionary());
	}
	public void setFileString(String fileString){
		sentence.setFileString(fileString);
	}
	public Vector<String> starSeg(){
		String temp;
		while((temp = sentence.getSentence()) != null){
//			System.out.println(temp);
			tempList = fb.segmentation(temp);
//			int length = tempList.size();
//			for(int i = length-1; i >=0; i --){
//				list.add(tempList.get(i));
//			}
			list.addAll(tempList);
		}
		return list;
	}
	public static void main(String[] args) {
		long olddate = System.currentTimeMillis();
		Segmentation seg = new Segmentation();
		Vector<String> list01 = new Vector<>();
		seg.setFileString("ÄãºÃ°¡£¬ÊÀ½ç£¡");
		list01 = seg.starSeg();
		for(int i = 0;i <list01.size(); i++){
			System.out.println(list01.get(i));
		}
		long newdate = System.currentTimeMillis();
		System.out.println((newdate-olddate));
	}
}
