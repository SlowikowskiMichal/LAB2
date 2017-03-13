import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by slovi on 12.03.2017.
 */
public class Main {
    public static void main(String [] args)
    {
        University university = new University();
        //dodawanie zajęć
        university.addActivity("Majca"); //0
        university.addActivity("Polski"); //1
        university.addActivity("Przyrka"); //2
        university.addActivity("WOS"); //3
        university.addActivity("Fizyka"); //4
        university.addActivity("Chemia"); //5

        //dodawanie studentów
        university.addStudent("Zofia","Naukowska",StudentType.STATIONARY); //0 Zajęcia 0,1,2
        university.addStudent("Nelson","Kowalski",StudentType.STATIONARY); //1 Zajęcia 0,2,3,4,5
        university.addStudent("Albert","Smith",StudentType.NONSTATIONARY); //2 Zajęcia 4
        university.addStudent("Maciej","Pypeć",StudentType.NONSTATIONARY); //3 Zajęcia Brak
        university.addStudent("Paciej","Mypeć",StudentType.POSTGRADUATE); //4 Zajęcia 0,2
        university.addStudent("Jan","Kowalski",StudentType.POSTGRADUATE); //5 Zajęcia Brak
        university.addStudent("Beata","Mydło",StudentType.NONSTATIONARY); //6 Zajęcia 1,3,5

        //przypisywanie studentów do zajęć
        //STUDENT 0
        university.studentToActivity(university.studentsList.get(0),university.activityList.get(0));
        university.studentToActivity(university.studentsList.get(0),university.activityList.get(1));
        university.studentToActivity(university.studentsList.get(0),university.activityList.get(2));

        //STUDENT 1
        university.studentToActivity(university.studentsList.get(1),university.activityList.get(0));
        university.studentToActivity(university.studentsList.get(1),university.activityList.get(2));
        university.studentToActivity(university.studentsList.get(1),university.activityList.get(3));
        university.studentToActivity(university.studentsList.get(1),university.activityList.get(4));
        university.studentToActivity(university.studentsList.get(1),university.activityList.get(5));

        //STUDENT 2
        university.studentToActivity(university.studentsList.get(2),university.activityList.get(4));

        //STUDENT 3
        //nie ma :(

        //STUDENT 4
        university.studentToActivity(university.studentsList.get(4),university.activityList.get(0));
        university.studentToActivity(university.studentsList.get(4),university.activityList.get(2));

        //STUDENT 5
        //nie ma

        //STUDENT 6
        university.studentToActivity(university.studentsList.get(6),university.activityList.get(1));
        university.studentToActivity(university.studentsList.get(6),university.activityList.get(3));
        university.studentToActivity(university.studentsList.get(6),university.activityList.get(5));

        university.print();


        //Czy jest
        System.out.println("\nCzy Zofia Naukowska ma matematykę?");
        if(university.isStudentSigned(university.studentsList.get(0), university.activityList.get(0)))
            System.out.println("Ma");
        else
            System.out.println("Nie ma");
        //----------------------------------------------------------------------------------------------

        System.out.println("\nCzy Nelson Kowalski ma polski");
        if(university.isStudentSigned(university.studentsList.get(1), university.activityList.get(1)))
            System.out.println("Ma");
        else
            System.out.println("Nie ma");
        //-------------------------------------------------------------------------------------------------

        //Kolejka
        System.out.println("\nKolejka niezapisanych: ");
        Queue<Student> test = university.notSigned();

        for(Student element : test)
        {
            element.print();
        }
        //---------------------------------------------------------------------------------------------------

        //Stos
        System.out.println("\nStos uczniów z 3 zajęciami:");
        Stack<Student> test2 = university.nActivityStudent(3);
        for(Student element : test2)
        {
            element.print();
        }
        //-----------------------------------------------------------------------------------------------------

        //Najbardziej aktywny

        System.out.println("\nNajbardziej aktywny:");
        university.mostActiv().print();
        //-----------------------------------------------------------------------------------------------------

        //HashMapa
        HashMap<StudentType, Integer> hashMap = university.studentTypeIntegerHashMap();

        System.out.println("\nHashMapa:");
        Integer v = university.studentTypeIntegerHashMap().get(StudentType.STATIONARY);
        System.out.println("Ilość brzdąców na stacjonarnych: " + v);
        v = university.studentTypeIntegerHashMap().get(StudentType.NONSTATIONARY);
        System.out.println("Ilość brzdąców na nonstacjonarnych: " + v);
        v = university.studentTypeIntegerHashMap().get(StudentType.POSTGRADUATE);
        System.out.println("Ilość brzdąców na postgraduate: " + v);
        //-----------------------------------------------------------------------------------------------------

        //Sortowanie Nazwisko Imię
        university.sortStudent();

        System.out.println("\nPo posortowaniu:");
        university.print();
        //-----------------------------------------------------------------------------------------------------

        //Czy listy uczniów z dwóch zajęć są takie zame?
        //(Matematyka i Przyroda)
        System.out.println("\nCzy ta sama lista uczniów?");
        if(university.sameListStudents(university.activityList.get(0), university.activityList.get(2)))
            System.out.println("Ta sama");
        else
            System.out.println("Nie ta sama");
        //(Polski i Przyroda)
        System.out.println("\nCzy ta sama lista?");
        if(university.sameListStudents(university.activityList.get(1), university.activityList.get(2)))
            System.out.println("Ta sama");
        else
            System.out.println("Nie ta sama");
        //-----------------------------------------------------------------------------------------------------


        //Usuwanie po studencie usuwa Pacieja Mypecia
        System.out.println("\nUsuwanie po studencie:");
        university.deleteStudent(university.studentsList.get(4));
        university.print();
        //-----------------------------------------------------------------------------------------------------

        //Usuwanie po id
        System.out.println("\nUsuwanie po id (3):");
        university.deleteStudent(3);
        university.print();
        //-----------------------------------------------------------------------------------------------------

        //Usuwanie z aktywności(Polski)
        System.out.println("\nUsuwanie uczniów z aktywności:");
        university.deleteStudentsFromActivity(university.activityList.get(1));

        university.print();

    }
}
