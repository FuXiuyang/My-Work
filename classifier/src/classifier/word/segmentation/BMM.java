package classifier.word.segmentation;
/**
 * 
 * @作者：付修杨
 * @时间：2016年5月30日22:11:40
 * @功能：实现逆向最大匹配法
 */
import java.util.HashMap;
import java.util.Vector;

public class BMM implements MM {
	private Vector<String> wordList;
	private HashMap<String,String> dic;
	private String temp;
	public BMM(){
		wordList = new Vector<>();
	}
/*	public BMM(HashMap<String, Integer> dic){
		this.dic = dic;
	}*/
	public void setDic(HashMap<String, String> dic) {
		// TODO Auto-generated method stub
		this.dic = dic;
	}

	public boolean lenJGMax(String phrase){
		//判断语句是否大于最大分词数
		if(phrase.length()>=MAXLEN){
			return true;
		}else{
			return false;
		}
	}
	public void getTemp(String phrase){
		//语句如果大于最大分词数，temp就获得最大分词数，否则就将语句全部赋值给temp
		if(lenJGMax(phrase)){
			temp = phrase.substring(phrase.length()-MAXLEN);
		}else{
			temp = phrase;
		}
	}
	public boolean subTemp(){
		//temp如果大于1就自减1
		if(temp.length()>1){
			temp = temp.substring(1,temp.length());
			return true;
		}else{
			return false;
		}
	}
	public boolean tempIsWord(){
		//temp如果是字典中的单词就返回真
		if(dic.containsKey(temp)){
			wordList.add(temp);
			wordList.add(dic.get(temp));
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Vector<String> segmentation(String phrase) {
		wordList.clear();
		// 开始分词
		
		getTemp(phrase);
		while(0!=phrase.length()){
			if(tempIsWord()){
				
				//temp是字典中的词汇，语句就减去temp
				phrase = phrase.substring(0,phrase.length()-temp.length());
				getTemp(phrase);
			}else{
				if(!subTemp()){
					wordList.add(temp);
					//temp长度为1，即表示就是一个字，语句就减去temp
					phrase = phrase.substring(0,phrase.length()-temp.length());
					getTemp(phrase);
				}
			}
		}
		return wordList;
	}
	
}
