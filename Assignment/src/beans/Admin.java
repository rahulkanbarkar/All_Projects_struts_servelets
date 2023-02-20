package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class Admin extends ActionForm {
	private String userid;
	private String name,email,gender,username,password;
	

	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [userid=" + userid + ", name=" + name + ", email=" + email + ", gender=" + gender + ", username="
				+ username + ", password=" + password + "]";
	}
	
	 private FormFile excelFile;

	   public FormFile getExcelFile() {
	      return excelFile;
	   }

	   public void setExcelFile(FormFile excelFile) {
	      this.excelFile = excelFile;
	   }
	   
	   @Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return super.validate(mapping, request);
	}
	
}