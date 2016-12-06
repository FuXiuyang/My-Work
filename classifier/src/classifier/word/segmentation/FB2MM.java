package classifier.word.segmentation;
/**
 * 
 * @作者：付修杨
 * @时间：2016年5月30日22:10:59
 * @功能：实现双向最大匹配法
 */
import java.util.HashMap;
import java.util.Vector;

import classifier.word.dictionary.Dictionary;

public class FB2MM implements MM{
	private Vector<String> fmmList;
	private Vector<String> bmmList;
//	private HashMap<String, Integer> dic;
	private FMM fmm;
	private BMM bmm;
	public FB2MM(){
//		fmmList = new Vector<>();
//		bmmList = new Vector<>();
		fmm = new FMM();
		bmm = new BMM();
	}
/*	public FB2MM(HashMap<String,Integer> dic){
		this.dic = dic;
		fmm = new FMM(dic);
		bmm = new BMM(dic);
	}*/
	@Override
	public void setDic(HashMap<String, String> dic) {
		// TODO Auto-generated method stub
		fmm.setDic(dic);
		bmm.setDic(dic);
	}

	public void getList(String phrase){
		fmmList = fmm.segmentation(phrase);
		bmmList = bmm.segmentation(phrase);
/*		for(int i = 0; i < fmmList.size(); i++){
			System.out.print(fmmList.get(i)+" /");
		}
		System.out.println();
		for(int i = 0; i < fmmList.size(); i++){
			System.out.print(fmmList.get(i)+" /");
		}
		System.out.println();*/
	}
	@Override
	public Vector<String> segmentation(String phrase) {
		// TODO Auto-generated method stub
		getList(phrase);
		if(fmmList.size() != bmmList.size()){
			 //如果分词结果词数不相同，就取词数最少的那个
			if(fmmList.size() > bmmList.size()){
				return bmmList;
			}else{
				return fmmList;
			}
		}else{
			 //如果分词结果词数相同，就随便返回一个
		    int i ,FSingle = 0, BSingle = 0;
	        boolean isSame = true;
	        for(i = 0; i < fmmList.size();  i=i+2){
	        	if(!fmmList.get(i).equals(bmmList.get(i)))
	        		isSame = false;
	        	if(fmmList.get(i).length() ==1)
	        		FSingle +=1;
	        	if(bmmList.get(i).length() ==1)
	        		BSingle +=1;
	        }
	        if(isSame)
	        	return fmmList;
	        else{
	        //分词结果不同，返回其中单字较少的那个
	        	if(BSingle > FSingle)
	        		return fmmList;
	        	else return bmmList;
		      }
		}
	}
	public static void main(String[] args) {
		//测试方法
		FB2MM fb = new FB2MM();
		Dictionary dic = new Dictionary();
		fb.setDic(dic.LoadDictionary());
		String str = "他才来，许多人还不认识。";
/*		System.out.println(fb.segmentation(str).size());
		for(int i = 0 ; i < fb.segmentation(str).size() ; i ++){
			System.out.println(fb.segmentation(str).get(i));
		}*/
//		System.out.println(fb.segmentation(str).toString());
		fb.segmentation(str);
	}
}
