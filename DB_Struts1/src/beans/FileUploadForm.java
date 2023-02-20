 package beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
 
public class FileUploadForm extends ActionForm {
       private FormFile dataFile = null;

	public FormFile getDataFile() {
		return dataFile;
	}

	public void setDataFile(FormFile dataFile) {
		this.dataFile = dataFile;
	}
       
       
       
	
	  public ActionErrors validateFileUpload(ActionMapping mapping,
	  HttpServletRequest request) { 
		ActionErrors errors = new ActionErrors();
		FormFile dataFile = this.getDataFile();
		System.out.println(dataFile.getContentType());
		String dataFileName = dataFile.getFileName();
		if (dataFile == null) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("file.required"));
		} else if (dataFileName != null && dataFileName.length() > 0) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("file.required"));
		} else if (!dataFileName.matches("[a-zA-Z0-9\\s\\-]+\\.pdf")) {
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("filename.invalid"));
		} else if (dataFile.getFileSize() > 2097152) { // 2mb
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("file.size.invalid"));
		}
	  
	  return errors; 
	  }
	 }
	 
       
