package ren.iming.service;
/**
 * 将token设置到内存中
 * @author xiuyang
 * @version 2016年11月27日 20:50:25
 */
import java.util.HashMap;
import ren.iming.model.Token;

public class TokenMap {
	private HashMap<String,Token> tokenMap;
	private static TokenMap instance = new TokenMap();
	
	private TokenMap(){
		tokenMap = new HashMap<String, Token>();
	}
	
	public static TokenMap getInstance(){
		return instance;
	}
	/**
	 * 设置Token到内存中
	 * @param token
	 */
	public void setToken(Token token){
		tokenMap.put(token.getToken(), token);
	}
	/**
	 * 从内存中获取相应的Token
	 * @param token
	 * @return
	 */
	public Token getToken(String tokenStr){
		return tokenMap.get(tokenStr);
	}
	
	public void remove(String tokenStr){
		tokenMap.remove(tokenStr);
	}
}
