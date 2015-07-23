/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.organizationmanagement;

import dao.model.Organization;
import dao.services.OrganizationService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ahaleem
 */
@Stateless
@LocalBean
public class OrganizationManagementEjb {
OrganizationService organizationService;
    private OrganizationService GetOrganizationServiceObject()
    {
        if(organizationService==null)
        {
           organizationService=new OrganizationService();
        }
        return organizationService;
    }
    public void setupOrganization(Organization organization) {
         
        
        try {
                GetOrganizationServiceObject().addOrganization(organization);
            } catch (Exception ex) {
                Logger.getLogger(OrganizationManagementEjb.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public Organization GetOrganization(int orgId) throws Exception
    {
        GetOrganizationServiceObject();
        if(orgId>0)
            return organizationService.findOrganizationById(orgId);
        else
            throw new Exception("Organization ID must be Greater than 0");
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
}
