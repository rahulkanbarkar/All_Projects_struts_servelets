package controller;
	import java.io.InputStream;
import java.io.Reader;
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
import dao.FileUploadDao;

	public class downloadfile  extends Action {
	 @Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 EmployeeDao dao = new EmployeeDao();
			ResultSet rsv = dao.download();
			List list = new ArrayList();
			while (rsv.next()) {
				System.out.println(rsv.getString(2));
				String id = rsv.getString(1);
				InputStream file = rsv.getBinaryStream(2);
			
				FileUploadDao ef = new FileUploadDao();
				ef.setId(id);
				ef.setFile(file);
				
				list.add(ef);
			}
			request.setAttribute("reslist", list);
			
			return mapping.findForward("downloademp");
			}
	}

	
	
	

