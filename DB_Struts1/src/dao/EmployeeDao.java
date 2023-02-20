 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.struts.config.FormBeanConfig;

import com.db.connection.DbConnection;

import beans.Employee;
import beans.FileUploadForm;

public class EmployeeDao  extends DbConnection{
	public int save(Employee e) throws Exception {
		Connection con=getConnection();
        int idNum=1;
        PreparedStatement ps=con.prepareStatement("select max(id) as id from employee.employee");
        ResultSet rs= ps.executeQuery();
        if(rs!=null && rs.next()) {
        	idNum=rs.getInt("id");
        	idNum=idNum+1;
        }
         ps=con.prepareStatement("insert into employee.employee values(?,?,?,?,?,?)");
        ps.setInt(1,idNum);
        ps.setString(2,e.getName());
        ps.setString(3, e.getEmail());
        ps.setString(4, e.getGender());
        ps.setString(5, e.getUsername());
        ps.setString(6, e.getPassword());
        int i=ps.executeUpdate();
        con.close();
        return i;    
	}
	
	public boolean update(Employee e)throws Exception {
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("update employee set name=?,email=?,gender=?,username=?,password=? where id=?");
        ps.setString(1, e.getName());
        ps.setString(2, e.getEmail());
        ps.setString(3, e.getGender());
        ps.setString(4, e.getUsername());
        ps.setString(5, e.getPassword());
        ps.setInt(6, e.getId());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public boolean delete(Employee e)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
        ps.setInt(1,e.getId());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public ResultSet find(int Id)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
        ps.setInt(1,Id);
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
	public ResultSet findempcrud(Employee e)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employee where id=?");
        ps.setInt(1,e.getId());
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
	
	
	public ResultSet findAll()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employee");	
       ResultSet rs= ps.executeQuery();
       return  rs;	
	}
	public boolean savefile(FileUploadForm fb) throws Exception{
		return true;
		
	}
}