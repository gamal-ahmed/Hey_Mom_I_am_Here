/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.services;

import dao.model.Organization;
import dao.model.Report;
import dao.model.ReportType;
import dao.persistence.HibernateUtil;
import dao.services.exceptions.NonexistentEntityException;
import dao.services.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ahaleem
 */
public class ReportsService implements Serializable {
    private Session session=null;
        private Transaction transaction=null;

        public ReportsService() {
              session = HibernateUtil.getSessionFactory().openSession();
        }
public void createReport(Report report) {
       
            try{
              session.save(report);
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

    public void editReport(Report report) throws Exception   {
        try{
            if(findReport(report.getId())==null)
            {
            throw  new Exception("No report type found with this id "+report.getId());
            }
            session.update(report);
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

    public void deleteReport(Integer id) throws Exception  {
       
              try{
            
              Report report=(Report) session.load(Report.class, new Integer(id));
               if(findReport(report.getId())==null)
            {
            throw  new Exception("No report  found with this id "+report.getId());
            }
              session.delete(report);
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
    public void createReportType(ReportType reportType) {
       
            try{
              session.save(reportType);
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

    public void editReportType(ReportType reportType) throws Exception   {
        try{
            if(findReportType(reportType.getId())==null)
            {
            throw  new Exception("No report type found with this id "+reportType.getId());
            }
            session.update(reportType);
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

    public void deleteReportType(Integer id) throws Exception  {
       
              try{
            
              ReportType reportType=(ReportType) session.load(ReportType.class, new Integer(id));
               if(findReportType(reportType.getId())==null)
            {
            throw  new Exception("No report type found with this id "+reportType.getId());
            }
              session.delete(reportType);
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

    public List<ReportType> findAllReportType() {
   org.hibernate.Query q= session.getNamedQuery("ReportType.findAll");
            List <ReportType>reportTypes=  q.list();
          return reportTypes;
    }

  

    public ReportType findReportType(Integer id) {
       ReportType reportType = null;
            org.hibernate.Query q= session.getNamedQuery("ReportType.findById");
            q.setInteger(0, id);
            List<ReportType>reportTypes=q.list();
            for (ReportType mdrsa : reportTypes) {
            reportType=mdrsa;
            }
            return reportType;
    }

    public int getReportTypeCount() {
      return 0;
    }

    private Object findReport(Integer id) {
            Report report = null;
            org.hibernate.Query q= session.getNamedQuery("Report.findById");
            q.setInteger(0, id);
            List<Report>reports=q.list();
            for (Report reporta : reports) {
            report=reporta;
            }
            return report;   
    }
    
}
