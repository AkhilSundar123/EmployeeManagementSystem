package org.ems.EmployeeManagementSystem;


import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("webapi")
public class ApplicationConfig extends ResourceConfig{

 public ApplicationConfig() {
	 packages("org.ems.EmployeeManagementSystem");
 }
	 
	
}
