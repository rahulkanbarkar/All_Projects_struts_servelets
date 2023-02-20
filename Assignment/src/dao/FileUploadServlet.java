package dao;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.hssf.model.Sheet;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


 
@WebServlet("/FileUploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
                 maxFileSize=1024*1024*50,      	// 50 MB
                 maxRequestSize=1024*1024*100)   	// 100 MB
public class FileUploadServlet extends HttpServlet {
 
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get the uploaded Excel file
		System.out.println("TEST 1");
	    Part filePart = request.getPart("file"); // "file" is the name of the file upload input in the form
	    InputStream fileContent = filePart.getInputStream();
	    System.out.println("TEST 1");
	    // Parse the Excel data using Apache POI
	    org.apache.poi.ss.usermodel.Workbook workbook = WorkbookFactory.create(fileContent);
	    org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0); // Get the first sheet
	    ArrayList<String> objects = new ArrayList<String>();
	    Connection conn = null ;
		try {
			   
		    Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "889325Ca");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
        // Prepare the insert statement
        PreparedStatement stmt = null;
		try {
			 PreparedStatement stmt1= conn.prepareStatement("insert into Library values(?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	    for (Row row : sheet) {
//	        String object = new String();
	        Cell cell1 = row.getCell(0);
	        Cell cell2 = row.getCell(1);
	        Cell cell3 = row.getCell(2);
            Cell cell4 = row.getCell(3);
//	        objects.setProperty1(row.getCell(0).getStringCellValue());
//	        objects.setProperty2(row.getCell(1).getNumericCellValue());
	        // ... set other properties
//	        objects.add(object);
	        
	        
	        try {
				stmt.setDouble(1, cell1.getNumericCellValue());
			
            stmt.setString(2, cell2.getStringCellValue());
            stmt.setString(3, cell3.getStringCellValue());
            stmt.setDouble(4, cell4.getNumericCellValue());
		
            System.out.println("test 5");
            // Execute the insert statement
           stmt.executeUpdate();
	        } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	        
	    response.sendRedirect("success.jsp");
	    }

	    // Insert the data into the database
//	    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "myusername", "mypassword");
//	         PreparedStatement statement = connection.prepareStatement("INSERT INTO mytable (column1, column2) VALUES (?, ?)")) {
//	        for (MyObject object : objects) {
//	            statement.setString(1, object.getProperty1());
//	            statement.setDouble(2, object.getProperty2());
//	            // ... set other parameters
//	            statement.executeUpdate();
//	        }
//	    }

//	    response.sendRedirect("success.jsp");
//	}

	
	
}