package dao;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.digester.annotations.rules.AttributeCallParam.List;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.upload.FormFile;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import beans.Employee;
import dao.EmployeeDao;

import beans.Admin;
import beans.Employee;
import dao.AdminDao;
import dao.EmployeeDao;


public class importData extends DynaActionForm{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
    FormFile file = (FormFile) ((DynaActionForm) form).get("file");
    InputStream is = file.getInputStream();
    HSSFWorkbook workbook = new HSSFWorkbook(is);
    HSSFSheet sheet = workbook.getSheetAt(0);
    List<DataObject> dataList = new ArrayList<>();
    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
        HSSFRow row = sheet.getRow(i);
        DataObject data = new DataObject();
        data.setField1(row.getCell(0).getStringCellValue());
        data.setField2(row.getCell(1).getStringCellValue());
        dataList.add(data);
    }
    // Save the data to the database
    MyDAO.saveData(dataList);
    return mapping.findForward("success");
}

public static void saveData(List<DataObject> dataList) throws SQLException {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username", "password");
    PreparedStatement ps = conn.prepareStatement("INSERT INTO mytable (field1, field2) VALUES (?, ?)");
    for (DataObject data : dataList) {
        ps.setString(1, data.getField1());
        ps.setString(2, data.getField2());
        ps.executeUpdate();
    }
    ps.close();
    conn.close();
}

}
