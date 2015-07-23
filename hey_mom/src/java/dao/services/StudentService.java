package dao.services;

import dao.model.Organization;
import dao.model.Student;
import dao.persistence.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * 
 *  manage student JPA Entity crud operations (add,delete,update,find)
 *  **/
public class StudentService {
   
        private Session session=null;
        private Transaction transaction=null;

        public StudentService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addStudent(Student student)throws Exception
        {
             try{
              session.save(student);
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
        public void deleteStudent(int stId)throws Exception
        {

              try{
              Organization organization=(Organization) session.load(Student.class, new Integer(stId));
              session.delete(organization);
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
        public void updateOrganization(Student student)
        {
           try{
            session.update(student);
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
        public Student findStudenById(int id)
        {
            Student student = null;
            Query q= session.getNamedQuery("Student.findById");
            q.setInteger(0, id);
            List<Student>Students=q.list();
            for (Student talb : Students) {
            student=talb;
            break;
            }
            return student;
        }
        public List<Student> findAllStudent()
        {
            Query q= session.getNamedQuery("Student.findAll");
            List <Student>Students=  q.list();
            return Students;
        }

    public List<Student> findAllStudentOfOrganization(int OrganizationId) {
            Query q= session.getNamedQuery("Student.findByOrganzationId");
            q.setInteger(0, OrganizationId);
            List <Student>Students=  q.list();
            return Students;
    }

}
