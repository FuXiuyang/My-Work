package ren.iming.action.user;
/**
 * 监控用户进入用户中心的活动
 * @author xiuyang
 */
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.jmx.snmp.SnmpUnknownSubSystemException;

public class UserInfoAction extends ActionSupport {
	/**
	 * 如果有session值,说明用户已经登陆了,可以进入用户中心,否则不能
	 * @return 
	 */
	public String userInfo(){
		if(ActionContext.getContext().getSession().get("tt") != null)
			return SUCCESS;
		return ERROR;
	}
	/**
	 * 用户查看账单时,进行检查过滤
	 * @return 如果用户已登陆,则返回success,否则返回error
	 */
	public String viewDeal(){
		if(ActionContext.getContext().getSession().get("tt") != null)
			return SUCCESS;
		return ERROR;
	}
	/**
	 * 用户修改密码是,进行检查过滤
	 * @return 如果用户已登陆,则返回success,否则返回error
	 */
	public String modifyPassword(){
		if(ActionContext.getContext().getSession().get("tt") != null)
			return SUCCESS;
		return ERROR;
	}
	
}
