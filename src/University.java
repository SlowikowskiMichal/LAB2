import java.util.*;

/**
 * Created by slovi on 12.03.2017.
 */
public class University implements Print {
    public List<Student> studentsList;
    public List<Activity> activityList;

    University()
    {
        studentsList = new ArrayList<Student>();
        activityList = new ArrayList<Activity>();
    }

    @Override
    public void print() {
        for(int i = 0; i < studentsList.size();i++)
        {
            studentsList.get(i).print();
        }
    }

    void addStudent(String inname, String insurname, StudentType intype) //dodaje studenta do systemu
    {
        studentsList.add(new Student(inname,insurname,intype));
    }
    void addActivity(String inname) //dodaje zajęcia do systemu
    {
        activityList.add(new Activity(inname));
    }
    void studenttoactivity(Student student, Activity activity) //przypisuje studenta do zajęć
    {
        student.addActivity(activity);
        activity.addStudent(student);
    }
    void deleteStudent(Student student) //usuwa studenta
    {
        studentsList.remove(student);
    }
/*    void deleteStudent(int id) // usuwa studenta po numerze id
    {

    }
    void deleteStudentsFromActivity(Activity activity) //usuwa wszystkich studentów z danych zajęć
    {

    }
    boolean isStudentSigned(Student student, Activity activity) //sprawdza czy dany student jest zapisany na dane zajęcia
    {
        return false;
    }
    Queue<Student> isntSigned() //zwraca kolejkę studentów nieprzypisanych do żadnych zajęć
    {
        return null;
    }
    Stack<Student> studentswithNActiv(int n) //zwraca stos studentów zapisanych na n zajęć
    {
        return null;
    }
    Student mostActiv() //zwraca studenta z największą ilością zajęć
    {
        return null;
    }
    HashMap<StudentType, Integer> studentTypeIntegerHashMap() //zwraca ilość studentów typu w postaci HashMap
    {
        return null;
    }
    boolean sameListStudents(Activity first, Activity secont) // zwraca prawdę jeżeli na dane zajęcia chodzą te same osoby
    {
        return false;
    }
    */
}
