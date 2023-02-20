package controller;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxml4j.opc.Package;

import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.util.Iterator;
import java.io.File;

public class InsertDataFromExcelToDB {

    public static void main(String[] args) {
        try {  System.out.println("test 0");
        File file = new File("C:\\\\Users\\\\a856947\\\\Documents\\\\abc.xlsx"); 
        System.out.println("test 0"+"  "+file);
        System.out.println("File name: " + file.getName());
        System.out.println("Path name: " + file.getPath());
        
            // Load the Excel file                    
            XSSFWorkbook workbook = new XSSFWorkbook("C:\\\\Users\\\\a856947\\\\Documents\\\\abc.xlsx");
            XSSFSheet sheet = workbook.getSheetAt(0);
            
            // Establish a connection to the database
			/* Class.forName("com.mysql.jdbc.Driver"); */
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "889325Ca");
            
            // Prepare the insert statement
            PreparedStatement stmt = conn.prepareStatement("insert into import values(?,?)");
            // Iterate through the rows in the sheet
        
            for (Row row : sheet) {
                Cell cell1 = row.getCell(0);
                Cell cell2 = row.getCell(1);
				/* Cell cell3 = row.getCell(2); */
                System.out.println("test 4 "+cell1.getStringCellValue());

                // Set the values of the prepared statement
                stmt.setString(1, cell1.getStringCellValue());
                stmt.setDouble(2, cell2.getNumericCellValue());
				/*
				 * stmt.setDate(3, cell3.getDateCellValue());
				 */
                System.out.println("test 5");
                
                // Execute the insert statement
               stmt.executeUpdate();
              
            }
            // Close the resources
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
