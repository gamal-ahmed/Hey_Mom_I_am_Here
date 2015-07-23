/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.mointormanagement;

import dao.model.AppRole;
import dao.model.Mointor;
import dao.model.Organization;
import dao.model.Student;
import dao.services.MointorService;
import dao.services.OrganizationService;
import dao.services.StudentService;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author ahaleem
 */
@Stateless
@LocalBean
public class MointorManagementEjb {

    MointorService mointorService;
   
    public void addMointor(Mointor mointor) throws Exception
    {
        mointorService=new MointorService();
        if(mointor!=null)
        {
            if(mointor.getOrgId()!=null)
            {
                 mointorService.addMointor(mointor);
            }
        }
    
    }
    public void deleteMointor(int mointorId) throws Exception
    {
    
    }
    public List<AppRole> getMointorPrivilige(int moId)
    {
        
        return null;
    }

    public void assignStudentsToMointor(Mointor mointor, List<Student> students) {
        mointorService=new MointorService();
        if(students !=null && mointor !=null)
        {
           Collection<Student>sts;
           sts=mointor.getStudents();
           for (Student st : students) {
                     sts.add(st);
           }
           mointor.setStudents(sts);
           mointorService.updateMointor(mointor);
        }
    }

    public List<Mointor> findAllOrganizatioMointors(int orgid) throws Exception {

            mointorService=new MointorService();
            List<Mointor>mointors;
             OrganizationService organizationService= new OrganizationService();
             Organization organization= organizationService.findOrganizationById(orgid);
             if(organization==null)
                 throw new Exception("there is oranization with this id "+orgid);
             else
                 mointors=mointorService.findAllMointorsOfOrganization(orgid);
        
             return mointors;
    
    }
}
