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
import com.ems.EmployeeManagementSystem.model.Employee;

public class EmployeeDAO {
	
	 public List<Employee> findAll() 
	 {
		 List<Employee> list = new ArrayList<Employee>();
	     Connection c = null;
	     //String sql = "select empid,lastname,firstname,deptid from Employee";
	     String sql = "SELECT e.empid, e.lastname, e.firstname, e.deptid, d.deptname FROM employee as e " +
	 			"INNER JOIN department d ON e.deptid = d.deptid ";
	     try {
	            c = ConnectionHelper.getConnection();
	            Statement s = c.createStatement();
	            ResultSet rs = s.executeQuery(sql);
	            while (rs.next()) {
	                list.add(processSummaryRow(rs));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	    // System.out.println(list);
	        return list;
	 }
	 
	 protected Employee processSummaryRow(ResultSet rs) throws SQLException {
	    	Employee employee = new Employee();
	    	employee.setEmpid(rs.getInt("empid"));
	    	employee.setFirstname(rs.getString("firstname"));
	    	employee.setLastname(rs.getString("lastname"));
	    	//int deptid = rs.getInt("deptid");
	    	
	    	Department dept = new Department();
	    	dept.setDeptid(rs.getInt("deptid"));
	    	dept.setDeptname(rs.getString("deptname"));
	    	employee.setDept(dept);
	    	
	    	return employee;
	    }
	 
	 public Employee findById(int empid) {
	    	//String sql = "select empid,firstname,lastname,deptid from employee where empid=?";
	        
		 String sql = "SELECT e.empid, e.lastname, e.firstname, e.deptid, d.deptname FROM employee as e " +
		 			"INNER JOIN department d ON e.deptid = d.deptid where empid=?";
		 Employee employee = null;
	        Connection c = null;
	        try {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement(sql);
	            ps.setInt(1, empid);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                employee = processRow(rs);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return employee;
	    }
	 
	 protected Employee processRow(ResultSet rs) throws SQLException 
	 {
	        Employee employee = new Employee();
	        employee.setEmpid(rs.getInt("empid"));
	        employee.setFirstname(rs.getString("firstname"));
	        employee.setLastname(rs.getString("lastname"));
	        
	        
	        //int deptid = rs.getInt("deptid");
	    	
	    	Department dept = new Department();
	    	dept.setDeptid(rs.getInt("deptid"));
	    	dept.setDeptname(rs.getString("deptname"));
	    	employee.setDept(dept);
	        
	        return employee;
	 }
	 
	 public Employee create(int deptid,Employee employee) 
	 {
	        Connection c = null;
	        PreparedStatement ps = null;
	        PreparedStatement temp = null;
	        String sql = "select deptid,deptname from department where deptid = ? ";
            Department dept= new Department();
            dept.setDeptid(deptid);
           // int deptid;
	        try {
	           c = ConnectionHelper.getConnection();
	           temp = c.prepareStatement(sql);
	           temp.setInt(1, deptid);
	           ResultSet rs = temp.executeQuery();
	           if(rs.next())
	           {
	        	   String deptname = rs.getString("deptname");
	        	  // System.out.println(deptid);
	        	   dept.setDeptname(deptname);
	           }
	            ps = c.prepareStatement("INSERT INTO employee (firstName, lastName, deptid) VALUES (?, ?, ?)");
	            ps.setString(1, employee.getFirstname());
	            ps.setString(2, employee.getLastname());
	            ps.setInt(3, dept.getDeptid());
	            ps.executeUpdate();
	            ResultSet rs1 = ps.getGeneratedKeys();
	            rs1.next();
	            int id = rs1.getInt(1);
	            employee.setEmpid(id);
	            employee.setDept(dept);
	               
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return employee;
	 }
	 
	 public Employee update(Employee employee) 
	 {
	        Connection c = null;
	        try 
	        {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("UPDATE employee SET firstname=?, lastname=?, deptid=? WHERE empid=?");
	           
	            ps.setString(1, employee.getFirstname());
	            ps.setString(2, employee.getLastname());
	            ps.setInt(3, employee.getDept().getDeptid());
	            ps.setInt(4, employee.getEmpid());
	            ps.executeUpdate();	
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	        return employee;
	 }
	 
	 public boolean remove(int empid) 
	 {
	        Connection c = null;
	        try 
	        {
	            c = ConnectionHelper.getConnection();
	            PreparedStatement ps = c.prepareStatement("DELETE FROM employee WHERE empid=?");
	            ps.setInt(1, empid);
	            
	            int count = ps.executeUpdate();
	            return count == 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException(e);
			} finally {
				ConnectionHelper.close(c);
			}
	 }
}
