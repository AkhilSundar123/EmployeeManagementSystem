package org.ems.EmployeeManagementSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ems.EmployeeManagementSystem.Database.ConnectionHelper;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() 
    {/*
    	Connection conn = null;
    	try {
    		String sql;
            sql = "SELECT Empid, firstname, lastname, department FROM Employee";
            
			conn = ConnectionHelper.getConnection();
			Statement s = conn.createStatement();
	        ResultSet rs = s.executeQuery(sql);
	        while (rs.next()) 
	        {
	        	int id  = rs.getInt("Empid");
	            String first = rs.getString("firstname");
	            String last = rs.getString("lastname");
	            String department = rs.getString("department");
	            //Display values
	            System.out.print("ID: " + id);
	            System.out.print(", First: " + first);
	            System.out.println(", Last: " + last);
	            System.out.print(", Dept: " + department);
	        }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	*/
    	
        return "Got it!";
    }
}
