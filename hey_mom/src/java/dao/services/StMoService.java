/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.services;

import dao.model.AccSt;
import dao.model.Account;
import dao.model.Mointor;
import dao.model.Organization;
import dao.model.StMo;
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
public class StMoService {
     private Session session=null;
        private Transaction transaction=null;

        public StMoService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addStMo(Student student,Mointor mointor )throws Exception
        {
             try{
              StMo studentMointor = new StMo(student, mointor);
              session.save(studentMointor);
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
        public void deleteStMo(int StMoId)throws Exception
        {

              try{
              StMo studentMointor=(StMo) session.load(StMo.class, new Integer(StMoId));
              session.delete(studentMointor);
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
        public void updateAccSt(StMo studentMointor)
        {
           try{
            session.update(studentMointor);
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
        public List<Mointor> findStudentsMointors(int studentId)
        {
            Query q= session.getNamedQuery("StMo.findAllStudentMointors");
            q.setInteger(0, studentId);
            List<Mointor>Mointors=q.list();
            return Mointors;
        }
        public List<Student> findAllMointorStudents(int mointortId)
        {
            Query q= session.getNamedQuery("StMo.findAllMointorStudents");
             q.setInteger(0, mointortId);
            List <Student>students=  q.list();
            return students;
        }
}
