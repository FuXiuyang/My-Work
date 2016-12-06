package ren.iming.service;
/**
 * 由服务层统一向用户提供获取和设置Token的服务.
 * @author xiuyang
 * @version 2016年11月26日 23:05:41
 */
import ren.iming.model.Token;

public class TokenService {
//	private Token token;
	private TokenMap tokenMap;
	
	public TokenService(){
		tokenMap = TokenMap.getInstance();
	}
/*	public TokenService(Token token){
		this();
		this.token = token;
	}
	*/
/*	public void setToken(){
		tokenMap.setToken(token);
	}*/
	/**
	 * 将Token设置到内存中
	 * @param token
	 */
	public void setToken(Token token){
		tokenMap.setToken(token);
	}
	/**
	 * 从内存中缓存的Token取出缓存
	 * @param token
	 * @return
	 */
	public Token getToken(String tokenStr){
		return tokenMap.getToken(tokenStr);
	}
	public void remove(String tokenStr){
		tokenMap.remove(tokenStr);
	}
	
	
}
