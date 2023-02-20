package controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Employee;
import dao.EmployeeDao;

public class FindEmpAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 EmployeeDao dao = new EmployeeDao();
			ResultSet rsv = dao.listemp();
			List list = new ArrayList();
			while (rsv.next()) {
				System.out.println(rsv.getString(2));
				String id = rsv.getString(1);
				String name = rsv.getString(2);
				String dob = rsv.getString(3);
				String manager = rsv.getString(4);
				String location = rsv.getString(5);
				String email = rsv.getString(6);
				String jobtype = rsv.getString(7);
				Employee ef = new Employee();
				ef.setId(id);
				ef.setName(name);
				ef.setDob(dob);
				ef.setLocation(location);
				ef.setManager(manager);
				ef.setEmail(email);
				ef.setJobtype(jobtype);
				list.add(ef);
			}
			request.setAttribute("reslist", list);
			return mapping.findForward("listemp");
			}


}
