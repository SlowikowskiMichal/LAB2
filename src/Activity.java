import java.util.HashSet;
import java.util.Set;

/**
 * Created by slovi on 12.03.2017.
 */
public class Activity implements Print{
    private String name;
    private Set<Student> assignedStudents;

    Activity(String inname)
    {
        name = inname;
        assignedStudents = new HashSet<Student>();
    }

    void addStudent(Student student)
    {
        assignedStudents.add(student);
    }

    @Override
    public void print() {
   //     System.out.println("Nazwa zajęć: " + name);
    //    System.out.println("Uczęszczający uczniowie:");
    //    for(int i = 0; i < assignedStudents.size(); i++)
    //        System.out.println(assignedStudents.toArray()[i].);
    }

    String getName()
    {
        return name;
    }
}
