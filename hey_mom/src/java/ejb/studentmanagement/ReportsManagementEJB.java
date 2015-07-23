/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.studentmanagement;

import dao.model.Account;
import dao.model.Organization;
import dao.model.Report;
import dao.model.Student;
import dao.services.AccountService;
import dao.services.OrganizationService;
import dao.services.ReportsService;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author ahaleem
 */
public class ReportsManagementEJB {
    ReportsService ReportsService;
    public void CreateReport(Report report) throws Exception {
    
       ReportsService=new ReportsService();
       if(report!=null)
       {
          
             ReportsService.createReport(report);
         
       }
    
    }
   
    public List<Account> findAllStudentReports(int orgid) throws Exception {
//            accountService=new AccountService();
            List<Account>accounts = null;
//             OrganizationService organizationService= new OrganizationService();
//             Organization organization= organizationService.findOrganizationById(orgid);
//             if(organization==null)
//                 throw new Exception("there is oranization with this id "+orgid);
//             else
//                 accounts=accountService.findAllStudentOfOrganization(orgid);
//        
            return accounts;
    }
    
}
