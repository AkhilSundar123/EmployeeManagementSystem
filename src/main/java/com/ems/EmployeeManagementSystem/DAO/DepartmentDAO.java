package com.ems.EmployeeManagementSystem.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ems.EmployeeManagementSystem.Database.ConnectionHelper;

import com.ems.EmployeeManagementSystem.model.Department;

public class DepartmentDAO {

	public List<Department> findAllDepartments()
	{
		 List<Department> list = new ArrayList<Department>();
	     Connection c = null;
	     String sql = "SELECT deptid, deptname from department ";
	     
	     try {
	            c = ConnectionHelper.getConnection();
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                list.add(processSummaryRowDept(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return list;
	}
	
	 public Department create(Department department) 
	 {
		 	Connection c = null;
	        PreparedStatement ps = null;
	        String sql = "INSERT into department(deptid,deptname) values (?,?)";
	       
	        try 
	        {
	            c = ConnectionHelper.getConnection();
	            ps = c.prepareStatement(sql);
	            ps.setInt(1, department.getDeptid());
	            ps.setString(2, department.getDeptname());
	            ps.executeUpdate();

	        }catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return department;
	 }
	
	 public Department updateDepartment(Department dept)
	 {
		 Connection c = null;
	        try 
	        {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("UPDATE department SET deptname=? WHERE deptid=?");
	            ps.setString(1, dept.getDeptname());
	            ps.setInt(2, dept.getDeptid());
	            ps.executeUpdate();
	            

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return dept;
	 }
	 
	 public void removeDepartment(int deptid)
	 {
		 Connection c = null;
	        try 
	        {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("DELETE from department WHERE deptid=?");   
	            ps.setInt(1, deptid);
	            ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	 }
	 
	 protected Department processSummaryRowDept(ResultSet rs) throws SQLException {
	    	Department dept = new Department();
	    	dept.setDeptid(rs.getInt("deptid"));
	    	dept.setDeptname(rs.getString("deptname"));
	    	
	    	return dept;
	    }
}
