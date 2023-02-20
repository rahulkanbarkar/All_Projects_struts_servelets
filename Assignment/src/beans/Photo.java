package beans;

import java.io.File;

import org.apache.struts.action.ActionForm;

import com.mysql.cj.jdbc.Blob;

public class Photo extends ActionForm {
	String id;
	File photo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
}
