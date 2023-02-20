package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.annotations.rules.AttributeCallParam.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.actions.MappingDispatchAction;

import beans.Admin;
import beans.Employee;
import dao.AdminDao;
import dao.EmployeeDao;

public class AddEmpAction extends DispatchAction {
	
//	@Override
//	protected Map getKeyMethodMap()
//	{
//		Map m=new HashMap();
//		m.put("empsave","empsave");
//		m.put("empupdate","empupdate");
//		m.put("empdelete","empdelete");
//		m.put("empfind","empfind");
//		m.put("empfinAll","empfindAll");
//		
//		return m;       
//	}
	
	
//	execute
//	based on parameter name it will call methods

	
	public ActionForward empsave(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		int i=dao.save(e);
		if(i!=0)
		return am.findForward("success");
		else
			return am.findForward("fail");
		
	}
	
	
	
	public ActionForward empupdate(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		boolean b=dao.update( e);
		if(b==true)
		return am.findForward("success");
		else 
			return am.findForward("fail");
	} 
	
	
	public ActionForward empdelete(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		boolean b=dao.delete(e);
		if(b==true)
		return am.findForward("success");
		else 
			return am.findForward("fail");


	}
	public ActionForward empfind(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		System.out.println("Hello Dao");
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		ResultSet rsv= dao.find(e);
		ArrayList list = new ArrayList();
		while (rsv.next()) {
			System.out.println(rsv.getString(2));
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String dob=rsv.getString(3);
			String manager=rsv.getString(4);
			String location=rsv.getString(5);
			String email = rsv.getString(6);
			String jobtype = rsv.getString(7);
			Employee ef = new Employee();
			ef.setId(id);
			ef.setName(name);
			ef.setDob(dob);
			ef.setManager(manager);
			ef.setLocation(location);
			ef.setEmail(email);
			ef.setJobtype(jobtype);
			list.add(ef);
		}
		req.setAttribute("list",list);
		return am.findForward("find");
		
	}
	
	
//	public ActionForward empfindbyname(ActionMapping am, ActionForm af, HttpServletRequest req,
//			HttpServletResponse res) throws Exception {
//		System.out.println("Hello Dao");
//		Employee e=(Employee) af;
//		EmployeeDao dao=new EmployeeDao();
//		java.util.List list= dao.findbyname(e);
//		req.setAttribute("list",list);
//		System.out.println(list);
//		return am.findForward("findbyname");
//		
//	}
	
	
	

	public ActionForward empfindAll(ActionMapping am, ActionForm af, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		Employee e=(Employee) af;
		EmployeeDao dao=new EmployeeDao();
		java.util.List list= dao.findAll(e);
		req.setAttribute("list",list);
		return am.findForward("findll");
		
	
}



}
	