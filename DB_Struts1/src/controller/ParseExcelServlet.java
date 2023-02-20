package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@MultipartConfig
public class ParseExcelServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Part filePart = request.getPart("excelFile");
    String fileName = filePart.getSubmittedFileName();
    String filePath = "/path/to/your/uploaded/files/" + fileName;

    try {
      // Save the uploaded file to the server
      filePart.write(filePath);

      // Open the Excel file
      FileInputStream inputStream = new FileInputStream(new File(filePath));
      Workbook workbook = new XSSFWorkbook(inputStream);
      Sheet sheet = workbook.getSheetAt(0);

      // Loop through the rows of the Excel sheet
      for (Row row : sheet) {
        for (Cell cell : row) {
          // Do something with the cell data
        }
      }
      inputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

