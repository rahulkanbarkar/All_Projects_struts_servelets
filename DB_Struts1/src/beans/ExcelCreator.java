package beans;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelCreator {

    public HSSFWorkbook createWorkbook(List<Employee> userList) throws Exception {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Employee Data");

        /**
         * Setting the width of the first three columns.
         */
        sheet.setColumnWidth(0, 3500);
        sheet.setColumnWidth(1, 7500);
        sheet.setColumnWidth(2, 5000);
        sheet.setColumnWidth(3, 4500);
        sheet.setColumnWidth(4, 4500);
        sheet.setColumnWidth(5, 5000);
        
        /**
         * Style for the header cells.
         */
        HSSFCellStyle headerCellStyle = wb.createCellStyle();
        HSSFFont boldFont = wb.createFont();
        boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerCellStyle.setFont(boldFont);

        HSSFRow headerrow = sheet.createRow(0);
        
        HSSFCell cell = headerrow.createCell(0);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString(" Name"));
        
        
        cell = headerrow.createCell(1);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Email "));
        
        cell = headerrow.createCell(2);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Gender"));
        
        cell = headerrow.createCell(3);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Username"));
        
        cell = headerrow.createCell(4);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Password"));
        
        cell = headerrow.createCell(5);
        cell.setCellStyle(headerCellStyle);
        cell.setCellValue(new HSSFRichTextString("Id"));
      
        
int row=1;
        for (int index = 0; index < userList.size(); index++) {
        	headerrow = sheet.createRow(row);
        	row++;
          
            cell = headerrow.createCell(0);
            Employee userData = (Employee) userList.get(index);
            HSSFRichTextString name = new HSSFRichTextString(userData.getName());
            cell.setCellValue(name);
            
            cell = headerrow.createCell(1);
            HSSFRichTextString email = new HSSFRichTextString(userData.getEmail());
            cell.setCellValue(email);
            
            cell = headerrow.createCell(2);
            HSSFRichTextString gender = new HSSFRichTextString(userData.getGender());
            cell.setCellValue(gender);
            
            cell = headerrow.createCell(3);
            HSSFRichTextString username = new HSSFRichTextString(userData.getUsername());
            cell.setCellValue(username);
            
            cell = headerrow.createCell(4);
            HSSFRichTextString password = new HSSFRichTextString(userData.getPassword());
            cell.setCellValue(password);
            
            cell = headerrow.createCell(5);
            HSSFRichTextString id = new HSSFRichTextString(Integer.toString(userData.getId()));
            cell.setCellValue(id);
            
        }
        return wb;
    }
}
