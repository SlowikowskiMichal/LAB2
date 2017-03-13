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

    //    System.out.println("------Ucznowie------:");
    //    for(int i = 0; i < studentsList.size();i++)
    //    {
     //       studentsList.get(i).print();
      //  }
        System.out.println("-----Zajęcia-----");
        for(int i = 0; i < activityList.size();i++)
        {
            activityList.get(i).print();
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
    void studentToActivity(Student student, Activity activity) //przypisuje studenta do zajęć
    {
        student.addActivity(activity);
        activity.addStudent(student);
    }
    void deleteStudent(Student student) //usuwa studenta
    {
        studentsList.remove(student);
        for(int i = 0; i < activityList.size(); i++)
        {
            activityList.get(i).getAssignedStudents().remove(student);
        }
    }
    void deleteStudent(int id) // usuwa studenta po numerze id
    {
        Student student = null;
        for(int i = 0; i < studentsList.size(); i++) {
            if (id == studentsList.get(i).getId()) {
                student = studentsList.get(i);
                break;
            }
        }
        for(int i = 0; i < student.getActivities().size(); i++)
        {
            student.getActivities().get(i).getAssignedStudents().remove(student);
        }

        studentsList.remove(student);
    }
    void deleteStudentsFromActivity(Activity activity) //usuwa wszystkich studentów z danych zajęć
    {

            for (Iterator<Student> it = activity.getAssignedStudents().iterator(); it.hasNext(); ) {
                Student f = it.next();
                f.getActivities().remove(activity);
            }

        activity.getAssignedStudents().clear();
    }
    boolean isStudentSigned(Student student, Activity activity) //sprawdza czy dany student jest zapisany na dane zajęcia
    {
        if(activity.getAssignedStudents().contains(student))
            return true;
        //else
        return false;
    }
    Queue<Student> notSigned() //zwraca kolejkę studentów nieprzypisanych do żadnych zajęć
    {
        Queue<Student> queue = new LinkedList<Student>();

        for(int i = 0;i < studentsList.size(); i++)
        {
            if(studentsList.get(i).haveActivities())
                queue.add(studentsList.get(i));
        }

        return queue;
    }
    Stack<Student> nActivityStudent(int n) //zwraca stos studentów zapisanych na n zajęć
    {
        Stack<Student> studentStack = new Stack<Student>();

        for(int i = 0; i < studentsList.size(); i++)
        {
            if(studentsList.get(i).numbActiv() == n)
                studentStack.add(studentsList.get(i));
        }

        return studentStack;
    }
    Student mostActiv() //zwraca studenta z największą ilością zajęć
    {
        return Collections.max(studentsList, new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Integer.compare(o1.numbActiv(), o2.numbActiv());
                    }
                });
    }
    HashMap<StudentType, Integer> studentTypeIntegerHashMap() //zwraca ilość studentów typu w postaci HashMap
    {
        HashMap<StudentType,Integer> hashmap= new HashMap<StudentType,Integer>();
        int[] counter = new int[]{0,0,0};

        for(int i = 0; i < studentsList.size(); i++)
        {
            if(studentsList.get(i).getType() == StudentType.STATIONARY)
                counter[0]++;
            else if(studentsList.get(i).getType() == StudentType.NONSTATIONARY)
                counter[1]++;
            else
                counter[2]++;
        }

        hashmap.put(StudentType.STATIONARY,counter[0]);
        hashmap.put(StudentType.NONSTATIONARY,counter[1]);
        hashmap.put(StudentType.POSTGRADUATE,counter[2]);

        return hashmap;
    }
    void sortStudent()
    {
        Collections.sort(studentsList);
    }

    boolean sameListStudents(Activity first, Activity second) // zwraca prawdę jeżeli na dane zajęcia chodzą te same osoby
    {
        return !Collections.disjoint(first.getAssignedStudents(), second.getAssignedStudents());
    }
}
