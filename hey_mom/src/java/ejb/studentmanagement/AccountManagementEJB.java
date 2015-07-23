/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.studentmanagement;

import dao.model.Account;
import dao.model.Organization;
import dao.model.Student;
import dao.services.StudentService;
import dao.services.AccountService;
import dao.services.OrganizationService;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author ahaleem
 */
public class AccountManagementEJB {
    AccountService accountService;

  

    public void addAccount(Account account) throws Exception {
    
       accountService=new AccountService();
       if(account!=null)
       {
          if(account.getOrgId()!=null)
          {
             accountService.addAccount(account);
          }
       
       }
    
    }

    public void assignStudentsToAccount(Account account, List<Student> students) {
        accountService=new AccountService();
        
           if(account!=null && students!=null)
             {
                 Collection<Student>sts;
                 sts=account.getStudents();
                 for (Student st : students) {
                     sts.add(st);
                 }
                 account.setStudents(sts);
                 accountService.updateAccount(account);
             }
    }

    public List<Account> findAllOrganizatioAccounts(int orgid) throws Exception {
            accountService=new AccountService();
            List<Account>accounts;
             OrganizationService organizationService= new OrganizationService();
             Organization organization= organizationService.findOrganizationById(orgid);
             if(organization==null)
                 throw new Exception("there is oranization with this id "+orgid);
             else
                 accounts=accountService.findAllStudentOfOrganization(orgid);
        
             return accounts;
    }
    
}
