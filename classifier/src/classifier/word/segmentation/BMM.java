package classifier.word.segmentation;
/**
 * 
 * @���ߣ�������
 * @ʱ�䣺2016��5��30��22:11:40
 * @���ܣ�ʵ���������ƥ�䷨
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
		//�ж�����Ƿ�������ִ���
		if(phrase.length()>=MAXLEN){
			return true;
		}else{
			return false;
		}
	}
	public void getTemp(String phrase){
		//�������������ִ�����temp�ͻ�����ִ���������ͽ����ȫ����ֵ��temp
		if(lenJGMax(phrase)){
			temp = phrase.substring(phrase.length()-MAXLEN);
		}else{
			temp = phrase;
		}
	}
	public boolean subTemp(){
		//temp�������1���Լ�1
		if(temp.length()>1){
			temp = temp.substring(1,temp.length());
			return true;
		}else{
			return false;
		}
	}
	public boolean tempIsWord(){
		//temp������ֵ��еĵ��ʾͷ�����
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
		// ��ʼ�ִ�
		
		getTemp(phrase);
		while(0!=phrase.length()){
			if(tempIsWord()){
				
				//temp���ֵ��еĴʻ㣬���ͼ�ȥtemp
				phrase = phrase.substring(0,phrase.length()-temp.length());
				getTemp(phrase);
			}else{
				if(!subTemp()){
					wordList.add(temp);
					//temp����Ϊ1������ʾ����һ���֣����ͼ�ȥtemp
					phrase = phrase.substring(0,phrase.length()-temp.length());
					getTemp(phrase);
				}
			}
		}
		return wordList;
	}
	
}
