package ejb.studentmanagement;




import dao.model.Organization;
import dao.model.Student;
import dao.services.OrganizationService;
import dao.services.StudentService;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class StudentManagement
 */

@Stateless
@LocalBean
public class StudentManagementBean  {

    StudentService studentService;
    /**
     * Default constructor. 
     */
    public StudentManagementBean() {
        // TODO Auto-generated constructor stub
    }

    public void addStudent(Student student) throws Exception {
        if(student!=null)
        {
            studentService= new StudentService();
            if(student.getOrgId()!=null)
            {
                studentService.addStudent(student);
               
            }
        }
    }

    public List<Student> findAllOrganizationStudents(int OrganizationId) throws Exception {
             studentService= new StudentService();
             List<Student>students;
             OrganizationService organizationService= new OrganizationService();
             Organization organization= organizationService.findOrganizationById(OrganizationId);
             if(organization==null)
                 throw new Exception("there is oranization with this id "+OrganizationId);
             else
                 students=studentService.findAllStudentOfOrganization(OrganizationId);
        
             return students;
    }

}
