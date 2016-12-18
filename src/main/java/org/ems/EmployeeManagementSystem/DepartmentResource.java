package org.ems.EmployeeManagementSystem;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ems.EmployeeManagementSystem.DAO.DepartmentDAO;
import com.ems.EmployeeManagementSystem.model.Department;

@Path("/departments")
public class DepartmentResource 
{
	DepartmentDAO deptDao = new DepartmentDAO();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Department> findAllDepartments()
	{
		return deptDao.findAllDepartments();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Department addDepartment(Department dept)
	{
		
		return deptDao.create(dept);
	}
	
	@PUT
	@Path("{deptid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Department updateDepartment(@PathParam("deptid") int deptid,Department dept)
	{
		dept.setDeptid(deptid);
		return deptDao.updateDepartment(dept);
	}
	
	@DELETE
	@Path("{deptid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteDepartment(@PathParam("deptid") int deptid)
	{
		deptDao.removeDepartment(deptid);
	}
}
