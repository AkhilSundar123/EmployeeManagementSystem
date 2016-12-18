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
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import com.ems.EmployeeManagementSystem.DAO.EmployeeDAO;
import com.ems.EmployeeManagementSystem.model.Employee;


@Path("/employees")
public class EmployeeResource extends Application{
	EmployeeDAO dao = new EmployeeDAO();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> findAll() 
	{
		return dao.findAll();
	}
	
	@GET
	@Path("/{empid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getMessage(@PathParam("empid") int empid)
	{
		return dao.findById(empid);
	}
	
	
	@POST
	@Path("/{deptid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addEmployee(@PathParam("deptid") int deptid, Employee employee)
	{
		
		return dao.create(deptid,employee);
	}
	
	@PUT
	@Path("/{empid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateEmlployee(@PathParam("empid") int empid,Employee employee)
	{
		employee.setEmpid(empid);
		return dao.update(employee);
	}
	
	@DELETE
	@Path("/{empid}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteEmlployee(@PathParam("empid") int empid)
	{
		boolean status = dao.remove(empid);
		System.out.println(status);
	}
	
	
}
