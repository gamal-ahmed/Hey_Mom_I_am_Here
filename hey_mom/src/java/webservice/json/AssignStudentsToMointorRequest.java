/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.json;

import dao.model.Account;
import dao.model.Mointor;
import dao.model.Organization;
import dao.model.StMo;
import dao.model.Student;
import java.util.Collection;
import java.util.List;


/**
 *
 * @author ahaleem
 */

public class AssignStudentsToMointorRequest {

  private  Mointor mointor;
  private  List <Student>students;

    /**
     * @return the account
     */
    public Mointor getMointor() {
        return mointor;
    }

    /**
     * @param account the account to set
     */
    public void setMointor(Mointor mointor) {
        this.mointor = mointor;
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
