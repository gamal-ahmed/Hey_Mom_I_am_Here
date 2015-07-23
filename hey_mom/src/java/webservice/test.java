/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.model.Organization;
import ejb.organizationmanagement.OrganizationManagementEjb;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author ahmed gamal
 */
@Path(value="/")
@Consumes(value="application/json")
@Produces(value="application/json")

public class test {
    @EJB
    private OrganizationManagementEjb ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    @GET
    @Path(value = "/SetupOrganization")
    public void setupOrganization(
                        @QueryParam(value = "name") String name,
			@QueryParam(value = "owner") String owner,
			@QueryParam(value = "address") String address,
			@QueryParam(value = "email") String email,
			@QueryParam(value = "mobile") String mobile,
                        @QueryParam(value = "homePhone") String homePhone,
                        @QueryParam(value = "scale") String scale)
    { 
//         ejbRef.setupOrganization( name, address, homePhone, email, owner, mobile, scale);
    }
    @GET
    @Path(value = "/hello")
    public String hello(
                        @QueryParam(value = "name") String name
			)
    { 
        System.out.println("hello "+name);
     return "hello"+name;   
    }
    
    
}
