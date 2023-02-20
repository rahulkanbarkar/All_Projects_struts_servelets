package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Employee;
import dao.EmployeeDao;

public class UpdateEmpAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Employee emp=(Employee) form;
		EmployeeDao dao=new EmployeeDao();
		int i=dao.save(emp);
		if(i!=0)
			return mapping.findForward("editform");
		else
			return mapping.findForward("fail");
	}
	

}
