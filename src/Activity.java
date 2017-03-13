import java.util.HashSet;
import java.util.Iterator;
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

    public Set<Student> getAssignedStudents()
    {
         return assignedStudents;
    }

    String getName()
    {
        return name;
    }

    @Override
    public void print() {
        System.out.println("Zajęcie: " + name);
        for (Iterator<Student> it = assignedStudents.iterator(); it.hasNext(); ) {
            Student f = it.next();
            f.print();
        }
    }
}
