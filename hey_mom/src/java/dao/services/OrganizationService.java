    package dao.services;

    import dao.model.Organization;
    import dao.persistence.HibernateUtil;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Query;
    import org.hibernate.Session;
    import org.hibernate.Transaction;

    /*
     * 
     *  manage Organization JPA Entity crud operations (add,delete,update,find)
     *  **/
    public class OrganizationService {
        private Session session=null;
        private Transaction transaction=null;

        public OrganizationService() {
              session = HibernateUtil.getSessionFactory().openSession();
              transaction=session.beginTransaction();
        }


        public void addOrganization(Organization organization)throws Exception
        {
             try{
              session.save(organization);
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
        public void deleteOrganization(int orgId)throws Exception
        {

              try{
              Organization organization=(Organization) session.load(Organization.class, new Integer(orgId));
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
                  session.flush();
                  session.close();
              }

              }
        public void updateOrganization(Organization organization)
        {
           try{
            session.update(organization);
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
        public Organization findOrganizationById(int id)
        {
            Organization organization = null;
            Query q= session.getNamedQuery("Organization.findById");
            q.setInteger(0, id);
            List<Organization>organizations=q.list();
            for (Organization mdrsa : organizations) {
            organization=mdrsa;
            }
            return organization;
        }
        public List<Organization> findAllOrganization()
        {
            Query q= session.getNamedQuery("Organization.findAll");
            List <Organization>organizations=  q.list();
          return organizations;
        }

    }