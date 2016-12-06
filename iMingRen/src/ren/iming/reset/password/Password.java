package ren.iming.reset.password;
/**
 * 自动密码生成
 * @author xiuyang
 * @version 1.0 2016年11月23日
 *
 */

public class Password {
	//初始化密码长度为9
	private int passwordNum = 9;
	
	public int getPasswordNum() {
		return passwordNum;
	}
	public void setPasswordNum(int passwordNum) {
		this.passwordNum = passwordNum;
	}
	/**
	 * 生成带有大小写字母和数字的密码
	 * @return 带有大小写字母加数字的密码
	 */
	public String getPassword(){
		StringBuilder sb = new StringBuilder();
		int key;
		for(int i = 0; i < passwordNum; i ++){
			key = (int)(Math.random()*3);
			switch (key) {
			case 0:
				sb.append(Integer.toString(getNum()));
				break;
			case 1:
				sb.append(getABC());
				break;
			case 2:
				sb.append(getabc());
				break;
			default:
				sb.append(getabc());
				break;
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	/**
	 * 获取一个随机的大写字母
	 * @return 返回一个随机的大写字母
	 */
	public char getABC(){
		return (char) ((Math.random()*26)+'A');
	}
	/**
	 * 获取一个随机的小写字母
	 * @return 返回一个随机的小写字母
	 */
	public char getabc(){
		return (char) ((Math.random()*26)+'a');
	}
	/**
	 * 获取一个随机的数字
	 * @return 返回一个随机的数字
	 */
	public int getNum(){
		return (int)(Math.random()*10);
	}
}
