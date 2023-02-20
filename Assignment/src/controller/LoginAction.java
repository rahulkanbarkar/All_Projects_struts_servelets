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

public class LoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm lf=(LoginForm) form;
		HttpSession session=request.getSession();
		session.setAttribute("userid", lf.getUserid());
		System.out.println(request.getSession().getAttribute("userid"));
		LoginDao dao=new LoginDao();
		boolean b=dao.validate(lf);
		if(b==true) {
			return mapping.findForward("home");
		}
		else	
			request.setAttribute("invaliddata","  Authentication failed" );
			return mapping.findForward("login");
	}
	
}