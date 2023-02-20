package controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.LoginForm;
import dao.LoginDao;

public class LoginController extends Action{
	static final Logger LOGGER = Logger.getLogger("LoginController.class");
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm lf=(LoginForm) form;
		HttpSession session=request.getSession();
		session.setAttribute("username",lf.getUsername());
		LOGGER.info("Start LoginController");
		
		
		  LOGGER.info("Login form UserName:"+lf.getUsername());
		  LOGGER.info("Login form password:"+lf.getPassword());
		 
		 
		
		// System.out.println(request.getSession().getAttribute("username"));
		LoginDao dao=new LoginDao();
		boolean b=dao.validate(lf);
		if(b==true) {
			
			return mapping.findForward("home");
		}
		else	
			request.setAttribute("invaliddata","  Authentication Failed" );
		LOGGER.info("End LoginController");
			return mapping.findForward("login");
	}
	
}