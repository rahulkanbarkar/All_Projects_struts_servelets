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

public class SelectAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Employee e=(Employee) form;
		EmployeeDao dao = new EmployeeDao();
		String idselected=request.getParameter("idSelected");
		System.out.println("idSelected"+idselected);
		ResultSet rsv=dao.find(Integer.parseInt(idselected));
		List<Employee> list=new ArrayList<Employee>();
		while(rsv.next()) {
			System.out.println(rsv.getString(2));
			int id=rsv.getInt(1);
			String name=rsv.getString(2);
			String email=rsv.getString(3);
			String gender=rsv.getString(4);
			String username=rsv.getString(5);
			String password=rsv.getString(6);
			Employee ef=new Employee();
			ef.setId(id);
			ef.setName(name);
			ef.setEmail(email);
			ef.setGender(gender);
			ef.setUsername(username);
			ef.setPassword(password);
			list.add(ef);
		}
		request.setAttribute("updatelist",list);
		return mapping.findForward("updatedelete");
	}}