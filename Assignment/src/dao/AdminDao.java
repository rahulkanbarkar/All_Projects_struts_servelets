 package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.db.connection.DbConnection;

import beans.Admin;

public class AdminDao  extends DbConnection{
	public int save(Admin e) throws Exception {
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
        ps.setString(1,e.getUserid());
        ps.setString(2,e.getName());
        ps.setString(3, e.getEmail());
        ps.setString(4, e.getGender());
        ps.setString(5, e.getUsername());
        ps.setString(6, e.getPassword());
        int i=ps.executeUpdate();
        con.close();
        return i;    
	}
	
	public boolean update(Admin e)throws Exception {
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("update Admin set name=?,email=?,gender=?,username=?,password=? where id=?");
        ps.setString(1, e.getName());
        ps.setString(2, e.getEmail());
        ps.setString(3, e.getGender());
        ps.setString(4, e.getUsername());
        ps.setString(5, e.getPassword());
        ps.setString(1,e.getUserid());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public boolean delete(Admin e)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("delete from Admin where id=?");
        ps.setString(1,e.getUserid());
        int i=ps.executeUpdate();
        con.close();
        if(i!=0)
        	return true;
        else
        	return false;
	}
	
	public ResultSet find(int Id)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from Admin where id=?");
        ps.setInt(1,Id);
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
	public ResultSet findempcrud(Admin e)throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from Admin where id=?");
        ps.setString(1,e.getUserid());
       ResultSet rs= ps.executeQuery();
       System.out.print("DAO");
       return rs;
     
	}
	
	
	public ResultSet findAll()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from Admin");	
       ResultSet rs= ps.executeQuery();
       return  rs;	
	}
}