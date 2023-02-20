package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
	private String userid,password;

	
	
	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors ae=new ActionErrors();
		if(userid.equals(""))
			ae.add("userid",new ActionMessage("msg1"));
		if(password.equals(""))
			ae.add("password",new ActionMessage("msg2"));
		return ae;
		
	}
	
	}

