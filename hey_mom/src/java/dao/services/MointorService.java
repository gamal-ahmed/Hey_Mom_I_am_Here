/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.services;

import dao.model.Mointor;
import dao.persistence.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ahaleem
 */
public class MointorService {
     private Session session=null;
        private Transaction transaction=null;

        public MointorService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addMointor(Mointor mointor )throws Exception
        {
             try{
              session.save(mointor);
              transaction.commit();
              }
              catch(Exception e)
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
        public void deleteMointor(int mointorId)throws Exception
        {

              try{
              Mointor mointor=(Mointor) session.load(Mointor.class, new Integer(mointorId));
              session.delete(mointor);
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
        public void updateMointor(Mointor mointor)
        {
           try{
            session.update(mointor);
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
        public Mointor findMointor(int mointorId)
        {
          
            return (Mointor) session.load(Mointor.class, new Integer(mointorId));
        }
        public List<Mointor> findAllMointors()
        {
            Query q= session.getNamedQuery("Mointor.findAll");
            List <Mointor>mointors=  q.list();
            return mointors;
        }
          public List<Mointor> findOrganizationMointors(int orgId)
        {
            Query q= session.getNamedQuery("Mointor.findByOrgId");
            q.setInteger(0, orgId);
            List <Mointor>organizationMointors=  q.list();
            return organizationMointors;
        }

//    public void assignStudentsToAccount(Mointor mointor, List<Student> students) {
//         try{
//             Collection<Student>sts;
//                 sts=mointor.getStudents();
//                 for (Student st : students) {
//                     sts.add(st);
//                 }
//             mointor.setStudents(sts);
//            session.update(mointor);
//            transaction.commit();
//           }
//           catch(RuntimeException e)
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

    public List<Mointor> findAllMointorsOfOrganization(int orgid) {
            Query q= session.getNamedQuery("Mointor.findAllMointorsOfOrganization");
            q.setInteger(0, orgid);
            List <Mointor>mointors=  q.list();
            return mointors;    
    }
}
