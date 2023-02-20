package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.RequestContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import beans.Employee;
import beans.ExcelCreator;
import dao.EmployeeDao;

public class EmpCrudController extends DispatchAction {
	static final Logger LOGGER = Logger.getLogger("EmpCrudController.class");
	public RequestContext req;
	public ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		ResultSet rsv =null;
		Employee e = (Employee) af;
		LOGGER.info("Start EmCrudController");
		EmployeeDao dao = new EmployeeDao();
		int i = dao.save(e);
		if (i != 0)
			return am.findForward("success");
		else
			return am.findForward("fail");
	}
	
	public ActionForward importTextFile(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		EmployeeDao dao11 = new EmployeeDao();
		ResultSet rsv1 = dao11.findAll();
		List list11 =new ArrayList();
	while (rsv1.next()) {
		
		String email = rsv1.getString("email");
		System.out.println(email);
		
		 Employee e1 = new Employee();
		
		e1.setEmail(email);	
		list11.add(email);

	}
		
		int i=0;
		  File file = new File(
		            "C:\\Users\\a856947\\Documents\\UserDetails.xls");
		  String fwd = null;
		  Employee e = (Employee) af;
		        // Note:  Double backquote is to avoid compiler
		        // interpret words
		        // like \test as \t (ie. as a escape sequence)
		 
		        // Creating an object of BufferedReader class
		        BufferedReader br
		            = new BufferedReader(new FileReader(file));
		 
		        // Declaring a string variable
		        int id = getInt(0);
		        String st;
		        String name = null;
		    	String email = null;
		    	String gender = null;
		    	String username = null;
		    	String password = null;
		        // Condition holds true till
		        // there is character in a string
		        while ((st = br.readLine()) != null) {
		         String arr[]=st.split("/");
		        for(String str:arr) {
		        	
		        	String[] arr1=str.split(",");
		        	
		          e = new Employee();
		        	 id=Integer.parseInt(arr1[0]);
		        	 name=arr1[1];
		        	 email=arr1[2];
		        	 gender=arr1[3];
		        	 username=arr1[4];
		        	 password=arr1[5];
		        	 e.setName(name);
		        	 e.setEmail(email);
		        	 e.setGender(gender);
		        	 e.setUsername(username);
		        	 e.setPassword(password);
		        	 e.setId(id);
		      
		
		LOGGER.info("Start EmCrudController");
		EmployeeDao dao = new EmployeeDao();
		if(!list11.contains(email)){
		 i = dao.save(e);
		        }else{
		        	System.out.println("record exists in db for id and email and id:"+email +"id:"+id);
		        }}
		        }
		List list = new ArrayList();

		 ResultSet rsv=null;
		 
			EmployeeDao dao1 = new EmployeeDao();
			 rsv = dao1.findAll();
		while (rsv.next()) {
			 id = rsv.getInt(1);
			 name = rsv.getString(2);
			 email = rsv.getString(3);
			 gender = rsv.getString(4);
			 username = rsv.getString(5);
			 password = rsv.getString(6);
			 e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setGender(gender);
			e.setUsername(username);
			e.setPassword(password);
			list.add(e);

		}
		req.setAttribute("reslist", list);
		
		        
		        return am.findForward("findAll");
		        }

	private int getInt(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ActionForward update(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Employee e = (Employee) af;
		LOGGER.info("Start Update");
		EmployeeDao dao = new EmployeeDao();
		boolean b = dao.update(e);
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			int id = rsv.getInt(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setGender(gender);
			e.setUsername(username);
			e.setPassword(password);
			list.add(e);
			e = null;
		}
		req.setAttribute("reslist", list);
		if (b == true)
			return am.findForward("findAll");
		else
			return am.findForward("fail");

	}

	public ActionForward delete(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Employee e = (Employee) af;
		LOGGER.info("Start Delete");
		EmployeeDao dao = new EmployeeDao();
		boolean b = dao.delete(e);
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			int id = rsv.getInt(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setGender(gender);
			e.setUsername(username);
			e.setPassword(password);
			list.add(e);
			e = null;
		}
		req.setAttribute("reslist", list);
		if (b == true)
			return am.findForward("findAll");
		else
			return am.findForward("fail");
	}

	public ActionForward find(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Employee e = (Employee) af;
		LOGGER.info("Start Find");
		EmployeeDao dao = new EmployeeDao();
		ResultSet rsv = dao.findempcrud(e);
		List list = new ArrayList();
		while (rsv.next()) {
			System.out.println(rsv.getString(2));
			int id = rsv.getInt(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Employee ef = new Employee();
			ef.setId(id);
			ef.setName(name);
			ef.setEmail(email);
			ef.setGender(gender);
			ef.setUsername(username);
			ef.setPassword(password);
			list.add(ef);
		}
		req.setAttribute("reslist", list);
		return am.findForward("find");

	}

	public ActionForward findAll(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		EmployeeDao dao = new EmployeeDao();
		ResultSet rsv = dao.findAll();
		
		List list = new ArrayList();
		while (rsv.next()) {
			int id = rsv.getInt(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Employee e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setGender(gender);
			e.setUsername(username);
			e.setPassword(password);
			list.add(e);

		}
		req.setAttribute("reslist", list);
		return am.findForward("findAll");
	}

	public ActionForward exportxl(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		EmployeeDao dao = new EmployeeDao();
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			int id = rsv.getInt(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Employee e = new Employee();
			e.setId(id);
			e.setName(name);
			e.setEmail(email);
			e.setGender(gender);
			e.setUsername(username);
			e.setPassword(password);
			list.add(e);

		}
		ExcelCreator excelCreator = new ExcelCreator();
		HSSFWorkbook workbook = excelCreator.createWorkbook(list);
		res.setHeader("Content-Disposition", "attachment; filename=UserDetails.xls");
		ServletOutputStream out = res.getOutputStream();
		workbook.write(out);
		out.flush();
		out.close();
		return am.findForward("success");

	}
	
	
	
	
	
	    
	}
	

