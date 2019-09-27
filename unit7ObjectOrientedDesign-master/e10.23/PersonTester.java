import java.util.Scanner;

/**
 * Write a description of class PersonTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonTester
{
    /** description of instance variable x (add comment for each instance variable) */
    private int x;

    public static Person firstPerson(Person[] people)
    {
        Person first = people[0];
        for(int i = 1; i < people.length; i++)
        {
            if(people[i].compareTo(first) < 0)
            {
                first = people[i];
            }
        }
        return first;
    }
    
    public static Person lastPerson(Person[] people)
    {
        Person last = people[0];
        for(int i = 1; i < people.length; i++)
        {
            if(people[i].compareTo(last) > 0)
            {
                last = people[i];
            }
        }
        return last;
    }
    
    public static void main(String[] args)
    {
        Person[] people = new Person[10];
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter 10 names: ");
        for (int i = 0; i < 10 && s.hasNext(); i++)
        {
            people[i] = new Person(s.next());
        }
        
        System.out.println("First: " + firstPerson(people).getName());
        System.out.println("Last: " + lastPerson(people).getName());
    }
}
