import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by slovi on 12.03.2017.
 */
public class Student implements Print{
    private static int count = 0;
    private int id;
    private String name;
    private String surname;
    private StudentType type;
    private List<Activity> activities;

    Student()
    {
        count++;
        id = count;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imie:");
        name = scanner.next();
        System.out.println("Podaj nazwisko:");
        surname = scanner.next();
        System.out.println("Podaj typ studenta(STATIONARY, NONSTATIONARY, POSTGRADUATE):");
        type = StudentType.valueOf(scanner.next().toUpperCase());
        activities = new ArrayList<Activity>();
    }

    Student(String inname, String insurname, StudentType intype)
    {
        count++;
        id = count;
        name = inname;
        surname = insurname;
        type = intype;
        activities = new ArrayList<Activity>();
    }

    void addActivity(Activity activity)
    {
        activities.add(activity);
    }

    @Override
    public void print() {
        System.out.println("Uczeń:");
        System.out.println(id + ". " + name +" " + surname);
        System.out.println("Zajęcia ucznia:");
        for(int i = 0; i<activities.size(); i++)
        {
            System.out.println(activities.get(i).getName());
        }
    }

    String getStudent()
    {
        return Integer.toString(id) + " " + name + " " + surname;
    }
}

