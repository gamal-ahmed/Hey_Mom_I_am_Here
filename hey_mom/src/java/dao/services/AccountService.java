package dao.services;

import dao.model.Account;
import dao.model.Organization;
import dao.model.Student;
import dao.persistence.HibernateUtil;
import java.util.Collection;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * 
 *  manage student JPA Entity crud operations (add,delete,update,find)
 *  **/
public class AccountService {
   
        private Session session=null;
        private Transaction transaction=null;

        public AccountService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addAccount(Account account)throws Exception
        {
             try{
              session.save(account);
              transaction.commit();
              }
                 catch(RuntimeException e)
              {
                  if(transaction!=null)
                  {  
                      transaction.rollback();
                  }
                  e.printStackTrace();
              }
              finally
              {
                  session.close();
              }
        }
        public void deleteAccount(int accId)throws Exception
        {

              try{
              Account account=(Account) session.load(Account.class, new Integer(accId));
              session.delete(account);
              transaction.commit();
              }
              catch(RuntimeException e)
              {
                  if(transaction!=null)
                  {  
                      transaction.rollback();
                  }
                  e.printStackTrace();
              }
              finally
              {
                  
                  session.close();
              }

              }
        
//      
//        public Student findStudenById(int id)
//        {
//            Student student = null;
//            Query q= session.getNamedQuery("Student.findById");
//            q.setInteger(0, id);
//            List<Student>Students=q.list();
//            for (Student talb : Students) {
//            student=talb;
//            break;
//            }
//            return student;
//        }
//        public List<Student> findAllStudent()
//        {
//            Query q= session.getNamedQuery("Student.findAll");
//            List <Student>Students=  q.list();
//            return Students;
//        }

//    public void assignStudentsToAccount(Account account, List<Student> students) {
//         try{
//             if(account!=null)
//             {
//                 Collection<Student>sts;
//                 sts=account.getStudents();
//                 for (Student st : students) {
//                     sts.add(st);
//                 }
//              account.setStudents(sts);
//              session.update(account);
//              transaction.commit();
//             }
//              }
//              catch(RuntimeException e)
//              {
//                  if(transaction!=null)
//                  {  
//                      transaction.rollback();
//                  }
//                  e.printStackTrace();
//              }
//              finally
//              {
//                  
//                  session.close();
//              }
//
//    }

    public void updateAccount(Account account) {
           try{
            session.update(account);
            transaction.commit();
           }
           catch(RuntimeException e)
           {
                  if(transaction!=null)
                  {  
                      transaction.rollback();
                  }
                  e.printStackTrace();
              }
              finally
              {
                  
                  session.close();
              }    }

    public List<Account> findAllStudentOfOrganization(int orgid) {
            Query q= session.getNamedQuery("Account.findAllAccountsOfOrganization");
            q.setInteger(0, orgid);
            List <Account>accounts=  q.list();
            return accounts;    
    }

}
