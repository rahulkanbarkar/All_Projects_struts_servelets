package controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import beans.FileUploadForm;
 
public class FileUploadAction extends DispatchAction {
       public ActionForward fileUploadAction( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
      throws Exception {
          ActionErrors errors = new ActionErrors();
          ActionForward forward = new ActionForward();
          FileUploadForm uploadForm = (FileUploadForm) form;
          String target = "";
		// errors = uploadForm.validateFileUpload(mapping, request);  // to validate the given file
          /*if (!errors.isEmpty())
                    {
                    System.out.println("Error");
                    saveErrors(request, errors);
                      target = "uploadform";
            } else {*/
 
                  try {
                    FormFile dataFile = uploadForm.getDataFile();
                    String fileName = dataFile.getFileName();
                    int  fileSize = dataFile.getFileSize();
                    byte[] fileData = dataFile.getFileData();
                    Part filePart = request.getPart("file");
                    
                 
                    FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\a856947\\\\Documents\\\\" + fileName);
                    
                    fileOut.write(fileData, 0, fileSize);
                    System.out.println("hello  "+fileOut);
                    fileOut.flush();
                     fileOut.close();
                     } catch (Exception e) {
                         System.out.println("Error ="+e.toString());
                                errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("error.upload", e.toString()));
                                target = "uploadform";
                              }
                    if (!errors.isEmpty()) {
                          saveErrors(request, errors);
                          target = "uploadform";
                      } else { target = "success";    }
                   //}
            forward = mapping.findForward(target);
            return mapping.findForward("success");
          }
         }