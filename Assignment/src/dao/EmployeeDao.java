package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.connection.DbConnection;

import beans.Admin;
import beans.Employee;

import beans.Employee;

public class EmployeeDao  extends DbConnection{

	public int save(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
		ps.setString(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getDob());
		ps.setString(4,e.getManager());
		ps.setString(5,e.getLocation());
		ps.setString(6,e.getEmail());
		ps.setString(7, e.getJobtype());
		int i=ps.executeUpdate();
		con.close();
		return i;		
	}
	
	
	public ResultSet listemp()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employee ");
        System.out.println();
       ResultSet rs= ps.executeQuery();
       System.out.println(rs);
       System.out.print("DAO");
       return rs;
	}
	
//	
	
	public boolean update(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update employee set name=?,dob=?,manager=?,location=?,email=?,jobtype=? where id=? ");
		ps.setString(1, e.getName());
		ps.setString(2, e.getDob());
		ps.setString(3,e.getLocation());
		ps.setString(4,e.getManager());
		ps.setString(5,e.getEmail());
		ps.setString(6, e.getJobtype());
		ps.setString(7, e.getId());
		
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
	}
	
	
	public boolean delete(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from employee where id=? ");
		ps.setString(1, e.getId());
		
		
		int i=ps.executeUpdate();
		con.close();
		if(i != 0)
			return true;
		else 
			return false;
		}
		
	
	public ResultSet find(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee where id=? or name like ?");
		ps.setString(1, e.getId());
		ps.setString(2,""+e.getName()+'%'+"" );
		ResultSet rs=ps.executeQuery();
		return rs;
	}
	
	
	public List findAll(Employee e)throws Exception{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employee");
		ps.setString(1, e.getId());
		ResultSet rs=ps.executeQuery();
		List<String> l=new ArrayList<String>();
		if (rs.next())
		{
			l.add(rs.getString(1));
			l.add(rs.getString(2));
			l.add(rs.getString(3));
			l.add(rs.getString(4));
			l.add(rs.getString(5));
			l.add(rs.getString(6));
			l.add(rs.getString(7));
		}
		con.close();
		return l;
	}
//	
	
	
	public ResultSet uploadlistemp()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from employee e, upload u where e.id=u.id;");
       ResultSet res= ps.executeQuery();
       System.out.print(res);
       System.out.print("DAO");
       return res;     
	}
	
	public ResultSet download()throws Exception{
		Connection con=getConnection();
        PreparedStatement ps=con.prepareStatement("select * from upload ");
        System.out.println();
       ResultSet rs= ps.executeQuery();
       System.out.println(rs);
       System.out.print("DAO");
       return rs;
	}
     
	}

