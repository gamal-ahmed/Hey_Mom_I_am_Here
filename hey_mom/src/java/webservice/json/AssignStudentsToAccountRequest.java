/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.json;

import dao.model.Account;
import dao.model.Organization;
import dao.model.StMo;
import dao.model.Student;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author ahaleem
 */

public class AssignStudentsToAccountRequest {

  private  Account account;
  private  List <Student>students;

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the students
     */
    public List <Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(List <Student> students) {
        this.students = students;
    }

    
}
