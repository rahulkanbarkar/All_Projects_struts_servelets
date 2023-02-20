package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.mysql.cj.result.Row;

import beans.Admin;
import beans.ExcelCreator;
//import beans.ExcelCreator;
import dao.AdminDao;
import javafx.scene.control.Cell;

public class AddAdminCrud
		extends DispatchAction {/*
								 * static final Logger LOGGER = Logger.getLogger("AddAdminCrud.class"); public
								 * ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req,
								 * HttpServletResponse res) throws Exception { Admin e = (Admin) af; AdminDao
								 * dao = new AdminDao(); int i = dao.save(e); if (i != 0) return
								 * am.findForward("success"); else return am.findForward("fail"); }
								 * 
								 * public ActionForward importTextFile(ActionMapping am, ActionForm af,
								 * HttpServletRequest req, HttpServletResponse res) throws Exception { AdminDao
								 * dao11 = new AdminDao(); ResultSet rsv1 = dao11.findAll(); List list11 =new
								 * ArrayList(); while (rsv1.next()) {
								 * 
								 * String email = rsv1.getString("email"); System.out.println(email);
								 * 
								 * Admin e1 = new Admin();
								 * 
								 * e1.setEmail(email); list11.add(email);
								 * 
								 * }
								 * 
								 * int i=0; File file = new File( "C:\\Users\\A849641\\Documents\\test.txt");
								 * String fwd = null; Admin e = (Admin) af; // Note: Double backquote is to
								 * avoid compiler // interpret words // like \test as \t (ie. as a escape
								 * sequence)
								 * 
								 * // Creating an object of BufferedReader class BufferedReader br = new
								 * BufferedReader(new FileReader(file));
								 * 
								 * // Declaring a string variable String id = null; String st; String name =
								 * null; String email = null; String gender = null; String username = null;
								 * String password = null; // Condition holds true till // there is character in
								 * a string while ((st = br.readLine()) != null) { String arr[]=st.split("/");
								 * for(String str:arr) {
								 * 
								 * String[] arr1=str.split(",");
								 * 
								 * e = new Admin(); id=arr1[0]; name=arr1[1]; email=arr1[2]; gender=arr1[3];
								 * username=arr1[4]; password=arr1[5]; e.setName(name); e.setEmail(email);
								 * e.setGender(gender); e.setUsername(username); e.setPassword(password);
								 * e.setUserid(id);
								 * 
								 * 
								 * LOGGER.info("Start AddAdminCrud");
								 */
		/*AdminDao dao = new AdminDao();
		if(!list11.contains(email)){
		 i = dao.save(e);
		        }else{
		        	System.out.println("record exists in db for userid and email and userid:"+email +"id:"+id);
		        }}
		        }
		List list = new ArrayList();

		 ResultSet rsv=null;
		 
			AdminDao dao1 = new AdminDao();
			 rsv = dao1.findAll();
		while (rsv.next()) {
			 id = rsv.getString(1);
			 name = rsv.getString(2);
			 email = rsv.getString(3);
			 gender = rsv.getString(4);
			 username = rsv.getString(5);
			 password = rsv.getString(6);
			 e = new Admin();
			e.setUserid(id);
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
		Admin e = (Admin) af;
		LOGGER.info("Start Update");
		AdminDao dao = new AdminDao();
		boolean b = dao.update(e);

		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			e = new Admin();
			e.setUserid(id);
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
		Admin e = (Admin) af;
		LOGGER.info("Start Delete");
		AdminDao dao = new AdminDao();
		boolean b = dao.delete(e);
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			e = new Admin();
			e.setUserid(id);
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
		Admin e = (Admin) af;
		LOGGER.info("Start Find");
		AdminDao dao = new AdminDao();
		ResultSet rsv = dao.findempcrud(e);
		List list = new ArrayList();
		while (rsv.next()) {
			System.out.println(rsv.getString(2));
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Admin ef = new Admin();
			ef.setUserid(id);
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
		AdminDao dao = new AdminDao();
		ResultSet rsv = dao.findAll();
		
		List list = new ArrayList();
		while (rsv.next()) {
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Admin e = new Admin();
			e.setUserid(id);
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
	*/
	
	
	/* exportxl */                                                         /* exportxl */

	public ActionForward exportxl(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		AdminDao dao = new AdminDao();
		ResultSet rsv = dao.findAll();
		List list = new ArrayList();
		while (rsv.next()) {
			String id = rsv.getString(1);
			String name = rsv.getString(2);
			String email = rsv.getString(3);
			String gender = rsv.getString(4);
			String username = rsv.getString(5);
			String password = rsv.getString(6);
			Admin e = new Admin();
			e.setUserid(id);
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
	
//	  public ActionForward findAllByWebService(ActionMapping am, ActionForm af,
//	  HttpServletRequest req, HttpServletResponse res) throws Exception {
//	  AdminDao dao = new AdminDao(); ResultSet rsv = dao.findAll();
//	  
//	  SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
//	  .newInstance(); SOAPConnection soapConnection = soapConnectionFactory
//	  .createConnection();
	  
//	   Send SOAP Message to SOAP Server SOAPMessage soapResponse =
//	soapConnection.call( createSOAPRequest(soapAction, webServicePronosDto),
//	  soapEndpointUrl);
	  
	/*  List list = new ArrayList(); while (rsv.next()) { String userid = rsv.getString(1);
	  String name = rsv.getString(2); String email = rsv.getString(3); String
	  gender = rsv.getString(4); String username = rsv.getString(5); String
	  password = rsv.getString(6); Admin e = new Admin(); e.setUserid(userid);
	  e.setName(name); e.setEmail(email); e.setGender(gender);
	  e.setUsername(username); e.setPassword(password); list.add(e);
	  
	  } req.setAttribute("reslist", list); return am.findForward("findAll"); }
	 */
	
	    
	    
	    
	}
	

