/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.services;

import dao.model.AccSt;
import dao.model.Account;
import dao.model.Organization;
import dao.model.Student;
import dao.persistence.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ahaleem
 */
public class AccStService {
     private Session session=null;
        private Transaction transaction=null;

        public AccStService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addAccSt(Student student,Account account )throws Exception
        {
             try{
              AccSt accountStudent = new AccSt(account, student);
              session.save(accountStudent);
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
                  session.flush();
                  session.close();
              }
        }
        public void deleteAccSt(int accStId)throws Exception
        {

              try{
              AccSt accountStudent=(AccSt) session.load(AccSt.class, new Integer(accStId));
              session.delete(accountStudent);
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
                  session.flush();
                  session.close();
              }

              }
        public void updateAccSt(AccSt accountStudent)
        {
           try{
            session.update(accountStudent);
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
                  session.flush();
                  session.close();
              }

        }
        public List<Student> findAccountStudents(int accountId)
        {
            Query q= session.getNamedQuery("AccSt.findAllAccountStudent");
            q.setInteger(0, accountId);
            List<Student>Students=q.list();
            return Students;
        }
        public List<AccSt> findAllAccountStudent()
        {
            Query q= session.getNamedQuery("AccSt.findAll");
            List <AccSt>AccSt=  q.list();
            return AccSt;
        }
}
