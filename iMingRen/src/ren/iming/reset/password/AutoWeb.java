package ren.iming.reset.password;
/**
 * 自动化打开浏览器,请求url,和自动填写和更改密码.
 * @author xiuyang
 * @version 1.0 2016年11月23日
 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoWeb {
	private WebDriver driver;
	private String setPwId;
	private String resetPwId;
	private String submitId;
	private String url;
	public AutoWeb(){
		driver=new FirefoxDriver();
	}
	public AutoWeb(String url){
//		System.setProperty("webdriver.firefox.bin", "D:\\mysoft\\Firefox\\firefox.exe");
		this();
		this.url = url;
	}
	
	public String getSetPwId() {
		return setPwId;
	}

	public void setSetPwId(String setPwId) {
		this.setPwId = setPwId;
	}

	public String getResetPwId() {
		return resetPwId;
	}

	public void setResetPwId(String resetPwId) {
		this.resetPwId = resetPwId;
	}

	public String getSubmitId() {
		return submitId;
	}

	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 重置密码
	 * @param password
	 */
	public void resetPassword(String password){
		driver.get(url);
		driver.manage().window().maximize();
		try{
			WebElement pw = driver.findElement(By.id(setPwId));
	        pw.clear();
	        pw.sendKeys(password);
	        
	        WebElement re_pw = driver.findElement(By.id(resetPwId));
	        re_pw.clear();
	        re_pw.sendKeys(password);
	        
	        WebElement submit = driver.findElement(By.id(submitId));
	        submit.click();
		}catch(Exception e){
			System.err.println("打开修改密码的连接出现了问题"+e);
		}finally{
			close();
		}
		
	}
	/**
	 * 判断更改密码是否成功
	 */
	public void hasSuccess(){
		String[] str = new String[driver.getWindowHandles().size()]; 
        driver.getWindowHandles().toArray(str);
        WebDriver childDriver = driver.switchTo().window(str[str.length-1]);
        System.out.println(childDriver.getCurrentUrl());
	}
	/**
	 * 关闭浏览器
	 */
	public void close(){
		driver.quit();
	}
}
